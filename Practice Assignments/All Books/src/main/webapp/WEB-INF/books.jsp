<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Books</title>
</head>
<body>
	<div class="container mt-3">
		<h1>All Books</h1>
		<table class="table table-striped">
			<tr class="text-center">
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th># Pages</th>
			</tr>
			
			<c:forEach items="${allDaBooks}" var="book">
			<tr class="text-center">
				<td><c:out value="${book.id}"/></td>
				<td> <a href="/books/${book.id}"><c:out value="${book.title}"/></a> </td>
				<td><c:out value="${book.language}"/></td>
				<td><c:out value="${book.numberOfPages}"/></td>
			</tr>
		</c:forEach>
		
		</table>
	</div>
	
</body>
</html>