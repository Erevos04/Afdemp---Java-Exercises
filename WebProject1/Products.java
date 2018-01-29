package com.websystique.springmvc.model;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="PRODUCTS")
public class Products {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pr_id;
    
    @Size(min=3, max=30)
    @Column(name = "NAME", nullable = false)
    private String name;
 
    @NotNull
    @Column(name="CATEGORY", nullable = false)
    private int category;
    
    @NotNull
    @Column(name="QUANTITY",nullable=false)
    private int quantity;
    
    @NotNull
    @Column(name="IMAGE" , nullable=false)
    private String image;
      
    @NotNull
    @Digits(integer=6, fraction=2)
    @Column(name = "PRICE_IN", nullable = false)
    private double price_in;
     
    @NotNull
    @Digits(integer=6, fraction=2)
    @Column(name = "PRICE_OUT", nullable = false)
    private double price_out;
    
    @ManyToOne
    @JoinColumn(name="PR_ID", nullable=false)
    private Wishlist wishlist;
    
    @ManyToOne
    @JoinColumn(name="PR_ID", nullable=false)
    private Cart cart;
    
    @ManyToOne
    @JoinColumn(name="PR_ID", nullable=false)
    private MemberSales membersales;
    
    
 
    public int getpr_id() {
        return pr_id;
    }
 
    public void setpr_id(int pr_id) {
        this.pr_id = pr_id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    
    
 
    public double getprice_in() {
        return price_in;
    }
 
    public void setprice_in(double price_in) {
        this.price_in = price_in;
    }
 
    public double getprice_out() {
        return price_out;
    }
 
    public void setprice_out(double price_out) {
        this.price_out = price_out;
    }
 
    
 
 
    @Override
    public String toString() {
        return "";
    }
     
}