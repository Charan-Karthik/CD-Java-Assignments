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
			<a href="/all/songs">Dashboard</a>
		</div>
		
		<div class="mt-3">
			<table class="mb-4">
				<tr>
					<td>Title</td>
					<td class="text-center"> <c:out value="${oneSong.title}"/> </td>
				</tr>
				<tr>
					<td>Artist</td>
					<td class="text-center"> <c:out value="${oneSong.artist}"/> </td>
				</tr>
				<tr>
					<td>Rating (1-10)</td>
					<td class="text-center"> <c:out value="${oneSong.rating}"/> </td>
				</tr>
			</table>
			<a href="/delete/${oneSong.id}">Delete</a>
		</div>
	</div>
</body>
</html>