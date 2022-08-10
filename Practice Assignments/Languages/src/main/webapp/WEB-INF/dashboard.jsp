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
<title>Languages</title>
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
	<div class="container mt-4">
		<table class="table table-striped mb-4 text-center">
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${languages}" var="lang">
				<tr>
					<td> <a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a> </td>
					<td> <c:out value="${lang.creator}"/> </td>
					<td> <c:out value="${lang.version}"/> </td>
					<td class="d-flex justify-content-center"> 
						<a href="/languages/${lang.id}/edit" class = "btn btn-sm btn-warning">Edit</a> 
						<form action="/languages/${lang.id}/delete" method="post" class="px-2">
							<input type="hidden" name="_method" value="delete"> 
							<input
					type="submit" value="Delete" class="btn btn-danger btn-sm">
						</form> 
					</td>
				</tr>
			</c:forEach>
			
		</table>
<hr/>
		<div>
			<form:form action="/languages" method="POST" modelAttribute="lang">
			<div class="text-center mt-3 mb-3">
				<form:errors path="*" class="text-danger"/>
			</div>
				<p>
					<form:label path="name" class="form-label"> Language Name</form:label>
					<%-- <form:errors path="name" /> --%>
					<form:input path="name" class="form-control"/>
				</p>
				<p>
					<form:label path="creator" class="form-label">Creator</form:label>
					<%-- <form:errors path="creator" /> --%>
					<form:input path="creator" class="form-control"/>
				</p>
				<p>
					<form:label path="version" class="form-label">Version</form:label>
					<%-- <form:errors path="version" /> --%>
					<form:input path="version" class="form-control"/>
				</p>
				<div class="d-flex justify-content-end">
					<input type="submit" value="Submit" class="btn btn-primary"/>
				</div>
			</form:form>
		</div>

	</div>
</body>
</html>