/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;
 

/**
 *
 * @author Orestis
 */
public class JavaProject1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    
    
    Login login = new Login();    
    if(login.LoginAttempt()){
        Menus menus  = new Menus();
        menus.ShowMenus(login.getConnectedUser());
        Database database = new Database();
        InternalBankAccounts internalbank = new InternalBankAccounts();

        System.exit(0);
    }
   
        else{
        System.out.println("User not Authenticated. Exiting Application...");       
        }
    }
}