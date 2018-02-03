
package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Users;


public interface UsersService {
    
    Users findUserById(int id);
    
    void insertNewUser(Users users);
}
