package com.itwill.user;

import java.util.List;
public interface UserService{

	public User findUser(String userId)	throws Exception;
	public List<User> findUserList()throws Exception;
	
}