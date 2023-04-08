/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shop_manager.GUI;


import com.mycompany.shop_manager.GUI.view.BillView;
import com.mycompany.shop_manager.GUI.view.CustomerView;
import com.mycompany.shop_manager.GUI.view.ImportView;
import com.mycompany.shop_manager.GUI.view.StatisticView;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author haidu
 */
public class MainView {
    private JFrame frame;
	private JButton importBtn, billBtn, customerBtn, statisticBtn;
	private JPanel navigateView, mainView, panel;
	private JLabel avatar;
	private JLabel lblNewLabel;
	private JPanel panel_1;
        getImg getImage= new getImg();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void lauch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Course manager app");
		frame.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		// set layout with 2 column, first has min 350, second has min 100
		gridBagLayout.columnWidths = new int[] { 250, 100 };
		gridBagLayout.rowHeights = new int[] { 500, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		this.initNavigateView();
		this.initMainView();

		frame.setVisible(true);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initMainView() {
		// add JPanel to switch between multiple JPanel
		this.mainView = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(this.mainView, gbc_panel_1);
		// add other panel from View package to main view
		this.mainView.setLayout(new CardLayout());
		this.mainView.add(new ImportView(), "import-view");
		this.mainView.add(new BillView(), "bill-view");
		this.mainView.add(new CustomerView(), "customer-view");
		this.mainView.add(new StatisticView(), "statistic-view");
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initNavigateView() {
		// add JPanel to navigate
		this.navigateView = new JPanel();
		navigateView.setBackground(Color.decode(ColorTheme.base));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(this.navigateView, gbc_panel);
		navigateView.setLayout(new GridLayout(0, 1, 0, 0));
		// create list btn naviage
		panel = new JPanel();
		panel.setBackground(Color.decode(ColorTheme.base));
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.gridx = 0;
		gbc_panel1.gridy = 0;
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		importBtn = new JButton("Import");
		importBtn.setIcon(new ImageIcon(getImage.imgs("icons8-cardboard-box-48.png")));
		addStyleBtn(importBtn);
		importBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showView("import-view");
			}
			
		});
		panel.add(importBtn);
		billBtn = new JButton("Bill");
		billBtn.setIcon(new ImageIcon(getImage.imgs("icons8-order-completed-48.png")));
		addStyleBtn(billBtn);
		billBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showView("bill-view");
			}
			
		});
		panel.add(billBtn);
		customerBtn = new JButton("Customer");
		customerBtn.setIcon(new ImageIcon(getImage.imgs("icons8-budget-48.png")));
		addStyleBtn(customerBtn);
		customerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showView("customer-view");
			}
			
		});
		panel.add(customerBtn);
		statisticBtn = new JButton("Statistic");
		statisticBtn.setIcon(new ImageIcon(getImage.imgs("icons8-analytics-48.png")));
		addStyleBtn(statisticBtn);
		statisticBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showView("statistic-view");
			}
			
		});
		panel.add(statisticBtn);
		navigateView.add(panel);

		// create Circle Image
		try {
			URL imageSource = new URL("https://i.pravatar.cc/75");
			BufferedImage image = ImageIO.read(imageSource);
			BufferedImage circularImage = new BufferedImage(image.getWidth(), image.getHeight(),
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = circularImage.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.WHITE);
			g2.fillOval(0, 0, circularImage.getWidth(), circularImage.getHeight());
			g2.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, circularImage.getWidth(), circularImage.getHeight()));
			g2.drawImage(image, 0, 0, null);
			g2.dispose();

			panel_1 = new JPanel();
			panel_1.setBackground(Color.decode(ColorTheme.base));
			navigateView.add(panel_1);
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			this.avatar = new JLabel(new ImageIcon(circularImage));
			panel_1.add(avatar);
			this.avatar.setText("Admin");
			this.avatar.setIconTextGap(20);
			this.avatar.setForeground(Color.black);
			this.avatar.setBackground(Color.decode(ColorTheme.base));
			avatar.setFont(new Font("Dialog", Font.BOLD, 24));
			GridBagConstraints gbc_avatar = new GridBagConstraints();
			gbc_avatar.fill = GridBagConstraints.BOTH;
			gbc_avatar.gridx = 0;
			gbc_avatar.gridy = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addStyleBtn(JButton btn) {
		String bg = ColorTheme.base;
		btn.setHorizontalAlignment(SwingConstants.LEADING);
		btn.setFont(new Font("Dialog", Font.BOLD, 16));
		btn.setBorder(new EmptyBorder(10, 35, 10, 20));
		btn.setBackground(Color.decode(bg));
		btn.setForeground(Color.black);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void showView(String view) {
		CardLayout layout = (CardLayout) mainView.getLayout();
		layout.show(mainView, view);
	}
}
