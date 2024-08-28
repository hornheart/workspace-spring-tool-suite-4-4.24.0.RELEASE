package com.itwill.shop.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.common.DataSource;
import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

public class CartDao {
	private DataSource dataSource;
	public CartDao() throws Exception{
		dataSource=new DataSource();
	}
	/*
	cart list
	*/
	/*
	 * 
	 */
	public int deleteByUserId(String sUserId) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	
	
	public List<Cart> findByUserId(String userid)throws Exception{
		List<Cart> cartList=new ArrayList<Cart>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_SELECT_BY_USERID);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			/*
			/*
			select c.*,p.* from cart c join product p on c.p_no=p.p_no where userid='guard1'
			
			CART_NO   CART_QTY  USERID    	P_NO 	P_NAME      P_PRICE    	P_IMAGE          P_DESC                                                                                                P_DESC                                                                                                                                                                                                   P_CLICK_COUNT
			---------- ---------- --------------------------------------------------------------------------
			   	34			1	guard1		5		포메라니안	800000		pomeranian.jpg	 기타 상세 정보 등...	
				35			1	guard1		8		사모예드	800000		samoyed.jpg		 기타 상세 정보 등...	0
				36			1	guard1		6		샤페이		700000		shaipei.jpg	  	 기타 상세 정보 등...	0
			*/   
			while(rs.next()) {
				cartList.add(Cart.builder()
							.cart_no(rs.getInt("cart_no"))
							.cart_qty(rs.getInt("cart_qty"))
							.user(User.builder().
								  userId(rs.getString("userid"))
								  .build())
							.product(Product.builder()
									.p_no(rs.getInt("p_no"))
									.p_name(rs.getString("p_name"))
									.p_price(rs.getInt("p_price"))
									.p_image(rs.getString("p_image"))
									.p_desc(rs.getString("p_desc"))
									.build())
							.build());
			}
			
		}finally {
			/* 항상실행하는 블록*/
			if(con!=null) {
				dataSource.close(con);
			}
		}
		
		 return cartList;
		
	}
	
	
	/*
	 * cart제품 존재여부
	 */
	public int  countByProductNo(String sUserId,int p_no) throws Exception{
		int count=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_COUNT_BY_USERID_PRODUCT_NO);
			pstmt.setString(1, sUserId);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return count;
	}
	public int updateByProductNo(Cart cart)throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO_USERID);
			pstmt.setInt(1, cart.getCart_qty());
			pstmt.setString(2, cart.getUser().getUserId());
			pstmt.setInt(3, cart.getProduct().getP_no());
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	public int updateByCartNo(Cart cart)throws Exception{
		return 0;
	}
	
	
	
	public int insert(Cart cart)throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int insertRowCount=0;
		try {
			
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_INSERT);
			pstmt.setInt(1, cart.getCart_qty());
			pstmt.setInt(2, cart.getProduct().getP_no());
			pstmt.setString(3, cart.getUser().getUserId());
			insertRowCount = pstmt.executeUpdate();
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return insertRowCount;
	}
	/*
	public int insert(String sUserId,int p_no,int cart_qty )throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int insertRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_INSERT);
			pstmt.setInt(1, cart_qty);
			pstmt.setInt(2, p_no);
			pstmt.setString(3,sUserId);
			insertRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return insertRowCount;
	}
	*/
	
	
}