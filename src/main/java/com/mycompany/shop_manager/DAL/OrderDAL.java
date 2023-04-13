/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author haidu
 */
public class OrderDAL {
    
    Session session;
    
    public OrderDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List<Order> loadOrder(){
        session.beginTransaction();
        List<Order> o= session.createQuery("FROM Order",Order.class).list();
        //o.forEach(System.out::println);
        session.getTransaction().commit();
        return o;
    }
    
    public Order getOrder(int OrderID){
        session.beginTransaction();
        Order o = session.get(Order.class, OrderID);
        session.getTransaction().commit();
        return o;
    }
    
    public int addOrder(Order o){
        session.beginTransaction();
        int result = (int)session.save(o);
        session.getTransaction().commit();
        return result;
    }
    
    public void updateOrder(Order o){
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
    }
    
    public void deleteOrder(Order o){
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
    }
    
    public void closeSession(){
        session.close();
    }
    
//    public static void main(String[] args) {
//        OrderDAL t = new OrderDAL();
//        t.loadOrder();
//    }
}
