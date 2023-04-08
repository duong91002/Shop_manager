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
    
//    @OneToMany (mappedBy = "customers", fetch = FetchType.LAZY)  
//    private Set<Order> listOrder;
}
