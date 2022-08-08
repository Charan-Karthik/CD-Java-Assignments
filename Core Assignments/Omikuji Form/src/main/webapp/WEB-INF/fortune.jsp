<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body class="container mt-3">
	<h1 class="text-center">Here's Your Omikuji!</h1>
	
	<div class="w-25 container-fluid p-4 alert alert-primary">
		<h2> In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, <c:out value="${occupation}"/> for a living. The next time you see a <c:out value="${organism}"/>, you will have good luck. Also, <c:out value="${message}"/>.</h2>
	</div>
	
	<p class="text-center"><a href="/">Go Back</a></p>
</body>
</html>