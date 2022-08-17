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
<title>Insert title here</title>
<!-- get Bootstrap from web -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- for CSS and/or JS -->
<!-- <link rel="stylesheet" href="{{ CSS PATH }}"> -->
<!-- <script src="{{ JS PATH }}"></script> -->
</head>
<body>
	<div class="container">
		<h1 class="text-center">Dorms</h1>
		
		<a href="/add/dorm" class="d-block">Add a new dorm</a>
		<a href="/add/student" class="d-block">Add a new student</a>
		<a href="/add/class" class="d-block">Add a new class</a>
		<a href="/all/classes" class="d-block">View all classes</a>
		
		<hr />
		<table class="table text-center">
			<tr>
				<th>Dorm</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${dorms}" var="dorm">
				<tr>
					<td><c:out value="${dorm.name}"/></td>
					<td><a href="/dorm/${dorm.id}/students">See Students</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>