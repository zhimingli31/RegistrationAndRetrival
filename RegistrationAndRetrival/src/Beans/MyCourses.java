package Beans;

import java.util.ArrayList;

public class MyCourses {
	private ArrayList<String> courseInfo;

	public MyCourses() {
		this.courseInfo = new ArrayList<String>();
	}

	public ArrayList<String> getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(ArrayList<String> courseInfo) {
		this.courseInfo = courseInfo;
	}
	
}
