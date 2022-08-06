<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Fruity Loops</title>
</head>
<body>
<div class="container mt-3 d-flex justify-content-center flex-column">
	<h1 class="text-center text-success">Fruit Store</h1>
	<table class="table table-striped table-dark text-center d-flex justify-content-center">
		<tr>
			<th class="table-primary"><h3>Name</h3></th>
			<th class="table-primary"><h3>Price</h3></th>
		</tr>
		<c:forEach items="${fruits}" var="fruit">
		<tr>
			<td><c:out value="${fruit.name}"/></td>
			<td><c:out value="${fruit.price}"/></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>