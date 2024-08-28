package com.itwill.member.test;
import javax.swing.JOptionPane;
import com.itwill.member.Member;
import com.itwill.member.MemberService;
public class MemberServiceTestMain {
	public static void main(String[] args) throws Exception {
		MemberService memberService = new MemberService();
		System.out.println("1.회원가입");
		boolean isSuccess1 =memberService.addMember(new Member("xxxx", "xxxx", "엑스맨", "경기도민", 30, "F", null));
		System.out.println("가입성공여부:"+isSuccess1);
		boolean isSuccess2 =memberService.addMember(new Member("aaaa", "aaaa", "에이맨", "경기시민", 35, "F", null));
		System.out.println("가입성공여부:"+isSuccess2);
		System.out.println("2.login");
		Member loginMember1=memberService.login("aaaa", "aaaa");
		if(loginMember1!=null) {
			System.out.println("로그인성공:"+loginMember1);
		}else {
			JOptionPane.showMessageDialog(null, "아이디나 패쓰워드가 일치하지않습니다.");
			System.out.println("로그인실패:"+loginMember1);
		}
		Member loginMember2=memberService.login("aaaa", "zzzz");
		if(loginMember2!=null) {
			System.out.println("로그인성공:"+loginMember2);
		}else {
			JOptionPane.showMessageDialog(null, "아이디나 패쓰워드가 일치하지않습니다.");
			System.out.println("로그인실패:"+loginMember2);
		}
		System.out.println("3.detail:"+memberService.memberDetail("cccc"));
		Member updateMember = memberService.memberDetail("xxxx");
		updateMember.setMemberAddress("로스엔젤리스");
		System.out.println("4.update:"+memberService.memberUpdate(updateMember));
	}
}
