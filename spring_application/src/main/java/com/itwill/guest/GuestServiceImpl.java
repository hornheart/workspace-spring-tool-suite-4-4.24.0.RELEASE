package com.itwill.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component("guestService")
public class GuestServiceImpl implements GuestService{
	
	private GuestDao guestDao;
	
	public GuestServiceImpl() {
		System.out.println("#### GuestServiceImpl() 기본생성자");
	}
	
    //setter method
	@Autowired
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("#### GuestServiceImpl.setGuestDao("+guestDao+") 메쏘드호출");
		this.guestDao = guestDao;
	}


	@Override
	public List<Guest> guestList() throws Exception {
		System.out.println("#### GuestSeriveImpl.selectAll()메쏘드호출");
		return guestDao.selectAll();
	}

	@Override
	public Guest guestDetail(Integer guestNo) throws Exception {
		System.out.println("#### GuestSeriveImpl.selectByNo("+guestNo+")메쏘드호출");
		return guestDao.selectByNo(guestNo);
	}

}