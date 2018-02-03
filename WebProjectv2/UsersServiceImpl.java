/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.UsersDao;
import com.websystique.springmvc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Orestis
 */
@Service("UsersService")
@Transactional
public class UsersServiceImpl implements UsersService {
    
    @Autowired
    private UsersDao usersdao;
    
    public Users findUserById(int id){
        return usersdao.findUserById(id);
    }
    
    public void insertNewUser(Users users){
        usersdao.insertNewUser(users);
    }
    
}
