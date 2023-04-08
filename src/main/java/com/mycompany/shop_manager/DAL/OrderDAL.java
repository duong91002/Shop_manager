/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author haidu
 */
public class OrderDAL {
    public List<Order> loadOrder(){
        try(Session session = HibernateUtils.getSessionFactory().openSession();){
            session.beginTransaction();
            List<Order> o= session.createQuery("FROM Order",Order.class).list();
            o.forEach(System.out::println);
            session.getTransaction().commit();
            return o;
        }
    }
//    public static void main(String[] args) {
//        OrderDAL t = new OrderDAL();
//        t.loadOrder();
//    }
}
