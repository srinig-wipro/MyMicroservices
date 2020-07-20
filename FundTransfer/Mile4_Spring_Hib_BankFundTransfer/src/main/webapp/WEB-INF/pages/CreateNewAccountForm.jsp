<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Micro Service - Workshop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="resources/images/wipro.png" type="image/ico"/>
  <link rel="stylesheet"  href="resources/css/bootstrap.min.css"/>
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/popper.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
  <style>
	  body {
	      position: relative; 
	  }
  </style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top"> 
  
  <a class="navbar-brand" href="#">
  	<span style="margin-left: 35%;">Account Tracker Solution With J2EE Application</span>
  </a>
</nav>
<div class="container-fluid">
	<div id="section1" class="container-fluid" style="padding-top:70px;">
	<div class="card">
	  <div class="card-header" style="background-color: brown;color:white;text-align: center;">
	  	<h5>Create New Account - Page</h5>
	  </div>
	  <div class="card-body">
	   <div style="float: right">
				   <a class="btn btn-info" href="../Mile2_BankFundTransfer/Home.jsp">Back To Home</a>
	   </div>
		<br/><br/>
			When the link "Create New Account" is selected in Home page, this page would be displayed to capture necessary Account & customer details and initiates post request for further processing.
			<br/><br/>
			<form action="AccountServlet" method="POST">
			  <div class="form-group">
			    <label for="customerName">Customer Name:</label>
			    <input type="text" class="form-control" id="customerName" maxlength="20" name="customerName">
			    <label for="balance">Initial Deposit (Balance):</label>
			    <input type="text" class="form-control" id="balance" name="balance" maxlength="6">
			  </div>
			  <p  style="text-align: right"><button type="submit" class="btn btn-success">Generate Account</button></p>
			</form>
			
			<c:choose>
				<c:when test="${msg eq 'success'}">
					<div class="alert alert-primary" role="alert" style="text-align: center;">
						 Account Created Successfully for ${CustomerName} !! <br/>
						 Account Number Generated: ${AccountNumber} for Customer ID : ${CustomerID} 
					</div>
				</c:when>
				<c:when test="${!empty msg}">
					<div class="alert alert-danger" role="alert" style="text-align: center;">
						 Please Try Again!! Error : ${error}
					</div>
				</c:when>
			</c:choose>
	  </div>
	  <div class="card-footer" style="background-color: brown;color:white;text-align: center;">
	  	&copy; © 2019 DevOps: 	Bank Fund Transfer - DevOps Program Demo Example
	  </div>
	</div>
	</div>
</div>	
</body>
</html>