package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressTableSelectAllMain {

	public static void main(String[] args) throws Exception{
		/************데이타베이스 접속정보[124.198.47.195]*************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user="jdeveloper00";
		String password="jdeveloper00";
		/**************************************************************/
		String selectSql="select * from address";
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		/*
		ResultSet executeQuery(String sql) throws SQLException
			Executes the given SQL statement, which returns a single ResultSet object.

			Parameters:
				sql - an SQL statement to be sent to the database, 
				typically a static SQL SELECT statement
			Returns:
				a ResultSet object that contains the data produced 
				by the given query; never null
		 */
		/*
		 이름      널?       유형            
		------- -------- ------------- 
		NO      NOT NULL NUMBER(10)    
		NAME    NOT NULL VARCHAR2(50)  
		PHONE   NOT NULL VARCHAR2(50)  
		ADDRESS          VARCHAR2(200) 
		*/
		ResultSet rs=stmt.executeQuery(selectSql);
		if(rs.next()) {
			do {
				/* --------------------------------
				 * DB타입 		| 자바타입
				 * --------------------------------
				 * number		| int,double(float)
				 * varchar2,char| String
				 * Date			| Date
				 * --------------------------------
				 */
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				System.out.println(no+"\t"+name+"\t"+phone+"\t"+address);
			}while(rs.next());
		}
		rs.close();
		stmt.close();
		con.close();
		
	}

}












