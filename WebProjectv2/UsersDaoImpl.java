
package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Users;
import org.springframework.stereotype.Repository;

@Repository("UsersDao")
public class UsersDaoImpl extends AbstractDao<Integer, Users> implements UsersDao {
    
    public void insertNewUser(Users users){
        persist(users);
    }
    
    public Users findUserById(int id){
        return getByKey(id);
    }
}
