<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Account Balance</title>
<style>
.ft{
	text-align :center;
	line-height: 50px;
}

</style>
</head>
<body>
<div class="ft">
<form action="getBalance" method="post">
<input type="number" name ="accountNumber" placeholder="Enter Accounr Number"> <br>
<input type="submit" value="Get Balance">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear">
</form>
</div>
<div style="text-align:center"><a href="Home.htm">Go Back To Home Page</a></div>
</body>
</html>