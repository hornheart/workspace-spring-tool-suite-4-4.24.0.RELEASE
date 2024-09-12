package com.itwill.shop.product;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductDaoTest {
	ProductDao productDao;
	@Test
	@BeforeEach
	void setUp() throws Exception {
		productDao=new ProductDao();
		assertNotNull(productDao,"dao객체생성실패");;
	}

	@Test
	void testFindByPrimaryKey()  throws Exception{
		Product p=productDao.findByPrimaryKey(1);
		assertNotNull(p);
		
	}

	@Test
	void testFindAll() throws Exception{
		List<Product> productList=productDao.findAll();
		assertTrue(productList.size()>0);
	}

}
