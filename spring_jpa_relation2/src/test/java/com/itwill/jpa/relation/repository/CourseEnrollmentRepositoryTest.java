package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.relation.entity.Address;
import com.itwill.jpa.relation.entity.Course;
import com.itwill.jpa.relation.entity.CourseEnrollment;
import com.itwill.jpa.relation.entity.Student;
import com.itwill.jpa.relation.entity.Tutor;

class CourseEnrollmentRepositoryTest extends SpringJpaApplicationTests{
	@Autowired
	CourseEnrollmentRepository courseEnrollmentRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	@Disabled
	@Transactional
//	@Rollback(false)
	void saveCourseEnrollmentWithStudentAndCourse1() {
		
	
		
		
	}
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void saveCourseEnrollmentWithStudentAndCourse2() {
			
	}
	@Test
//	@Disabled
	@Transactional
	@Rollback(false)
//	@Rollback(true)
	void selectCourseEnrollmentWithStudentAndCourse() {
	
		/*Student student1=studentRepository.findById(1L).get();
		Course course1=courseRepository.findById(1L).get();
		
		CourseEnrollment courseEnrollment1
			=CourseEnrollment.builder()
							 .student(student1)
							 .course(course1)
							 .build();
		courseEnrollmentRepository.save(courseEnrollment1);*/
		Student student1=studentRepository.findById(1L).get();
		Course course1=courseRepository.findById(3L).get();
		CourseEnrollment courseEnrollment1=CourseEnrollment.builder()
											.student(student1)
											.course(course1)
											.build();
		courseEnrollmentRepository.save(courseEnrollment1);
	}
}










