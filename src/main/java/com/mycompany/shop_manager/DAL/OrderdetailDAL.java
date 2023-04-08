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
public class OrderdetailDAL {
    
    Session session;
    
    public OrderdetailDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public List<Orderdetail> loadOrderdetail(){
        try(Session session = HibernateUtils.getSessionFactory().openSession();){
            session.beginTransaction();
            List<Orderdetail> orderdetail= session.createQuery("FROM Orderdetail",Orderdetail.class).list();
            orderdetail.forEach(System.out::println);
            session.getTransaction().commit();
            return orderdetail;
        }
    }
//    public static void main(String[] args) {
//        OrderdetailDAL a =new OrderdetailDAL();
//        a.loadOrderdetail();
//    }
    
}
