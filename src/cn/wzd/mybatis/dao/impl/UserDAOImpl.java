package cn.wzd.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.wzd.mybatis.po.User;
import cn.wzd.mybatis.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	//
	public UserDAOImpl(SqlSessionFactory factory) {
		this.sqlSessionFactory = factory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		User user = session.selectOne("cn.wzd.mybatis.mapper.findUserById", id);
		
		session.close();
		
		return user;
	}

}
