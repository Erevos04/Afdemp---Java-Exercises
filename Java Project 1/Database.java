/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;


import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Database{
    private static final Logger log =  LogManager.getLogger(Database.class.getName());
    private String sdf = new SimpleDateFormat("dd_MM_yyyy HH:mm:ss").format(new Date());
    private String datenow = new SimpleDateFormat("dd_MM_yyyy").format(new Date());
    protected static ArrayList<String> Statement = new ArrayList<>();
    
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "afdemp";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/afdemp_java_1?autoReconnect=true&useSSL=false";
    private static  Connection conn = null;
    
    protected ArrayList<String> getStatement (){
        return Statement;
    }
    
    protected ArrayList<String> clearStatement(){      
        Statement.clear();        
        return Statement;       
    }
    
    
    protected Database(){      
        InitConnection();
        
    }
   
    private static void InitConnection(){      
        if(conn==null){
            try {

                conn=DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD); 
            }
            catch (SQLException ex) {
                System.out.println("Error : Cannot connect to database!");
                System.exit(0);
            }
        }
        
        
        
    }
        
    protected Boolean AuthenticateUser(String username,String password){
         PreparedStatement stmt;
        try {
            String authUser= "SELECT count(*) FROM users where username=? and password=?";
            stmt = conn.prepareStatement(authUser);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet acc1 = stmt.executeQuery();
            int IsAuthenticated = 0;
            while (acc1.next()){
                IsAuthenticated = acc1.getInt(1);                        
            }
            if(IsAuthenticated==1) 
                return true;
            else return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
            
        }
            
    
    }

    protected double GetBalanceOfUser(String username) throws SQLException{
        PreparedStatement stmt;
        double balance =0;
        
            String SingleBalanceSQL= "select u.username,a.amount from accounts a\n" +
                             "inner join users u\n" +
                             "on a.user_id = u.id\n" +
                             "where u.username =? ";
            stmt = conn.prepareStatement(SingleBalanceSQL);
            stmt.setString(1, username);
            
            ResultSet OneAcc = stmt.executeQuery();
            
            while (OneAcc.next()){
                balance = OneAcc.getDouble(2);
            }
            
            return balance;
            
       
            
    
    }
    
    
    protected ArrayList<InternalBankAccounts> GetBalanceOfAllUsers() throws SQLException{
        PreparedStatement stmt;
        ArrayList<InternalBankAccounts> accounts = new ArrayList<>();
        
        
                String ManyBalanceSQL= "select u.username,a.amount from accounts a\n" +
                             "inner join users u\n" +
                             "on a.user_id = u.id "
                            + "where u.username not in ('admin') ";
            stmt = conn.prepareStatement(ManyBalanceSQL);
            
            
            ResultSet ManyAcc = stmt.executeQuery();
            
            while (ManyAcc.next()){
                InternalBankAccounts acc = new InternalBankAccounts();
                acc.setAccountHolder(ManyAcc.getString(1));
                acc.setBalance(ManyAcc.getDouble(2));
                accounts.add(acc);                        
            }
            
            return accounts;
            
      
            
    
    }
    
    protected void TransferBalance(String username) throws SQLException {
       
            Scanner sc = new Scanner (System.in);
            sc.useLocale(new Locale ("el", "GR"));
            String UserToTransfer;
            double newamount=0;

            System.out.println("Please type the username of the recipient : ");
            UserToTransfer=sc.next();
            if (UserToTransfer.equals("admin")){
                System.out.println("Use this menu for simple user transactions only!");
                log.info("User : '"+username+"' made an invalid transfer balance to user input.");
                return;
            }
            System.out.println("Please type the amount you want to transfer : ");          
            try{
             newamount=sc.nextDouble();
            }
            catch(Exception e){
                 System.out.println("Invalid input. Balance should numeric.");
                 log.info("User : '"+username+"' made an invalid transfer balance to user input.");
                 return;
            }
             log.info("User : '"+username+"' tried to transfer "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                 .format(newamount)+" to User : '"+UserToTransfer+"'");
            if(newamount <= 0){ 
                 System.out.println("Balance should be greater than zero."); 
                 log.info("User : '"+username+"' made an invalid transfer balance to user input.");

            }

            else{
                PreparedStatement stmt;
                String FindUser = "select count(*) from users where username = ? ;";
                stmt=conn.prepareStatement(FindUser);
                stmt.setString(1, UserToTransfer);
                ResultSet PossibleUser = stmt.executeQuery();
                int validUser=0;
                while(PossibleUser.next()){
                    validUser = PossibleUser.getInt(1);
                }
                if (validUser == 0){
                    System.out.println("This user doesn't exist.");
                    log.info("User : '"+username+"' made an invalid transfer balance to user input.");
                    return;

                } 
                else{
                    if (newamount<=GetBalanceOfUser(username)){
                        System.out.println("Transfering amount...");
                        UpdateBalance(username,-newamount);
                        UpdateBalance(UserToTransfer,newamount);
                        System.out.println("Transfer Completed!");
                        log.info("User : '"+username+"' succesfully transfered "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                            .format(newamount)+" to User : '"+UserToTransfer+"'");
                        Statement.add(sdf+" User : '"+username+"' succesfully transfered "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                            .format(newamount)+" to User : '"+UserToTransfer+"'");



                    }
                    else  {System.out.println("Not enough Balance in your Account!");
                    log.info("User : '"+username+"' had insufficient funds to complete the transfer.");
                    Statement.add(sdf+" User : '"+username+"' had insufficient funds to complete the transfer");
                    }
                }       
                stmt.close();
           }
           
          
       }
    
    protected void TransferBalancetoAdmin(String username) throws SQLException {
           Scanner sc = new Scanner (System.in);
           sc.useLocale(new Locale ("el", "GR"));
           String UserToTransfer = "admin";
           double newamount=0;
           
           System.out.println("Please type the amount you want to transfer to Admin : ");
           try{
            newamount=sc.nextDouble();
           }
           catch(Exception e){
                System.out.println("Balance should numeric."); 
                log.info("User : '"+username+"' made an invalid transfer balance to admin input.");
                return;
           }
           log.info("User : '"+username+"' tried to transfer "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                .format(newamount)+" to User : 'admin'");
           
            if(newamount < 0){ 
                System.out.println("Balance should be greater than zero.");
                log.info("User : '"+username+"' made an invalid transfer balance to admin input.");
               
            }
            else {
            PreparedStatement stmt;
            String FindUser = "select username from users where username = admin ;";
            stmt=conn.prepareStatement(FindUser);
           
            if (newamount<=GetBalanceOfUser(username)){
               System.out.println("Transfering amount to Admin...");
               UpdateBalance(username,-newamount);
               UpdateBalance(UserToTransfer,newamount);
               System.out.println("Transfer Completed!");
               log.info("User : '"+username+"' succesfully transfered "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                    .format(newamount)+" to User : 'admin'");
               Statement.add(sdf+" User : '"+username+"' succesfully transfered "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                    .format(newamount)+" to User : 'admin'");
                
               
               
               
               
            }
            else  {System.out.println("Not enough Balance in your Account!");
            log.info("User : '"+username+"' had insufficient funds to complete the transfer.");
            Statement.add(sdf+" User : '"+username+"' had insufficient funds to complete the transfer");
            }
           
            stmt.close();
           
            }
        }
    
    
    protected void WithdrawBalance(String username) throws SQLException {
           Scanner sc = new Scanner (System.in);
           sc.useLocale(new Locale ("el", "GR"));
           String UserToTransfer;
           double newamount=0;
           System.out.println("Please type the username of the user you want to withdraw from : ");
           UserToTransfer=sc.next();
           System.out.println("Please type the amount you want to withdraw : ");
           try{
            newamount=sc.nextDouble();
           }
           catch(Exception e){
                System.out.println("Balance should numeric.");
                log.info("User : 'admin' made an invalid withdrawal input.");
                return;
           }
           log.info("User : 'admin' tried to withdraw "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                .format(newamount)+" from '"+UserToTransfer+"'");
           
           if(newamount < 0){ 
                System.out.println("Amount should be greater than zero.");
                log.info("User : 'admin' made an invalid withdrawal input.");
                return;
           }
           
            PreparedStatement stmt;
                String FindUser = "select count(*) from users where username = ? ;";
                stmt=conn.prepareStatement(FindUser);
                stmt.setString(1, UserToTransfer);
                ResultSet PossibleUser = stmt.executeQuery();
                int validUser=0;
                while(PossibleUser.next()){
                    validUser = PossibleUser.getInt(1);
                }
                if (validUser == 0){
                    System.out.println("This user doesn't exist.");
                    log.info("User : 'admin' made an invalid withdrawal input.");
                    

                }
                else{
                    if (newamount<=GetBalanceOfUser(UserToTransfer)){
                        System.out.println("Transfering amount...");
                        UpdateBalance(username,newamount);
                        UpdateBalance(UserToTransfer,-newamount);
                        System.out.println("Transfer Completed!");
                        log.info("User : 'admin' succesfully withdrew "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                            .format(newamount)+" from User : '"+UserToTransfer+"'");
                        Statement.add(sdf+" User : 'admin' succesfully withdrew "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                            .format(newamount)+" from User : '"+UserToTransfer+"'");



                    }
                    else  {System.out.println("Not enough Balance in user's Account!");
                    log.info("User : '"+UserToTransfer+"' had less than "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                        .format(newamount)+" to complete the withdrawal from 'admin'");
                    Statement.add(sdf+" User : '"+UserToTransfer+"' had less than "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                        .format(newamount)+" to complete the withdrawal from 'admin'");
                    }
                
                }         
                stmt.close();   
       }
    
    
    protected void UpdateBalance(String username,double newamount) throws SQLException {
           
                
                
                PreparedStatement stmt;
                
                String TransferBalanceSQL="update accounts a\n" +
                                            "inner join users u on a.user_id = u.id \n" +
                                            "set amount = amount + ? , transaction_date = now() \n" +                                     
                                            "where   u.username = ? " ;
                
            stmt = conn.prepareStatement(TransferBalanceSQL);
            stmt.setDouble(1, newamount);
            stmt.setString(2, username);  
            
            stmt.executeUpdate();
            
            stmt.close();
           
           
           
    }
    
    
    protected boolean CreateNewUser (String username) throws SQLException{
        Console console = System.console();
        Scanner sc = new Scanner (System.in);
        System.out.println("Please insert username and password again");
        
        byte count_attempts=0;
        
    while (count_attempts<=2){
        System.out.print("Username : "); String id = sc.next();       
        System.out.print("Password : "); String pwd = new String(console.readPassword());
        if (!id.equals("admin")){
            System.out.println("Invalid username for this action!");
            log.info("User : '"+id+"' made an invalid username input to execute Create User action.");
            return false;
        }
        log.info("User : '"+id+"' tried to verify credentials to Create a new User.");
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(pwd.getBytes());
            byte[] bytepwd = md.digest();          
            String hashpwd = DatatypeConverter.printHexBinary(bytepwd);
           
            boolean IsAuthenticated = new Database().AuthenticateUser(id, hashpwd.substring(1, 20));
            if(IsAuthenticated){
                String ConnectedUser = id;
                log.info("User : '"+ConnectedUser+"' succesfully verified credentials after "+count_attempts+" false attempts.");
                
            String newusername;
            String newpassword;
            System.out.println("Please insert userame for new entry (template : user* ) : ");
            newusername=sc.next();
            
            PreparedStatement stmt;
                String FindUser = "select count(*) from users where username = ? ;";
                stmt=conn.prepareStatement(FindUser);
                stmt.setString(1, newusername);
                ResultSet PossibleUser = stmt.executeQuery();
                int validUser=0;
                while(PossibleUser.next()){
                    validUser = PossibleUser.getInt(1);
                }
                if (validUser != 0 || !newusername.contains("user")){
                    System.out.println("Invalid new username input!");
                    log.info("User : 'admin' made an invalid new username input.");
                    stmt.close();
                    return false;
                }
            
            
            System.out.println("Please insert password for new entry : ");
            newpassword=sc.next();
            String hashnewpwd;
            md = MessageDigest.getInstance("SHA-512");
            md.update(newpassword.getBytes());
            byte[] bytenewpwd = md.digest();
            
            String hashnewpwddef = DatatypeConverter.printHexBinary(bytenewpwd);
            hashnewpwd=hashnewpwddef.substring(1, 20);
        
            PreparedStatement stmt1;
            
            String CreateUser = "insert  into users ( username , password ) values ( ? , ? ) ; ";
            stmt1=conn.prepareStatement(CreateUser);
            stmt1.setString(1, newusername);
            stmt1.setString(2, hashnewpwd);
            stmt1.executeUpdate();

            stmt1.close();
            
            
            PreparedStatement stmt2;
            
            String CreateUser_id="INSERT INTO accounts select null, id , now() , ?  from users where username = ? ; ";
            stmt2=conn.prepareStatement(CreateUser_id);
            stmt2.setDouble(1, 0);
            stmt2.setString(2, newusername);
            stmt2.executeUpdate();
            
 
            stmt2.close();
            
                System.out.println("Succesfully created new User : '"+newusername+"'");
                log.info("User : 'admin' succesfully created new User : '"+newusername+"'");
                Statement.add(sdf+" User : 'admin' succesfully created new User : '"+newusername+"'");                              
                return true;
            }
            
            count_attempts++;
            
            new Menus().ClearScreen();
            if (count_attempts!=3){
            System.out.println("Please enter another Username or Password.\nAttempts remaining : "+(3-count_attempts));                        
            }
            else {
                System.out.println("Credentials not verified for this action.");
                log.info("User : 'admin' failed to verify credentials to create a new User.");
            }           
            
        }   
            catch (NoSuchAlgorithmException ex) {
            return false;
            }
        }

        return false;
    }
     
}   