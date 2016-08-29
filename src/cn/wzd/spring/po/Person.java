package cn.wzd.spring.po;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("person")
public class Person {
	private String name;
	private int age;
	private String sex;
	
	@Resource(name="fuckStudy",type=Study.class)
	private Study study;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", study=" + study + "]";
	}
	
	

}
