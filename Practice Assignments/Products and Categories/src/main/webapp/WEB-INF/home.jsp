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
<title>Home</title>
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
		<h1 class="text-center">Home Page</h1>
		<a href="/new/product">New Product</a> <br /> <a href="/new/category">New
			Category</a>

		<hr />

		<div class="d-flex justify-content-between">
			<div class="w-25">
				<table class="table table-striped text-center">
					<thead>
						<tr>
							<th>Products</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allProducts}" var="product">
							<tr>
								<td><a href="/product/${product.id}"><c:out
											value="${product.name}" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="w-25">
				<table class="table table-striped text-center">
					<thead>
						<tr>
							<th>Categories</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allCategories}" var="category">
							<tr>
								<td><a href="/category/${category.id}"><c:out
											value="${category.name}" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>