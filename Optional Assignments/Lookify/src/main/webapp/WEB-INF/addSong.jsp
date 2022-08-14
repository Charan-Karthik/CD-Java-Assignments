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
<title>Insert title here</title>
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
		<div class="d-flex justify-content-end">
			<a href="/all/songs">Dashboard</a>
		</div>

		<h1>Add a New Song</h1>
		<form:form action="/new/song" method="post" modelAttribute="newSong"
			class="w-50">
			<div class="form-group mb-3">
				<form:label path="title" class="form-label">Title:</form:label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group mb-3">
				<form:label path="artist" class="form-label">Artist:</form:label>
				<form:input path="artist" class="form-control" />
				<form:errors path="artist" class="text-danger" />
			</div>
			<div class="form-group mb-3 w-25">
				<form:label path="rating" class="form-label">Rating:</form:label>
				<form:select path="rating" class="form-control mb-3">
					<c:forEach var="i" begin="1" end="10">
						<form:option value="${i}" label="${i}" class="text-center"/>
					</c:forEach>
				</form:select>
				<form:errors path="rating" class="text-danger" />
			</div>
			<div class="d-flex justify-content-end">
				<input type="submit" value="Add Song" class="btn btn-primary" />
			</div>
		</form:form>
	</div>
</body>
</html>