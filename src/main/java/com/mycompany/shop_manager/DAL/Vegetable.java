package com.mycompany.shop_manager.DAL;

import java.awt.List;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author caothanh
 */
@Data
@Entity
@Table(name = "Vegetable")
public class Vegetable  implements Serializable {
    
    @Id
    private int VegetableID;
    @Column 
    private int CatagoryID;
    @Column 
    private String VegetableName;
    @Column
    private String Unit;
    @Column
    private int Amount;
    @Column 
    private String Image;
    @Column
    private float Price;
    public int getVegetableID() {
        return VegetableID;
    }
    public void setVegetableID(int VegetableID) {
        this.VegetableID = VegetableID;
    }
    public int getCatagoryID() {
        return CatagoryID;
    }
    public void setCatagoryID(int CatagoryID) {
        this.CatagoryID = CatagoryID;
    }
    
    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }
    public int getAmount(){
        return Amount;
    }
    public void setAmount(int Amount){
        this.Amount=Amount;
    }
    public String getImage() {
        return Image;
    }
    public void setImage(String Image) {
        this.Image = Image;
    }
    public float getPrice() {
        return Price;
    }
    public void setPrice(float Price) {
        this.Price = Price;
    }

    
//    @ManyToOne
//    @JoinColumn(name="CatagoryID")
//    private Category catagory;
    
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "vegetable")
//    private List Orders;
}
