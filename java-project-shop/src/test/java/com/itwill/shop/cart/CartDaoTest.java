package com.itwill.shop.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

class CartDaoTest {
	CartDao cartDao;
	@BeforeEach
	void setUp() throws Exception {
		cartDao=new CartDao();
	}

	//@Test
	void testInsert() throws Exception{
		Cart cart=Cart.builder()
				.cart_qty(1)
				.user(User.builder().userId("guard1").build())
				.product(Product.builder().p_no(1).build())
				.build();
		
		int insertRowCount1 = cartDao.insert(cart);
		assertEquals(1, insertRowCount1);
		
		//int insertRowCount2 = cartDao.insert("guard2",1,3);
		//assertEquals(1, insertRowCount2);
		
	}
	@Test
	void testUpdateByProductNo() throws Exception{
		Cart cart=Cart.builder()
				.cart_qty(3)
				.product(Product.builder().p_no(1).build())
				.user(User.builder().userId("guard1").build())
				.build();
		
		int updateRowCount=cartDao.updateByProductNo(cart);
		assertEquals(1, updateRowCount);
		
	}

}