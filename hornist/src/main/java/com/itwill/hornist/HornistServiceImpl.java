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
		// TODO Auto-generated method stub
		return hornistDao.findByAll();
	}
	
//	@Override
//	public 
}
