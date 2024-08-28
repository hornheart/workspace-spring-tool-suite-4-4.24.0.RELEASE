package com.itwill.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itwill.common.DataSource;

/*
 * Dao(Data[DataBase] Access Object)객체
 * 		- member(회원) 데이타를 저장하고있는 테이블에
 *        CRUD(Create,Read,Update,Delete)작업을 할수있는 
 *        단위메쏘드를 가지고있는 클래스
 */
public class MemberDao {

	/*
	 * Dao 객체는멤버변수로 Connection을 생성하는 DataSource객체를 가짐
	 */
	private DataSource dataSource;
	public MemberDao()  throws Exception{
		dataSource=new DataSource();
	}
	
	
	public int insert(Member newMember) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_INSERT);
		pstmt.setString(1,newMember.getMemberId());
		pstmt.setString(2,newMember.getMemberPassword());
		pstmt.setString(3,newMember.getMemberName());
		pstmt.setString(4,newMember.getMemberAddress());
		pstmt.setInt(5, newMember.getMemberAge());
		pstmt.setString(6, newMember.getMemberMarried());
		int insertRowCount=pstmt.executeUpdate();
		return insertRowCount;
	}
	public int update(Member updateMember)throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_UPDATE);
		pstmt.setString(1, updateMember.getMemberPassword());
		pstmt.setString(2, updateMember.getMemberName());
		pstmt.setString(3, updateMember.getMemberAddress());
		pstmt.setInt(4, updateMember.getMemberAge());
		pstmt.setString(5, updateMember.getMemberMarried());
		//pstmt.setDate(6,new  java.sql.Date(updateMember.getmember_regdate().getTime()));
		pstmt.setString(6, updateMember.getMemberId());
		int updateRowCount = pstmt.executeUpdate();
		return updateRowCount;
	}
	public int delete(String member_id) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_DELETE);
		pstmt.setString(1, member_id);
		int deleteRowCount=pstmt.executeUpdate();
		return deleteRowCount;
	}
	public Member findByMemberId(String member_id)throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_SELECT_BY_ID);
		pstmt.setString(1,member_id);
		ResultSet rs=pstmt.executeQuery();
		
		Member findMember=null;
		if(rs.next()) {
			findMember=new Member( 
						rs.getString("member_id"),
						rs.getString("member_password"),
						rs.getString("member_name"),
						rs.getString("member_address"),
						rs.getInt("member_age"),
						rs.getString("member_married"),
						rs.getDate("member_regdate"));
		}
		return findMember;
	}
	public ArrayList<Member> findAll() throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(MemberSQL.MEMBER_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		ArrayList<Member> memberList=new ArrayList<Member>();
		while(rs.next()) {
			memberList.add(new Member(
						rs.getString("member_id"),
						rs.getString("member_password"),
						rs.getString("member_name"),
						rs.getString("member_address"),
						rs.getInt("member_age"),
						rs.getString("member_married"),
						rs.getDate("member_regdate"))
					 );
		}
		return memberList;
	}
}

















