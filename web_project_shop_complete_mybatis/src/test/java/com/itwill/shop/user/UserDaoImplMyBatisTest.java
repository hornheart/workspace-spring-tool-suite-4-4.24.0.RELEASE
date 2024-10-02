package com.itwill.shop.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.mock.http.client.MockClientHttpRequest;


class UserDaoImplMyBatisTest {
	UserDao userDao;
	
	@BeforeEach
	void setUp() throws Exception {
		userDao=new UserDaoImplMyBatis();
	}
	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testFindUser() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testFindUserList()  throws Exception{
		assertNotEquals(userDao.findUserList(), null);
		assertEquals(userDao.findUserList().size(),21 );
		assertTrue(userDao.findUserList().size() > 0 );
		System.out.println(userDao.findUserList());
	}
	@Disabled
	@Test
	void testInsert() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testDelete() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testCountByUserId() {
		fail("Not yet implemented");
	}

	
}
