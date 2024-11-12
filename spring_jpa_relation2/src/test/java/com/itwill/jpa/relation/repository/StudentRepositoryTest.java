package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.relation.entity.Address;
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
	@Disabled
	void selectStudentWithAddress() {
		
	}

}











