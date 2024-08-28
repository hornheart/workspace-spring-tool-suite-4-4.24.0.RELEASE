package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception {
		/******* 데이타베이스접속정보[localhost]*********** 
		String driverClass="oracle.jdbc.OracleDriver"; 		 
 		String url="jdbc:oracle:thin:@localhost:1521:xe"; 
 		String user="scott"; 
 		String password="tiger";
		***********************************************/
		
		/******* 데이타베이스접속정보[124.198.47.195] ***********/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
		String user = "jdeveloper00";
		String password = "jdeveloper00";
		/***********************************************/
		String selectSql = "select deptno,dname,loc from dept";
		/*
		 * 1.Driver class loading
		 *   A.Driver class객체생성
		 *   B.DriverManager클래스에 드라이버객체등록
		 */
		Class.forName(driverClass);
		System.out.println("1.Driver class loading");

		/*
		 * 2.Connection객체생성
		 *   - DB Server와의 연결객체
		 */
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.Connection객체생성:" + con);

		/*
		 * 3. Statement객체생성
		 *   - SQL문전송객체
		 */
		Statement stmt = con.createStatement();
		System.out.println("3.Statement객체생성:" + stmt);

		/*
		 * 4. SQL문전송(select)
		 * 5. ResultSet객체얻기(select)
		 * 
		 	<<ResultSet객체>>
		 	 ----------------------------
		 	 DEPTNO  DNAME  	 LOC      
		 	 ----------------------------
  (cursor) ->BEFORE FIRST 영역	
		 	 10		ACCOUNTING	NEW YORK
			 20		RESEARCH	DALLAS
			 30		SALES		CHICAGO
			 40		OPERATIONS	BOSTON
			 AFTER LAST 영역	
		 */
		ResultSet rs = stmt.executeQuery(selectSql);
		System.out.println("4,5.SQL전송&ResultSet객체얻기(select문실행결과):" + rs);
		while (rs.next()) {
			int deptno = rs.getInt("DEPTNO");
			String dname = rs.getString("DNAME");
			String loc = rs.getString("LOC");
			System.out.println(deptno + "\t" + dname + "\t" + loc);
		}
		/*
		 * 6.연결객체(resource)해지 close
		 */
		System.out.println("6.연결객체(resource)해지 close");
		rs.close();
		stmt.close();
		con.close();
	}

}
