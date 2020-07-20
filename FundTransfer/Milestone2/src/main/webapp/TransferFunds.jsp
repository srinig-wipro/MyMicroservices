<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer funds</title>
<style>
.ft{
	text-align :center;
	line-height: 50px;
}

</style>
</head>
<body>
<div class="ft">
<form action="fundTransfer" method="post">
<input type="number" name ="fromAccount" placeholder="Enter From account"> <input type="number" name="toAccount" placeholder="Enter To account number"><br>
<input type="text" name="amount" placeholder="Enter Amount "></br>
<input type="submit" value="Transfer Money">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear">
</form>
</div>
<div style="text-align:center"><a href="Home.jsp">Go Back To Home Page</a></div>
</body>
</html>