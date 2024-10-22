package com.itwill.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	

	public UserDaoImpl() {
		System.out.println("#### UserDaoImpl() : 디폴트생성자 호출  ");
	}
	
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImpl : findUser() 호출  ");
		return new User("guard1", "1111", "KIM", "guard1@gmail.com");
	}
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImpl : findUserList 호출  ");
		List<User> userList=new ArrayList<User>();
		userList.add(new User("guard1", "1111", "KIM", "guard1@gmail.com"));
		userList.add(new User("guard1", "1111", "KIM", "guard1@gmail.com"));
		userList.add(new User("guard1", "1111", "KIM", "guard1@gmail.com"));
		userList.add(new User("guard1", "1111", "KIM", "guard1@gmail.com"));
		return userList;
	}
	
}














