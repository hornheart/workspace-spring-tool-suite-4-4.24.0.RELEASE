package com.itwill.user.mapper;

import java.util.List;


import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.itwill.user.User;

public interface UserMapper {

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
}
