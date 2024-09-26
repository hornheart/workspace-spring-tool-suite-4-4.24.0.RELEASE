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
		
		System.out.println("update row count:"+0);
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("delete row count:"+0);
		
		
	}
}
