package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception{
		GuestDao guestDao=new GuestDao();
		
		Guest guest=new Guest(0,"고소미",null,"gosomi@naver.com","http://www.naver.com","제목","내용");
		
		
		System.out.println("1.insert:"+guestDao.insert(guest)+" row insert");
		System.out.println("2.findByAll:");
		System.out.println(guestDao.findByAll());
		System.out.println("3.findByGuestNo:"+guestDao.findByGuestNo(3));
		System.out.println("3.findByGuestNo:"+guestDao.findByGuestNo(4));
		System.out.println("4-1.update form 보여주기");
		Guest updateGuest = guestDao.findByGuestNo(2);
		System.out.println(updateGuest);
		updateGuest.setGuestName("정변경");
		updateGuest.setGuestEmail("change@naver.com");
		updateGuest.setGuestTitle("제목변경");
		updateGuest.setGuestContent("내용변경");
		System.out.println("4-2.update:"+guestDao.update(updateGuest));
		System.out.println("5.delete:"+guestDao.delete(10));
		
		
	}

}
