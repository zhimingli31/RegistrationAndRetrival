package Validation;

import Beans.MyCourses;
import DBUtils.DButil;

public class CourseSimpleMap implements CourseLookUpService{

	@Override
	public MyCourses getCourses(String ssn) {
		MyCourses bean = new MyCourses();
		
		
		DButil db = new DButil();
		
		bean = db.validateCourse(ssn);
		db.closeConn();
		return (bean);
	}

}
