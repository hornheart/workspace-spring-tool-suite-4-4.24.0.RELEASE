package com.itwill.guest.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.address.Address;
import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class GuestMainFrame extends JFrame {

	/*************** GuestService멤버필드선언 *******************/
	private GuestService guestService;
	/**********************************************************/

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField titleTextField;
	private JTable guestListTable;
	private JTextField emailTextField;
	private JTextField homepageTextField;
	private JTabbedPane guestTabbedPane;
	private JTextField searchTextField;
	private JTextArea guestContentTextArea;
	private JLabel idMessageLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestMainFrame frame = new GuestMainFrame();
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
	public GuestMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		guestTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(guestTabbedPane, BorderLayout.CENTER);

		JPanel guestInsertPanel = new JPanel();
		guestTabbedPane.addTab("방명록쓰기", null, guestInsertPanel, null);
		guestInsertPanel.setLayout(null);

		JLabel nameLabel = new JLabel("작성자");
		nameLabel.setBounds(12, 7, 57, 15);
		guestInsertPanel.add(nameLabel);

		JLabel titleLabel = new JLabel("제목");
		titleLabel.setBounds(12, 32, 57, 15);
		guestInsertPanel.add(titleLabel);

		JLabel addressLabel = new JLabel("내용");
		addressLabel.setBounds(12, 141, 57, 18);
		guestInsertPanel.add(addressLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(81, 7, 96, 18);
		guestInsertPanel.add(nameTextField);
		nameTextField.setColumns(10);

		titleTextField = new JTextField();
		titleTextField.setBounds(81, 30, 160, 18);
		guestInsertPanel.add(titleTextField);
		titleTextField.setColumns(10);

		JButton guestWriteButton = new JButton("방명록쓰기");
		guestWriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String guestName=nameTextField.getText();
					if(guestName.trim().equals("")) {
						idMessageLabel.setText("이름을 입력하세요");
						nameTextField.requestFocus();
						return;
					}
					String guestEmail=emailTextField.getText();
					String guestHomepage=homepageTextField.getText();
					String guestTitle=titleTextField.getText();
					String guestContent=guestContentTextArea.getText();
					
					//Guest guest=new Guest(0, null, null, null, null, null, null);
					Guest guest = Guest.builder()
									.guestName(guestName)
									.guestEmail(guestEmail)
									.guestHomepage(guestHomepage)
									.guestTitle(guestTitle)
									.guestContent(guestContent).build();
					int insertRowCount=
							guestService.guestWrite(guest);
					
					guestTabbedPane.setSelectedIndex(1);
					
				}catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		guestWriteButton.setBounds(81, 219, 150, 23);
		guestInsertPanel.add(guestWriteButton);

		JScrollPane guestContentScrollPane = new JScrollPane();
		guestContentScrollPane.setBounds(81, 107, 270, 102);
		guestInsertPanel.add(guestContentScrollPane);

		guestContentTextArea = new JTextArea();
		guestContentScrollPane.setViewportView(guestContentTextArea);

		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setBounds(12, 58, 57, 15);
		guestInsertPanel.add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setBounds(81, 54, 160, 21);
		guestInsertPanel.add(emailTextField);
		emailTextField.setColumns(10);

		JLabel homepageLabel = new JLabel("홈페이지");
		homepageLabel.setBounds(12, 83, 57, 15);
		guestInsertPanel.add(homepageLabel);

		homepageTextField = new JTextField();
		homepageTextField.setBounds(81, 80, 160, 21);
		guestInsertPanel.add(homepageTextField);
		homepageTextField.setColumns(10);
		
		idMessageLabel = new JLabel("");
		idMessageLabel.setForeground(Color.RED);
		idMessageLabel.setBounds(246, 7, 125, 15);
		guestInsertPanel.add(idMessageLabel);

		JPanel guestListPanel = new JPanel();
		guestTabbedPane.addTab("방명록리스트", null, guestListPanel, null);
		guestListPanel.setLayout(null);

		JButton guestListButton = new JButton("방명록리스트");
		guestListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayGuestList(GuestService.GUEST_SEARCH_BY_ALL,"");
			}
		});
		guestListButton.setBounds(114, 219, 150, 23);
		guestListPanel.add(guestListButton);

		JScrollPane guestListScrollPane = new JScrollPane();
		guestListScrollPane.setBounds(12, 32, 359, 165);
		guestListPanel.add(guestListScrollPane);

		guestListTable = new JTable();
		guestListTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "\uBC88\uD638", "\uC774\uB984", "\uB0A0\uC9DC", "\uC774\uBA54\uC77C",
						"\uD648\uD398\uC774\uC9C0", "\uC81C\uBAA9", "\uB0B4\uC6A9" }));
		guestListTable.getColumnModel().getColumn(4).setPreferredWidth(92);
		guestListTable.getColumnModel().getColumn(6).setPreferredWidth(135);
		guestListScrollPane.setViewportView(guestListTable);

		JComboBox searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"전체", "이름", "제목", "내용"}));
		searchComboBox.setBounds(218, 6, 51, 23);
		guestListPanel.add(searchComboBox);

		searchTextField = new JTextField();
		searchTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/************* 방명록 검색 ****************/
				int selectedIndex = searchComboBox.getSelectedIndex();
				String searchString = searchTextField.getText();
				displayGuestList(selectedIndex, searchString);
			}
		});
		searchTextField.setBounds(274, 7, 73, 21);
		guestListPanel.add(searchTextField);
		searchTextField.setColumns(10);

		JButton searchButton = new JButton("");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/************* 방명록 검색 ****************/
				System.out.println(searchComboBox.getSelectedIndex());
				System.out.println(searchComboBox.getSelectedItem());
				System.out.println(searchTextField.getText());
				
				int selectedIndex = searchComboBox.getSelectedIndex();
				String searchString = searchTextField.getText();
				displayGuestList(selectedIndex, searchString);
			}
		});
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setBorder(null);
		searchButton.setBackground(new Color(255, 255, 255));
		searchButton.setOpaque(false);
		searchButton.setIcon(new ImageIcon(GuestMainFrame.class.getResource("/images/search_image20.png")));
		searchButton.setBounds(345, 6, 32, 23);
		guestListPanel.add(searchButton);
		guestTabbedPane.setSelectedIndex(1);
		/*************** GuestService객체 초기화 *******************/
		try {
			this.guestService=new GuestService();
		}catch (Exception e) {
			e.printStackTrace();
		}
		/**********************************************************/
	}// 생성자끝

	private void displayGuestList(int searchType, String searchString) {
		try {
			
			List<Guest> guestList=guestService.findByGuest(searchType, searchString);
			
			Vector<String> columnVector=new Vector<String>();
			columnVector.add("번호");
			columnVector.add("이름");
			columnVector.add("날짜");
			columnVector.add("이메일");
			columnVector.add("홈페이지");
			columnVector.add("제목");
			columnVector.add("내용");
			
			Vector tableVector=new Vector();
			
			for(Guest guest:guestList) {
				Vector rowVector=new Vector();
				rowVector.add(guest.getGuestNo());
				rowVector.add(guest.getGuestName());
				rowVector.add(guest.getGuestDate());
				rowVector.add(guest.getGuestEmail());
				rowVector.add(guest.getGuestHomepage());
				rowVector.add(guest.getGuestTitle());
				rowVector.add(guest.getGuestContent());
				tableVector.add(rowVector);
			}
			
			
			DefaultTableModel  tableModel = 
					new DefaultTableModel(tableVector,columnVector);
			guestListTable.setModel(tableModel);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}// 클래스끝