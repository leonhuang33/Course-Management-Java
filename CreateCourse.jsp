<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Course</title>
</head>
<body>
	<h2>
		<a href="DisplayCourses">Course Management</a> > Create Course
	</h2>
	<form action="CreateCourse" method="post">
		<table border="1">
			<tr>
				<th>Course Name:</th>
				<td><input type="text" name="coursename"></td>
			</tr>
		</table>
		<input type="submit" value="Create">
	</form>
</body>
</html>