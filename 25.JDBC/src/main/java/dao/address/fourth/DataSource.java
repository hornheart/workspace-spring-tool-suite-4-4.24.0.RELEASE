package dao.address.fourth;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 데이타베이스 접속정보를 이용해서
 * Connection을 생성하고 해지하는역할을하는 클래스
 * [Dao객체들이사용하는 클래스]
 */
public class DataSource {
	/****데이타베이스 접속정보[124.198.47.195] 를저장할필드********/
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@124.198.47.195:1521:xe";
	private String user = "jdeveloper00";
	private String password = "jdeveloper00";
	/**************************************************************/
	/*
	 * 데이타베이스접속정보를 이용해서 Connection를 생성해서
	 * 반환하는 메쏘드
	 */
	public Connection getConnection() throws Exception{
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
	/*
	 * 사용한Connection객체를 close하는메쏘드
	 */
	public void close(Connection con) throws Exception{
		con.close();
	}
}
