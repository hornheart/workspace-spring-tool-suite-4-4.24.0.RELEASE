package com.mybatis3.basic;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;
import com.mybatis3.domain.Tutor;

public class MyBatisFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0. mybatis-config.xml --> InputStream
		 */
		InputStream myBatisConfigStream=Resources.getResourceAsStream("mybatis-config.xml");
		
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlsessionFactoryBuilder=new SqlSessionFactoryBuilder();
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlsessionFactory=sqlsessionFactoryBuilder.build(myBatisConfigStream);
		
		/*
		 * 3. SqlSession open (Connection)
		 */
		SqlSession sqlSession=sqlsessionFactory.openSession(true);
		/*
		 * autocommit true
		 */
		System.out.println("# sqlSession객체:"+sqlSession);
		
		/*
		 * 4. SqlSession사용(CRUD)
		*/
		Student student= sqlSession.selectOne("com.mybatis3.dao.mapper.StudentBasicMapper.findStudentById",1);
		System.out.println(student);
		List<Student> studentList= sqlSession.selectList("com.mybatis3.dao.mapper.StudentBasicMapper.findAllStudents");
		System.out.println(studentList);
		
		System.out.println("===============findTutorByIdWithCourses===============");
		Tutor tutor = sqlSession.selectOne("com.mybatis3.dao.mapper.TutorMapper.findTutorByIdWithCourses",1);
		System.out.println(tutor);
		/*
		 * 5. SqlSession close
		 */
		sqlSession.close();
	}
}













