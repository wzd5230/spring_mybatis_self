package cn.wzd.spring.po;

import org.springframework.stereotype.Component;

//@Component("study")
public class Study {
	private String schoolName;
	private String grage;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getGrage() {
		return grage;
	}
	public void setGrage(String grage) {
		this.grage = grage;
	}
	
	@Override
	public String toString() {
		return "Study [schoolName=" + schoolName + ", grage=" + grage + "]";
	}
	
	
	

}
