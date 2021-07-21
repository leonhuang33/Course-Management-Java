<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
</head>
<body>
	<h2>
		<a href="DisplayCourses">Course Management</a>
	</h2>
	<table border="1">
		<tr>
			<th>Course</th>
			<th>Assignments</th>
		</tr>
		<c:forEach items="${courses }" var="course">
			<tr>
				<td><a href="DisplayAssignments?id=${course.getId() }">${course.getName() }</a></td>
				<td>${course.getAssignmentNum() }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="CreateCourse">Create Course</a>
</body>
</html>