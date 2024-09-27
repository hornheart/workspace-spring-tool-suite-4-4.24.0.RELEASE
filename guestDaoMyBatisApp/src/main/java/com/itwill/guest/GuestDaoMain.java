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
		System.out.println(guestDao.delete(5));
		System.out.println(guestDao.delete(1));
		System.out.println("----------update-----------------");
		System.out.println("updqte row count : "+ guestDao.update(new Guest(
				4,"박지은",new Date(),"kim@itwill.com", "http://itwill.co.kr","ITWILL","ITWILL")));
		System.out.println("----------insert-----------------");
		Guest insert= new Guest(
				10,"강지은",new Date(),"kim@itwill.com", "http://itwill.co.kr","ITWILL","ITWILL");
		System.out.println("insert row count : "+insert.getGuestNo());
		int insertRowCount=
				guestDao.insert(new Guest(
						1,"강지은",new Date(),"kim@itwill.com", "http://itwill.co.kr","ITWILL","ITWILL"));
	}

}
