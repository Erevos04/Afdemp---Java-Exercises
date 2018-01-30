package com.websystique.springmvc.dao;
 
import java.util.List;
 
import com.websystique.springmvc.model.Products;
 
public interface ProductsDao {
 
    
    Products findByPrName(String name);
    
    Products findByPrId(int pr_id);
 
    void saveNewProduct(Products products);
    
    void editProduct(Products products);
    
    void changePriceIn(Products products);
    
    void changePriceOut(Products products);
    
    void changeLiveQuantity(Products products);
       
    void deleteByPrId(Products products);
     
    List<Products> showAllProducts();
    
    
}