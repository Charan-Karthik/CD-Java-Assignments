<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Project</title>
<!-- get Bootstrap from web -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- for CSS and/or JS -->
<!-- <link rel="stylesheet" href="{{ CSS PATH }}"> -->
<!-- <script src="{{ JS PATH }}"></script> -->
</head>
<body>
	<div class="container mt-3">
		<h1 class="mb-4">Create a Project</h1>
		<form:form action="/new/project" method="post" modelAttribute="newProject">
				<div class="form-group mb-3">
					<form:label path="title" class="form-label">Project Title:</form:label>
					<form:input path="title" class="form-control" />
					<form:errors path="title" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<form:label path="description" class="form-label">Project Description:</form:label>
					<form:input path="description" class="form-control" />
					<form:errors path="description" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<form:label path="dueDate" class="form-label">Due Date:</form:label>
					<form:input path="dueDate" class="form-control" type="date"/>
					<form:errors path="dueDate" class="text-danger" />
				</div>
				<div class="d-flex justify-content-between align-items-center">
					<a href="/dashboard" class="btn btn-warning">Cancel</a>
					<input type="submit" value="Submit" class="btn btn-primary" />
				</div>
			</form:form>
	</div>
</body>
</html>