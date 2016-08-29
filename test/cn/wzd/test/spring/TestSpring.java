package cn.wzd.test.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wzd.spring.po.Person;

public class TestSpring {
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testSpringIOCAnnotation(){
		String configLocation = "classpath:ApplicationContext.xml";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		
		Person person =  (Person)ctx.getBean("person");
		
		System.out.println(person.getStudy());
		
	}

}
