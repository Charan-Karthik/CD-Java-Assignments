<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Project</title>
<!-- get Bootstrap from web -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- for CSS and/or JS -->
<!-- <link rel="stylesheet" href="{{ CSS PATH }}"> -->
<!-- <script src="{{ JS PATH }}"></script> -->
</head>
<body>
	<div class="container mt-3">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Project Details</h1>
			<a href="/dashboard">Back to Dashboard</a>
		</div>

		<div class="mt-3 mb-3">
			<table>
				<tr>
					<td><b>Project:</b></td>
					<td><c:out value="${thisProject.title}" /></td>
				</tr>
				<tr>
					<td><b>Description:</b></td>
					<td><c:out value="${thisProject.description}" /></td>
				</tr>
				<tr>
					<td><b>Due Date:</b></td>
					<td><c:out value="${thisProject.dueDate}" /></td>
				</tr>
			</table>
		</div>

		<div class="mb-5">
			<a href="#">See tasks!</a>
		</div>

		<c:if test="${thisProject.user.id == loggedInUserID}">
			<div class="d-flex justify-content-end">
				<%-- <a href="/project/${thisProject.id}/delete" class="btn btn-danger">Delete Project</a> --%>
				<form action="/project/${thisProject.id}/delete" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete" class="btn btn-danger">
				</form>
			</div>
		</c:if>
	</div>
</body>
</html>