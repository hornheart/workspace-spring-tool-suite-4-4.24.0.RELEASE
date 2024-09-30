package com.itwill.guest;

import java.util.Date;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class GuestDaoMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDao();
		System.out.println("### guestDao:"+guestDao);
		System.out.println("----------findByAll--------------");
		System.out.println(guestDao.findByAll());
		System.out.println("----------findByGuestNo----------");
		System.out.println(guestDao.findByGuestNo(2));
		System.out.println("----------delete-----------------");
		System.out.println(guestDao.delete(15));
		System.out.println(guestDao.delete(1));
		System.out.println("----------update-----------------");
//		System.out.println("updqte row count : "+ guestDao.update(new Guest(
//				22,"P.지은",new Date(),"kim@itwill.com", "http://itwill.co.kr","ITWILL","ITWILL")));
		System.out.println(guestDao.update(Guest.builder()
												.guestNo(26)
												.guestName("지은")
												.guestEmail("itwill@nac.com")
												.guestHomepage("http://itwill.co.ke")
												.guestTitle("itwill")
												.guestContent("itwill")
												.build()));
		System.out.println("----------insert-----------------");

//		int insertRowCount=
//				guestDao.insert(new Guest(
//						0,"지은",new Date(),"kim@itwill.com", "http://itwill.co.kr","ITWILL","ITWILL"));
	
		System.out.println(guestDao.insert(Guest.builder()
												.guestName("이창섭")
												.guestEmail("itwill@itwill.com")
												.guestHomepage("http://itwill.co.ke")
												.guestTitle("아무말대잔치")
												.guestContent("비투비")
												.build()));
	}

}
