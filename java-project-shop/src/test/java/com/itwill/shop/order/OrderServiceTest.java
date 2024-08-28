package com.itwill.shop.order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
	OrderService orderService;
	@BeforeEach
	void setUp() throws Exception {
		orderService=new OrderService();
	}

	@Test
	void testCreate()throws Exception{
		int insertRowCount = orderService.create("guard3");
		assertTrue(insertRowCount==0);
		
	}

}