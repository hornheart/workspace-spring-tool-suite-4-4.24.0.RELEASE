package com.itwill.guest;

import java.util.List;

public interface GuestDao {
	List<Guest> selectAll() throws Exception;
	Guest selectByNo(Integer guestNo) throws Exception;
	
}
