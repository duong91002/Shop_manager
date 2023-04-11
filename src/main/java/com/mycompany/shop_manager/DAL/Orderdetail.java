/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.Table;
/**
 *
 * @author haidu
 */
@Data
@Entity
@Table(name="Orderdetail")
public class Orderdetail implements Serializable{
    @Id
    @Column
    private int OrderID;
    
    @Id
    @Column
    private int VegetableID;
    
    @Column
    private int Quantity;
    
    @Column
    private double Price;
    
    @ManyToOne
    @JoinColumn(name="OrderID",insertable = false, updatable = false)
    private Order order;
    
    @ManyToOne
    @JoinColumn(name="VegetableID",insertable = false, updatable = false)
    private Vegetable vegetable;
}
