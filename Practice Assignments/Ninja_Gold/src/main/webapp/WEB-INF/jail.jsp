<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Jail</title>
</head>
<body>
	<h1 class="m-5 text-center text-danger">You accumulated too much debt and now you're in jail...</h1>
	<h1 class="text-center">RIP</h1>
	
	<div class="mt-5 d-flex justify-content-center">
		<form action="/changegold" method="POST">
			<input type="submit" name="playAgainButton" value="Click Here to Play Again" class="btn btn-primary">
		</form>
	</div>
</body>
</html>