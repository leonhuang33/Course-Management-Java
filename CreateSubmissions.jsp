<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Submissions</title>
</head>
<body>
	<h2>
		<a href="DisplayCourses">Course Management</a> > 
		<a href="DisplayAssignments?id=${course.get(idSeed).getId() }">${courses.get(idSeed).getName() }</a> >
		<a href="DisplaySubmissions?id=${assignments.get(idSeed).getId() }">${assignments.get(idSeed).getName() }</a> Create Submission
	</h2>
	<form action="CreateSubmissions" method="post">
		<input type="hidden" name="id" value="${assignments.get(idSeed).getId() }">
		<table border="1">
			<tr>
				<th>Student Name:</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>Answer:</th>
				<td><textarea rows="4" cols="20" name="answer"></textarea>
			</tr>
		</table>
		<input type="Submit" value="Create">
	</form>
</body>
</html>