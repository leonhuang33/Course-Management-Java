<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submissions</title>
</head>
<body>
	<h2>
		<a href="DisplayCourses">Course Management</a> > <a
			href="DisplayAssignments?id=${courses.get(idSeed).getId() }">${courses.get(idSeed).getName() }</a>
		> <a href="DisplaySubmissions?id=${assignments.get(idSeed).getId() }">${assignments.get(idSeed).getName() }</a>
		> Submissions
	</h2>
	<table border="1">
		<tr>
			<th>Student Name</th>
			<th>Answer</th>
			<th>Submitted Date</th>
		</tr>
		<c:forEach items="${assignments.get(idSeed).getSubmissionEntries() }"
			var="submission">
			<tr>
				<td>${submission.getName() }</td>
				<td>${submission.getAnswer() }</td>
				<c:choose>
					<c:when test="${assignments.get(idSeed).getSubmissionNum() > 0 }">
						<td><fmt:formatDate type="both" dateStyle="short"
								timeStyle="short" value="${submission.getSubmissionDate()}" /></td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
	<a href="CreateSubmissions?id=${assignments.get(id).getId() }">Create
		Submission</a>
</body>
</html>