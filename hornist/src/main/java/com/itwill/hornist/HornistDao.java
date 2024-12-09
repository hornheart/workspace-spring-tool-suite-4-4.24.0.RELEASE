package com.itwill.hornist;

import java.util.List;

public interface HornistDao {
	/*
	int insert(Hornist guest) throws Exception;

	int update(Hornist guest) throws Exception;

	int delete(int guestNo) throws Exception;

	*/
	List<Hornist> findByAll() throws Exception;

	Hornist findByHornistNo(int no) throws Exception;
	
	Hornist findByHornistWeather(String weather) throws Exception;
	
}