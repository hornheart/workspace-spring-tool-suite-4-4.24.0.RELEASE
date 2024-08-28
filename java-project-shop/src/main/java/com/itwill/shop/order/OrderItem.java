package com.itwill.shop.order;

import com.itwill.shop.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
	
	private int oi_no;
	private int oi_qty;
	/****FK****/
	private Order order;

	/****FK****/
	private Product product;
	

}
