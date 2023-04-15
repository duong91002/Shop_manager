/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.BLL;

import com.mycompany.shop_manager.DAL.Category;
import com.mycompany.shop_manager.DAL.CategoryDAL;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CategoryBLL {
    private CategoryDAL categoryDAL;
    private ArrayList<Category> categorylist;
    // Khởi tạo đối tượng CategoryDAL
    public CategoryBLL() {
        categoryDAL = new CategoryDAL();
        categorylist=new ArrayList<>();
        categorylist=categoryDAL.loadCategory();
    }

    // Phương thức lấy danh sách các Category từ database
    public ArrayList<Category> getCategories() {
        return categorylist;
    }
    public void setCategories(ArrayList<Category>categorylist){
        this.categorylist=categorylist;
    }
    // Phương thức thêm mới một Category
    public void addCategory(Category category) {
        categoryDAL.addCategory(category);
        categorylist.add(category);
    }
    public void updateCategory(Category category){
        categoryDAL.updateCategory(category);
        //thay dổi thông tin Category:
    }
    public void deleteCategory(Category category){
        categoryDAL.deleteCategory(category);
    }
    public ArrayList<Category> SearchbyName(String name){
        ArrayList<Category> arr=new ArrayList<>();
        for(Category cate:categorylist){
            if(cate.getName().toUpperCase().equals(name.toUpperCase())){
                arr.add(cate);
            }
        }
        return arr;
    }
    public String SeachByID(int id){
        String s = null;
        for(Category c: categorylist){
            if(c.getCategoryID()==id){
                s=c.getName();
                break;
            }
        }
        return s;
    }
    
}
