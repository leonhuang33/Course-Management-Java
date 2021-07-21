<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Assignment</title>
</head>
<body>
	<h2>
		<a href="DisplayCourses">Course Management</a> >
		<a href="DisplayAssignments?id=${courses.get(idSeed).getId() }"> ${courses.get(idSeed).getName() }</a> > Create Assignment
	</h2>

	<form action="CreateAssignments" method="post">
		<input type="hidden" name="id" value="${courses.get(idSeed).getId() }">
		<table border="1">
			<tr>
				<th>Assignment Name:</th>
				<td><input type="text" name="assignment"></td>
			</tr>
		</table>
		<input type="Submit" value="Create">
	</form>
</body>
</html>