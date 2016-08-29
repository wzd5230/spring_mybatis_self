package cn.wzd.test.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wzd.spring.po.Person;

public class TestDbcp {
	
	@Test
	public void testDBCP() throws SQLException{
		String configLocation = "classpath:ApplicationContext.xml";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		
		BasicDataSource bds =  (BasicDataSource)ctx.getBean("dataSource");
		
	 	Connection conn = bds.getConnection();
	 	
	 	String sql="SELECT * FROM user WHERE sex=?";
	 	
	 	PreparedStatement ps = conn.prepareStatement(sql);
	 	
	 	//ps.setInt(1, 4);
	 	ps.setString(1, "b");
	 	
	 	ResultSet rs = ps.executeQuery();
	 	
	 	while(rs.next()){
	 		System.out.print(rs.getString("username")+" --- ");
	 		System.out.println(rs.getString("address"));
	 	}
	 	
	 	ps.close();
	 	conn.close();
		
	}

}






