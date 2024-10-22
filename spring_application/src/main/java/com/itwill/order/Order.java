package com.itwill.order;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	private int orderNo;
	private String orderTitle;
	private Date orderDate;
	
}
