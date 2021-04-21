<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Name: ${student.firstName}, ${student.lastName} Phone: ${student.phone}<br>
My Classes:<br>

ID|Course|Grade<br>
<c:forEach items="${courseInfo}" var="courseInfo">
    ${MyCourses.courseInfo}
</c:forEach>
</body>
</html>