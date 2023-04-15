/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author haidu
 */
public class VegetableDAL {

    
    
    public VegetableDAL() {
        Session session = HibernateUtils.getSessionFactory().openSession();
    }

    /**
     *
     * @return
     */
   public ArrayList<Vegetable> loadVegetable() {
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        session.beginTransaction();
        ArrayList<Vegetable> vegetable = (ArrayList<Vegetable>) session.createQuery("FROM Vegetable", Vegetable.class).list();
        vegetable.forEach(System.out::println);
        session.getTransaction().commit();
        return vegetable;
    }
}
    public void addVegetable(Vegetable vegetable){
      try(Session session=HibernateUtils.getSessionFactory().openSession()){
          session.beginTransaction();
          session.save(vegetable);
          session.getTransaction().commit();
      }
    }
    public void updateVegetable(Vegetable vegetable){
         try(Session session=HibernateUtils.getSessionFactory().openSession()){
          session.beginTransaction();
          session.update(vegetable);
          session.getTransaction().commit();
      }
    }
     public void deleteVegetable(Vegetable vegetable){
         try(Session session=HibernateUtils.getSessionFactory().openSession()){
          session.beginTransaction();
          session.delete(vegetable);
          session.getTransaction().commit();
      }
    }
    public static void main(String[] args) {
        VegetableDAL t = new VegetableDAL();
        Vegetable a=new Vegetable();
        a.setVegetableID(0);
        a.setVegetableName("a");
        a.setAmount(0);
        a.setImage("");
        a.setPrice(0);
        a.setUnit("abcdef");
        a.setCatagoryID(2);
        t.loadVegetable();
//        t.addVegetable(a);
//        t.updateVegetable(a);
        t.deleteVegetable(a);
    }
}
