/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.BLL;

import com.mycompany.shop_manager.DAL.Vegetable;
import com.mycompany.shop_manager.DAL.VegetableDAL;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class VegtableBLL {
    private VegetableDAL vegetableDAL;
    private ArrayList<Vegetable> vegetablelist;

    public VegtableBLL() {
        vegetableDAL = new VegetableDAL();
        vegetablelist=new ArrayList<>();
        vegetablelist=vegetableDAL.loadVegetable();
    }
    
     public ArrayList<Vegetable> getVegetables() {
        return vegetablelist;
    }
    public void seVegetables(ArrayList<Vegetable>vegetablelist){
        this.vegetablelist=vegetablelist;
    }
    public void addVegetable(Vegetable vegetable) {
        vegetableDAL.addVegetable(vegetable);
        vegetablelist.add(vegetable);
    }
    public void updateVegetable(Vegetable vegetable){
        vegetableDAL.updateVegetable(vegetable);
        //thay dổi thông tin Category:
    }
    public void deleteVegetable(Vegetable vegetable){
        vegetableDAL.deleteVegetable(vegetable);
    }
     public ArrayList<Vegetable> SearchbyName(String name){
        ArrayList<Vegetable> arr=new ArrayList<>();
        for(Vegetable veget:vegetablelist){
            if(veget.getVegetableName().toUpperCase().equals(name.toUpperCase())){
                arr.add(veget);
            }
        }
        return arr;
    }
}
