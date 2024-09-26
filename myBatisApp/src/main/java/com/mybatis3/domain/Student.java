package com.mybatis3.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/*
이름      널?       유형           
------- -------- ------------ 
STUD_ID NOT NULL NUMBER(11)   
NAME    NOT NULL VARCHAR2(50) 
EMAIL   NOT NULL VARCHAR2(50) 
PHONE            VARCHAR2(15) 
DOB              DATE         
BIO              CLOB         
PIC              BLOB         
ADDR_ID          NUMBER(11)   

*/


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	
	private Integer studId;//stud_Id로 하면 맴핑가능?
	
	private String name;
	
	private String email;
	
	private Date dob;
	
	private String phone;


}
