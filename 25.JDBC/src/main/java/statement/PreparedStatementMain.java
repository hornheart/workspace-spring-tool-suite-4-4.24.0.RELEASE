package statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import dao.common.DataSource;

public class PreparedStatementMain {

	public static void main(String[] args) throws Exception{
		
		/*
		이름       널?       유형           
		-------- -------- ------------ 
		EMPNO    NOT NULL NUMBER(4)    
		ENAME             VARCHAR2(10) 
		JOB               VARCHAR2(9)  
		MGR               NUMBER(4)    
		HIREDATE          DATE         
		SAL               NUMBER(7,2)  
		COMM              NUMBER(7,2)  
		DEPTNO            NUMBER(2)  
		 */
		DataSource dataSource=new DataSource();
		Connection con=dataSource.getConnection();
		
		System.out.println("%%%%%%%%%%%%%%% [select] %%%%%%%%%%%%%%%%%%%");
		String selectSql="select empno,ename,job,sal,hiredate from emp where sal>=? and sal<=? and job=? or job=?";
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		
		int sal1=1000;
		int sal2=4000;
		String job1="SALESMAN";
		String job2="CLERK";
		
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int empno=rs.getInt("EMPNO");
			String ename=rs.getString("ENAME");
			String job=rs.getString("JOB");
			double sal=rs.getDouble("SAL");
			Date hireDate=	rs.getDate("HIREDATE");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+hireDate);
		}
		rs.close();
		
		System.out.println("------------------------------");
		sal1=2000;
		sal2=5000;
		job1="MANAGER";
		job2="ANALYST";
		
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);
		
		rs=pstmt.executeQuery();
		while(rs.next()) {
			int empno=rs.getInt("EMPNO");
			String ename=rs.getString("ENAME");
			String job=rs.getString("JOB");
			double sal=rs.getDouble("SAL");
			Date hireDate=	rs.getDate("HIREDATE");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+hireDate);
		}
		rs.close();
		pstmt.close();
		
		System.out.println("%%%%%%%%%%%%%%% [select] %%%%%%%%%%%%%%%%%%%");
		String deleteSql="delete from emp where empno=?";
		PreparedStatement pstmt2=con.prepareStatement(deleteSql);
		
		pstmt2.setInt(1, 9001);
		int deleteRowCount1=pstmt2.executeUpdate();
		System.out.println(">>>> delete 9001 -->"+ deleteRowCount1+" 행");
		
		pstmt2.setInt(1, 9002);
		int deleteRowCount2=pstmt2.executeUpdate();
		System.out.println(">>>> delete 9002 -->"+ deleteRowCount2+" 행");
		pstmt2.setInt(1, 9003);
		int deleteRowCount3=pstmt2.executeUpdate();
		System.out.println(">>>> delete 9003 -->"+ deleteRowCount3+" 행");
		
		System.out.println("%%%%%%%%%%%%%%% [insert] %%%%%%%%%%%%%%%%%%%");
		//String insertSql1="insert into emp values(9000,'JUNG', 'MANAGER',7369,to_date('2000/01/01','YYYY/MM/DD'),3000.34,30,40)";
		String insertSql1="insert into emp values(?,?,?,?,to_date(?,?),?,?,?)";
		PreparedStatement pstmt3=con.prepareStatement(insertSql1);
		pstmt3.setInt(1, 9001);
		pstmt3.setString(2, "김태희");
		pstmt3.setString(3, "CLERK");
		pstmt3.setInt(4, 7369);
		pstmt3.setString(5,"2002/01/10");
		pstmt3.setString(6,"YYYY/MM/DD");
		pstmt3.setDouble(7,5656.23);
		pstmt3.setInt(8,0);
		pstmt3.setInt(9,40);
		int insertRowCount1=pstmt3.executeUpdate();
		System.out.println(">> insert 9001 -->"+insertRowCount1+"행 insert");
		pstmt3.close();
		
		//String insertSql2="insert into emp values(9000,'JUNG', 'MANAGER',7369,<날짜데이타> ,3000.34,30,40)";
		String insertSql2="insert into emp values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt4=con.prepareStatement(insertSql2);
		pstmt4.setInt(1, 9002);
		pstmt4.setString(2, "김희애");
		pstmt4.setString(3, "MANAGER");
		pstmt4.setInt(4, 7369);
		pstmt4.setDate(5,new Date(new SimpleDateFormat("yyyy/MM/dd").parse("2022/05/04").getTime()));
		pstmt4.setDouble(6,8000);
		pstmt4.setInt(7,88);
		pstmt4.setInt(8,30);
		int insertRowCount2 = pstmt4.executeUpdate();
		System.out.println(">> insert 9002 -->"+insertRowCount2+ "행 insert");
		pstmt4.close();
		
		//String insertSql3="insert into emp values(9000,'JUNG', 'MANAGER',7369,sysdate ,3000.34,30,40)";
		String insertSql3="insert into emp values(?,?,?,?,sysdate,?,?,?)";
		PreparedStatement pstmt5=con.prepareStatement(insertSql3);
		
		pstmt5.setInt(1, 9003);
		pstmt5.setString(2, "이소담");
		pstmt5.setString(3, "SALESMAN");
		pstmt5.setInt(4, 7369);
		pstmt5.setDouble(5,3000);
		pstmt5.setInt(6,33);
		pstmt5.setInt(7,20);
		int insertRowCount3=pstmt5.executeUpdate();
		System.out.println(">> insert 9003 -->"+insertRowCount3+"행 insert");
		pstmt5.close();
		
		
		//String updateSql="update emp set sal=sal*1.1 where empno>=7369 and empno<=7600";
		String updateSql="update emp set sal=sal*? where empno>=? and empno<=?";
		PreparedStatement pstmt6=con.prepareStatement(updateSql);
		pstmt6.setDouble(1,1.1);
		pstmt6.setInt(2,9001);
		pstmt6.setInt(3,9003);
		int updateRowCount = pstmt6.executeUpdate();
		System.out.println(">> update --> "+updateRowCount+ "행 update");
		
		pstmt6.close();
		dataSource.close(con);
		
		
		
		
			
	}

}
