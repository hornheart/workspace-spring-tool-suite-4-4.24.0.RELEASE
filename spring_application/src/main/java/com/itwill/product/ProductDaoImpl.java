package com.itwill.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
	public ProductDaoImpl() {
		System.out.println("1.#### ProductDaoImpl() 생성자:"+this);
	}
	
	@Override
	public List<Product> productList(){
		System.out.println("#### ProductDaoImpl : productList():메쏘드호출");
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1,"새우깡"));
		productList.add(new Product(2,"감자깡"));
		productList.add(new Product(3,"양파링"));
		productList.add(new Product(4,"옥수수깡"));
		return productList;
	}
	
	@Override
	public Product productDetail(int p_no) {
		System.out.println("#### ProductDaoImpl : productDetail("+p_no+") 메쏘드호출");
		return new Product(p_no, "허니버터칩");
	}
}