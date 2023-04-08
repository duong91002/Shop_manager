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
public class VegetableDAL {
    Session session;
    
    public VegetableDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    /**
     *
     * @return
     */
    public List<Vegetable> loadVegetable(){
        try(Session session = HibernateUtils.getSessionFactory().openSession();){
            session.beginTransaction();
            List<Vegetable> vegetable= session.createQuery("FROM Vegetable",Vegetable.class).list();
            vegetable.forEach(System.out::println);
            session.getTransaction().commit();
            return vegetable;
        }
    }
//    public static void main(String[] args) {
//        VegetableDAL t = new VegetableDAL();
//        t.loadVegetable();
//    }
}
