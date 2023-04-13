/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.BLL;

import com.mycompany.shop_manager.DAL.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class OrderBLL {
    
    OrderDAL orDAL = new OrderDAL();
    OrderdetailDAL ordeDAL = new OrderdetailDAL();
    VegetableDAL VeDAL = new VegetableDAL();
    CategoryDAL cateDAL = new CategoryDAL();
    CustomersDAL cusDAL = new CustomersDAL();
    
    public List<Order> loadOrders(){
        return orDAL.loadOrder();
    }
    public List<Orderdetail> loadOrderDetail(){
        return ordeDAL.loadOrderdetail();
    }
    public List<Vegetable> loadProducts(){
        return VeDAL.loadVegetable();
    }
    public List<Customers> loadcustomer(){
        return cusDAL.loadCustomers();
    }
    public List<Category> loadcategory(){
        return cateDAL.loadCategory();
    }
    
    public String addOrder(Order o,int id){
        int result = orDAL.addOrder(o);
        if(id == result)
            return "Success";
        return "Error";
    }
    public void updateOrder(Order o){
        orDAL.updateOrder(o);
    }
    public void deleteOrder(Order o){
        orDAL.deleteOrder(o);
    }
    
    public void addOrderDetail(Orderdetail o){
        ordeDAL.addOrderDetail(o);
        
    }
    public void updateOrder(Orderdetail o){
        ordeDAL.updateOrderDetail(o);
    }
    public void deleteOrder(Orderdetail o){
        ordeDAL.deleteOrderDetail(o);
    }
    
    public void addVegetable(Vegetable v){
        VeDAL.addVegetable(v);
    }
    public void updateVegetable(Vegetable v){
        VeDAL.updateVegetable(v);
    }
    public void deleteVegetable(Vegetable v){
        VeDAL.deleteVegetable(v);
    }
    
    public DefaultTableModel convertOrder(List<Order> list){
        String[] ConlumnNames = {"ID","Customer","Date","Total","Note","Products"};
        
        Object[][] data = new Object[list.size()][6];
        
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getOrderID()+1;
            data[i][1] = list.get(i).getCustomer().getFullname();
            data[i][2] = list.get(i).getDate();
            data[i][3] = list.get(i).getTotal();
            data[i][4] = list.get(i).getNote();
            data[i][5] = list.get(i).getListOrderDetail().size();
        }
        
        DefaultTableModel model = new DefaultTableModel(data, ConlumnNames);
        return model;
    }
    
    public DefaultTableModel convertVegetable(List<Vegetable> list){
        String[] ConlumnNames = {"ID","Name","Category","Unit","Amount","Image","Price"};
        
        Object[][] data = new Object[list.size()][7];
        
        for(int i = 0; i < list.size(); i++){
            
            data[i][0] = list.get(i).getVegetableID();
            data[i][1] = list.get(i).getVegetableName();
            data[i][2] = list.get(i).getCatagory();
            data[i][3] = list.get(i).getUnit();
            data[i][4] = list.get(i).getAmount();
            data[i][5] = list.get(i).getImage();
            data[i][6] = list.get(i).getPrice();
        }
        
        DefaultTableModel model = new DefaultTableModel(data, ConlumnNames);
        return model;
    }
    
    public DefaultTableModel ConvertOrderDetail(List<Orderdetail> list){
        String[] ConlumnNames = {"Vegetable","Quantity","Price"};
        Object[][] data = new Object[list.size()][4];
        
        for(int i = 0; i < list.size(); i++){
            data[i][0] = list.get(i).getVegetable().getVegetableName();
            data[i][1] = list.get(i).getQuantity();
            data[i][2] = list.get(i).getPrice();
        }
        
        DefaultTableModel model = new DefaultTableModel(data, ConlumnNames);
        return model;
    }
    
    public Object[] ConvertCusCb(List<Customers> list){
        Object[] item = new Object[list.size()];
        for(int i = 0; i < list.size(); i++){
            item[i] = list.get(i).getCustomerID() + "." + list.get(i).getFullname();
        }
        return item;
    }
    
    public Object[] ConverCateCb(List<Category> list){
        Object[] item = new Object[list.size()];
        for(int i = 0; i < list.size(); i++){
            item[i] = list.get(i).getCatagoryID() + "." + list.get(i).getName();
        }
        return item;
    }
    
    public List<Order> Search(String s, String choose){
        List<Order> list = orDAL.loadOrder();
        List<Order> result = new ArrayList<Order>();
        try {
            switch(choose){
                case "ID":
                    for (Order order : list) {
                        if((order.getOrderID()+1) == Integer.parseInt(s)){
                            result.add(order);
                        }
                    }
                    break;
                case "Customers":
                    for (Order order : list) {
                        if(order.getCustomer().getFullname().toLowerCase().trim().contains(s)){
                            result.add(order);
                        }
                    }
                    break;
                case "Total":
                    for (Order order : list) {
                        if(order.getTotal() == Integer.parseInt(s)){
                            result.add(order);
                        }
                    }
                    break;
                case "Note":
                    for (Order order : list) {
                        if(order.getNote().toLowerCase().trim().contains(s.trim().toLowerCase())){
                            result.add(order);
                        }
                    }
                    break;
                case "Products":
                    for (Order order : list) {
                        if(order.getListOrderDetail().size() == Integer.parseInt(s)){
                            result.add(order);
                        }
                    }
                    break;
            }
        } catch (Exception e) {
        }
        return result;
    }
}
