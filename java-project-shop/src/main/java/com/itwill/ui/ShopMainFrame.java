package com.itwill.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

import java.awt.Cursor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ShopMainFrame extends JFrame {
	private ProductService productService;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainParentPanel;
	private JLabel homeLabel;
	private JLabel chusukLabel;
	private JLabel specialLabel;
	private JLabel bestLabel;
	private JPanel productListPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame frame = new ShopMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShopMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 326);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("회원");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("로그인");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDialog=new LoginDialog();
				loginDialog.setShopMainFrame(ShopMainFrame.this);
				loginDialog.setModal(true);
				loginDialog.setVisible(true);
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("로그아웃");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("종료");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel menuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) menuPanel.getLayout();
		flowLayout.setVgap(1);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		menuPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(menuPanel, BorderLayout.NORTH);
		
		homeLabel = new JLabel("홈");
		homeLabel.setOpaque(true);
		homeLabel.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
				cardLayout.show(mainParentPanel, "HOME");
				menuSelectUIChange("HOME");
			}
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)mainParentPanel.getLayout()).previous(mainParentPanel);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/back-30.png")));
		menuPanel.add(btnNewButton);
		homeLabel.setIgnoreRepaint(true);
		homeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeLabel.setPreferredSize(new Dimension(50, 20));
		menuPanel.add(homeLabel);
		
		chusukLabel = new JLabel("추석");
		chusukLabel.setOpaque(true);
		chusukLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
				cardLayout.show(mainParentPanel, "CHUSUK");
				menuSelectUIChange("CHUSUK");
			}
		});
		chusukLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		chusukLabel.setIgnoreRepaint(true);
		chusukLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chusukLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chusukLabel.setPreferredSize(new Dimension(50, 20));
		menuPanel.add(chusukLabel);
		
		specialLabel = new JLabel("특가");
		specialLabel.setOpaque(true);
		specialLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
				cardLayout.show(mainParentPanel, "SPECIAL");
				menuSelectUIChange("SPECIAL");
			}
		});
		specialLabel.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		specialLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		specialLabel.setHorizontalAlignment(SwingConstants.CENTER);
		specialLabel.setPreferredSize(new Dimension(50, 20));
		menuPanel.add(specialLabel);
		
		bestLabel = new JLabel("베스트");
		bestLabel.setOpaque(true);
		bestLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
				cardLayout.show(mainParentPanel, "BEST");
				menuSelectUIChange("BEST");
			}
		});
		bestLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bestLabel.setPreferredSize(new Dimension(50, 20));
		menuPanel.add(bestLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)mainParentPanel.getLayout()).next(mainParentPanel);
				
				
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/arrow-right-30.png")));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		menuPanel.add(btnNewButton_1);
		
		mainParentPanel = new JPanel();
		mainParentPanel.setPreferredSize(new Dimension(220, 10));
		mainParentPanel.setBackground(Color.PINK);
		contentPane.add(mainParentPanel, BorderLayout.CENTER);
		mainParentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel homePanel = new JPanel();
		homePanel.setBackground(Color.YELLOW);
		mainParentPanel.add(homePanel, "HOME");
		
		JPanel chusukPanel = new JPanel();
		chusukPanel.setBackground(Color.LIGHT_GRAY);
		mainParentPanel.add(chusukPanel, "CHUSUK");
		
		JPanel specialPricePanel = new JPanel();
		specialPricePanel.setBackground(Color.ORANGE);
		mainParentPanel.add(specialPricePanel, "SPECIAL");
		
		JPanel bestPanel = new JPanel();
		bestPanel.setBackground(SystemColor.activeCaption);
		mainParentPanel.add(bestPanel, "BEST");
		
		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setPreferredSize(new Dimension(220, 0));
		mainParentPanel.add(productListScrollPane, "PRODUCT");
		
		productListPanel = new JPanel();
		productListPanel.setPreferredSize(new Dimension(220, 1000));
		FlowLayout fl_productListPanel = (FlowLayout) productListPanel.getLayout();
		fl_productListPanel.setVgap(20);
		fl_productListPanel.setHgap(20);
		fl_productListPanel.setAlignment(FlowLayout.LEFT);
		productListScrollPane.setViewportView(productListPanel);
		/**************/
		JPanel productPanel = new JPanel();
		productPanel.setBackground(Color.LIGHT_GRAY);
		productPanel.setPreferredSize(new Dimension(100, 100));
		productListPanel.add(productPanel);
		productPanel.setLayout(null);
		
		JLabel productImageLabel = new JLabel("");
		productImageLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("image click event");
				
			}
		});
		productImageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/50bigle.jpg")));
		productImageLabel.setBounds(0, 10, 50, 55);
		productPanel.add(productImageLabel);
		
		JLabel productNameLabel = new JLabel("비글");
		productNameLabel.setBounds(32, 0, 30, 15);
		productPanel.add(productNameLabel);
		
		JLabel productDescLabel = new JLabel("<html>아주멋진강아지<br>이뻐요</html>");
		productDescLabel.setBounds(0, 61, 100, 29);
		productPanel.add(productDescLabel);
		
		JComboBox productQtyComboBox = new JComboBox();
		productQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		productQtyComboBox.setBounds(49, 36, 51, 21);
		productPanel.add(productQtyComboBox);
		
		JButton productAddCartButton = new JButton("");
		productAddCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("add cart 버튼클릭");
				
			}
		});
		productAddCartButton.setBackground(Color.WHITE);
		productAddCartButton.setOpaque(false);
		productAddCartButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")));
		productAddCartButton.setBounds(49, 9, 46, 21);
		productPanel.add(productAddCartButton);
		/***************/
		
		CardLayout cardLayout = (CardLayout)mainParentPanel.getLayout();
		cardLayout.show(mainParentPanel, "PRODUCT");
		
		try {
			productService=new ProductService();
			
			productList();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
	}//생성자끝
	
	
	private void productList() throws Exception{
		
		List<Product> productList=productService.productList();
		
		productListPanel.removeAll();
		
		for(Product product:productList) {
			JPanel productPanel = new JPanel();
			productPanel.setBackground(Color.LIGHT_GRAY);
			productPanel.setPreferredSize(new Dimension(100, 100));
			productListPanel.add(productPanel);
			productPanel.setLayout(null);
			
			JLabel productImageLabel = new JLabel("");
			productImageLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("image click event");
					System.out.println(product);
				}
			});
			productImageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			productImageLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/50"+product.getP_image())));
			productImageLabel.setBounds(0, 10, 50, 55);
			productPanel.add(productImageLabel);
			
			JLabel productNameLabel = new JLabel(product.getP_name());
			productNameLabel.setBounds(32, 0, 30, 15);
			productPanel.add(productNameLabel);
			
			JLabel productDescLabel = new JLabel("<html>"+product.getP_desc()+"</html>");
			productDescLabel.setBounds(0, 61, 100, 29);
			productPanel.add(productDescLabel);
			
			JComboBox productQtyComboBox = new JComboBox();
			productQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
			productQtyComboBox.setBounds(49, 36, 51, 21);
			productPanel.add(productQtyComboBox);
			
			JButton productAddCartButton = new JButton("");
			productAddCartButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("add cart 버튼클릭");
					System.out.println(product);
					System.out.println(productQtyComboBox.getSelectedItem());
				}
			});
			productAddCartButton.setBackground(Color.WHITE);
			productAddCartButton.setOpaque(false);
			productAddCartButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")));
			productAddCartButton.setBounds(49, 9, 46, 21);
			productPanel.add(productAddCartButton);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	private void menuSelectUIChange(String selectedMenu) {
		switch (selectedMenu) {
		case "HOME":
			homeLabel.setBackground(Color.DARK_GRAY);
			homeLabel.setForeground(Color.WHITE);
			
			chusukLabel.setBackground(Color.WHITE);
			chusukLabel.setForeground(Color.DARK_GRAY);
			
			specialLabel.setBackground(Color.WHITE);
			specialLabel.setForeground(Color.DARK_GRAY);
			
			bestLabel.setBackground(Color.WHITE);;
			bestLabel.setForeground(Color.DARK_GRAY);
			
			break;
		case "CHUSUK":
			
			homeLabel.setBackground(Color.WHITE);
			homeLabel.setForeground(Color.DARK_GRAY);
			
			chusukLabel.setBackground(Color.DARK_GRAY);
			chusukLabel.setForeground(Color.WHITE);
			
			specialLabel.setBackground(Color.WHITE);
			specialLabel.setForeground(Color.DARK_GRAY);
			
			bestLabel.setBackground(Color.WHITE);;
			bestLabel.setForeground(Color.DARK_GRAY);
			
			break;
		case "SPECIAL":
			homeLabel.setBackground(Color.WHITE);
			homeLabel.setForeground(Color.DARK_GRAY);
			
			chusukLabel.setBackground(Color.WHITE);
			chusukLabel.setForeground(Color.DARK_GRAY);
			
			specialLabel.setBackground(Color.DARK_GRAY);
			specialLabel.setForeground(Color.WHITE);
			
			bestLabel.setBackground(Color.WHITE);;
			bestLabel.setForeground(Color.DARK_GRAY);
			break;
		case "BEST":
			homeLabel.setBackground(Color.WHITE);
			homeLabel.setForeground(Color.DARK_GRAY);
			
			chusukLabel.setBackground(Color.WHITE);
			chusukLabel.setForeground(Color.DARK_GRAY);
			
			specialLabel.setBackground(Color.WHITE);
			specialLabel.setForeground(Color.DARK_GRAY);
			
			bestLabel.setBackground(Color.DARK_GRAY);;
			bestLabel.setForeground(Color.WHITE);
			break;

		
		}
	}
}