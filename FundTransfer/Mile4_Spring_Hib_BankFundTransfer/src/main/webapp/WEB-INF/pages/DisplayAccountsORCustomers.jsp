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
  	Banking Example <span style="margin-left: 35%;">Account Tracker Solution With J2EE Application</span>
  </a>
</nav>
<div class="container-fluid">
	<div id="section1" class="container-fluid" style="padding-top:70px;">
	<div class="card">
	  <div class="card-header" style="background-color: brown;color:white;text-align: center;">
	  	<h5>Display all Accounts or Customers - Page</h5>
	  </div>
	  <div class="card-body">
	   <div style="float: right">
				   <a class="btn btn-info" href="../Mile2_BankFundTransfer/Home.jsp">Back To Home</a>
	   </div>
		<br/><br/>
			When the link "Display Accounts OR Customers" selected in Home page, this would display a page such that user can request for either all account or customer details to get as response(initiates post request to process).
			<br/><br/>
			<form action="DisplayAccountsORCustomServlet" method="POST">
			  <div class="form-group">
				  <select class="form-control" id="details" name="details">
				    <option value="AD">Account Details</option>
				    <option value="CD">Customer Details</option>
				  </select>
			  </div>
			  <p  style="text-align: right"><button type="submit" class="btn btn-success">Search Details</button></p>
			</form>
			<c:choose>
				<c:when test="${msg eq 'AD'}">
					<c:forEach items="${list}" var="items"> 
						<div class="alert alert-primary" role="alert" style="text-align: left;">
							 Account ID: ${items.accountID} <br/>	
							 Customer Name: ${items.customer.name} <br/>			 
							 Balance: ${items.balance}
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${msg eq 'CD'}">
					<c:forEach items="${list}" var="items"> 
						<div class="alert alert-primary" role="alert" style="text-align: left;">
							 Customer ID: ${items.customerID}  <br/>				 
							 Name: ${items.name}
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${msg eq 'ER'}">
					<div class="alert alert-danger" role="alert" style="text-align: center;">
						 Issue Found. Please try again! <br/> ${code} 
					</div>
				</c:when>
				<c:when test="${msg eq 'NF'}">
					<div class="alert alert-danger" role="alert" style="text-align: center;">
						 NO Data Found. 
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