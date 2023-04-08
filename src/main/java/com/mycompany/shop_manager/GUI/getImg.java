/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.GUI;
import java.io.File;

/**
 *
 * @author haidu
 */
public class getImg {

    public getImg() {
    }
    public String imgs(String str)
    {
        String path = new File("src/main/java/com/mycompany/shop_manager/GUI/res/").getAbsolutePath()
            +"/"+str
                ;
        System.out.println(path);
//        File img = new File(path);
        return path;
    }
}
