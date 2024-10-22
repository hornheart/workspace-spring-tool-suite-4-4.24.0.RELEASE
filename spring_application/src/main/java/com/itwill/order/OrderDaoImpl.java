package com.itwill.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrderDaoImpl implements OrderDao {
	public OrderDaoImpl() {
		System.out.println("#### OrderDaoImpl() : 기본생성자호출");
	}
	
	@Override
	public List<Order> list() {
		System.out.println("#### OrderDaoImpl : list() 메쏘드호출");
		List<Order> orderList=new ArrayList<>();
		orderList.add(new Order(1,"주문1",new Date()));
		orderList.add(new Order(2,"주문2",new Date()));
		orderList.add(new Order(3,"주문3",new Date()));
		return orderList;
	
	}
	
}
