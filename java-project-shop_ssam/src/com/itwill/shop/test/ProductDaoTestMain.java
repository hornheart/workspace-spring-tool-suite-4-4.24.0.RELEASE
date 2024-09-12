package com.itwill.shop.test;

import com.itwill.shop.product.ProductDao;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception{
		ProductDao productDao=new ProductDao();
		System.out.println("1.selectAll:");
		System.out.println("  "+productDao.findAll());
		System.out.println("2.selectByNo:"+productDao.findByPrimaryKey(8));
		System.out.println("2.selectByNo:"+productDao.findByPrimaryKey(9));

	}

}
