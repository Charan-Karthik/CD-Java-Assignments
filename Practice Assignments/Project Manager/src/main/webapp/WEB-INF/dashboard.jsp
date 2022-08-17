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
<title>Project Manager Dashboard</title>
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
			<h1>
				Welcome,
				<c:out value="${user.firstName}" />
				!
			</h1>
			<a href="/">log out</a>
		</div>
		<br />
		<div class="d-flex justify-content-between align-items-center">
			<h5>All Projects</h5>
			<a href="/new/project" class="btn btn-success">+ new project</a>
		</div>
		<table class="table table-striped mt-3 text-center">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projectsWithoutUser}" var="project">
					<tr>
						<td><a href="/project/${project.id}"><c:out value="${project.title}"/></a></td>
						<td><c:out value="${project.user.firstName}"/></td>
						<td><c:out value="${project.dueDate}"/></td>
						<td><a href="/project/${project.id}/join">Join Team</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="mt-5">
			<h5>Your Projects</h5>
			<table class="table table-striped text-center">
				<thead>
					<tr>
						<th>Project</th>
						<th>Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
					<c:forEach items="${user.getAllProjects()}" var="userProject">
						<tr>
							<td><a href="/project/${userProject.id}"><c:out value="${userProject.title}"/></a></td>
							<td><c:out value="${userProject.user.firstName}"/></td>
							<td><c:out value="${userProject.dueDate}"/></td>
							<c:choose>
								<c:when test="${userProject.user.id == user.id}">
									<td><a href="/project/${userProject.id}/edit">Edit</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="/project/${userProject.id}/leave">Leave Project</a></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>