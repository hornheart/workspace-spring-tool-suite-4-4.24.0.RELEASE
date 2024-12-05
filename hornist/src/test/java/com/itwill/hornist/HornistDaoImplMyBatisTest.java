package com.itwill.hornist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.HornistSpringApplicationTests;
import com.itwill.hornist.HornistDao;

class HornistDaoImplMyBatisTest extends HornistSpringApplicationTests {
	@Autowired
	HornistDao hornistDao;
	@Test
	void hornist_list() throws Exception{
		System.out.println(hornistDao.findByAll());
	}

}
