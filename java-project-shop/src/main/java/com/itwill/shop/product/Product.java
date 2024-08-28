package com.itwill.shop.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

	private int p_no;
	private String p_name;
	private int p_price;
	private String p_image;
	private String p_desc;
	private int p_click_count;
}
