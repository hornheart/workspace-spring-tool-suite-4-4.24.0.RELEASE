package dao.address.first;
/*
Dao(Data Access Object)클래스
  - address 테이블에 CRUD(Create,Read,Update,Delete) 작업을하는 
    단위메쏘드를 가지고있는 클래스
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressDao1 {
	/************ 데이타베이스 접속정보[124.198.47.195] *************/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
	String user = "jdeveloper00";
	String password = "jdeveloper00";
	/**************************************************************/
	public void insert() throws Exception {
		
		String insertSql = "insert into address values(address_no_seq.nextval,'김경호','123-6779','서울시 여러분')";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:" + rowCount);
		stmt.close();
		con.close();

	}

	public void deleteByNo() throws Exception {
	
		String deleteSql = "delete from address where no=1";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(">> delete row count:" + rowCount);
		stmt.close();
		con.close();
	}

	public void updateByNo() throws Exception {
		
		String updateSql = "update address set name='김변경',phone='999-9999',address='부산시 여러분' where no=1";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(">> update row count:" + rowCount);
		stmt.close();
		con.close();
	}

	public void selectByNo() throws Exception {
		
		String selectSql = "select * from address where no=1";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		
		/*
		 이름      널?       유형            
		------- -------- ------------- 
		NO      NOT NULL NUMBER(10)    
		NAME    NOT NULL VARCHAR2(50)  
		PHONE   NOT NULL VARCHAR2(50)  
		ADDRESS          VARCHAR2(200) 
		*/
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			/* --------------------------------
			 * DB타입 		| 자바타입
			 * --------------------------------
			 * number		| int,double(float)
			 * varchar2,char| String
			 * Date			| Date
			 * --------------------------------
			 */
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + "\t" + name + "\t" + phone + "\t" + address);

		} else {
			System.out.println(">>>주소록 친구없다.");
		}
		rs.close();
		stmt.close();
		con.close();

	}

	public void selectAll() throws Exception {
		
		String selectSql = "select * from address";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		
		/*
		 이름      널?       유형            
		------- -------- ------------- 
		NO      NOT NULL NUMBER(10)    
		NAME    NOT NULL VARCHAR2(50)  
		PHONE   NOT NULL VARCHAR2(50)  
		ADDRESS          VARCHAR2(200) 
		*/
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			do {
				/* --------------------------------
				 * DB타입 		| 자바타입
				 * --------------------------------
				 * number		| int,double(float)
				 * varchar2,char| String
				 * Date			| Date
				 * --------------------------------
				 */
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(no + "\t" + name + "\t" + phone + "\t" + address);
			} while (rs.next());
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
