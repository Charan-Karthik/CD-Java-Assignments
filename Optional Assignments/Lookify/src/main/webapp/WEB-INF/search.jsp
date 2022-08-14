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
		<div class="d-flex justify-content-between">
			<h5>Songs by artist containing: "<c:out value="${artist}"/>"</h5>
			<div>
				<form method="post" action="/search">
					<input type="text" placeholder="${artist}" name="artist">
					<button type="submit">Search Artists</button>
				</form>
			</div>
			<a href="/all/songs">Dashboard</a>
		</div>
		
		<div class="mt-4">
			<c:choose>
				<c:when test="${searched.size() < 1}">
					<h4 class="text-center text-danger">No Results Found Matching Search Query</h4>
				</c:when>
				<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Name</th>
								<th>Rating</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${searched}" var="song">
								<tr>
									<td><a href="/song/${song.id}"><c:out
												value="${song.title}" /></a></td>
									<td><c:out value="${song.rating}" /></td>
									<td><a href="/delete/${song.id}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>