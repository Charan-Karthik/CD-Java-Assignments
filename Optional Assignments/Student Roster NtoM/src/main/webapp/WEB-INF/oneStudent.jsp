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
	<div class="container">
		<h1 class="text-center">
			<c:out value="${thisStudent.name}" />
			's Classes
		</h1>

		<a href="/">Dashboard</a>

		<hr />

		<form action="/student/${thisStudent.id}/add/class" method="post">
			<input type="hidden" name="_method" value="put">
			<div class="d-flex align-items-center justify-content-between">
				<p>
					<label>Classes that can be added:</label> 
					<select name="classID">
						<c:forEach items="${classesStudentIsNotIn}" var="noClass">
							<option value="${noClass.id}" label="${noClass.name}" />
						</c:forEach>
					</select>
				</p>


				<input type="submit" value="Add" />
			</div>
		</form>

		<hr />

		<h5>Currently Enrolled Classes</h5>
		<table class="table text-center">
			<thead>
				<tr>
					<th>Class Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${thisStudent.getClasses()}" var="studentClass">
					<tr>
						<td><c:out value="${studentClass.name}"/></td>
						<td><a href="/student/${thisStudent.id}/drop/class/${studentClass.id}">Drop</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>