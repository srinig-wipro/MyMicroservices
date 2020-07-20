<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Micro Service - Workshop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="images/wipro.png" type="image/ico" />
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <style>
	  body {
	      position: relative; 
	  }
  </style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top"> 
  
  <a class="navbar-brand" href="#">
  	Micro Services - Workshop <span style="margin-left: 35%;">Account Tracker Solution With J2EE Application</span>
  </a>
</nav>
<div class="container-fluid">
	<div id="section1" class="container-fluid" style="padding-top:70px;">
	<div class="card">
	  <div class="card-header" style="background-color: brown;color:white;text-align: center;">
	  	<h5>Search Account by ID - Page</h5>
	  </div>
	  <div class="card-body">
	   <div style="float: right">
				   <a class="btn btn-info" href="../Mile2_BankFundTransfer/Home.jsp">Back To Home</a>
	   </div>
		<br/><br/>
			When the link "Search Account by ID" is selected in Home page, this page would be displayed to capture Account id to initiate post request for further processing.
			<br/><br/>
			<form action="GetAccountBalance" method="POST">
			  <div class="form-group">
			    <label for="customerName">Account ID:</label>
			    <input type="text" class="form-control" id="accountID" maxlength="2" name="accountID" placeholder="Enter Digit(s) ONLY for Account ID">
			  </div>
			  <p  style="text-align: right"><button type="submit" class="btn btn-success">Search Account ID</button></p>
			</form>
			<c:choose>
				<c:when test="${msg eq 'success'}">
					<div class="alert alert-primary" role="alert" style="text-align: left;">
						 Account Found for ${CustomerName} !! <br/>
							1. Account Number : ${AccountNumber} <br/>
							2. Customer ID : ${CustomerID} <br/>
							3. Balance :  ${Balance}<br/>						 
					</div>
				</c:when>
				<c:when test="${msg eq 'NF'}">
					<div class="alert alert-danger" role="alert" style="text-align: center;">
						 Customer Not Found for account number : ${AccountNumber} 
					</div>
				</c:when>
				<c:when test="${msg eq 'ER'}">
					<div class="alert alert-danger" role="alert" style="text-align: center;">
						 Issue Found. Please try again! <br/> ${code} 
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