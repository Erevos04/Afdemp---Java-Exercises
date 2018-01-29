/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

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
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="MEMBER_SALES")
public class MemberSales {
    
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
    
    @OneToMany(mappedBy="USERS")
    private Set <Users> users;
    
    @OneToMany(mappedBy="PRODUCTS")
    private Set <Products> products;
}
