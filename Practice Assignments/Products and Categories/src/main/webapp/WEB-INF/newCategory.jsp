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
<title>New Category</title>
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
		<h1 class="text-center">New Category</h1>
		<a href="/">Home</a>

		<hr />

		<form:form action="/new/category" method="post" modelAttribute="newCategory" class="w-50">
			<div class="form-group mb-3">
				<form:label path="name" class="form-label">Name:</form:label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>