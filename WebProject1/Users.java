/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="USERS")
public class Users {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private User_info user_info;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Bank_accounts bank_accounts;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Wishlist wishlist;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private Cart cart;
    
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private MemberSales membersales;
    
    @NotNull
    @Column(name="FLAG",nullable=false)
    private int flag;
    
    @NotNull
    @Size (min=4,max=10)
    @Column(name="USERNAME",nullable=false)
    private String username;
    
    @NotNull
    @Size (min=4,max=10)
    @Column(name="PASSWORD",nullable=false)
    private String password;
}
