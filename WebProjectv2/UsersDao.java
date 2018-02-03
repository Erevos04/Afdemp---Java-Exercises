/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import java.util.List;
 
import com.websystique.springmvc.model.Users;


public interface UsersDao {
    
    //Users findUserByName(String name);
    
    
    Users findUserById(int id);
    
    void insertNewUser(Users users);
    
    //void deleteUserById(Users users);
    
    //void changeUsername(Users users);
    
    //void changePassword(Users users);
    
    //List <Users> findUsersMatchingName(String name);
    
    //List <Users> showAllUsers();
    
}
