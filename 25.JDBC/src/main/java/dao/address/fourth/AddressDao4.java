package dao.address.fourth;
/*
Dao(Data Access Object)클래스
  - address 테이블에 CRUD(Create,Read,Update,Delete) 작업을하는 
    단위메쏘드를 가지고있는 클래스
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDao4 {
	/*
	 * DataSource객체를 멤버필드로가짐
	 * (Connection을 생성하고 해지하는객체)
	 */
	private DataSource dataSource;
	
	public AddressDao4() {
		this.dataSource=new DataSource();
	}

	public int insert(Address address) throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval,'"+address.getName()+"','"+address.getPhone()+"','"+address.getAddress()+"')";
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int deleteByNo(int no) throws Exception {
		String deleteSql = "delete from address where no="+no;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(deleteSql);
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}


    public int updateByNo(Address address) throws Exception {
		String updateSql = 
				"update address set name='"+address.getName()+"',phone='"+address.getPhone()+"',address='"+address.getAddress()+"' where no="+address.getNo();
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		stmt.close();
		dataSource.close(con);
		return rowCount;
	}
	public Address selectByNo(int no) throws Exception {
		String selectSql = "select * from address where no="+no;
		Address finAddress=null;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			int number = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			finAddress=new Address(number, name, phone, address);
		} else {
			finAddress=null;
		}
		rs.close();
		stmt.close();
		dataSource.close(con);
		return finAddress;
	}

	public List<Address> selectAll() throws Exception {
		
		String selectSql = "select * from address";
		List<Address> addressList=new ArrayList<Address>();
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		
		
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			do {
		
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				addressList.add(new Address(no, name, phone, address));
			} while (rs.next());
		}
		rs.close();
		stmt.close();
		dataSource.close(con);
		return addressList;
	}
}
