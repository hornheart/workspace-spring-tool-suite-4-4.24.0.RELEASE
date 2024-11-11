package com.itwill.jpa.relation.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests{
	
	
	
	void productWithCategorySaveAndRead() {
		
		/*
		 * 연관관계설정 Product-->Category
		 */
	
		/*
		엔티티를 저장하고 변경 사항을 데이터베이스에 즉시 동기화합니다.
		- saveAndFlush
		 */
		
		
	
	}
	
	
	

	void productWithProviderSaveAndRead() {
		
		/***** 연관설정 Product-->Provider *****/
		System.out.println("--------------read-------------");
		
	}
	

	void productWithProductDetailSaveAndRead() {
		
	
		/*
		 * 연관관계설정(OWNER테이블아닌경우)
		 * Product-->ProductDetail
		 */
	}
	
	
	
	
	
	
}