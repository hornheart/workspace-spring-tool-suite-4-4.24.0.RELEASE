package com.itwill.guest.mapper;

import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.guest.Guest;

public interface GuestMapper {
	
	@ResultType(Guest.class)
	@Select("select * from guest order by guest_date desc")
	public List<Guest> findByAll();
	
	@ResultType(Guest.class)
	@Select("select * from guest where guest_no=#{guestNo}")
	public Guest findByGuestNo(int guestNo);
	
	@SelectKey( before = true,
				resultType = Integer.class,
				statement = "select guest_guest_no_seq.nextval from dual",
				keyProperty ="guestNo"
				)
	@Insert("insert into guest values( #{guestNo},#{guestName},sysdate,#{guestEmail},#{guestHomepage},#{guestTitle},#{guestContent})")
	public int insert(Guest guest);
	
	
	public int delete(int guestNo);
	public int update(Guest guest);
	
	
}
