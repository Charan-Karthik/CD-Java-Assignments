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
<title>Edit Book</title>
<!-- get Bootstrap from web -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- for CSS and/or JS -->
<!-- <link rel="stylesheet" href="{{ CSS PATH }}"> -->
<!-- <script src="{{ JS PATH }}"></script> -->
</head>
<body>
	<div class="container mt-3">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Change Your Entry</h1>
			<a href="/welcome">back to the shelves</a>
		</div>

		<form:form action="/book/${bookToUpdate.id}/edit" method="post"
			modelAttribute="bookToUpdate" class="w-50 mt-3">
			<div class="form-group mb-3">
				<form:label path="title">Title:</form:label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group mb-3">
				<form:label path="author">Author:</form:label>
				<form:input path="author" class="form-control" />
				<form:errors path="author" class="text-danger" />
			</div>
			<div class="form-group mb-3">
				<form:label path="thoughts">My thoughts:</form:label>
				<form:textarea path="thoughts" class="form-control" />
				<form:errors path="thoughts" class="text-danger" />
			</div>
			<div class="d-flex justify-content-end">
				<input type="submit" value="Submit Changes" class="btn btn-primary" />
			</div>
		</form:form>
		
		<div class="mt-5">
			<a href="/book/${bookToUpdate.id}/delete" class="btn btn-danger">Delete</a>
		</div>
	</div>
	
</body>
</html>