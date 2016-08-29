package cn.wzd.test.mapper.lazy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.wzd.mybatis.mapper.UserMapper;
import cn.wzd.mybatis.po.User;

public class TestMapperLazy {
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
		
		List<User> users = userMapper.findUserAndOrdersResultMapper();
		
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()){
			User user = iterator.next();
			
			System.out.println(user.getUsername()+" "+user.getId());
			System.out.println("------");
			System.out.println(user.getOrdersList());
		}
		
		session.close();
	}

}
