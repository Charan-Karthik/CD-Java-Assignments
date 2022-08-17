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
		<h1 class="text-center">New Student</h1>
		<a href="/">Dashboard</a>
		
		<form:form action="/add/student" method="post" modelAttribute="student">
			<div class="text-danger text-center">
				<p>
					<form:errors path="*" />
				</p>
			</div>

			<p>
				<form:label path="name">Student Name</form:label>
				<form:input path="name" />
			</p>
			
			<p>
				<form:label path="dorm">Select Dorm</form:label>
				<form:select path="dorm">
					<c:forEach items="${dorms}" var="dorm">
						<form:option value="${dorm.id}" label="${dorm.name}"/>
					</c:forEach>
				</form:select>
			</p>
			<input type="submit" value="Add" />
		</form:form>
	</div>
</body>
</html>