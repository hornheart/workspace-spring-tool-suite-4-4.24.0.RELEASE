package com.itwill.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	
	public OrderServiceImpl() {
		System.out.println("#### OrderServiceImpl()기본생성자호출");
	}
	
	public OrderServiceImpl(OrderDao orderDao) {
		System.out.println("#### OrderServiceImpl("+orderDao+")생성자호출");
		this.orderDao=orderDao;
		
	}
	public void setOrderDao(OrderDao orderDao) {
		System.out.println("#### OrderServiceImpl : setOrderDao("+orderDao+") 메쏘드호출");
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> list() {
		System.out.println("#### OrderServiceImpl : list()메쏘드호출");
		return orderDao.list();
	}
	
}
