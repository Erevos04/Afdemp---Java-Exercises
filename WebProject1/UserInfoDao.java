/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import java.util.List;
 
import com.websystique.springmvc.model.User_info;


public interface UserInfoDao {
    
    User_info findByUserId(int user_id);
    
    User_info findByLastName(String last_name);
    
    User_info findByPhoneNumber(String phone_number);
    
    void deleteByUserId(User_info userinfo);
    
    void saveUserInfo(User_info userinfo);
    
    void editUserInfo(User_info userinfo);
    
    List <User_info> showAllEmails();
    
    
    
    
}
