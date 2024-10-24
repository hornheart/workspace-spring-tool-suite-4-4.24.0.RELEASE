package com.itwill.datasource.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration
 - 스프링부트가 초기화하면서 설정파일의 @Bean이 있는 모든 메소드를 호출 수 
 한반환객체를 스프링빈으로등록한다. 
 
 */
@Configuration
public class DataSourceConfig {
/*@Bean
 * -메소드 호출 후 반환되는 객체를 빈으로 등록*/
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		/*spring boot 3.2.x이후 실행안됨*/
		System.out.println("##############DataSourceConfig.dataSource()");
		return DataSourceBuilder
				.create()
				.type(BasicDataSource.class)
				.build();
	}
}
