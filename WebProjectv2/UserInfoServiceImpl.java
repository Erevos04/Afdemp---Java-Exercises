
package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.UserInfoDao;
import com.websystique.springmvc.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userinfoservice")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    
    @Autowired
    private UserInfoDao userinfodao;
    
    public UserInfo findByUserId(int user_id){
    
    return userinfodao.findByUserId(user_id);
    
    }
    
    //User_info findByLastName(String last_name);
    
    //User_info findByPhoneNumber(String phone_number);
    
    //void deleteByUserId(User_info userinfo);
    
    public void saveUserInfo(UserInfo userinfo){
        
        userinfodao.saveUserInfo(userinfo);
    }
    
    //void editUserInfo(User_info userinfo);
    
    //List <User_info> showAllEmails();
    
    
}
