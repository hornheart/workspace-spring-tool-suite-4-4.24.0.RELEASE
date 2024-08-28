package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.common.DataSource;

public class AccountService {
	private DataSource dataSource;

	public AccountService() throws Exception {
		dataSource = new DataSource();
	}

	/*
	 * 모든계좌의 잔고를 balance만큼 갱신
	 */
	public void updateBalance(int balance) throws Exception {
		boolean exceptionCondition = true;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String updateSql = "update accounta set acc_balance=acc_balance + ? where acc_no=?";
			con = dataSource.getConnection();
			System.out.println("-------updateBalance transaction  start-------------");
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(updateSql);
			/********************** 1000번계좌 update *********************/
			int acc_no = 10000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			int rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌 " + rowCount + " 행 update");
			/********************** 2000번계좌 update *********************/
			acc_no = 20000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌 " + rowCount + " 행 update");
			/********************** 3000번계좌 update *********************/
			acc_no = 30000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌 " + rowCount + " 행 update");
	
			/** 예외발생 ***/
			int rn = (int) (Math.random() * 2);
			if (rn % 2 == 0) {
				exceptionCondition = true;
			} else {
				exceptionCondition = false;
			}
	
			if (exceptionCondition) {
				throw new Exception("모든계좌잔고갱신예외발생");
			}
			/********************** 4000번계좌 update *********************/
			acc_no = 40000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌 " + rowCount + " 행 update");
			/********************** 5000번계좌 update *********************/
			acc_no = 50000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌 " + rowCount + " 행 update");
			/********************** 6000번계좌 update *********************/
			acc_no = 60000;
			pstmt.setInt(1, balance);
			pstmt.setInt(2, acc_no);
			rowCount = pstmt.executeUpdate();
			System.out.println(acc_no + "번 계좌 " + rowCount + " 행 update");
			con.commit();
			System.out.println("-------updateBalance transaction  end[commit]-------------");
		}catch(Exception e) {
			System.err.println("99.예외발생:"+e.getMessage());
			System.out.println("---------updateBalance transaction  end[rollback]--------------");
			con.rollback();
		}
	}

}
