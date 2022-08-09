<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Ninja Gold</title>
</head>
<body>
	<div class="d-flex">
		<h1 class="p-4">Your Gold:</h1>
		<c:if test="${gold gt 0}">
			<h1 class="p-4 text-success"><c:out value="${gold}"/></h1>
		</c:if>
		<c:if test="${gold lt 0}">
			<h1 class="p-4 text-danger"><c:out value="${gold}"/></h1>
		</c:if>
		<c:if test="${gold eq 0}">
			<h1 class="p-4"><c:out value="${gold}"/></h1>
		</c:if>
	</div>
	
	<div class="d-flex justify-content-around">
		<!-- Farm +10-20 -->
		<form action="/changegold" method="POST">
			<h3 class="text-center">Farm</h3>
			<p class="text-center">earns 10-20 gold</p>
			<input type="submit" name="farmButton" value="Find Gold!" class="btn btn-success">
		</form>
		
		<!-- Cave +5-10 -->
		<form action="/changegold" method="POST">
			<h3 class="text-center">Cave</h3>
			<p class="text-center">earns 5-10 gold</p>
			<input type="submit" name="caveButton" value="Find Gold!" class="btn btn-success">
		</form>
		
		<!-- House +2-5 -->
		<form action="/changegold" method="POST">
			<h3 class="text-center">House</h3>
			<p class="text-center">earns 2-5 gold</p>
			<input type="submit" name="houseButton" value="Find Gold!" class="btn btn-success">
		</form>
		
		<!-- Quest +/- 0-50 -->
		<form action="/changegold" method="POST">
			<h3 class="text-center">Quest</h3>
			<p class="text-center">gain or lose 0-50 gold</p>
			<input type="submit" name="questButton" value="Wager Gold" class="btn btn-warning">
		</form>
		
		<!-- Spa - 5-20 -->
		<form action="changegold" method="POST">
			<h3 class="text-center">Spa</h3>
			<p class="text-center">lose 5-20 gold</p>
			<input type="submit" name="spaButton" value="Spend Gold" class="btn btn-warning">
		</form>
	</div>
	
	<h3 class="p-4 mt-3">Activities:</h3>
	<iframe src="/activities" title="all activities" width="100%"></iframe>
	
	<div class="d-flex flex-column">
		<form action="/changegold" method="POST" class="mx-auto">
			<input type="submit" name="resetButton" value="Reset" class="btn btn-danger mt-3">
		</form>
		<p class="mx-auto"><em>Reset Gold Count to Zero (0)</em></p>
	</div>
	
</body>
</html>