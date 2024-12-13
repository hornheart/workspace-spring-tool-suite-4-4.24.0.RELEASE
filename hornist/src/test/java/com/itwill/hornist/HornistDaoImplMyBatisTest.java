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
		System.out.println("hornistByList => "+"\n "+hornistDao.findByAll());
	}
	
	@Test
	void hornistByNumberList()throws Exception{
	
		System.out.println("hornistByNumberList => "+"\n "+hornistDao.findByHornistNo(5));
	
	}
	
	@Test
	void hornistByWeatherList()throws Exception{
		
		System.out.println("hornistByWeatherList => "+"\n "+hornistDao.findByHornistWeather("sunny"));
		
	}
	
	

}
