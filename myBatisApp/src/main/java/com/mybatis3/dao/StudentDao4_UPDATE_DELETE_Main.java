package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDao4_UPDATE_DELETE_Main {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		
		/**************************************************
		 UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		
		System.out.println("update row count:"+
					studentDao.updateStudentById(new Student(new Integer(8), "팔팔팔", "vkf@na.com", new Date(),"1234-1234")));
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("delete row count:"+studentDao.deleteStudentById(19));
		
		
	}
}
