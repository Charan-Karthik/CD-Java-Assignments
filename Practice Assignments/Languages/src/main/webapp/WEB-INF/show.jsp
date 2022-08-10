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
	<div class="container mt-3">
		<div class="d-flex justify-content-end">
			<a href="/" class="btn btn-primary">Dashboard</a>
		</div>
		
		<div class="mt-3 mb-4">
			<h5><c:out value="${lang.name}"/></h5> <br/>
			<h5><c:out value="${lang.creator}"/></h5> <br/>
			<h5><c:out value="${lang.version}"/></h5> <br/>
		</div>
		
		<div class="d-flex justify-content-between">
			<a href="/languages/${lang.id}/edit" class = "btn btn-sm btn-warning">Edit</a>
			<form action="/languages/${lang.id}/delete" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete" class="btn btn-danger">
			</form>
		</div>
	</div>
</body>
</html>