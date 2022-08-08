<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Counter</h1>
	<h3>You have visited your server <c:out value="${count}"/> times</h3>
	
	<a href="/reset">Reset Counter</a>
	<a href="/add/two">Add Two Visits</a>
	
</body>
</html>