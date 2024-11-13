package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.relation.entity.Address;
import com.itwill.jpa.relation.entity.CourseEnrollment;
import com.itwill.jpa.relation.entity.Student;

import jakarta.transaction.Transactional;

class StudentRepositoryTest extends SpringJpaApplicationTests {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	AddressRepository addressRepository;
	@Transactional
	@Rollback(false)
	@Test
	@Disabled
	void saveStudentWithAddress() {
		
	
	}
	@Transactional
	@Rollback(false)
	@Test
	//@Disabled
	void selectStudentWithAddress() {
	
		Student student1=studentRepository.findById(1L).get();
		System.out.println("---------------조인연산안함---------------");
		System.out.println(">>> "+student1);
		System.out.println("---------------select * from address---------------");
		System.out.println(">>> "+student1.getAddress());
	
	}

	@Transactional
	@Rollback(false)
	@Test
	//@Disabled
	void selectStudentWithCourseEnrollments() {
	
		Student student1=studentRepository.findById(1L).get();
		List<CourseEnrollment> courseEnrollments=student1.getCourseEnrollments();
		for(CourseEnrollment ce:courseEnrollments) {
			System.out.println("---------------selectStudentWithCourseEnrollments---------------");
			System.out.println(ce.getCourse());
		}
	
	
	}
}











