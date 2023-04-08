/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.BLL;


import com.mycompany.shop_manager.DAL.Order;
import com.mycompany.shop_manager.DAL.OrderDAL;
import com.mycompany.shop_manager.DAL.OrderdetailDAL;
import java.util.List;

/**
 *
 * @author haidu
 */
public class StatisticBLL {
    OrderDAL o= new OrderDAL();
    public List<Order> loadOrder(){
        return o.loadOrder();
    }
}
