<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignments</title>
</head>
<body>
	<h2>
		<a href="DisplayCourses">Course Management</a> > <a
			href="DisplayAssignments">${courses.get(idSeed).getName() }</a>
		> Assignments
	</h2>

	<table border="1">
		<tr>
			<th>Assignments</th>
			<th>Submissions</th>
			<th>Latest Submissions</th>
		</tr>
		<c:forEach items="${courses.get(idSeed).getAssignmentEntries() }" var="assignment">
			<tr>
				<td><a href="DisplaySubmissions?id=${assignment.getId() }">${assignment.getName() }</a></td>
				<td>${assignment.getSubmissionNum() }</td>
				<c:choose>
					<c:when test="${assignment.getSubmissionEntries().size() > 0}">
						<td><fmt:formatDate type="both" dateStyle="short"
								timeStyle="short" value="${assignment.getSubmissionDate() }" /></td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
	<a href="CreateAssignments?id=${assignments.get(idSeed).getId() }">Create
		Assignment</a>
</body>
</html>