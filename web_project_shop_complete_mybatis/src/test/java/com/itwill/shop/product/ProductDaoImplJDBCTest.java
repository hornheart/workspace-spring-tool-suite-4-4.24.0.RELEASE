package com.itwill.shop.product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.notNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductDaoImplJDBCTest {
	ProductDao productDao;
	@BeforeEach
	void setUp() throws Exception {
		productDao=new ProductDaoImplJDBC();
	}

	@Test
	void testFindByPrimaryKey() throws Exception{
		
		Product product=productDao.findByPrimaryKey(1);
		System.out.println(product);
		assertNotEquals(product,null);
		assertTrue(product != null);
		assertTrue(product.getP_name().equals("비글"));
	}

	@Test
	void testFindAll() throws Exception {
		assertTrue(productDao.findAll().size() > 0);
		
	}

}
