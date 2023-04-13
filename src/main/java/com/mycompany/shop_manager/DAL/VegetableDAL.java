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
        session.beginTransaction();
        List<Vegetable> vegetable= session.createQuery("FROM Vegetable",Vegetable.class).list();
        //vegetable.forEach(System.out::println);
        session.getTransaction().commit();
        return vegetable;
    }
    
    public Vegetable getVegetable(int VegetableID){
        session.beginTransaction();
        Vegetable o = session.get(Vegetable.class, VegetableID);
        session.getTransaction().commit();
        return o;
    }
    
    public void addVegetable(Vegetable v){
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
    }
    
    public void updateVegetable(Vegetable v){
        session.beginTransaction();
        session.update(v);
        session.getTransaction().commit();
    }
    
    public void deleteVegetable(Vegetable v){
        session.beginTransaction();
        session.delete(v);
        session.getTransaction().commit();
    }
    
    public void closeSession(){
        session.close();
    }
//    public static void main(String[] args) {
//        VegetableDAL t = new VegetableDAL();
//        t.loadVegetable();
//    }
}
