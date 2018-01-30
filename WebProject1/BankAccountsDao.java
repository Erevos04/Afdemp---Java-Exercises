/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import java.util.List;
 
import com.websystique.springmvc.model.Bank_accounts;


public interface BankAccountsDao {
    
    void increaseBalance(Bank_accounts bankaccounts);
    
    void reduceBalance(Bank_accounts bankaccounts);
    
    Bank_accounts findAccountById(int user_id);
    
    List <Bank_accounts> showAllAccounts();
    
    Bank_accounts showAdminAccount();

}
