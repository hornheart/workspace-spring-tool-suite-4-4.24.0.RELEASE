package com.itwill.jpa.relation.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;

class CategoryRepositoryTest extends SpringJpaRelationApplicationTests{
	
	
	void categoryWithProductsSaveAndReadDelete() {
		/***************[CascadeType.PERSIST]**************/
		
		
		/*
		 * 연관관계설정
		 * Category-->Product
		 */
		
		System.out.println("--------------------save[CascadeType.PERSIST]-------------------");
	
		
		System.out.println("--------------------read[CascadeType.PERSIST]-------------------");
		
		System.out.println("--------------------delete-------------------");
		System.out.println("--------------------부모엔티티삭제[CascadeType.REMOVE]-------------------");
		
		System.out.println("--------------------자식엔티티삭제[CascadeType.REMOVE]-------------------");
		
		System.out.println("--------------------부모엔티티삭제[orphanRemoval = true]-------------------");
		
		System.out.println("--------------------자식엔티티삭제[orphanRemoval = true]--------------------");
	
		System.out.println("--------------------부모엔티티와자식엔티티연관관계제거[orphanRemoval = true]??-------------------");
	}
}





