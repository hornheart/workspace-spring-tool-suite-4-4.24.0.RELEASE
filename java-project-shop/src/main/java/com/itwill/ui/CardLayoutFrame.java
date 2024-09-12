package com.itwill.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardLayoutFrame extends JFrame {

	private JPanel contentPane;
	private JPanel parentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutFrame frame = new CardLayoutFrame();
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
	public CardLayoutFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		parentPanel = new JPanel();
		parentPanel.setBackground(new Color(135, 206, 235));
		contentPane.add(parentPanel, BorderLayout.CENTER);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel joinPanel = new JPanel();
		joinPanel.setBackground(new Color(0, 128, 0));
		parentPanel.add(joinPanel, "join");
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(0, 255, 0));
		parentPanel.add(loginPanel, "login");
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(173, 216, 230));
		parentPanel.add(infoPanel, "info");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(250, 240, 230));
		parentPanel.add(mainPanel, "main");
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(176, 196, 222));
		contentPane.add(menuPanel, BorderLayout.SOUTH);
		
		JButton joinPanelButton = new JButton("가입패널");
		joinPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)parentPanel.getLayout()).show(parentPanel, "join");
			}
		});
		
		JLabel prevLabel = new JLabel("");
		prevLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((CardLayout)parentPanel.getLayout()).previous(parentPanel);
			}
		});
		prevLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		prevLabel.setIcon(new ImageIcon(CardLayoutFrame.class.getResource("/images/back-30.png")));
		menuPanel.add(prevLabel);
		menuPanel.add(joinPanelButton);
		
		JButton loginPanelButton = new JButton("로그인패널");
		loginPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)parentPanel.getLayout()).show(parentPanel, "login");
			}
		});
		menuPanel.add(loginPanelButton);
		
		JButton infoPanelButton = new JButton("정보패널");
		infoPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)parentPanel.getLayout()).show(parentPanel, "info");
			}
		});
		menuPanel.add(infoPanelButton);
		
		JButton mainPanelButton = new JButton("메인패널");
		mainPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)parentPanel.getLayout()).show(parentPanel, "main");
			}
		});
		menuPanel.add(mainPanelButton);
		
		JLabel nextLabel = new JLabel("");
		nextLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((CardLayout)parentPanel.getLayout()).next(parentPanel);
			}
		});
		nextLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextLabel.setIcon(new ImageIcon(CardLayoutFrame.class.getResource("/images/arrow-right-30.png")));
		menuPanel.add(nextLabel);
		/*******초기카드설정*****/
		CardLayout cardLayout=(CardLayout)parentPanel.getLayout();
		cardLayout.show(parentPanel, "main");
	}

}