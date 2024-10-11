package com.testboard2.configuration;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration//자동으로 빈 등록
@PropertySource("classpath:/application.properties")
public class DBConfiguration {//@ComponentScan이 이 클래스로 지정한 IoC(Inversion of Control)컨테이너에 등록

	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {//hikariCP 설정1 @Bean:retur 되는 객체를 IoC컨테이너에 등록
		
		return new HikariConfig();
	}

	@Bean
	public DataSource dataSource() {//hikari 설정2
		
		DataSource dataSource=new HikariDataSource(hikariConfig());
		System.out.println( dataSource.toString() );
		
		return dataSource;
	}
	
	//MyBatis 설정1:SqlSessionFactory<--SqlSessionFactoryBean
	@Bean
	public SqlSessionFactory sqlSessionFatory(DataSource dataSource) throws Exception{//일종의 공장으로 생각해 놓는다
		
		SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
		factoryBean.setDataSource( dataSource );
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/Mapper.xml"));
		//		ApplicationContext 객체를 가져오며 프레임워크 컨테이너라고 생각하면 됨, 스타트에서 끝나는 순간까지 필요한 모든 자원을 모아놓고 관리 
		factoryBean.setTypeAliasesPackage("com.testboard2.dto");
		return factoryBean.getObject();
	}

	//MyBatis 설정2:SqlSessionTemplate<--SqlSessionFactory 형틀을 만든다, 
//	넘겨받은 sqlSessionFatory를 통해 sqlSessioTemplate객체 생성 및 리턴과 spring+MyBatis 연동 모듈에서 대체
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
		
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
