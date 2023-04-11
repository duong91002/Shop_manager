package com.mycompany.shop_manager.DAL;

import java.util.List;
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
public class Vegetable implements Serializable {
    
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
    private Double Price;
    
    @ManyToOne
    @JoinColumn(name="CatagoryID",insertable = false, updatable = false)
    private Category catagory;
    
    
    @OneToMany (mappedBy = "vegetable")  
    private List<Orderdetail> listOrderdetail;
 
    @Override
    public String toString()
    {
        return this.VegetableName;
    }
}
