package com.itwill.user;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.user.mapper.UserMapper;


public class UserDaoImplMyBatisInterface implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImplMyBatisInterface() throws Exception {
		this.sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		
		sqlSession.close();
	}

	@Override
	public int update(User user) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		System.out.println("#### UserDaoImplMyBatis : update() 호출  "+sqlSession);
		int rowCount=sqlSession.getMapper(UserMapper.class).update(user);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public User findUser(String userId) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		System.out.println("#### UserDaoImplMyBatis : findUser() 호출  ");
		User user=(User) sqlSession.getMapper(UserMapper.class).findUser(userId);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUserList() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		System.out.println("#### UserDaoImplMyBatis : findUserList 호출  "+sqlSession);
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List userList=userMapper.findUserList();
//		List<User> userList=sqlSession.getMapper(UserMapper.class).findUserList();
		sqlSession.close();
		return userList;
	}

	@Override
	public int insert(User user) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		System.out.println("#### UserDaoImplMyBatis : insert() 호출  "+sqlSession);
		int rowCount=sqlSession.getMapper(UserMapper.class).insert(user);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int delete(String userId) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		System.out.println("#### UserDaoImplMyBatis : delete() 호출  "+sqlSession);
		int rowCount=sqlSession.getMapper(UserMapper.class).delete(userId);
		sqlSession.close();
		return rowCount;
	}

	@Override
	public int countByUserId(String userId) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		System.out.println("#### UserDaoImplMyBatis : countByUserId 호출  "+sqlSession);
		int rowCount=sqlSession.getMapper(UserMapper.class).countByUserId(userId);
		sqlSession.close();
		return rowCount;
	}

}