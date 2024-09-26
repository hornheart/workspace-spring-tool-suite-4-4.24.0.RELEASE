package com.mybatis3.basic;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0.mybatis-config-mapper-interface.xml --> InputStream
		 */
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		/*
		 * 2. SqlSessionFactory
		 */
		/*
		 * 3. SqlSession open (Connection)
		 * 	  autocommit true
		 */
		/*
		 * 4. StudentMapper[MapperInterface]생성
		 *    org.apache.ibatis.binding.MapperProxy
		 */
		/*
		 * 4. StudentMapper[MapperInterface]사용(CRUD)
		*/
		
		/*
		 * 5. SqlSession close
		 */
		
	}
}













