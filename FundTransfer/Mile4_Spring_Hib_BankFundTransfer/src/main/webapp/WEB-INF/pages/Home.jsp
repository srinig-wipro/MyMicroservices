<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
  <title>Welcome to Web Application-Bank Fund Transfer</title>
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
  	Bank Fund Transfer <span style="margin-left: 35%;">Account Tracker Solution With J2EE Application</span>
  </a>
</nav>
<div class="container-fluid">
	<div id="section1" class="container-fluid" style="padding-top:70px;">
	<div class="card">
	  <div class="card-header" style="background-color: brown;color:white;text-align: center;">
	  	<h5>Home Page</h5>
	  </div>
	  <div class="card-body">
	   <div style="float: right">
				   <a class="btn btn-info" href="getNewAccountForm">Create New Account</a>
				   <a class="btn btn-info" href="getSearchByIdForm">Search Account by ID</a>
				   <a class="btn btn-info" href="getSearchAllAccountsForm">Display all Accounts or customers</a>
				   <a class="btn btn-info" href="getFundTransferForm">Transfer Funds from one account to another</a>
	   </div>
		<br/><br/>
		Technologies Used: Servlets, JSP and JDBC 
		<ul>
			<li>Create an “Account Profile” form that collects required account & customer details, received data to be sent to a servlet which is responsible to invoke appropriate service for processing to save the data into the database (Accout & Customer table).</li>
			<li>Ensure to define primary key in a Table, Primary key should be random generated value (example. from DUAL table using sequence).</li>
			<li>Whenever new Account saved (along with customer details), do acknowledge with generated “Account ID” for confirmation to client/user.</li>
		</ul>
		
		Home.jsp Contains hyperlinks with the title as listed below
		<ul>
			<li> Create New Account</li>
			<li> Search Account by ID</li>
			<li> Display all Accounts or customers</li>
			<li> Transfer Funds from one account to another</li>
		</ul>
	  </div>
	  <div class="card-footer" style="background-color: brown;color:white;text-align: center;">
	  	© 2019 DevOps: 	Bank Fund Transfer - DevOps Program Demo Example
	  </div>
	</div>
	  
	  
	</div>
</div>	
</body>
</html>