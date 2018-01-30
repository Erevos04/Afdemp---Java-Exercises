/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;
import java.util.List;
 
import com.websystique.springmvc.model.Wishlist;


public interface WishlistDao {
  
    void addProduct(Wishlist wishlist);
    
    void removeProduct(Wishlist wishlist);
    
    Wishlist findWishlistById(int user_id);
    
    List <Wishlist> findWishlistContainingProduct(int pr_id);
    
    List <Wishlist> findAllProductsInWishlists(int pr_id);
    
    
}
