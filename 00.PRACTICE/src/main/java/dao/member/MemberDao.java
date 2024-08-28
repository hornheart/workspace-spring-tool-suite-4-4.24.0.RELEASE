package dao.member;

import javax.sql.DataSource;

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
	/*
	Connection을 생성할수있는 DataSource객체를 멤버변수로 가진다.
	*/
	Member m=new Member();
	
	private DataSource dataSource;		
	
//	public void insert(MemberVO m){}
//	public MemberVO selectById(){}
//	public ArrayList<MemberVO> selectAll(){}
//	public void updateById(MemberVO m){}
	public void deleteById(String id){}
	
}
