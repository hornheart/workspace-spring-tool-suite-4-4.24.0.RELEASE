package basic.etc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class StaticBlock {
	static {
		try {
		System.out.println("1.Driver객체생성");
		Driver driver=new OracleDriver();
		System.out.println("2.DriverManager에Driver객체등록");
		DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
