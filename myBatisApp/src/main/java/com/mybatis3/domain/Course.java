package com.mybatis3.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course  {
	/*
	이름          널?       유형            
	----------- -------- ------------- 
	COURSE_ID   NOT NULL NUMBER(11)    
	NAME        NOT NULL VARCHAR2(100) 
	DESCRIPTION          VARCHAR2(512) 
	START_DATE           DATE          
	END_DATE             DATE          
	TUTOR_ID    NOT NULL NUMBER(11)    	(FK)
	
<course_enroll>  
이름        널?       유형         
--------- -------- ---------- 
COURSE_ID NOT NULL NUMBER(11) 
STUD_ID   NOT NULL NUMBER(11) 
	 */

	private Integer courseId;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	
	private Tutor tutor;
	
	private List<Student> students;
	
	
}
