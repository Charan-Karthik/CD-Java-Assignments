<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Book ${thisBook.id}</title>
</head>
<body>
	<div class="container mt-3">
		<h1>${thisBook.title}</h1>
		<h4>Description: ${thisBook.description}</h4>
		<h4>Language: ${thisBook.language}</h4>
		<h4>Number of Pages: ${thisBook.numberOfPages}</h4>
	</div>
</body>
</html>