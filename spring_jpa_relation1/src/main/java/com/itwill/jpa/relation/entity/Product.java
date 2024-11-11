package com.itwill.jpa.relation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer price;
	private Integer stock;
	/***PRODUCT:PRODUCT_DETAIL*****
	 * 1(PRODUCT):1(PRODUCT_DETAIL)
	 * 
	*/
	@OneToOne(mappedBy = "product",cascade = CascadeType.PERSIST)
	@ToString.Exclude
	private ProductDetail productDetail;
	

}