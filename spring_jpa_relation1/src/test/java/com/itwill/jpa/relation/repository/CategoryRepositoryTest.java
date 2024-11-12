package com.itwill.jpa.relation.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;

class CategoryRepositoryTest extends SpringJpaRelationApplicationTests{
	
	
		@Autowired
		CategoryRepository categoryRepository;
		
		@DisplayName("1.카테고리+제품들저장")
		@Test
		@Transactional
		@Rollback(false)
		void categoryWithProductsSave() {
			/***************[CascadeType.PERSIST]**************/
			
			Category category1=Category.builder().code("IT").name("프로그래밍").build();
			Category category2=Category.builder().code("HOBBY").name("취미").build();
			
			Product product1 = Product.builder().name("SPRING").price(3000).stock(50).build();
			Product product2 = Product.builder().name("JAVA").price(1000).stock(23).build();
			Product product3 = Product.builder().name("HTML").price(2400).stock(11).build();
			/*
			 * 연관관계설정[OWNER 테이블이 아닌경우]
			 * Category-->Product
			 * Product-->Category
			 */
			category1.getProducts().add(product1);
			category1.getProducts().add(product2);
			category1.getProducts().add(product3);
			
			product1.setCategory(category1);
			product2.setCategory(category1);
			product3.setCategory(category1);
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			
		}
		
		@DisplayName("2.카테고리+제품들 읽기")
		@Test
		@Transactional
		@Rollback(false)
		void categoryWithProductsRead() {
			Category category1 = categoryRepository.findById(1L).get();
			System.out.println(">>> "+category1);
			System.out.println(">>> "+category1.getProducts());
		}
		@DisplayName("3.카테고리+제품들  삭제")
		@Test
		@Transactional
		@Rollback(false)
		void categoryWithProductsDelete() {
			System.out.println("----부모엔티티삭제시자식엔티티도같이삭제[CascadeType.REMOVE]------");
			Category category1=categoryRepository.findById(1L).get();
			System.out.println(category1.getProducts());
			categoryRepository.delete(category1);
			
		}
/*
		@Test
		@DisplayName("4.카테고리+제품들 읽기")
		@Transactional
		@Rollback(false)
		void categoryWithProductsRead() {
			System.out.println("--------------------read[CascadeType.PERSIST]-------------------");
		
			Category category1=categoryRepository.findById(1L).get();
			System.out.println(">>> "+category1);
//			System.out.println(">>> "+category1.getProducts());=>join해서? 어제 gpt한테 물은거1111==>owner table이 아니라서
			
		System.out.println("--------------------save[CascadeType.PERSIST]-------------------");
	
		
		
		System.out.println("--------------------부모엔티티삭제[CascadeType.REMOVE]-------------------");
		
		System.out.println("--------------------자식엔티티삭제[CascadeType.REMOVE]-------------------");
		
		System.out.println("--------------------부모엔티티삭제[orphanRemoval = true]-------------------");
		
		System.out.println("--------------------자식엔티티삭제[orphanRemoval = true]--------------------");
	
		System.out.println("--------------------부모엔티티와자식엔티티연관관계제거[orphanRemoval = true]??-------------------");
		/***************[CascadeType.PERSIST]**************/
		
		
		/*
		 * 연관관계설정[OWNER]
		 * Category-->Product
	}
		void categoryWithProductsDelete() {
			
			System.out.println("--------------------delete-------------------");
			
		}
		 */

	
}





