<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Book</title>
</head>
<body>
	<div class="container">
		<h1>CREATE A BOOK</h1>
		<hr/>
		
		<form action="/processBook" method="POST">
			Title: <input name="title">
			<br/>
			Description: <input name="description">
			<br/>
			Language: <input name="language">
			<br/>
			Number of Pages: <input type = "number" name="numberOfPages">
			<br/>
			
			<button>Submit</button>
		</form>
	</div>
</body>
</html>