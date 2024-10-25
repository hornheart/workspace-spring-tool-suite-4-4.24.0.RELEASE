package com.itwill.user;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.user.mapper.UserMapper;
@Repository
public class UserDaoImplMyBatis implements UserDao {

	private final SqlSessionFactory sqlSessionFactory;

	@Autowired
    public UserDaoImplMyBatis(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : update() 호출  ");
		/*SqlSession sqlSession= sqlSessionFactory.openSession(true);
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int rowCount=userMapper.update(user);
		sqlSession.close();
		return rowCount;*/
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.update(user);
        }
	}

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUser() 호출  ");
		/*SqlSession sqlSession= sqlSessionFactory.openSession(true);
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.findUser(userId);
		sqlSession.close();
		return user;*/
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.findUser(userId);
        }
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUserList 호출  ");
		/*SqlSession sqlSession= sqlSessionFactory.openSession(true);
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> userList=userMapper.findUserList();
		sqlSession.close();
		return userList;*/
		return null;
	}

	@Override
	public int insert(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : insert() 호출  ");
		/*SqlSession sqlSession= sqlSessionFactory.openSession(true);
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int rowCount=userMapper.insert(user);
		sqlSession.close();
		return rowCount;*/
		return 0;
	}

	@Override
	public int delete(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : delete() 호출  ");
		/*SqlSession sqlSession= sqlSessionFactory.openSession(true);
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int rowCount=userMapper.delete(userId);
		sqlSession.close();
		return rowCount;*/
		return 0;
	}

	@Override
	public int countByUserId(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : countByUserId 호출  ");
		/*SqlSession sqlSession= sqlSessionFactory.openSession(true);
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int rowCount=userMapper.countByUserId(userId);
		sqlSession.close();
		return rowCount;*/
		return 0;
	}

}