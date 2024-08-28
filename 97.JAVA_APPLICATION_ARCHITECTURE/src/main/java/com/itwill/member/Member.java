package com.itwill.member;
/*
VO(Value Object),DTO(Data Transfer Object)
	- member 테이블 1개 row의 데이타의 값을 가지는객체
	- member 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- member 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
이름         널?       유형            
---------- -------- ------------- 
M_ID       NOT NULL VARCHAR2(20)  
M_PASSWORD          VARCHAR2(20)  
M_NAME              VARCHAR2(50)  
M_ADDRESS           VARCHAR2(100) 
M_AGE               NUMBER(3)     
M_MARRIED           CHAR(1)       
M_REGDATE           DATE     
 */

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Member {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberAddress;
	private int memberAge;
	private String memberMarried;
	private Date memberRegdate;
}
