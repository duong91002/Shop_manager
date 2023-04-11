/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.shop_manager.GUI.view;


import com.mycompany.shop_manager.BLL.StatisticBLL;
import com.mycompany.shop_manager.DAL.Customers;
import com.mycompany.shop_manager.DAL.Order;
import com.mycompany.shop_manager.DAL.Orderdetail;
import com.mycompany.shop_manager.DAL.Vegetable;
import com.mycompany.shop_manager.GUI.ColorTheme;
import static com.mycompany.shop_manager.GUI.view.StatisticView.p1;
import static com.mycompany.shop_manager.GUI.view.StatisticView.p2;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haidu
 */
public class StatisticProductViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form StatisticProductViewPanel
     */
    StatisticBLL bll= new StatisticBLL();
    List<Orderdetail> listOrderdetail= bll.loadOrderdetail();
    JDateChooser c1, c2;
    Date date1, date2;
    String strDate1, strDate2;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public StatisticProductViewPanel() {
        initComponents();
        init();
        custom();
        loadTable();
        jTable1.setAutoCreateRowSorter(true);
    }
    public final void loadTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Danh mục");
        model.addColumn("Số lượng");
        model.addColumn("Ảnh");
        model.addColumn("Giá");
        int countProduct=0;
        int countEachProduct = 0;
        double countEachPrice = 0 ;
        int location= -1;
        for(Orderdetail o: listOrderdetail){
            if(o.getOrder().getDate().after(date1) && o.getOrder().getDate().before(date2)){
                for(int i = 0 ; i< countProduct; i++){
                    int valueTable=(int) jTable1.getValueAt(i, 0);
                        if(o.getVegetableID() == valueTable){
                            location = i;
                            break;
                        }
                    }
                if(location != -1){// neu trùng thì cong thêm 
                    countEachProduct+=o.getQuantity();
                    countEachPrice+=o.getPrice();
                    int sumProduct = (int) jTable1.getValueAt(location, 3);
                    double sumPrice = (double) jTable1.getValueAt(location, 5);
                    jTable1.setValueAt(countEachProduct + sumProduct, location, 3);
                    jTable1.setValueAt(countEachPrice + sumPrice, location, 5);
                    location = -1;
                }else{// không trùng thì thêm 
                    countProduct++;
                    countEachProduct += o.getQuantity();
                    countEachPrice += o.getPrice();
                    model.addRow(new Object[]{
                                o.getVegetableID(),
                                o.getVegetable().getVegetableName(), 
                                "[" + o.getVegetable().getCatagoryID() + "] " + o.getVegetable().getCatagory().getName(), 
                                countEachProduct, 
                                o.getVegetable().getImage(), 
                                countEachPrice
                            });
                    jTable1.setModel(model);
                    countEachProduct = 0;
                    countEachPrice = 0;
                }
            }
        }
        lbl_CountProduct.setText("Tổng: "+countProduct+" sản phẩm");
    }
    public final void init(){
        c1= new JDateChooser();
        c1.setDate(new Date(2000-1900, 1-1, 1));
        date1= c1.getDate();
        strDate1 = dateFormat.format(date1);
        c1.setBounds(0, 0, 200, 30);
        pnl_contentTopLeft.add(c1);

        c2= new JDateChooser();
        c2.setDate(new Date());
        date2= c2.getDate();
        strDate2= dateFormat.format(date2);
        c2.setBounds(220, 0, 200, 30);
        pnl_contentTopLeft.add(c2);
        
        lbl_time.setText("Từ ngày "+strDate1+" đến "+strDate2);
        
        c1.addPropertyChangeListener("date", new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("date".equals(evt.getPropertyName())) {
                Date selectedDate = (Date) evt.getNewValue();
                date1= selectedDate;
                strDate1 = dateFormat.format(selectedDate);
                lbl_time.setText("Từ ngày "+strDate1+" đến "+strDate2);
                loadTable();
                }
            }
        });
        c2.addPropertyChangeListener("date", new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("date".equals(evt.getPropertyName())) {
                Date selectedDate = (Date) evt.getNewValue();
                date2= selectedDate;
                strDate2 = dateFormat.format(selectedDate);
                lbl_time.setText("Từ ngày "+strDate1+" đến "+strDate2);
                loadTable();
                }
            }
        });
    }
    public final void custom(){
        lbl_headerProducts.setForeground(Color.decode(ColorTheme.primary));
        lbl_CountProduct.setForeground(Color.decode(ColorTheme.primary));
        pnl_Header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Header = new javax.swing.JPanel();
        lbl_headerProducts = new javax.swing.JLabel();
        lbl_headerStatistic = new javax.swing.JLabel();
        pnl_ContentTop = new javax.swing.JPanel();
        pnl_contentTopLeft = new javax.swing.JPanel();
        pnl_contentTopRight = new javax.swing.JPanel();
        lbl_TitleProduct = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        lbl_CountProduct = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        lbl_headerProducts.setText("Sản phẩm");
        lbl_headerProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_headerProducts.setPreferredSize(new java.awt.Dimension(56, 16));
        lbl_headerProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_headerProductsMouseClicked(evt);
            }
        });

        lbl_headerStatistic.setText("Doanh thu");
        lbl_headerStatistic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_headerStatistic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_headerStatisticMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_HeaderLayout = new javax.swing.GroupLayout(pnl_Header);
        pnl_Header.setLayout(pnl_HeaderLayout);
        pnl_HeaderLayout.setHorizontalGroup(
            pnl_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_HeaderLayout.createSequentialGroup()
                .addComponent(lbl_headerStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_headerProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_HeaderLayout.setVerticalGroup(
            pnl_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbl_headerProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addComponent(lbl_headerStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_contentTopLeftLayout = new javax.swing.GroupLayout(pnl_contentTopLeft);
        pnl_contentTopLeft.setLayout(pnl_contentTopLeftLayout);
        pnl_contentTopLeftLayout.setHorizontalGroup(
            pnl_contentTopLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        pnl_contentTopLeftLayout.setVerticalGroup(
            pnl_contentTopLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnl_contentTopRight.setBackground(new java.awt.Color(255, 255, 255));

        lbl_TitleProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TitleProduct.setText("Sản phẩm");

        lbl_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_time.setText("Từ ngày xx đến ngày xxx");

        lbl_CountProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_CountProduct.setText("6 sản phâm");

        javax.swing.GroupLayout pnl_contentTopRightLayout = new javax.swing.GroupLayout(pnl_contentTopRight);
        pnl_contentTopRight.setLayout(pnl_contentTopRightLayout);
        pnl_contentTopRightLayout.setHorizontalGroup(
            pnl_contentTopRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_time, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
            .addComponent(lbl_TitleProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_CountProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_contentTopRightLayout.setVerticalGroup(
            pnl_contentTopRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_contentTopRightLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lbl_TitleProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_time, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_CountProduct)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout pnl_ContentTopLayout = new javax.swing.GroupLayout(pnl_ContentTop);
        pnl_ContentTop.setLayout(pnl_ContentTopLayout);
        pnl_ContentTopLayout.setHorizontalGroup(
            pnl_ContentTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ContentTopLayout.createSequentialGroup()
                .addComponent(pnl_contentTopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_contentTopRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_ContentTopLayout.setVerticalGroup(
            pnl_ContentTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_contentTopLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_ContentTopLayout.createSequentialGroup()
                .addComponent(pnl_contentTopRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên sản phẩm", "Danh mục", "Số lượng", "Ảnh", "Giá"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_ContentTop, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnl_ContentTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void setActive(JLabel lbl) {
        lbl_headerStatistic.setForeground(Color.BLACK);
        lbl_headerProducts.setForeground(Color.BLACK);
        lbl.setForeground(Color.decode(ColorTheme.primary));
    }
    private void lbl_headerProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_headerProductsMouseClicked
        // TODO add your handling code here:
        setActive(lbl_headerProducts);
    }//GEN-LAST:event_lbl_headerProductsMouseClicked

    private void lbl_headerStatisticMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_headerStatisticMouseClicked
        // TODO add your handling code here:
        setActive(lbl_headerStatistic);
        p1.setVisible(true);
        p2.setVisible(false);
    }//GEN-LAST:event_lbl_headerStatisticMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_CountProduct;
    private javax.swing.JLabel lbl_TitleProduct;
    private javax.swing.JLabel lbl_headerProducts;
    private javax.swing.JLabel lbl_headerStatistic;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JPanel pnl_ContentTop;
    private javax.swing.JPanel pnl_Header;
    private javax.swing.JPanel pnl_contentTopLeft;
    private javax.swing.JPanel pnl_contentTopRight;
    // End of variables declaration//GEN-END:variables
}
