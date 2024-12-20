package com.itwill.hornist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HornistServiceImpl implements HornistService{
	@Autowired
	private HornistDao hornistDao;

	@Override
	public List<Hornist> hornist_list() throws Exception{
		return hornistDao.findByAll();
	}
	
	@Override
	public Hornist hornistDetail(int no) throws Exception{
		return hornistDao.findByHornistNo(no);//번호로 1개보기
	}
	 
	@Override
	public Hornist findByHornistWeather(String weather) throws Exception{
		return hornistDao.findByHornistWeather(weather);
	}
	
}
