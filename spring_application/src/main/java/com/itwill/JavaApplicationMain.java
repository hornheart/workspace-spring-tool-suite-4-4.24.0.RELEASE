package com.itwill;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestDaoImpl;
import com.itwill.guest.GuestServiceImpl;

public class JavaApplicationMain {

	public static void main(String[] args) throws Exception {
		System.out.println("-------------java application-------------");
		GuestDao guestDao=new GuestDaoImpl();
		GuestServiceImpl guestService=new GuestServiceImpl();
		guestService.setGuestDao(guestDao);
		
		System.out.println(guestService.guestList());
		System.out.println(guestService.guestDetail(1));
	}
}
