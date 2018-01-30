/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
 
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ORDERS")
public class Orders implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    
    
    @NotNull
    @Column(name="PR1_ID",nullable=false)
    private int pr1_id;
    
    
    @Column(name="PR2_ID",nullable=false)
    private int pr2_id;
    
   
    @Column(name="PR3_ID",nullable=false)
    private int pr3_id;
    
    
    @Column(name="PR4_ID",nullable=false)
    private int pr4_id;
    
    @NotNull
    @Column(name="PR1_QUANTITY",nullable=false)
    private int pr1_quantity;
    
    
    @Column(name="PR2_QUANTITY",nullable=false)
    private int pr2_quantity;
    
  
    @Column(name="PR3_QUANTITY",nullable=false)
    private int pr3_quantity;
    
    
    @Column(name="PR4_QUANTITY",nullable=false)
    private int pr4_quantity;
            
            
        
    @NotNull
    @Digits(integer=6, fraction=2)
    @Column(name = "PRICE_OUT1", nullable = false)
    private double price_out1;
    
    
    @Digits(integer=6, fraction=2)
    @Column(name = "PRICE_OUT2", nullable = false)
    private double price_out2;
    
   
    @Digits(integer=6, fraction=2)
    @Column(name = "PRICE_OUT3", nullable = false)
    private double price_out3;
    
    
    @Digits(integer=6, fraction=2)
    @Column(name = "PRICE_OUT4", nullable = false)
    private double price_out4;
    
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate date;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="ORDER_ID")
    private Client_Orders clientorders;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "CLIENT_ORDERS", joinColumns = { @JoinColumn(name = "USER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "ORDER_ID") })
        private Set <Users> users;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getPr1_id() {
        return pr1_id;
    }

    public void setPr1_id(int pr1_id) {
        this.pr1_id = pr1_id;
    }

    public int getPr2_id() {
        return pr2_id;
    }

    public void setPr2_id(int pr2_id) {
        this.pr2_id = pr2_id;
    }

    public int getPr3_id() {
        return pr3_id;
    }

    public void setPr3_id(int pr3_id) {
        this.pr3_id = pr3_id;
    }

    public int getPr4_id() {
        return pr4_id;
    }

    public void setPr4_id(int pr4_id) {
        this.pr4_id = pr4_id;
    }

    public int getPr1_quantity() {
        return pr1_quantity;
    }

    public void setPr1_quantity(int pr1_quantity) {
        this.pr1_quantity = pr1_quantity;
    }

    public int getPr2_quantity() {
        return pr2_quantity;
    }

    public void setPr2_quantity(int pr2_quantity) {
        this.pr2_quantity = pr2_quantity;
    }

    public int getPr3_quantity() {
        return pr3_quantity;
    }

    public void setPr3_quantity(int pr3_quantity) {
        this.pr3_quantity = pr3_quantity;
    }

    public int getPr4_quantity() {
        return pr4_quantity;
    }

    public void setPr4_quantity(int pr4_quantity) {
        this.pr4_quantity = pr4_quantity;
    }

    public double getPrice_out1() {
        return price_out1;
    }

    public void setPrice_out1(double price_out1) {
        this.price_out1 = price_out1;
    }

    public double getPrice_out2() {
        return price_out2;
    }

    public void setPrice_out2(double price_out2) {
        this.price_out2 = price_out2;
    }

    public double getPrice_out3() {
        return price_out3;
    }

    public void setPrice_out3(double price_out3) {
        this.price_out3 = price_out3;
    }

    public double getPrice_out4() {
        return price_out4;
    }

    public void setPrice_out4(double price_out4) {
        this.price_out4 = price_out4;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client_Orders getClientorders() {
        return clientorders;
    }

    public void setClientorders(Client_Orders clientorders) {
        this.clientorders = clientorders;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
    
}
