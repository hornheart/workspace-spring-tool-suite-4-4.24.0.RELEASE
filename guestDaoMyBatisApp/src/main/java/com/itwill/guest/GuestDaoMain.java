package com.itwill.guest;

public class GuestDaoMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDao();
		System.out.println("### guestDao:"+guestDao);
		System.out.println("----------findByAll--------------");
//		System.out.println(guestDao.findByAll());
		System.out.println("----------findByGuestNo----------");
		System.out.println(guestDao.findByGuestNo(2));
		System.out.println("----------delete-----------------");
		System.out.println("----------update-----------------");
		System.out.println("----------insert-----------------");
		
		
	}

}
