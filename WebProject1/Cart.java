/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
 

 
@Entity
@Table(name="CART")
public class Cart implements Serializable {
    
    @Id
    @Column(name="USER_ID",unique=true,nullable=false)
    private int user_id;
    
    @NotNull
    @Column(name="PR_ID",unique=true,nullable=false)
    private int pr_id;
    
    @NotNull
    @Column(name="QUANTITY",nullable=false)
    private int quantity;
    
    @OneToMany(mappedBy="PRODUCTS")
    private Set <Products> products;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPr_id() {
        return pr_id;
    }

    public void setPr_id(int pr_id) {
        this.pr_id = pr_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
    
    
}
