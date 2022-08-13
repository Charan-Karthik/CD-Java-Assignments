<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${oneBook.title}" /></title>
<!-- get Bootstrap from web -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- for CSS and/or JS -->
<!-- <link rel="stylesheet" href="{{ CSS PATH }}"> -->
<!-- <script src="{{ JS PATH }}"></script> -->
</head>
<body>
	<div class="container mt-3">
		<div class="d-flex justify-content-between align-items-center">
			<h1>
				<c:out value="${oneBook.title}" />
			</h1>
			<a href="/welcome">back to the shelves</a>
		</div>

		<c:choose>
			<c:when test="${session_user_id == oneBook.user.id}">
				<h5 class="mt-3">
					<span style="color:red"> You </span> read
					<span style="color:purple"><c:out value="${oneBook.title}" /></span>
					by
					<span style="color:green"><c:out value="${oneBook.author}" /></span>
				</h5>
				<h5 class="mt-2">Here are your thoughts: </h5>
			</c:when>
			<c:otherwise>
				<h5 class="mt-3">
					<span style="color:red"> <c:out value="${oneBook.user.userName}" /> </span>
					read
					<span style="color:purple"> <c:out value="${oneBook.title}" /> </span>
					by
					<span style="color:green"> <c:out value="${oneBook.author}" /> </span>
				</h5>
				<h5 class="mt-2">
					Here are
					<c:out value="${oneBook.user.userName}" />
					's thoughts:
				</h5>
			</c:otherwise>
		</c:choose>


		<hr />
		<p class="text-center">
			<em><c:out value="${oneBook.thoughts}" /></em>
		</p>
		<hr />

		<div class="d-flex justify-content-end">
			<c:if test="${session_user_id == oneBook.user.id}">
				<a href="/book/${oneBook.id}/edit" class="btn btn-warning">Edit</a>
			</c:if>
		</div>
	</div>
</body>
</html>