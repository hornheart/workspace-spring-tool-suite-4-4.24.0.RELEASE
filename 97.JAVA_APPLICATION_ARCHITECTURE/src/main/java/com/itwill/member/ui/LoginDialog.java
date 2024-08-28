package com.itwill.member.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.member.Member;
import com.itwill.member.MemberService;

public class LoginDialog extends JDialog {
	
	/**********MemberMainFrame객체필드선언*************/
    MemberMainFrame memberMainFrame;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField loginIdTextField;
	private JPasswordField loginPasswordPasswordField;
	
	
	
	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setBounds(100, 100, 361, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		loginIdTextField = new JTextField();
		loginIdTextField.setBounds(199, 32, 116, 21);
		contentPanel.add(loginIdTextField);
		loginIdTextField.setColumns(10);
		
		loginPasswordPasswordField = new JPasswordField();
		loginPasswordPasswordField.setBounds(199, 74, 116, 21);
		contentPanel.add(loginPasswordPasswordField);
		
		JLabel loginIdLabel = new JLabel("아이디");
		loginIdLabel.setBounds(64, 35, 57, 15);
		contentPanel.add(loginIdLabel);
		
		JLabel lgoinPasswordLabel = new JLabel("패쓰워드");
		lgoinPasswordLabel.setBounds(64, 77, 57, 15);
		contentPanel.add(lgoinPasswordLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("로그인");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/************회원로그인**********/
						try {
							String id= loginIdTextField.getText();
							String password=loginPasswordPasswordField.getText();
							Member loginMember = memberMainFrame.memberService.login(id,password);
							if(loginMember!=null) {
								/* 1.멤버메인프레임 loginProcess메쏘드호출
								 * 2.로그인 다이얼로그닫기
								 */
								memberMainFrame.loginProcess(loginMember);
								
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "아이디와패쓰워드를 확인하세요");
								loginIdTextField.requestFocus();
								loginIdTextField.select(0, id.length());
							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
						/*********************************/
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	
	}//end 생성자

	public void setMemberMainFrame(MemberMainFrame memberMainFrame) {
		this.memberMainFrame=memberMainFrame;
	}
}//end class
