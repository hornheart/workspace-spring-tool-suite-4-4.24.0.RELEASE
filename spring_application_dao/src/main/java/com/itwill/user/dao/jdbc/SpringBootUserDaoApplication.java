package com.itwill.user.dao.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.user.dao.mybatis.SpringBootUserDaoImplMyBatisMain;

@SpringBootApplication
public class SpringBootUserDaoApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext = 
				SpringApplication.run(SpringBootUserDaoApplication.class, args);
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		UserDao userDao=applicationContext.getBean(UserDao.class);
		System.out.println(userDao);
		System.out.println(userDao.findUserList());
		System.out.println("####################################");
		System.out.println(userDao.findUser("eun.3"));
		System.out.println("####################################");
		System.out.println(userDao.findUserName("jee"));
	}

}
