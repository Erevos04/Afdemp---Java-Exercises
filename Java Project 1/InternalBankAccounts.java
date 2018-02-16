/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;


import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


/**
 *
 * @author Orestis
 */
public class InternalBankAccounts {    
    
    private String AccountHolder;
    private double balance;
    private Date transactiondate;
    private String sqldate;
    private String sqltime;

    public String getAccountHolder() {
        return AccountHolder;
    }

    public void setAccountHolder(String AccountHolder) {
        this.AccountHolder = AccountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "User : '"+AccountHolder+"' has balance of : " +NumberFormat.getCurrencyInstance(new Locale("el", "GR")).format(balance);
    }

   
    
    public void printBalanceofSingleUser(String AccountHolder) throws SQLException {
        double balance = new Database().GetBalanceOfUser(AccountHolder);
        System.out.println("Your balance is : "+NumberFormat.getCurrencyInstance(new Locale("el", "GR"))
                .format(balance));
    }
    
    
    public void printBalanceofAllUsers() throws SQLException{
        ArrayList <InternalBankAccounts> accounts = new Database().GetBalanceOfAllUsers();
        for (InternalBankAccounts acc : accounts){
            System.out.println(acc.toString());
            }
    }       
             
}