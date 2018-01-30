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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
 
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="MEMBER_SALES")
public class MemberSales implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sales_id;
    
    @NotNull
    @Column(name="USER_ID",nullable=false)
    private int user_id;
    
    @NotNull
    @Column(name="PR_ID",nullable=false)
    private int pr_id;
    
    @NotNull
    @Column(name="SALES_QUANTITY",nullable=false)
    private int sales_quantity;
        
    @NotNull
    @Digits(integer=6, fraction=2)
    @Column(name = "PRICE_IN", nullable = false)
    private double price_in;
    
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate date;
    
    @NotNull
    @Column(name="APPROVE",nullable=false)
    private int approve;
    
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private Users users;
    
    @OneToMany(mappedBy="PRODUCTS")
    private Set <Products> products;

    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

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

    public int getSales_quantity() {
        return sales_quantity;
    }

    public void setSales_quantity(int sales_quantity) {
        this.sales_quantity = sales_quantity;
    }

    public double getPrice_in() {
        return price_in;
    }

    public void setPrice_in(double price_in) {
        this.price_in = price_in;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getApprove() {
        return approve;
    }

    public void setApprove(int approve) {
        this.approve = approve;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
    
   
}
