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
<title>Category Page</title>
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
		<h1 class="text-center">
			<c:out value="${category.name}" />
		</h1>
		<a href="/">Home</a>

		<hr />

		<h3>Products:</h3>
		<c:choose>
			<c:when test="${category.products.size() < 1}">
				<h5 class="text-center">
					<em>No products have been assigned to this category yet.</em>
				</h5>
			</c:when>
			<c:otherwise>
				<ul>
					<c:forEach items="${category.products}" var="productIn">
						<li><c:out value="${productIn.name}" /></li>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>

		<hr />

		<h3>Add Product:</h3>
		<c:choose>
			<c:when test="${productsNotInCategory.size() < 1}">
				<h5 class="text-center"><em>This category has all the existing products added to it already.</em></h5>
			</c:when>
			<c:otherwise>
				<form action="/category/${category.id}/add/product" method="post">
					<select name="productID" class="form-select w-50">
						<c:forEach items="${productsNotInCategory}" var="product">
							<option value="${product.id}"><c:out
									value="${product.name}" /></option>
						</c:forEach>
					</select> <input class="btn btn-primary mt-2" type="submit" value="Add" />
				</form>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>