package com.testboard2.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration//자동으로 빈 등록
@PropertySource("classpath:/application.properties")
public class DBConfiguration {//@ComponentScan이 이 클래스로 지정한 IoC(Inversion of Control)컨테이너에 등록

	public HikariConfig hikariConfig() {//hikari 설정1
		
		return new HikariConfig();
	}

	public DataSource dataSource() {//hikari 설정2
		
		DataSource dataSource=new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		
		return dataSource;
	}
	
	//MyBatis 설정1:SqlSessionFactory<--SqlSessionFactoryBean
	public SqlSessionFactory sqlSessionFatory() throws Exception{//일종의 공장으로 생각해 놓는다
		
		SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
		
		return factoryBean.getObject();
	}

	//MyBatis 설정2:SqlSessionTemplate<--SqlSessionFactory 형틀을 만든다
	public SqlSessionTemplate sqlSessionTemplate() throws Exception{
		
		return new SqlSessionTemplate(sqlSessionFatory());
	}
}
