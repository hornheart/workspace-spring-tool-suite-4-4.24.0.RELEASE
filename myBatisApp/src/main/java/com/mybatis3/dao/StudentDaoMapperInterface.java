package com.mybatis3.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class StudentDaoMapperInterface {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	
	public StudentDaoMapperInterface() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = 
					sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 resultType Dto 
	*/
	public Student findStudentById(Integer studId) {
		return null;
	}
	public List<Student> findAllStudents() {
		return null;
	}
	
	
	
}
