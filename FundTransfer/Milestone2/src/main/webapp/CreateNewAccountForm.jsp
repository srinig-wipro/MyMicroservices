<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<style>
.ft{
	text-align :center;
	line-height: 50px;
}

</style>
</head>
<body>
<div class="ft">
<form action="addAccount" method="POST">
Enter Account Id : <input type="number" name="accountId" placeholder="Enter Account Id"><br>
Enter Customer Id : <input type="number" name="customerId" placeholder="Enter Customer Id"><br>
Enter Customer Name : <input type="text" name="customerName" placeholder="Enter Customer Name"><br>
Enter Opening Balance: <input type="text" name="balance" placeholder="Enter amount"><br>
<input type="submit" value="Submit">
<input type="reset" value="Cancel">

</form>
<div><a href="Home.jsp">Go Back To Home Page</a></div>
</div>
</body>
</html>