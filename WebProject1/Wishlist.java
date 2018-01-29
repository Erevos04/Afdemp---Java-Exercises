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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 

 
@Entity
@Table(name="WISHLIST")
public class Wishlist {
    
    
    @Id
    @Column(name="USER_ID",nullable=false)
    private int user_id;
    
    @NotNull
    @Column(name="PR_ID",nullable=false)
    private int pr_id;
    
    @OneToMany(mappedBy="PRODUCTS")
    private Set <Products> products;
    
    
    
}
