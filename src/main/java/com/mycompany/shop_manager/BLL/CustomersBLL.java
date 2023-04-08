/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.BLL;

import com.mycompany.shop_manager.DAL.Customers;
import com.mycompany.shop_manager.DAL.CustomersDAL;
import java.util.List;

/**
 *
 * @author haidu
 */
public class CustomersBLL {
    CustomersDAL dal =new CustomersDAL();
    public List<Customers> loadCustomers(){
        return dal.loadCustomers();
    }
}
