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
  	Banking Example <span style="margin-left: 35%;">Account Tracker Solution With J2EE Application</span>
  </a>
</nav>
<div class="container-fluid">
	<div id="section1" class="container-fluid" style="padding-top:70px;">
	<div class="card">
	  <div class="card-header" style="background-color: brown;color:white;text-align: center;">
	  	<h5>Transfer Funds From One Account To Another - Page</h5>
	  </div>
	  <div class="card-body">
	   <div style="float: right">
				   <a class="btn btn-info" href="../Mile2_BankFundTransfer/Home.jsp">Back To Home</a>
	   </div>
		<br/><br/>
			When the submit button clicked on "TransferFunds.jsp page", this method would be executed to invoke either transferFunds() to process further based on given input with necessary validations. <br/><br/>
			<form action="FundTransferServlet" method="POST">
			    <div class="form-group row">
				  <div class="col-xs-4">
				    <label for="from">Account From</label>
				    <input class="form-control" id="from" type="text" name="from">
				  </div>
				  <div class="col-xs-3">&nbsp;</div>
				  <div class="col-xs-4">
				    <label for="to">Account To</label>
				    <input class="form-control" id="to" type="text" name="to">
				  </div>
				  <div class="col-xs-3">&nbsp;</div>
				  <div class="col-xs-3">
				    <label for="amount">Amount Transfer</label>
				    <input class="form-control" id="amount" type="text" name="amount">
				  </div>
				</div>  
			  <p  style="text-align: right"><button type="submit" class="btn btn-success">Transfer Money</button></p>
			</form>
			<c:choose>
				<c:when test="${msg eq 'ID MISMATCH'}">
					<div class="alert alert-primary" role="alert" style="text-align: left;">
						${errorMsg} 
					</div>	
				</c:when>
				<c:when test="${msg eq 'INSUFFICIENT FUNDS'}">
					<div class="alert alert-danger" role="alert" style="text-align: center;">
						${errorMsg}
					</div>
				</c:when>
				<c:when test="${msg eq 'SUCCESS'}">
					<div class="alert alert-danger" role="alert" style="text-align: center;">
						 Fund Transfer is Success! <br/> 
						 ${successMsg} 
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