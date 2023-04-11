/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author haidu
 */
@Data
@Entity
@Table(name="Customers")
public class Customers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CustomerID;
    
    @Column
    private String Password;
    
    @Column
    private String Fullname;
    
    @Column
    private String Address;
    
    @Column
    private String City;
    
    @OneToMany (mappedBy = "customer")  
    private List<Order> listOrders;
    
    @Override
    public String toString()
    {
        return this.Fullname;
    }
}
