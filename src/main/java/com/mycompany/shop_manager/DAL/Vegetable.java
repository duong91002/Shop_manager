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
    @Column(name = "Vegetable_Name") 
    private String VegetableName;
    @Column
    private String Unit;
    @Column
    private int Amount;
    @Column 
    private String Image;
    @Column
    private Double Price;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "vegetable")
    private List<Orderdetail> orderdetail;
    
    @ManyToOne
    @JoinColumn(name="CatagoryID")
    private Category catagory;
    
//    @ManyToOne
//    @JoinColumn(name="CatagoryID")
//    private Category catagory;
    
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "vegetable")
//    private List Orders;
}
