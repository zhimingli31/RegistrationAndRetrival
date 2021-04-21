package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Beans.MyCourses;
import Beans.Student;


public class DButil {
	private static Connection connection;
	private ResultSet resultSet;
	
	public void dbConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("JDBC Driver Loaded");
			connection = DriverManager.getConnection("jdbc:sqlserver://s16988308.onlinehome-server.com;databaseName=CUNY_DB;intergratedSecurity=false;" , "cst4713", "password1");
			System.out.println("Database Connected");
		} catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public ResultSet getQuery(String query) throws SQLException, ClassNotFoundException{
		try {
			dbConnection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		}catch(SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return resultSet;
	}
	
	public void updateValues(String table, String query) throws SQLException, ClassNotFoundException {
		try {
			dbConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch(SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}
	
	public Student validateSSN(String ssn) {
		
		String queryString = "select * from Students where ssn = ?";
		Student bean = new Student();
		try {
			dbConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, ssn);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				bean.setSsn(resultSet.getString(1));
				bean.setFirstName(resultSet.getString(2));
				bean.setMi(resultSet.getString(3));
				bean.setLastName(resultSet.getString(4));
				bean.setBirthDate(resultSet.getString(5));
				bean.setStreet(resultSet.getString(6));
				bean.setPhone(resultSet.getString(7));
				bean.setZipcode(resultSet.getString(8));
				bean.setDeptId(resultSet.getString(9));
				resultSet.close();
				return(bean);
			} else {
				resultSet.close();
				return(bean);
			}
		} catch(SQLException e) {
			return null;
		}
	}
	
	public MyCourses validateCourse(String ssn) {
		
		ArrayList<String> courseInfo = new ArrayList<String>();
		
		String queryString = "select Enrollment.courseId, Course.title, Enrollment.grade "
				+ "from Enrollment "
				+ "INNER JOIN Course ON Enrollment.courseId=Enrollment.courseId"
				+ "where ssn = ?";
		MyCourses bean = new MyCourses();
		try {
			dbConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, ssn);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				courseInfo.add(resultSet.getString(1));
				courseInfo.add(resultSet.getString(2));
				courseInfo.add(resultSet.getString(3));
				//resultSet.close();
				//return(bean);
			} else {
				resultSet.close();
				return(bean);
			}
			
			resultSet.close();
			bean.setCourseInfo(courseInfo);
			return (bean);
		} catch(SQLException e) {
			return null;
		}
	}
	
	public void closeConn() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
