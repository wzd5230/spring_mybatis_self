package cn.wzd.test.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import cn.wzd.mybatis.po.User;
import cn.wzd.mybatis.dao.UserDAO;
import cn.wzd.mybatis.dao.impl.UserDAOImpl;

public class TestDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testDaoFindUserById() throws Exception{
		
		UserDAO dao = new UserDAOImpl(this.sqlSessionFactory);
		
		User user = dao.findUserById(4);
		
		System.out.println(user);
				
	}

}
