package com.itwill.member.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.member.Member;
import com.itwill.member.MemberService;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class MemberMainFrame extends JFrame {
	/********* 1.MemberService멤버필드선언 *****/
	MemberService memberService;
	/********* 2.로그인한회원 멤버필드선언 *****/
	Member loginMember=null;

	private JPanel contentPane;
	private JTextField joinIdTF;
	private JPasswordField joinPassTF;
	private JTextField joinNameTF;
	private JTextField joinAddressTF;
	private JLabel idMsgLB;
	private JTextField loginIdTF;
	private JPasswordField loginPassTF;
	private JTextField infoIdTF;
	private JPasswordField infoPassTF;
	private JTextField infoNameTF;
	private JTextField infoAddressTF;
	private JTabbedPane memberTabbedPane;
	private JButton updateFormBtn;
	private JButton updateBtn;
	private JButton memberDeleteBtn;
	private JComboBox joinAgeComboBox;
	private JCheckBox joinMarriedCheckBox;
	private JLabel ageMsgLB;
	private JComboBox infoAgeComboBox;
	private JCheckBox infoMarriedCheckBox;
	private JTable adminMemberListTable;
	private JButton logoutButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMainFrame frame = new MemberMainFrame();
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
	public MemberMainFrame() throws Exception {
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				switch(memberTabbedPane.getSelectedIndex()) {
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					displayMemberInfo(loginMember);
					break;
				case 4:
					break;
				
				
				}
			}
		});
		
		memberTabbedPane.setFont(new Font("D2Coding", Font.BOLD, 13));
		contentPane.add(memberTabbedPane, BorderLayout.CENTER);

		JPanel memberMainPanel = new JPanel();
		memberTabbedPane.addTab("회원메인", null, memberMainPanel, null);
		memberMainPanel.setLayout(new BorderLayout(0, 0));

		JLabel memberMainLabel = new JLabel("");
		memberMainLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/****** 메인화면클릭시로그인화면 or 회원정보화면보여주기 ********/

			}
		});
		memberMainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberMainLabel.setIcon(new ImageIcon(MemberMainFrame.class.getResource("/images/album.jpg")));
		memberMainPanel.add(memberMainLabel, BorderLayout.CENTER);

		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setBackground(new Color(192, 192, 192));
		memberTabbedPane.addTab("회원로그인", null, memberLoginPanel, null);
		memberLoginPanel.setLayout(null);

		JLabel loginIdLabel = new JLabel("아이디");
		loginIdLabel.setBounds(96, 71, 57, 15);
		memberLoginPanel.add(loginIdLabel);

		JLabel lgoinPasswordLabel = new JLabel("패쓰워드");
		lgoinPasswordLabel.setBounds(96, 133, 57, 15);
		memberLoginPanel.add(lgoinPasswordLabel);

		loginIdTF = new JTextField();
		loginIdTF.setBounds(196, 68, 116, 21);
		memberLoginPanel.add(loginIdTF);
		loginIdTF.setColumns(10);

		loginPassTF = new JPasswordField();
		loginPassTF.setBounds(196, 130, 116, 21);
		memberLoginPanel.add(loginPassTF);

		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********** 회원로그인 ************/
				try {
					String id=loginIdTF.getText();
					String password=loginPassTF.getText();
					Member localLoginMember = memberService.login(id, password);
					if(localLoginMember!=null) {
						//로그인성공
						loginProcess(localLoginMember);
					}else {
						//로그인실패
						JOptionPane.showMessageDialog(null,"아이디또는 비밀번호를 확인하세요");
						loginIdTF.requestFocus();
						loginIdTF.select(0,id.length());
					}
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		loginBtn.setBounds(96, 192, 97, 23);
		memberLoginPanel.add(loginBtn);

		JButton joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*************** 회원가입화면전환 *****************/
			
			}
		});
		joinBtn.setBounds(215, 192, 97, 23);
		memberLoginPanel.add(joinBtn);

		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setBackground(new Color(192, 192, 192));
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		memberJoinPanel.setLayout(null);

		JLabel joinIdLabel = new JLabel("아이디");
		joinIdLabel.setBounds(84, 61, 57, 15);
		memberJoinPanel.add(joinIdLabel);

		joinIdTF = new JTextField();
		joinIdTF.setBounds(181, 54, 116, 21);
		memberJoinPanel.add(joinIdTF);
		joinIdTF.setColumns(10);

		JLabel joinPasswordLabel = new JLabel("패쓰워드");
		joinPasswordLabel.setBounds(84, 110, 57, 15);
		memberJoinPanel.add(joinPasswordLabel);

		JLabel joinNameLabel = new JLabel("이름");
		joinNameLabel.setBounds(84, 163, 57, 15);
		memberJoinPanel.add(joinNameLabel);

		JLabel joinAddressLabel = new JLabel("주소");
		joinAddressLabel.setBounds(84, 206, 57, 15);
		memberJoinPanel.add(joinAddressLabel);

		JLabel joinAgeLabel = new JLabel("나이");
		joinAgeLabel.setBounds(84, 265, 57, 15);
		memberJoinPanel.add(joinAgeLabel);

		JLabel joinMarriedLabel = new JLabel("결혼여부");
		joinMarriedLabel.setBounds(84, 323, 57, 15);
		memberJoinPanel.add(joinMarriedLabel);

		joinPassTF = new JPasswordField();
		joinPassTF.setBounds(181, 104, 116, 18);
		memberJoinPanel.add(joinPassTF);

		joinNameTF = new JTextField();
		joinNameTF.setBounds(181, 156, 116, 21);
		memberJoinPanel.add(joinNameTF);
		joinNameTF.setColumns(10);

		joinAddressTF = new JTextField();
		joinAddressTF.setBounds(181, 199, 116, 21);
		memberJoinPanel.add(joinAddressTF);
		joinAddressTF.setColumns(10);

		JButton memberJoinBtn = new JButton("가입");
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********** 회원가입 ************/
				try {
					/****** TextField로 부터 데이타얻기 *****/
					String id=joinIdTF.getText();
					String password=joinPassTF.getText();
					String name=joinNameTF.getText();
					String address=joinAddressTF.getText();
					/*********** 유효성체크 ****************/
					if(id.trim().equals("")) {
						idMsgLB.setText("아이디를 입력하세요.");
						joinIdTF.requestFocus();
						return;
					}else {
						idMsgLB.setText("");
					}
					
					int seletedAgeIndex = joinAgeComboBox.getSelectedIndex();
					if(seletedAgeIndex==0) {
						ageMsgLB.setText("나이를 선택하세요");
						joinAgeComboBox.requestFocus();
						return;
					}else {
						ageMsgLB.setText("");
					}
					
					int age=Integer.parseInt((String) joinAgeComboBox.getSelectedItem());//object를 반환하기 때문에 언박싱
					String married= joinMarriedCheckBox.isSelected()?"T":"F";
					
					Member member=Member.builder()
							.memberId(id)
							.memberPassword(password)
							.memberName(name)
							.memberAddress(address)
							.memberAge(age)
							.memberMarried(married)
							.build();
					
//					memberService.addMember(member);
					boolean isAdd= memberService.addMember(member);
					if(isAdd) {//가입성공 ==>로그인화면 전환
						memberTabbedPane.setSelectedIndex(1);
					}else {//가입실패==>아이디중복
						JOptionPane.showMessageDialog(null, id+" 는 이미 사용중인 아이디입니다.");
						joinIdTF.requestFocus();
						joinIdTF.select(0, id.length());
						
					}
					
					
				} catch (Exception e1) {
					System.out.println("회원가입에러-->" + e1.getMessage());
				}
			}
		});
		memberJoinBtn.setBounds(84, 375, 97, 23);
		memberJoinPanel.add(memberJoinBtn);

		JButton memberCancleBtn = new JButton("취소");
		memberCancleBtn.setBounds(210, 375, 97, 23);
		memberJoinPanel.add(memberCancleBtn);

		idMsgLB = new JLabel("");
		idMsgLB.setForeground(Color.RED);
		idMsgLB.setBounds(181, 85, 167, 15);
		memberJoinPanel.add(idMsgLB);

		joinAgeComboBox = new JComboBox();
		joinAgeComboBox.setModel(
				new DefaultComboBoxModel(new String[] { "나이를선택하세요", "10", "20", "30", "40", "50", "60", "70" }));
		joinAgeComboBox.setBounds(181, 261, 126, 23);
		memberJoinPanel.add(joinAgeComboBox);

		joinMarriedCheckBox = new JCheckBox("");
		joinMarriedCheckBox.setBounds(181, 319, 21, 23);
		memberJoinPanel.add(joinMarriedCheckBox);

		ageMsgLB = new JLabel("");
		ageMsgLB.setForeground(new Color(255, 0, 255));
		ageMsgLB.setBounds(181, 294, 126, 15);
		memberJoinPanel.add(ageMsgLB);

		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.setBackground(Color.LIGHT_GRAY);
		memberTabbedPane.addTab("회원정보", null, memberInfoPanel, null);
		memberInfoPanel.setLayout(null);

		JLabel memberInfoIdLabel = new JLabel("아이디");
		memberInfoIdLabel.setBounds(84, 50, 57, 15);
		memberInfoPanel.add(memberInfoIdLabel);

		infoIdTF = new JTextField();
		infoIdTF.setEnabled(false);
		infoIdTF.setColumns(10);
		infoIdTF.setBounds(162, 47, 116, 21);
		memberInfoPanel.add(infoIdTF);

		JLabel memberInfoPasswordLabel = new JLabel("패쓰워드");
		memberInfoPasswordLabel.setBounds(84, 99, 57, 15);
		memberInfoPanel.add(memberInfoPasswordLabel);

		infoPassTF = new JPasswordField();
		infoPassTF.setEditable(false);
		infoPassTF.setBounds(162, 97, 116, 18);
		memberInfoPanel.add(infoPassTF);

		JLabel memberInNameLabel = new JLabel("이름");
		memberInNameLabel.setBounds(84, 152, 57, 15);
		memberInfoPanel.add(memberInNameLabel);

		infoNameTF = new JTextField();
		infoNameTF.setEditable(false);
		infoNameTF.setColumns(10);
		infoNameTF.setBounds(162, 149, 116, 21);
		memberInfoPanel.add(infoNameTF);

		JLabel memberInAddressLabel = new JLabel("주소");
		memberInAddressLabel.setBounds(84, 195, 57, 15);
		memberInfoPanel.add(memberInAddressLabel);

		infoAddressTF = new JTextField();
		infoAddressTF.setEditable(false);
		infoAddressTF.setColumns(10);
		infoAddressTF.setBounds(162, 192, 116, 21);
		memberInfoPanel.add(infoAddressTF);

		JLabel memberInAgeLabel = new JLabel("나이");
		memberInAgeLabel.setBounds(84, 254, 57, 15);
		memberInfoPanel.add(memberInAgeLabel);

		JLabel memberInMarriedLabel = new JLabel("결혼여부");
		memberInMarriedLabel.setBounds(84, 316, 57, 15);
		memberInfoPanel.add(memberInMarriedLabel);

		updateFormBtn = new JButton("수정폼");
		updateFormBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/************ 수정폼 활성화 **********/
				updateFormEnable(true);
			}
		});
		updateFormBtn.setBounds(170, 379, 75, 23);
		memberInfoPanel.add(updateFormBtn);

		updateBtn = new JButton("수정");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**************** 회원수정 ***************/
				try {
					/****** TextField로 부터 데이타얻기 *****/
					
					//로그인회원정보변경
					
					
					
				} catch (Exception e1) {
					System.out.println("회원수정에러-->" + e1.getMessage());

				}
			}
		});
		updateBtn.setBounds(246, 379, 69, 23);
		memberInfoPanel.add(updateBtn);

		JButton memberInfoButton = new JButton("회원정보");
		memberInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**************** 로그인한회원정보보기 ***************/
				//System.out.println(loginMember.hashCode());
				displayMemberInfo(loginMember);
				
			}
		});
		memberInfoButton.setBounds(84, 379, 86, 23);
		memberInfoPanel.add(memberInfoButton);

		infoAgeComboBox = new JComboBox();
		infoAgeComboBox.setEnabled(false);
		infoAgeComboBox.setModel(new DefaultComboBoxModel(new String[] { "10", "20", "30", "40", "50", "60", "70" }));
		infoAgeComboBox.setBounds(162, 250, 47, 23);
		memberInfoPanel.add(infoAgeComboBox);

		infoMarriedCheckBox = new JCheckBox("");
		infoMarriedCheckBox.setEnabled(false);
		infoMarriedCheckBox.setBounds(162, 312, 32, 23);
		memberInfoPanel.add(infoMarriedCheckBox);

		JPanel memberAdminPanel = new JPanel();
		memberTabbedPane.addTab("회원관리", null, memberAdminPanel, null);
		memberAdminPanel.setLayout(null);

		JButton memberListBtn = new JButton("회원리스트[admin]");
		memberListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayMemberList();
			}
		});
		memberListBtn.setBounds(65, 148, 104, 23);
		memberAdminPanel.add(memberListBtn);

		memberDeleteBtn = new JButton("회원삭제");
		memberDeleteBtn.setEnabled(false);
		memberDeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/************* 선택된아이디삭제 ************/
					int selectedRow=adminMemberListTable.getSelectedRow();
					String selectedId = (String)adminMemberListTable.getValueAt(selectedRow, 0);	
					memberService.memberDelete(selectedId);
					memberDeleteBtn.setEnabled(false);
					displayMemberList();
				} catch (Exception e1) {
					System.out.println("회원삭제에러-->" + e1.getMessage());

				}

			}
		});
		memberDeleteBtn.setBounds(213, 148, 97, 23);
		memberAdminPanel.add(memberDeleteBtn);

		JScrollPane adminMemberScrollPane = new JScrollPane();
		adminMemberScrollPane.setBounds(12, 10, 365, 131);
		memberAdminPanel.add(adminMemberScrollPane);

		adminMemberListTable = new JTable();
		adminMemberListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/******* 테이블클릭시 선택된아이디얻기&삭제버튼활성화 *******/
				
				
			}
		});
		adminMemberListTable
				.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
						new String[] { "\uC544\uC774\uB514", "\uD328\uC4F0\uC6CC\uB4DC", "\uC774\uB984", "\uC8FC\uC18C",
								"\uB098\uC774", "\uACB0\uD63C", "\uAC00\uC785\uC77C" }));
		adminMemberScrollPane.setViewportView(adminMemberListTable);
		memberTabbedPane.setSelectedIndex(0);
		
		JPanel northMenuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) northMenuPanel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(northMenuPanel, BorderLayout.NORTH);
		
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutProcess();
			}
		});
		logoutButton.setEnabled(false);
		logoutButton.setOpaque(false);
		logoutButton.setBackground(new Color(255, 255, 255));
		logoutButton.setIcon(new ImageIcon(MemberMainFrame.class.getResource("/images/user-logout20.png")));
		northMenuPanel.add(logoutButton);

		/****** 2.MemberService멤버필드객체생성 *********/
		memberService = new MemberService();
		
		/****최초실행시로그아웃상태로변경****/
		logoutProcess();

	}// 생성자끝

	/*****************************************************/
	private void displayMemberList() {
		try {
			/*************** 회원리스트보기[JTable] ************/
			List<Member> memberList=memberService.memberList();
			Vector columnVector=new Vector();
			columnVector.add("아이디");
			columnVector.add("패쓰워드");
			columnVector.add("이름");
			columnVector.add("주소");
			columnVector.add("나이");
			columnVector.add("결혼");
			columnVector.add("가입일");
			
			Vector tableVector=new Vector();
			for(Member member:memberList) {
				Vector rowVector=new Vector();
				rowVector.add(member.getMemberId());
				rowVector.add(member.getMemberPassword());
				rowVector.add(member.getMemberName());
				rowVector.add(member.getMemberAddress());
				rowVector.add(member.getMemberAge());
				rowVector.add(member.getMemberMarried());
				rowVector.add(member.getMemberRegdate());
				tableVector.add(rowVector);
			}
			DefaultTableModel tableModel=
					new DefaultTableModel(tableVector,columnVector);
			adminMemberListTable.setModel(tableModel);
			memberDeleteBtn.setEnabled(false);
		} catch (Exception e1) {
			System.out.println("회원리스트보기에러-->" + e1.getMessage());
		}
	}

	/************* 회원수정폼활성화 불활성화 ****************/
	private void updateFormEnable(boolean b) {
		infoNameTF.setEditable(b);
		infoAddressTF.setEditable(b);
		infoAgeComboBox.setEnabled(b);
		infoMarriedCheckBox.setEnabled(b);
		updateBtn.setEnabled(b);
	}

	/************** 로그아웃 or 애플리케이션로딩시 호출할메쏘드 ***************/
	private void logoutProcess() {
		/*********** 로그아웃시 해야할일*********** 
		 * 1.로그인성공한 멤버객체 멤버필드에서제거 
		 * 2.MemberMainFrame타이틀변경
		 * 3.로그인,회원가입탭 활성화,회원정보탭 불활성화 
		 *   로그인,회원가입 메뉴아이템 활성화 
		 *   로그아웃 메뉴아이템 불활성화
		 * 4.메인 화면전환
		 ********************************************/
		 loginMember=null;
		 setTitle("회원관리");
		 memberTabbedPane.setEnabledAt(1,true );
		 memberTabbedPane.setEnabledAt(2,true );
		 memberTabbedPane.setEnabledAt(3,false );
		 memberTabbedPane.setEnabledAt(4,false );
		 memberTabbedPane.setSelectedIndex(0);
		 logoutButton.setEnabled(false);
	}

	/************** 로그인성공시 호출할메쏘드 ***************/
	void loginProcess(Member loginMember) throws Exception {
		/************ 로그인성공시 해야할일*********** 
		 * 1.로그인성공한 멤버객체 멤버필드에저장 
		 * 2.MemberMainFrame타이틀변경
		 * 3.로그인탭,회원가입탭 불활성화 회원정보 탭 활성화 
		 *   로그인메뉴아이템,회원가입 메뉴아이템 불활성화 
		 *   로그아웃 메뉴아이템 활성화 
		 * 4.회원정보보기 화면전환
		 ********************************************/
		this.loginMember=loginMember;
		setTitle(loginMember.getMemberName()+" 님 로그인");
		if(this.loginMember.getMemberId().equals("admin")) {
			 memberTabbedPane.setEnabledAt(1,false );
			 memberTabbedPane.setEnabledAt(2,false );
			 memberTabbedPane.setEnabledAt(3,true );
			 memberTabbedPane.setEnabledAt(4,true );
			 memberTabbedPane.setSelectedIndex(4);
		}else {
			 memberTabbedPane.setEnabledAt(1,false );
			 memberTabbedPane.setEnabledAt(2,false );
			 memberTabbedPane.setEnabledAt(3,true );
			 memberTabbedPane.setEnabledAt(4,false );
			 memberTabbedPane.setSelectedIndex(3);
		}
		logoutButton.setEnabled(true);
		
		
	}

	private void displayMemberInfo(Member member) {
		/**** 로그인한회원상세데이타보여주기 *****/
		
		infoIdTF.setText(member.getMemberId());
		infoPassTF.setText(member.getMemberPassword());
		infoNameTF.setText(member.getMemberName());
		infoAddressTF.setText(member.getMemberAddress());
		infoAgeComboBox.setSelectedItem(member.getMemberAge()+" ");
		/*
		if(member.getMemberMarried().equals("T")) {
			infoMarriedCheckBox.setSelected(true);
		}else {
			infoMarriedCheckBox.setSelected(false);
		}
		*/
		//infoMarriedCheckBox.setSelected(member.getMemberMarried().equals("T") ?true:false);
		infoMarriedCheckBox.setSelected(member.getMemberMarried().equals("T"));
		
	}
}