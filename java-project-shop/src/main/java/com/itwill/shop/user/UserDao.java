package com.itwill.shop.user;

import com.itwill.shop.common.DataSource;

public class UserDao {

	private DataSource dataSource;
	public UserDao() throws Exception{
		dataSource=new DataSource();
	}
}
