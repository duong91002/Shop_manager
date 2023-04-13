package com.mycompany.shop_manager.GUI.view;

import com.mycompany.shop_manager.GUI.ColorTheme;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class BillView extends JPanel {

	/**
	 * Create the panel.
	 */
    
    public static BillProductPanel prod = new BillProductPanel();
    public static BillPayPanel pay = new BillPayPanel();
    public static BillOrderPanel order = new BillOrderPanel();
    
	public BillView() {
		setLayout(new CardLayout(0, 0));
                add(prod);
                add(pay);
                add(order);
                order.setVisible(false);
                pay.setVisible(false);
                //setBackground(Color.decode(ColorTheme.bg));
	}

}
