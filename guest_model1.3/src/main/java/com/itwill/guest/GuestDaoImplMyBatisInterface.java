package com.itwill.guest;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatisInterface implements GuestDao{
	private SqlSessionFactory sqlSessionFactory;
	public GuestDaoImplMyBatisInterface() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config-interface.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Guest guest) throws Exception {
		SqlSession sqlSession =sqlSessionFactory.openSession(true);
		/************mapper interface사용안할시*************
		int insertRowCount=sqlSession.insert("com.itwill.guest.mapper.GuestMapper.insert", guest);
		****************************************************/
		/************mapper interface사용시*****************/
		GuestMapper guestMapper= 
				sqlSession.getMapper(GuestMapper.class);
		int insertRowCount=guestMapper.insert(guest);
		/*******************/
		sqlSession.close();
		return guest.getGuestNo();
	}

	@Override
	public int update(Guest guest) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int rowCount= guestMapper.update(guest);
		return rowCount;
	}

	@Override
	public int delete(int guestNo) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int rowCount= guestMapper.delete(guestNo);
		return rowCount;
	}
	@Override
	public Guest findByGuestNo(int guestNo) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		Guest guest= guestMapper.findByGuestNo(guestNo);
		return guest;
	}

	@Override
	public List<Guest> findByAll() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		List<Guest> guestList= guestMapper.findByAll();
		return guestList;
	}

}











