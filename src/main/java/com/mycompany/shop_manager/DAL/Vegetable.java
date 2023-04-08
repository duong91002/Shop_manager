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
    
//    @ManyToOne
//    @JoinColumn(name="CatagoryID")
//    private Category catagory;
    
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "vegetable")
//    private List Orders;
}
