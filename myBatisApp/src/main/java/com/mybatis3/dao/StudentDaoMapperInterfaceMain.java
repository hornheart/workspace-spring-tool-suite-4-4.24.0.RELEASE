package com.mybatis3.dao;

public class StudentDaoMapperInterfaceMain {

	public static void main(String[] args) {
		StudentDaoMapperInterface mapperInterfaceStudentDao=
				new StudentDaoMapperInterface();
		System.out.println("<<<<<<<<<<<<<< StudentMapper Interface를 사용한Dao메쏘드호출 >>>>>>>>>");
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println("---------findStudentById-----------------------------");
		
	}

}
