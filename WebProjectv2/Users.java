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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
 
@Entity
@Table(name="USERS")
public class Users implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private int id;
    
    
    /*@NotNull
    @Column(name="FLAG",nullable=false)
    private int flag;*/
    
    @NotNull
    @Size (min=4,max=10)
    @Column(name="USERNAME",nullable=false)
    private String username;
    
    @NotNull
    @Size (min=4,max=10)
    @Column(name="PASSWORD",nullable=false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userinfo;
    
    public Users(){}
    
    /*@OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Bank_accounts bank_accounts;*/
    
    /*@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="USER_ID")
    private Client_Orders clientorders;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Wishlist wishlist;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Cart cart;
    
    @OneToMany(mappedBy="USERS")
    private Set <MemberSales> membersales;
    
    @ManyToMany(mappedBy = "USERS")
    private Set<Orders> orders;*/
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userinfo;
    }

    public void setUserInfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    /*public Bank_accounts getBank_accounts() {
        return bank_accounts;
    }

    public void setBank_accounts(Bank_accounts bank_accounts) {
        this.bank_accounts = bank_accounts;
    }*/

    /*public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<MemberSales> getMembersales() {
        return membersales;
    }

    public void setMembersales(Set<MemberSales> membersales) {
        this.membersales = membersales;
    }*/

    /*public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
