package com.itwill.hornist;

import java.util.Date;
import java.util.List;

public interface HornistService {
	
	public List<Hornist> hornist_list() throws Exception;//전체보기
	
	Hornist hornistDetail(int no) throws Exception;//번호로 1개보기
	//Hornist findByHornistWeather(String weather) throws Exception;//날씨로 1개보기
	//Hornist findByHornistDate(Date regDate) throws Exception;//날짜로 1개보기
	
	
	
}
