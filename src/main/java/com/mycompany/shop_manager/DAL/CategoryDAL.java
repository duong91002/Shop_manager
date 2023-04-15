/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.DAL;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author haidu
 */
public class CategoryDAL {

    public CategoryDAL() {
        Session session = HibernateUtils.getSessionFactory().openSession();
    }

   public ArrayList<Category> loadCategory() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Category> categories = (ArrayList<Category>) session.createQuery("FROM Category", Category.class).list();
            categories.forEach(System.out::println);
            session.getTransaction().commit();
            return categories;
        }
   }
   
   public void addCategory(Category category){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }
    }
    
    public void updateCategory(Category category){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
        }
    }
    
    public void deleteCategory(Category category){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            
            session.beginTransaction();
            session.delete(category);   
            session.getTransaction().commit();
        }
    }
    
    public static void main(String[] args) {
        CategoryDAL categoryDAL = new CategoryDAL();
        Category c = new Category();
        c.setCategoryID(4);
        c.setName("bbbb");
        c.setDescription(null);
        categoryDAL.loadCategory();
//        categoryDAL.addCategory(c);
//        categoryDAL.updateCategory(c);
        categoryDAL.deleteCategory(c);
    }
}

