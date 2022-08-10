<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Save Travels</title>
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-primary">Save Travels</h1>

		<table class="table table-dark table-striped text-center mb-5">
			<tr>
				<th><b>Expense</b></th>
				<th><b>Vendor</b></th>
				<th><b>Amount</b></th>
			</tr>
			
			<c:forEach items="${expenses}" var="expense">
				<tr>
					<td><c:out value="${expense.expenseName}"/></td>
					<td><c:out value="${expense.vendor}"/></td>
					<fmt:formatNumber var="formattedAmount" type="number" minFractionDigits= "2" maxFractionDigits="2" value="${expense.amount}"/>
					<td>$<c:out value="${formattedAmount}"/></td>
				</tr>
			</c:forEach>
		</table>
		
		<h1 class="text-center text-primary">Add an Expense</h1>
		<form:form action="/expenses" method="POST" modelAttribute="expense" class="d-flex flex-column">
			<p class="mx-auto">
				<form:label path="expenseName" class="form-label"><b>Title</b></form:label>
				<form:errors path="expenseName" class="text-danger"/>
				<form:input path="expenseName" class="form-control" />
			</p>
			
			<p class="mx-auto">
				<form:label path="vendor" class="form-label"><b>Vendor</b></form:label>
				<form:errors path="vendor" class="text-danger"/>
				<form:input path="vendor" class="form-control" />
			</p>
			
			<p class="mx-auto">
				<form:label path="amount" class="form-label"><b>Amount</b></form:label>
				<form:errors path="amount" class="text-danger"/>
				<form:input type="double" path="amount" class="form-control" />
			</p>
			
			<p class="mx-auto">
				<form:label path="description" class="form-label"><b>Description</b></form:label>
				<form:errors path="description" class="text-danger"/>
				<form:textarea path="description" class="form-control" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary mx-auto"/>
		</form:form>
	</div>
</body>
</html>