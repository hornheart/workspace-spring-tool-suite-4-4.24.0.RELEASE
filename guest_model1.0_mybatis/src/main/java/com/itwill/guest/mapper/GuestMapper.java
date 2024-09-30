package com.itwill.guest.mapper;

import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.guest.Guest;

public interface GuestMapper {
	
@ResultType(Guest.class)	
@Select	("select * from guest order by guest_date desc")
public List<Guest> findByAll();
	
@ResultType(Guest.class)
@Select("select * from guest where guest_no=#{guestNo}")
public Guest findByGuestNo(Integer guestNo);

@ResultType(Guest.class)
@Select("delete from guest where guest_no=#{guestNo}")
public int delete(Integer guestNo);

@ResultType(Guest.class)
@Select("update guest set guest_name=#{guestName},guest_email=#{guestEmail},\r\n"
		+ "							 guest_homepage=#{guestHomepage},guest_title=#{guestTitle},\r\n"
		+ "							 guest_content=#{guestContent}\r\n"
		+ "			where guest_no=#{guestNo}")
public int update(Guest guest);


@ResultType(Guest.class)
@Select("insert into guest \r\n"
		+ "			values( #{guestNo},#{guestName},\r\n"
		+ "					sysdate,#{guestEmail},#{guestHomepage},\r\n"
		+ "					#{guestTitle},#{guestContent})")
public int insert(Guest guest);
}