package com.itwill.shop.test;

import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;

public class UserServiceTestMain {

	public static void main(String[] args) throws Exception{
		UserService  userService=new UserService();
		System.out.println("1.가입");
		int rowCount=userService.create(new User("xxxx", "1111", "엑스맨", "xxx.x.co.kr"));
		System.out.println(">> "+rowCount);
		System.out.println("2.로그인");
		int result = userService.login("xxxx", "1111");
		System.out.println("성공:"+result);
		result = userService.login("yyyy", "1111");
		System.out.println("실패:"+result);
		result = userService.login("xxxx", "2222");
		System.out.println("실패:"+result);
		System.out.println("3.수정");
		rowCount = userService.update(new User("xxxx", "xxxx", "와이맨", "yyyy.co.kr"));
		System.out.println(">> "+rowCount);
		System.out.println("   "+userService.findUser("xxxx"));
		System.out.println("4.삭제");
		rowCount = userService.remove("xxxx");
		System.out.println(">> "+rowCount);
		
	}

}
