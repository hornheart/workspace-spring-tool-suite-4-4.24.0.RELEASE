package dao.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.common.DataSource;



public class AddressDao {
	/*
	 * DataSource 객체를 멤버필드로가짐
	 * (Connection을 생성하고 해지하는객체)
	 */
	private DataSource dataSource;

	public AddressDao() throws Exception{
		this.dataSource = new DataSource();
	}
	
	public int insert(Address address) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_INSRET);
		pstmt.setString(1,address.getName());
		pstmt.setString(2,address.getPhone());
		pstmt.setString(3,address.getAddress());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int deleteByNo(int no) throws Exception {
		
		Connection con = dataSource.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_DELETE_BY_NO);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int updateByNo(Address address) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_UPDATE);
		pstmt.setString(1,address.getName());
		pstmt.setString(2,address.getName());
		pstmt.setString(3,address.getName());
		pstmt.setInt(4,address.getNo());
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public Address selectByNo(int no) throws Exception {
		
		Address finAddress = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_BY_NO);
		pstmt.setInt(1,no);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			int number = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			finAddress = new Address(number, name, phone, address);
		} else {
			finAddress = null;
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return finAddress;
	}

	public List<Address> selectAll() throws Exception {

		
		List<Address> addressList = new ArrayList<Address>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_ALL);

		ResultSet rs = pstmt.executeQuery();
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
		pstmt.close();
		dataSource.close(con);
		return addressList;
	}
}
