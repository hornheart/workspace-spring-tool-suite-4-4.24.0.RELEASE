package com.itwill.shop.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

class CartServiceTest {
	CartService cartService;
	@BeforeEach
	void setUp() throws Exception {
		cartService=new CartService();
	}
	
	@Test
	void testAddCart() throws Exception {
		//update
		Cart cart=Cart.builder()
				.user(User.builder().userId("guard1").build())
				.product(Product.builder().p_no(2).build())
				.cart_qty(3)
				.build();
		int rowCount = cartService.addCart(cart);
		assertEquals(1, rowCount);
		//insert
		Cart cart2=Cart.builder()
				.user(User.builder().userId("guard1").build())
				.product(Product.builder().p_no(8).build())
				.cart_qty(3)
				.build();
		int rowCount2 = cartService.addCart(cart2);
		assertEquals(1, rowCount2);
	}

}