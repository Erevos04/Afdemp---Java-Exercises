/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import java.util.List;
 
import com.websystique.springmvc.model.Orders;


public interface OrdersDao {
    
    void createOrder(Orders orders);
    
    void editOrder(Orders orders);
    
    void deleteOrder(Orders orders);
    
    List <Orders> findOrdersOfUser(int user_id);
    
    List <Orders> findOrdersContainingProduct(int pr_id);
    
    Orders findOrderById(int order_id);
    
    
    
}
