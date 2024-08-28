package com.itwill.shop.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
VO(Value Object),DTO(Data Transfer Object)
	- userinfo 테이블 1개 row의 데이타의 값을 가지는객체
	- userinfo 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- userinfo 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
 =================================== 
 이름 		널? 		유형
 =================================== 
 USERID 	NOT NULL VARCHAR2(100) 
 PASSWORD	NOT NULL VARCHAR2(100) 
 NAME 		NOT NULL VARCHAR2(200) 
 EMAIL 			 VARCHAR2(300)
 ===================================
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private String userId;
	private String password;
	private String name;
	private String email;
}