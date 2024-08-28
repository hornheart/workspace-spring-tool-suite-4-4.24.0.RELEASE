package com.itwill.shop.cart;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

	private int cart_no;
	private int cart_qty;
	/****FK****user**/
//	private String userid;
	private User user;
	/****FK****product**/
//	private String p_no;
	private Product product;
	
}
