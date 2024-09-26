package com.mybatis3.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Address;

public class AddressDao {
	private SqlSessionFactory sqlSessionFactory;
	public AddressDao() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*************************************************
	 SELECT ( addresses + students JOIN)[ 1 : n ]
	 *************************************************/
	public Address findAddressByIdWithStudents(Integer addrId) {
		
		Address address=null;
		return address;
	}
	/*************************************************
	 SELECT ( addresses + tutors JOIN)[ 1 : n ]
	 *************************************************/
	public Address findAddressByIdWithTutors(Integer addrId) {
		
		Address address=null;
				
		return address;
	}
}

