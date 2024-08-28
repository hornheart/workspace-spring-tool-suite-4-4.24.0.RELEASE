package dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileLoadingMain {

	public static void main(String[] args)throws Exception {
		/*
		 * .properties 설정파일을 읽어서 Properties[Map]객체생성
		 */
		Properties properties=new Properties();
		
		InputStream fis=PropertiesFileLoadingMain.class.getResourceAsStream("/프로퍼티파일.properties");
		properties.load(fis);
		/*
		 <<프로퍼티파일.properties>>
		 driverClass=oracle.driver.OracleDriver
		 url=jdbc:oracle:thin:@124.198.47.195:1521:xe
		 username=jdeveloper00
		 password=jdeveloper00
 
		<<Properties객체>>
		------------------------------------------------------
		 key(String) | value(String)
		------------------------------------------------------
		 driverClass | oracle.jdbc.OracleDriver
		 url         | jdbc:oracle:thin:@124.198.47.195:1521:xe
		 user        | jdeveloper00
		 password    | jdeveloper00
		-------------------------------------------------------
		 */
		System.out.println("Properties size:"+properties.size());
		System.out.println(properties);
		
		String driverClass=properties.getProperty("driverClass");
		String url=properties.getProperty("url");
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
	}

}
