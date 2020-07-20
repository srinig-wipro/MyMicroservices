<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Account or customers</title>
<style>
.ft {
	text-align: center;
	line-height: 30px;
}
</style>
</head>

<body>
	<div class="ft">
		<form action="getAccountOrCustomer" method="POST">
			<h3>
				<input type="radio" value="account" name="select"> All
				Account
			</h3>
			<br>
			<h3>
				<input type="radio" value="customer" name="select"> All
				Customer
			</h3>
			<br> <input type="submit" value="Get">
		</form>
	</div>
	<div style="text-align: center">
		<a href="Home.jsp">Go Back To Home Page</a>
	</div>
</body>
</html>