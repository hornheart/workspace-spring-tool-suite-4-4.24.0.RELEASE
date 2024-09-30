package com.mybatis3.basic;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentBasicMapper;
import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0.mybatis-config-mapper-interface.xml --> InputStream
		 */
		InputStream myBatisConfigStream = Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(myBatisConfigStream);
		/*
		 * 3. SqlSession open (Connection)
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/*
		 * autocommit true
		 */
		/*
		 * 4. StudentMapper[MapperInterface]생성
		 *    org.apache.ibatis.binding.MapperProxy
		 */
		StudentBasicMapper studentMapper=
				sqlSession.getMapper(StudentBasicMapper.class);
		
		System.out.println(studentMapper);
		/*
		 * 4. StudentMapper[MapperInterface]사용(CRUD)
		*/
		System.out.println(studentMapper.findStudentById(1));
		System.out.println(studentMapper.findAllStudents());
		/*
		 * 5. SqlSession close
		 */
		
	}
}












