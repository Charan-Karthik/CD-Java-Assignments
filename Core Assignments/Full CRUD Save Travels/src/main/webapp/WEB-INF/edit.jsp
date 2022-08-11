<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Edit Expense ${expense.id}</title>
</head>
<body>
	<div class="container mt-3">
		<div class="d-flex justify-content-between mb-3">
			<h1 class="text-center text-primary">Edit Expense</h1>
			<a href='/'>All Expenses</a>
		</div>
		<%-- <h3>Expense Number: ${expense.id}</h3> --%>
		<form:form action="/change/${expense.id}" method="POST"
			modelAttribute="expense" class="w-50 mx-auto">
			<p class="mx-auto">
				<form:label path="expenseName" class="form-label">
					<b>Expense Name</b>
				</form:label>
				<form:errors path="expenseName" class="text-danger" />
				<form:input path="expenseName" class="form-control" />
			</p>

			<p class="mx-auto">
				<form:label path="vendor" class="form-label">
					<b>Vendor</b>
				</form:label>
				<form:errors path="vendor" class="text-danger" />
				<form:input path="vendor" class="form-control" />
			</p>

			<p class="mx-auto">
				<form:label path="amount" class="form-label">
					<b>Amount</b>
				</form:label>
				<form:errors path="amount" class="text-danger" />
				<form:input type="double" path="amount" class="form-control" />
			</p>

			<p class="mx-auto">
				<form:label path="description" class="form-label">
					<b>Description</b>
				</form:label>
				<form:errors path="description" class="text-danger" />
				<form:textarea path="description" class="form-control" />
			</p>
			<input type="submit" value="Submit Edit" class="btn btn-primary" />
			<hr />
			<%-- <a href="/delete/${expense.id}" class="btn btn-danger d-block">DELETE</a> --%>
		</form:form>
		<div class="w-50 mx-auto">
			<div class="d-flex justify-content-end">
				<form action="/delete/${expense.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class="btn btn-danger">
				</form>
			</div>
		</div>
	</div>
</body>
</html>