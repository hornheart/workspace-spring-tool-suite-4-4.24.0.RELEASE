package com.itwill.hornist.mapper;

import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.hornist.Hornist;
@Mapper
public interface HornistMapper {
	/*
	@SelectKey(before = true, resultType = Integer.class,keyProperty = "guestNo" ,statement ="select guest_guest_no_seq.nextval from dual")
	@Insert("insert into guest(guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content)  values(#{guestNo},#{guestName},sysdate,#{guestEmail},#{guestHomepage},#{guestTitle},#{guestContent})")
	int insert(Hornist guest) throws Exception;
	
	@Update("update guest set guest_name=#{guestName},guest_email=#{guestEmail},guest_homepage=#{guestHomepage},guest_title=#{guestTitle},guest_content=#{guestContent} where guest_no=#{guestNo}")
	int update(Hornist guest) throws Exception;
	
	@Delete("delete from guest where guest_no=#{guestNo}")
	int delete(@Param("guestNo") int guestNo) throws Exception;
	
	@Select("select * from guest where guest_no=#{guestNo}")
	Hornist findByGuestNo(int guestNo) throws Exception;
	*/
	@ResultType(Hornist.class)
	@Select("select * from hornist")
	List<Hornist> findByAll() throws Exception;
	
	@Select("select * from hornist 	WHERE no=#{no}")
	Hornist findByHornistNo(int no) throws Exception;
	
	@Select("select * from hornist 	WHERE weather=#{weather}")
	Hornist findByHornistWeather(String weather) throws Exception;
	
	
	
}
