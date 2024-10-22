package com.itwill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	//field injection
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		System.out.println("#### UserServiceImpl() : 디폴트생성자호출");

	}
	//@Autowired 생성자 injection
	public UserServiceImpl(UserDao userDao) {
		System.out.println("#### UserServiceImpl("+userDao+") :생성자호출");
		this.userDao=userDao;
	}
	//@Autowired setter injection
	public void setUserDao(UserDao userDao) {
		System.out.println("#### UserServiceImpl : setUserDao(UserDao userDao) : 메쏘드호출");
		this.userDao = userDao;
	}

	public User findUser(String userId) throws Exception {
		System.out.println("#### UserServiceImpl : findUser("+userId+") 호출");
		return userDao.findUser(userId);
	}
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserServiceImpl : findUserList() 호출  ");
		return userDao.findUserList();
	}
}
