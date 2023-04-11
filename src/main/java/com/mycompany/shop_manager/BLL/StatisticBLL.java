/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.BLL;


import com.mycompany.shop_manager.DAL.Customers;
import com.mycompany.shop_manager.DAL.Order;
import com.mycompany.shop_manager.DAL.OrderDAL;
import com.mycompany.shop_manager.DAL.Orderdetail;
import com.mycompany.shop_manager.DAL.OrderdetailDAL;
import com.mycompany.shop_manager.DAL.Vegetable;
import com.mycompany.shop_manager.DAL.VegetableDAL;
import java.util.List;

/**
 *
 * @author haidu
 */
public class StatisticBLL {
    OrderDAL order= new OrderDAL();
    OrderdetailDAL orderDetail= new OrderdetailDAL();
    VegetableDAL vegetable= new VegetableDAL();
    public List<Order> loadOrder(){
        return order.loadOrder();
    }
    public List<Orderdetail> loadOrderdetail(){
        return orderDetail.loadOrderdetail();
    }
    
    public List<Vegetable> loadVegetable(){
        return vegetable.loadVegetable();
    }
}
