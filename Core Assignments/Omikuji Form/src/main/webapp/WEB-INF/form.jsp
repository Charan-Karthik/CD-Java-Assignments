<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>

<body>
	
	
	<div class="container-fluid d-flex justify-content-center flex-column">
		
		<c:if test="${numberError != null}">
			<div class="container alert alert-danger mt-3 p-2">
				<h4 class="text-center"><c:out value="${numberError}"/></h4>
			</div>
		</c:if>
		
		
		<h1 class="text-center mt-3">Send an Omikuji!</h1>
		<form class="w-25 mx-auto mt-3" action="/fortune" method="post">
			<label for="number" class="form-label">Pick any number from 5 to 25</label>
			<input name="number" type="number" class="form-control w-25" required>
			
			<label for="city" class="form-label mt-3">Enter the name of any city</label>
			<input name="city" type="text" class="form-control" required>
			
			<label for="person" class="form-label mt-3">Enter the name of any real person</label>
			<input name="person" type="text" class="form-control" required>
			
			<label for="occupation" class="form-label mt-3">Enter professional endeavor or hobby</label>
			<input name="occupation" type="text" class="form-control" required>
			
			<label for="organism" class="form-label mt-3">Enter any type of living thing</label>
			<input name="organism" type="text" class="form-control" required>
			
			<label for="message" class="form-label mt-3">Say something nice to someone:</label>
			<textarea name="message" class="form-control" required></textarea>
			
			<p class="mt-3"><em>Send and show a friend</em></p>
			<button class="btn btn-primary">Submit</button>
	</form>
	</div>
	
</body>
</html>