<%@ page language="java" contentType="text/html; charget=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Product Manager</title>
</head>
<body>
	<div align="center">
		<h1>${msg} : Product List</h1>

		<br />
		<br />

		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Products</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Band</th>
				<th>Madein</th>
				<th>Price</th>
			</tr>
			<c:forEach var="product" items="${viewProducts}">
				<tr>
					<td><c:out value="${product.id}" /></td>
					<td><c:out value="${product.name}" /></td>
					<td><c:out value="${product.brand}" /></td>
					<td><c:out value="${product.madein}" /></td>
					<td><c:out value="${product.price}" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>