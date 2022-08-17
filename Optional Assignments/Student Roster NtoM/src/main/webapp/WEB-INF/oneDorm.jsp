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
			<c:out value="${dorm.name}" />
			Students
		</h1>
		<a href="/">Dashboard</a> <br />

		<c:if test="${!emptyQ}">

			<form action="/add/student/to/dorm/${dorm.id}" method="post">
				<input type="hidden" name="_method" value="put">
				<div class="d-flex align-items-center justify-content-between">
					<p>
						<label>Students without Dorm Assignments</label> <select
							name="studentId">
							<c:forEach items="${noDormStudents}" var="student">
								<option value="${student.id}"
									label="${student.id} - ${student.name}" />
							</c:forEach>
						</select>
					</p>


					<input type="submit" value="Add" />
				</div>
			</form>
		</c:if>

		<table class="table">
			<tr>
				<th>Student</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><a href="/student/${student.id}">${student.name}</a></td>
					<td><a href="/remove/student/${student.id}">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>