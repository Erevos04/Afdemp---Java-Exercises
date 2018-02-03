/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends AbstractDao<Integer, UserInfo> implements UserInfoDao {
    
    public UserInfo findByUserId(int user_id){
        return getByKey(user_id);
    }
    
    public void saveUserInfo(UserInfo userinfo){
        persist(userinfo);
    }
}
