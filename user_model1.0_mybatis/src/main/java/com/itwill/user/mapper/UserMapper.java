package com.itwill.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.user.User;

public interface UserMapper {
/*
	@ResultType(com.itwill.user.User.class)
	@Select("select userid,password,name,email from userinfo")
	public List<User> findUserList(); 
	
	@ResultType(com.itwill.user.User.class)
	@Select("select userid,password,name,email from userinfo where userid=#{userId}")
	public User findUser(String userId);
	
	@ResultType(com.itwill.user.User.class)
	@Select("delete userinfo where userid=#{userId}")
	public int delete(String userId);
	
	@ResultType(com.itwill.user.User.class)
	@Select("update  userinfo set password=#{password},name=#{name},email=#{email} "
			+ "where userid=#{userId}")
	public int update(User user);
	
	@ResultType(com.itwill.user.User.class)
	@Select("insert into userinfo(userid,password,name,email) "
			+ "values(#{userId},"
			+ "#{password},"
			+ "#{name},"
			+ "#{email})")
	public int insert(User user);
	
	@ResultType(com.itwill.user.User.class)
	@Select("select count(*) cnt from userinfo where userid=#{userId}")
	public int countByUserId(String userId);
*/
	@Insert("insert into userinfo(userid,password,name,email) values(#{userId},#{password},#{name},#{email})")
	int insert(User user) throws Exception;

	/*
	 * 기존의 사용자정보를 수정
	 */
	@Update("update  userinfo set password=#{password},name=#{name},email=#{email} where userid=#{userId}")
	int update(User user) throws Exception;

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	@Delete("delete userinfo where userid=#{userId}")
	int delete(String userId) throws Exception;

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	@Select("select userid,password,name,email from userinfo where userid=#{userId}")
	User findUser(String userId) throws Exception;

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	@Select("select userid,password,name,email from userinfo")
	List<User> findUserList() throws Exception;

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	@Select("select count(*) cnt from userinfo where userid=#{userId}")
	int countByUserId(String userId) throws Exception;
	
}
