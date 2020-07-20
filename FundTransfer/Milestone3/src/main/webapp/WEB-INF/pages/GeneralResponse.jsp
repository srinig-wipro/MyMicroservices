<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response</title>
</head>
<body>
	<div style="text-align: center">
		<h2><%=request.getAttribute("message")%></h2>
	</div>
	<div style="text-align: center">
		<a href="Home.htm">Go Back To Home Page</a>
	</div>
</body>
</html>