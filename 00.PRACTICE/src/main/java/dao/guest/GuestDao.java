package dao.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DataSource;

public class GuestDao {

	private DataSource dataSource;
	
	public GuestDao() throws Exception{
		this.dataSource = new DataSource();
	}
	
public int insert(Guest guest) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		//pstmt.setInt(1,guest.getGuest_no());
		pstmt.setString(1,guest.getGuest_name());
		//pstmt.setDate(3,new java.sql.Date(guest.getGuest_date().getTime()));
		pstmt.setString(2,guest.getGuest_email());
		pstmt.setString(3,guest.getGuest_homepage());
		pstmt.setString(4,guest.getGuest_title());
		pstmt.setString(5,guest.getGuest_content());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
public int updateByNo(Guest guest) throws Exception {
	
	Connection con = dataSource.getConnection();
	PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
	pstmt.setString(1,guest.getGuest_name());
	int rowCount = pstmt.executeUpdate();
	pstmt.close();
	dataSource.close(con);
	return rowCount;
}

public int deleteByNo(int no) throws Exception {
	
	Connection con = dataSource.getConnection();
	
	PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE_BY_NO);
	pstmt.setInt(1, no);
	int rowCount = pstmt.executeUpdate();
	
	pstmt.close();
	dataSource.close(con);
	return rowCount;
}
	
	
}