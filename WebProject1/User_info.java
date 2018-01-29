/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 

 
@Entity
@Table(name="USER_INFO")
public class User_info {
    
    @Id
    @Column(name="USER_ID",nullable=false)
    private int user_id;
    
    @NotNull
    @Size (min=2,max=11)
    @Column(name="FIRST_NAME",nullable=false)
    private String first_name;
    
    @NotNull
    @Size (min=2,max=11)
    @Column(name="LAST_NAME",nullable=false)
    private String last_name;
    
    @NotNull
    @Size (min=10,max=20)
    @Column(name="PHONE_NUMBER",nullable=false)
    private String phone_number;
    
    @NotNull
    @Size (min=5,max=50)
    @Column(name="EMAIL",nullable=false)
    private String email;
    
    @NotNull
    @Size (min=10,max=20)
    @Column(name="ADDRESS_1",nullable=false)
    private String address_1;

    @NotNull
    @Size (min=10,max=20)
    @Column(name="ADDRESS_2",nullable=true)
    private String address_2;
}
