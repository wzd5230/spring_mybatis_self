package cn.wzd.test.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.wzd.mybatis.mapper.UserMapper;
import cn.wzd.mybatis.po.User;

public class TestMapper {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testMapperFindUserById() throws Exception{
		SqlSession session = this.sqlSessionFactory.openSession();
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = userMapper.findUserByIdMapper(4);
		
		System.out.println(user);
		
		session.close();
	}
	
	@Test
	public void testMapperFindUserById_2Cache() throws Exception{
		SqlSession session = this.sqlSessionFactory.openSession();
		SqlSession session1 = this.sqlSessionFactory.openSession();
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserMapper userMapper1 = session1.getMapper(UserMapper.class);
		
		User user = userMapper.findUserByIdMapper(4);
		
		System.out.println(user);
		
		session.close();

	
		User user1 = userMapper1.findUserByIdMapper(4);
		System.out.println(user1);
		session1.close();
	
	
	
	}

}
