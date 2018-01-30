/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import java.util.List;
 
import com.websystique.springmvc.model.Cart;


public interface CartDao {
  
    void addProduct(Cart cart);
    
    void removeProduct(Cart cart);
    
    void editQuantity(Cart cart);
    
    Cart findCartById(int user_id);
    
    List <Cart> findCartsContainingProduct(int pr_id);
    
    
}
