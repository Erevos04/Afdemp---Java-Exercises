/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;

import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author Orestis
 */
class Login {
private static final Logger log =  LogManager.getLogger(Login.class.getName());
private Scanner sc = new Scanner(System.in);
private String ConnectedUser;

protected boolean LoginAttempt(){
Console console = System.console();
new Menus().ClearScreen();
System.out.println("----Welcome to Corporate Bank----\nPlease verify your credentials below.");

byte count_attempts=0;
        
    while (count_attempts<=2){
        System.out.print("Username : "); String id = sc.next();
        System.out.print("Password : "); String pwd = new String(console.readPassword());
        log.info("User : '"+id+"' made a login attempt.");
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(pwd.getBytes());
            byte[] bytepwd = md.digest();           
            String hashpwd = DatatypeConverter.printHexBinary(bytepwd);
            
            boolean IsAuthenticated = new Database().AuthenticateUser(id, hashpwd.substring(1, 20));
            if(IsAuthenticated){
                ConnectedUser=id;
                log.info("User : '"+ConnectedUser+"' made a succesful login after "+count_attempts+" false attempts.");
                return true;
            }
            
            count_attempts++;
            new Menus().ClearScreen();
            if (count_attempts!=3){
            System.out.println("Please enter another Username or Password.\nAttempts remaining : "+(3-count_attempts));                        
            }
            
    }   catch (NoSuchAlgorithmException ex) {
            return false;
        }
    }
    return false;
}

    protected String getConnectedUser() {
        return ConnectedUser;
    }


}
    