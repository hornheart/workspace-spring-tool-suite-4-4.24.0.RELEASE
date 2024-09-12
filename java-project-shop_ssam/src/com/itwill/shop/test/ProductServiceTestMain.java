package com.itwill.shop.test;

import com.itwill.shop.product.ProductService;

public class ProductServiceTestMain {

	public static void main(String[] args)throws Exception {
		ProductService productService=new ProductService();
		System.out.println("1.제품리스트보기");
		System.out.println("  "+productService.productList());
		System.out.println("2.제품상세보기");
		System.out.println("  "+productService.productDetail(5));
		

	}

}
