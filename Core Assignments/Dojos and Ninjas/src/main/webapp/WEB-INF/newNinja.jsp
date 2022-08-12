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
<title>New Ninja</title>
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
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Create a New Ninja</h1>
			<a href='/'>All Dojos</a>
		</div>

		<hr />

		<form:form action="/add/ninja" method="post" modelAttribute="ninja">
			<div class="text-danger text-center">
				<p>
					<form:errors path="*" />
				</p>
			</div>
			<p>
				<form:label path="dojo">Dojo</form:label>
				<form:select path="dojo">
					<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo.id}" label="${dojo.name}"/>
					</c:forEach>
				</form:select>
			</p>

			<p>
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" />
			</p>
			
			<p>
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" />
			</p>
			
			<p>
				<form:label path="age">Age</form:label>
				<form:input path="age" type="number" />
			</p>
			<input type="submit" value="Create" />
		</form:form>

	</div>
</body>
</html>