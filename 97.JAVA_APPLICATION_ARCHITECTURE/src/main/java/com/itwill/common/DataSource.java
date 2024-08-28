package com.itwill.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * 데이타베이스 접속정보를 이용해서
 * Connection을 생성하고 해지하는역할을하는 클래스
 * [Dao객체들이사용하는 클래스]
 */
public class DataSource {
	/****데이타베이스 접속정보를저장할필드********/
	private String driverClassName ;
	private String url ;
	private String username ;
	private String password ;
	/**************************************************************/
	public DataSource() throws Exception{
		/******jdbc.propetiee파일을 읽어서 데이타베이스 접속정보를 멤버필드저장******/
		Properties properties=new Properties();
		/*
		 * jdbc.properties파일은 src 폴더에 위치해야합니다.
		 */
		InputStream in = DataSource.class.getResourceAsStream("/jdbc.properties");
		properties.load(in);
		this.driverClassName=properties.getProperty("driverClassName");
		this.url=properties.getProperty("url");
		this.username=properties.getProperty("username");
		this.password=properties.getProperty("password");
		
	}
	
	/*
	 * 데이타베이스접속정보를 이용해서 Connection를 생성해서
	 * 반환하는 메쏘드
	 */
	public Connection getConnection() throws Exception{
		Class.forName(driverClassName);
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}
	/*
	 * 사용한Connection객체를 close하는메쏘드
	 */
	public void close(Connection con) throws Exception{
		con.close();
	}
}
