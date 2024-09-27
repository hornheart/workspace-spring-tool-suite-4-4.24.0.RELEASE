package com.mybatis3.dao;

import com.mybatis3.domain.Tutor;

public class TutorDaoMain {

	public static void main(String[] args) {
		TutorDao tutorDao=new TutorDao();
		System.out.println("----------findTutorByIdWithCourses--------");
		Tutor tutor=tutorDao.findTutorByIdWithCourses(1);
		System.out.println(tutor);
	
	}
}