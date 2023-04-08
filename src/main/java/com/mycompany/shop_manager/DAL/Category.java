/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "Category")

/**
 *
 * @author haidu
 */
public class Category implements Serializable { 
    @Id
    private int CatagoryID;
    @Column
    private String Name;
    @Column
    private String Description;
    
//    @OneToMany (mappedBy = "catagory")  
//    private List<Vegetable> listVegetable;
 
//    @Override
//    public String toString()
//    {
//        return this.Name;
//    }
}
