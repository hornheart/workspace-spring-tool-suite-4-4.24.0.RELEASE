package com.itwill.jpa.relation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ProductDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String description;
	/***PRODUCT_DETAIL:PRODUCT*****
	 * 1(PRODUCT_DETAIL):1(PRODUCT)
	 * OWNER TABLE
	 */
	@OneToOne
	private Product product;
	
	
}