package com.itwill.shop.order;

import java.util.Date;
import java.util.List;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	private int o_no;
	private String o_desc;
	private Date o_date;
	private int o_price;
	/****FK****/
	private User user;
	
	private List<OrderItem> orderItems;
}
