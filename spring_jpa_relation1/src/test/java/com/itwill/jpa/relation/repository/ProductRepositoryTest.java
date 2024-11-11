package com.itwill.jpa.relation.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

import jakarta.transaction.Transactional;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests{
	
	@Autowired
	ProductRepository productRepository;
	@DisplayName("제품+제품상세 저장")
	@Test
	@Transactional
	@Rollback(false)
	void productWithProductDetailSave() {
		System.out.println("--------------insert-------------");
		Product product=
				Product.builder().
				name("JPA").
				price(2000).
				stock(50).
				build();
		ProductDetail productDetail=
				ProductDetail.builder().description("JPA아주좋아요!!").build();
		/*
		 * 연관관계설정(OWNER테이블아닌경우)
		 * Product에 ProductDetail set
		 * ProductDetail에 Product set
		 */
		product.setProductDetail(productDetail);
		productDetail.setProduct(product);
		
		productRepository.save(product);
		
	}
	
	void productWithCategorySaveAndRead() {
		
		/*
		 * 연관관계설정 Product-->Category
		 */
	
		/*
		엔티티를 저장하고 변경 사항을 데이터베이스에 즉시 동기화합니다.
		- saveAndFlush
		 */
		
		
	
	}
	
	
	

	@DisplayName("제품+제품상세 읽기")
	@Test
	@Transactional
	@Rollback(false)
	void productWithProductDetailRead() {
		/*******************************************/
		Product product=
				Product.builder().
				name("JPA").
				price(2000).
				stock(50).
				build();
		ProductDetail productDetail=
				ProductDetail.builder().description("JPA아주좋아요!!").build();
		/*
		 * 연관관계설정(OWNER테이블아닌경우)
		 * Product에 ProductDetail set
		 * ProductDetail에 Product set
		 */
		product.setProductDetail(productDetail);
		productDetail.setProduct(product);
		
		productRepository.save(product);
		/********************************************/
		
		/*
		 * 연관관계설정(OWNER테이블아닌경우)
		 * Product-->ProductDetail
		 */
		System.out.println("--------------productWithProductDetailRead-------------------");
//		Product product1=productRepository.findById(1L).get();
//		System.out.println(">>>>>"+product1);
//		System.out.println(">>>>>"+product1.getProductDetail());
		
		Product product2 = productRepository.findById(2L).orElse(null);
		if (product2 != null) {
		    // ProductDetail 정보도 출력합니다.
		    System.out.println(">>>>>Product: " + product2);
		    
		    // productDetail이 정상적으로 연결되어 있으면 출력
		    if (product2.getProductDetail() != null) {
		        System.out.println(">>>>>ProductDetail: " + product2.getProductDetail());
		    } else {
		        System.out.println(">>>>>ProductDetail: null (연결된 ProductDetail이 없습니다.)");
		    }
		} else {
		    System.out.println(">>>>>Product가 존재하지 않습니다.");
		}
		System.out.println(">>>>>"+product2);
//		System.out.println(">>>>>"+product2.getProductDetail());

	}
	
	void productWithProductDetailSaveAndRead() {
		
	
		/*
		 * 연관관계설정(OWNER테이블아닌경우)
		 * Product-->ProductDetail
		 */
	}
	
	
	
	
	
	
}