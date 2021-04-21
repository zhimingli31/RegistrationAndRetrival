package Validation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.MyCourses;
import Beans.Student;

@WebServlet("/validateLogin")
public class validateLogin extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String ssn = request.getParameter("ssn");
		
		studentLookUp studentLookup = new StudentSimpleMap();
		Student student = studentLookup.findStudent(ssn);
		request.setAttribute("student", student);
		
		CourseLookUpService courseLookup = new CourseSimpleMap();
		MyCourses course = courseLookup.getCourses(ssn);
		request.setAttribute("course", course);
		
		String address;
		
		if(student.getSsn().trim() != "") {
			address = "/WEB-INF/MyRegistration.jsp";
		} else {
			request.setAttribute("badSSN", ssn);
			address = "/WEB-INF/StudentNotFound.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
