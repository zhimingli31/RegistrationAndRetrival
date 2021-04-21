package Validation;

import DBUtils.DButil;
import Beans.Student;

public class StudentSimpleMap implements studentLookUp{

	public StudentSimpleMap() {
		
	}
	
	public Student findStudent(String ssn){
		
		Student bean = new Student();
		
		
		DButil db = new DButil();
		
		bean = db.validateSSN(ssn);
		db.closeConn();
		
		
		
		
		return(bean);
	}
	

}
