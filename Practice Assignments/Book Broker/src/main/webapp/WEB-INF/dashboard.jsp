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
<title>Book Broker - Dashboard</title>
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
			<div>
				<h5>
					Hello,
					<c:out value="${userName}" />.
					Welcome to
				</h5>
				<h1>The Book Broker!</h1>
			</div>
			<a href="/welcome">back to the shelves</a>
		</div>

		<div class="mt-4">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${unborrowed}" var="book">
						<tr>
							<td><c:out value="${book.id}" /></td>
							<td><a href="/book/${book.id}"><c:out
										value="${book.title}" /></a></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.user.getUserName()}" /></td>
							<td><c:choose>
									<c:when test="${session_user_id == book.user.getId()}">
										<a href="/book/${book.id}/edit">Edit</a> | <a
											href="/book/${book.id}/delete">Delete</a>
									</c:when>
									<c:otherwise>
										<a href="/bookmarket/borrow/${book.id}">Borrow</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="mt-4">
			<c:choose>
				<c:when test="${borrowed.size() < 1}">
					<div>
						<h4 class="text-center mt-4">
							<em>You are currently not borrowing any books.</em>
						</h4>
					</div>
				</c:when>
				<c:otherwise>
					<h5>Books I'm borrowing:</h5>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Title</th>
								<th>Author Name</th>
								<th>Owner</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${borrowed}" var="b">
								<tr>
									<td><c:out value="${b.id}"/></td>
									<td><a href="/book/${b.id}"><c:out value="${b.title}"/></a></td>
									<td><c:out value="${b.author}"/></td>
									<td><c:out value="${b.user.userName}"/></td>
									<td><a href="/bookmarket/return/${b.id}">Return Book</a></td>
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