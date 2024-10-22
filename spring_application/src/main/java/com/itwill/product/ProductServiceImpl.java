package com.itwill.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service("productService")
@Scope("singleton")
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	public ProductServiceImpl() {
		System.out.println("2.#### ProductServiceImpl()생성자:"+this);
	}
	public ProductServiceImpl(ProductDao productDao) {
		System.out.println("2.#### ProductServiceImpl("+productDao+")생성자:"+this);
		this.productDao=productDao;
	}
	
	public void setProductDao(ProductDao productDao) {
		System.out.println("3.#### ProductServiceImpl.setProductDao("+productDao+")호출");
		this.productDao = productDao;
	}
	@Override
	public List<Product> productList(){
		System.out.println("#### ProductServiceImpl : productList() 메쏘드호출");
		return productDao.productList();
	}
	@Override
	public Product productDetail(int p_no) {
		System.out.println("#### ProductServiceImpl : productDetail("+p_no+") 메쏘드호출");
		return productDao.productDetail(p_no);
	}
}
