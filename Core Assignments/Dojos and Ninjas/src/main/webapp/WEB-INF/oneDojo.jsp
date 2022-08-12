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
<title><c:out value="${dojo.name}"/> Dojo</title>
<!-- get Bootstrap from web -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- for CSS and/or JS -->
<!-- <link rel="stylesheet" href="{{ CSS PATH }}"> -->
<!-- <script src="{{ JS PATH }}"></script> -->
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1><c:out value="${dojo.name}"/> Dojo</h1>
			<a href='/'>All Dojos</a>
		</div>
		
		<hr />
		<div class="d-flex justify-content-between align-items-center">
			<h2> Ninjas </h2>
			<a href='/new/ninja'>Create a New Ninja</a>
		</div>
		
		<table class="table">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
			<c:forEach items="${dojoNinjas}" var="ninja">
				<tr>
					<td><c:out value="${ninja.firstName}"/></td>
					<td><c:out value="${ninja.lastName}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>