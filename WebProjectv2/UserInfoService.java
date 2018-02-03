
package com.websystique.springmvc.service;

import com.websystique.springmvc.model.UserInfo;

public interface UserInfoService {
    
    UserInfo findByUserId(int user_id);
    
    //User_info findByLastName(String last_name);
    
    //User_info findByPhoneNumber(String phone_number);
    
    //void deleteByUserId(User_info userinfo);
    
    void saveUserInfo(UserInfo userinfo);
    
    //void editUserInfo(User_info userinfo);
    
    //List <User_info> showAllEmails();
    
}
