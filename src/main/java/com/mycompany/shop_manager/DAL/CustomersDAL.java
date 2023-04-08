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
public class CustomersDAL {
    public List<Customers> loadCustomers(){
        try(Session session = HibernateUtils.getSessionFactory().openSession();){
            session.beginTransaction();
            List<Customers> c= session.createQuery("FROM Customers",Customers.class).list();
            c.forEach(System.out::println);
            session.getTransaction().commit();
            return c;
        }
    }
//    public static void main(String[] args) {
//        CustomersDAL cus= new CustomersDAL();
//        cus.loadCustomers();
//    }
}
