package com.itwill.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("userDao1")
public class UserDaoImpl1 implements UserDao {
	

	public UserDaoImpl1() {
		System.out.println("#### UserDaoImpl1() : 디폴트생성자 호출  ");
	}
	
	
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImpl1 : findUser() 호출  ");
		return new User("guard1", "1111", "KIM", "guard1@gmail.com");
	}
	
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImpl1 : findUserList 호출  ");
		List<User> userList=new ArrayList<User>();
		userList.add(new User("guard1", "1111", "KIM", "guard1@gmail.com"));
		userList.add(new User("guard2", "2222", "JIM", "guard2@gmail.com"));
		userList.add(new User("guard3", "3333", "DIM", "guard3@gmail.com"));
		userList.add(new User("guard4", "4444", "AIM", "guard4@gmail.com"));
		return userList;
	}
	
}













