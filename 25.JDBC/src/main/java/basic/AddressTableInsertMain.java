package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableInsertMain {

	public static void main(String[] args) throws Exception{
		/************데이타베이스 접속정보[124.198.47.195]*************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user="jdeveloper00";
		String password="jdeveloper00";
		/**************************************************************/
		String insertSql="insert into address values(address_no_seq.nextval,'김경호','123-6779','서울시 여러분')";
		/*
		 1.Driver class loading
	     2.Connection 객체생성
		 3.Statement객체생성
		 4.SQL문전송(insert)
		 5.SQL문전송(insert)결과 영향받은행의수 반환
		 6.연결객체해지(resource해지) close
		 */
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		/*
		 << int executeUpdate(String sql) throws SQLException >>
		 	Executes the given SQL statement, 
		 	which may be an INSERT, UPDATE, 
		 	or DELETE statement or anSQL statement that returns nothing,
		 	such as an SQL DDL statement. 
		 */
		int rowCount=stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:"+rowCount);
		stmt.close();
		con.close();
	}

}
