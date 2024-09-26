package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDao3_INSERT_Main {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudentBySequence(Dto)--------------------------");
		int insertRowCount= 
				studentDao.insertStudentBySequence(
						new Student(null, "시퀀스1", "kim@nam.com", new Date(), "333-3333"));
		System.out.println(">>> dao return insertRowCount:"+insertRowCount);
		System.out.println("---------insertStudentBySequenceReturnPrimaryKey---------------");
		
		System.out.println(">>> dao return  insertPrimaryKey:"+0);
		System.out.println(">>> Student[Dto]     primary key:"+0);
		
		
		
		
	}
}
