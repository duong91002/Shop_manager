/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author haidu
 */
@Data
@Entity
@Table(name = "`Order`")
public class Order implements Serializable {
    @Id
    private int OrderID;
    
    @Column
    private int CustomerID;
    
    @Column
    private Date Date;
    
    @Column
    private float Total;
    
    @Column
    private String Note;
    
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="CustomerID",nullable = false, foreignKey = @ForeignKey(name="fk_post_Customer"))
//    private Customers customers;
    
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "Orderdetail", 
//        joinColumns = { @JoinColumn(name = "OrderID", nullable = false, updatable = false) }, 
//        inverseJoinColumns = { @JoinColumn(name = "VegetableID", nullable = false, updatable = false) })
//    private List vegetable;
}
