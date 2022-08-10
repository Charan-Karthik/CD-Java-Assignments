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
<title>Insert title here</title>
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
	<div class="container mt-4">
		<div class="d-flex justify-content-end align-items-center">
			<form action="/languages/${lang.id}/delete" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete" class="btn btn-danger">
			</form>
			<div>
				<h1>|</h1>
			</div>
			<a href="/" class="btn btn-primary">Dashboard</a>
		</div>

		<form:form action="/languages/${lang.id}/update" method="POST"
			modelAttribute="lang">
			<input type="hidden" name="_method" value="put">
			<div class="text-center mt-3 mb-3">
				<form:errors path="*" class="text-danger" />
			</div>
			<p>
				<form:label path="name" class="form-label"> Language Name</form:label>
				<%-- <form:errors path="name" /> --%>
				<form:input path="name" class="form-control" />
			</p>
			<p>
				<form:label path="creator" class="form-label">Creator</form:label>
				<%-- <form:errors path="creator" /> --%>
				<form:input path="creator" class="form-control" />
			</p>
			<p>
				<form:label path="version" class="form-label">Version</form:label>
				<%-- <form:errors path="version" /> --%>
				<form:input path="version" class="form-control" />
			</p>
			<div class="d-flex justify-content-end">
				<input type="submit" value="Submit" class="btn btn-primary" />
			</div>
		</form:form>
	</div>
</body>
</html>