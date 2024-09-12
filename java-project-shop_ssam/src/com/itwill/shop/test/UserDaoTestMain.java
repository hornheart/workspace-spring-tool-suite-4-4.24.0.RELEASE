package com.itwill.shop.test;

import com.itwill.shop.user.User;
import com.itwill.shop.user.UserDao;

public class UserDaoTestMain {

	public static void main(String[] args) throws Exception{
		UserDao userDao=new UserDao();
		System.out.println("1.create:"+
		userDao.insert(new User("tomato", "1111", "토마토", "tomato@gmail.com")));
		System.out.println("2.findUser:"+userDao.findByPrimaryKey("tomato"));
		System.out.println("3.update:"+userDao.update(
				new User("tomato", "1111","난오이", "cucum@gmail.com")));
		System.out.println(userDao.findByPrimaryKey("tomato"));
		System.out.println("4.remove:"+userDao.delete("tomato"));
		System.out.println("5.existedUser:"+userDao.countByUserId("tomato"));

	}

}
