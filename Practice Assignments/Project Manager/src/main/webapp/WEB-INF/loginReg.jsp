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
<title>Project Manager - Login/Register</title>
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
<div class="container mt-3">
	<h1 style="color: cornflowerblue" class="text-center">Project
		Manager</h1>
	<h4 class="mb-4 text-center">A place for teams to manage projects.</h4>

	<div class="d-flex justify-content-between">
		<div class="w-50">
			<h3>Register:</h3>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="form-group mb-3">
					<form:label path="firstName" class="form-label">First Name:</form:label>
					<form:input path="firstName" class="form-control" />
					<form:errors path="firstName" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<form:label path="lastName" class="form-label">Last Name:</form:label>
					<form:input path="lastName" class="form-control" />
					<form:errors path="lastName" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<form:label path="email" class="form-label">Email:</form:label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<form:label path="password" class="form-label">Password:</form:label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<form:label path="confirm" class="form-label">Confirm Password:</form:label>
					<form:password path="confirm" class="form-control" />
					<form:errors path="confirm" class="text-danger" />
				</div>
				<input type="submit" value="Register" class="btn btn-primary" />
			</form:form>
		</div>

		<div class="w-25">
			<h3>Login:</h3>
			<form:form action="/login" method="post" modelAttribute="loginUser">
				<div class="form-group mb-3">
					<form:label path="email" class="form-label">Email:</form:label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<form:label path="password" class="form-label">Password:</form:label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<input type="submit" value="Login" class="btn btn-success" />
			</form:form>
		</div>
	</div>
</div>
<body>
</body>
</html>