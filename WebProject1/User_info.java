/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 

 
@Entity
@Table(name="USER_INFO")
public class User_info implements Serializable {
    
    @Id
    @Column(name="USER_ID",unique=true,nullable=false)
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }
    
    
}
