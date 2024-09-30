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
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int guestMapper=sqlSession.getMapper(GuestMapper.class).insert(guest);
		sqlSession.close();
		return guestMapper;
	}

	@Override
	public int update(Guest guest) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int updateRowCount=sqlSession.getMapper(GuestMapper.class).update(guest);
		sqlSession.close();
		return updateRowCount;
	}

	@Override
	public int delete(int guestNo) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=sqlSession.getMapper(GuestMapper.class).delete(guestNo);
		sqlSession.close();
		return deleteRowCount;
	}

	@Override
	public Guest findByGuestNo(int guestNo) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Guest guestMapper=sqlSession.getMapper(GuestMapper.class).findByGuestNo(guestNo);
		sqlSession.close();
		return guestMapper;
	}

	@Override
	public List findByAll() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
//		List<Guest> guestList=sqlSession.getMapper(GuestMapper.class).findByAll();
		GuestMapper guestMapper=sqlSession.getMapper(GuestMapper.class);
		List guestList=guestMapper.findByAll(); 
		sqlSession.close();
		return guestList;
	}

}