package com.itwill.hornist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.hornist.mapper.HornistMapper;

@Repository
public class HornistDaoImplMyBatis implements HornistDao {
	@Autowired
	private HornistMapper hornistMapper;

	@Override
	public List<Hornist> findByAll() throws Exception {
		return hornistMapper.findByAll();
	}

	@Override
	public Hornist findByHornistNo(int no) throws Exception {
		return  hornistMapper.findByHornistNo(no);
	}
	
	@Override
	public Hornist findByHornistWeather(String weather) throws Exception {
		return  hornistMapper.findByHornistWeather(weather);
	}
	
	/*
	@Override
	public int insert(Hornist guest) throws Exception {
		guestMapper.insert(guest);
		return guest.getGuestNo();
	}

	@Override
	public int update(Hornist guest) throws Exception {
		return guestMapper.update(guest);

	}

	@Override
	public int delete(int guestNo) throws Exception {
		return guestMapper.delete(guestNo);
	}


	
	*/
}
