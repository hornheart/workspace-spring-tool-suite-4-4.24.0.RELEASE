package com.itwill.shop.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.common.DataSource;
import com.itwill.shop.user.User;

public class OrderDao {
	private DataSource dataSource;
	public OrderDao() throws Exception{
		dataSource=new DataSource();
	}
	/*
	 * 주문전체리스트(특정사용자)
	 */
	public List<Order> findOrderWithOrderItemByUserId(String sUserId) throws Exception{
		List<Order> orderList=new ArrayList<Order>();
		
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		try {
			con=dataSource.getConnection();
			/*
			    select * from orders where userid=?
			 	--------------------------------------------------
			  	O_NO	O_DESC		O_DATE		O_PRICE		USERID            
                --------------------------------------------------
			 	 1		비글외1종	2024/08/28	950000		guard1
				 2		비글외1종	2024/08/28	950000		guard1
			 */
			pstmt1=con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
			pstmt1.setString(1, sUserId);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()) {
				Order order=Order.builder()
								.o_no(rs1.getInt("o_no"))
								.o_desc(rs1.getString("o_desc"))
								.o_date(rs1.getDate("o_date"))
								.o_price(rs1.getInt("o_price"))
								.user(User.builder()
										.userId(rs1.getString("userid"))
										.build())
								.build();
				orderList.add(order);
			}
			
			/*
			 <<select * from orders o join order_item oi on o.o_no=oi.o_no join product p on oi.p_no=p.p_no where o.o_no=1;>>
			*/
			pstmt2=con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_ORDERITEM_BY_O_NO);
			for(Order order:orderList) {
				pstmt2.setInt(1, order.getO_no());
				rs2=pstmt2.executeQuery();
				/*
				  O_NO 	O_DESC 		O_DATE 		O_PRICE     USERID OI_NO OI_QTY O_NO P_NO P_NAME 	P_PRICE P_IMAGE 	P_DESC 
			 	---------- --------------------------------------------------------------------------------------------------------------- 
			 		1 	비글외2마리 2023/01/06 	1550000 	guard2   1    	1     1    1   비글 	550000 	bigle.png 	기타 상세 정보 등... 0 
			 		1 	비글외2마리 2023/01/06 	1550000 	guard2   2    	3     1    2   달마시안 500000 	dalma.jpg 	기타 상세 정보 등... 0
			 		1 	비글외2마리 2023/01/06 	1550000 	guard2   2    	2     1    2   달마시안 500000 	dalma.jpg 	기타 상세 정보 등... 0
				 */
				Order orderWithOrderItem=null;
				if(rs2.next()) {
					orderWithOrderItem=Order.builder()
									.o_no(rs2.getInt("o_no"))
									.o_desc(rs2.getString("o_desc"))
									.o_date(rs2.getDate("o_date"))
									.o_price(rs2.getInt("o_price"))
									.user(User.builder().userId(rs2.getString("userid")).build())
									.build();
					do {
						orderWithOrderItem.getOrderItems()
						.add(OrderItem.builder()
								
								.build());
						
					}while(rs2.next());
					
					
				}
			}
			
			
		}finally {
			if(con!=null)
				dataSource.close(con);
		}
		return orderList;
	}
	
	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	public int deleteByUserId(String sUserId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
		return rowCount;
	}
	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	public int deleteByOrderNo(int o_no) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_O_NO);
			pstmt.setInt(1, o_no);
			rowCount = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
		return rowCount;
	}

	/*
	 CART 에서 주문생성
	 */
	
	public int insert(Order order) throws Exception{
		/*
		insert into orders(o_no,o_desc,o_date,o_price,userid) values(orders_o_no_SEQ.nextval,'비글외7종',sysdate,5000000,'guard3');
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,5);
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,6);
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,7);
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,8);
		 */
		
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(OrderSQL.ORDER_INSERT);
			pstmt1.setString(1,order.getO_desc());
			pstmt1.setInt(2,order.getO_price());
			pstmt1.setString(3,order.getUser().getUserId());
			pstmt1.executeUpdate();
			
			for(OrderItem orderItem : order.getOrderItems()) {
				pstmt2=con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)
				dataSource.close(con);
		}
		return 0;
	}
}