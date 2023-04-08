package com.mycompany.shop_manager.GUI.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mycompany.shop_manager.GUI.ColorTheme;

public class CustomerView extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerView() {
		setLayout(new CardLayout(0, 0));
		JLabel lblThisIsHome = new JLabel("This is customer view");
		lblThisIsHome.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblThisIsHome, "name_140143002992856");
		setBackground(Color.decode(ColorTheme.bg));
	}

}
