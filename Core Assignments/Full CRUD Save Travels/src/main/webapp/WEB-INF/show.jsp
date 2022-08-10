<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Expense ${expense.id}</title>
</head>
<body>
	<div class="container mt-3">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="text-primary">Expense Details</h1>
			<a href="/">Go Back</a>
		</div>
		
		<table class="mt-5 mb-5">
			<tr>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<td><b>Expense Name:</b></td>
				<td></td>
				<td><c:out value="${expense.expenseName}"/></td>
			</tr>
			<tr>
				<td><b>Expense Description:</b></td>
				<td></td>
				<td><c:out value="${expense.description}"/></td>
			</tr>
			<tr>
				<td><b>Vendor:</b></td>
				<td></td>
				<td><c:out value="${expense.vendor}"/></td>
			</tr>
			<tr>
				<td><b>Expense Name:</b></td>
				<td></td>
				<fmt:formatNumber var="formattedAmount" type="number" minFractionDigits= "2" maxFractionDigits="2" value="${expense.amount}"/>
				<td>$<c:out value="${formattedAmount}"/></td>
			</tr>
		</table>
		
		<a href="/expenses/edit/${expense.id}" class="btn btn-sm btn-warning">Edit</a>
	</div>
</body>
</html>