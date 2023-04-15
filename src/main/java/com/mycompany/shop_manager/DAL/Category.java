/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.io.Serializable;
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
    private int CategoryID;
    @Column
    private String Name;
    @Column
    private String Description;
    public int getCategoryID(){
        return  CategoryID;
    }
    public String getName(){
        return  Name;
    }
    public String getDescription(){
        return  Description;
    }
    public void setCategoryID(int CategoryID){
        this.CategoryID=CategoryID;
    }
    public void setName(String Name){
        this.Name=Name;
    }
     public void setDescription(String Description){
        this.Description=Description;
    }
    
//    @OneToMany (mappedBy = "catagory")  
//    private List<Vegetable> listVegetable;
 
//    @Override
//    public String toString()
//    {
//        return this.Name;
//    }
}
