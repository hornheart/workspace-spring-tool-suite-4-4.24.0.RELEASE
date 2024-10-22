package com.itwill.guest;

import java.util.List;

public interface GuestService {
	List<Guest> guestList() throws Exception;
	Guest guestDetail(Integer guestNo) throws Exception;
}
