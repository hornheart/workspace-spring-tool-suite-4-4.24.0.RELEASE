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
	
@Select	("select * from guest order by guest_date desc")
public List<Guest> findByAll();
	
@Select("select * from guest where guest_no=#{guestNo}")
public Guest findByGuestNo(Integer guestNo);


@Delete("delete from guest where guest_no=#{guestNo}")
public int delete(Integer guestNo);

@Update("update guest set guest_name=#{guestName},guest_email=#{guestEmail},\r\n"
		+ "							 guest_homepage=#{guestHomepage},guest_title=#{guestTitle},\r\n"
		+ "							 guest_content=#{guestContent}\r\n"
		+ "			where guest_no=#{guestNo}")
public int update(Guest guest);


/*
 * @ResultType(Guest.class)
 * 
 * @Select("insert into guest \r\n" +
 * "			values( #{guestNo},#{guestName},\r\n" +
 * "					sysdate,#{guestEmail},#{guestHomepage},\r\n" +
 * "					#{guestTitle},#{guestContent})")
 */
@SelectKey(before=true,
		   resultType = Integer.class,
		   statement = "Select guest_guest_no_seq.nextval from dual",
		   keyProperty="guestNo")
@Insert("insert into guest values( #{guestNo},#{guestName},	sysdate,#{guestEmail},#{guestHomepage},	#{guestTitle},#{guestContent})")
public int insert(Guest guest);
}