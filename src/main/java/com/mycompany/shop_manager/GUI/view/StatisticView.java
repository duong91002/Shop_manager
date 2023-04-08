package com.mycompany.shop_manager.GUI.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mycompany.shop_manager.GUI.ColorTheme;

public class StatisticView extends JPanel {
        public static StatisticViewPanel p1= new StatisticViewPanel();
        public static StatisticProductViewPanel p2= new StatisticProductViewPanel();
	/**
	 * Create the panel.
	 */
	public StatisticView() {
		setLayout(new CardLayout(0, 0));
		add(p1);
                add(p2);
                p2.setVisible(false);
		setBackground(Color.decode(ColorTheme.bg));
	}

}
