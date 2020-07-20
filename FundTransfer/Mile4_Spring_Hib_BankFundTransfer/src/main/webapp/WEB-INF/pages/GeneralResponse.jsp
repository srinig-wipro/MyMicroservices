<%@ page language="java" contentType="text/html; charset=utf-8" %>
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
  	Micro Services - Workshop
  </a>
  <div class="collapse navbar-collapse" id="myNavbar">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#section1">Create New Account</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section2">Search Account by ID</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section3">Accounts / Customer Details</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section4">Fund Transfer</a>
    </li>
  </ul>
  </div>
</nav>
<div class="container-fluid">
	<div id="section1" class="container-fluid" style="padding-top:70px;">
	<div class="card">
	  <div class="card-header" style="background-color: brown;color:white;text-align: center;">
	  	<h5>Personal Details (Use of Card, Scrollspy and Grid)</h5>
	  </div>
	  <div class="card-body">
	  	<div style="float: left;width: 50%">
		  <div class="row">
			  <div class="col">Name:</div>
			  <div class="col">Shyandeep Chatterjee</div>
		  </div>
		  <div class="row">
			  <div class="col">Contact Number:</div>
			  <div class="col">XXXXXX6949</div>
		  </div>
		  <div class="row">
			  <div class="col">Designation:</div>
			  <div class="col">Project Lead</div>
		  </div>
		  <div class="row">
			  <div class="col">Practice:</div>
			  <div class="col">IBAS ( BAS CORE - CES-INDIA )</div>
		  </div>
		  <div class="row">
			  <div class="col">Vertical:</div>
			  <div class="col">IBAS</div>
		  </div><br/>
		  <div class="row"></div>
		  <div class="row" style="background-color: brown;color:white;text-align: center;">
			  <div class="col-sm-12"><b>Account Details</b></div>
		  </div>
		  <div class="row">
		    <div class="col-sm-6" style="background-color:lavender;">CUSTOMER NAME</div>
		    <div class="col-sm-6">POLITICAL</div>
		  </div>
		  <div class="row">
			  <div class="col-sm-6" style="background-color:lavender;">TENURE IN CURRENT CUSTOMER</div>
			  <div class="col-sm-6">03 Years 07 Months</div>
		  </div>
		  <div class="row">
			  <div class="col-sm-6" style="background-color:lavender;">PROJECT NAME</div>
			   <div class="col-sm-6">IGO-PDE-PJ-NRC-BAS</div> 
		  </div>
		  <div class="row">
		    <div class="col-sm-6" style="background-color:lavender;">INDENT ROLE ID</div>
		    <div class="col-sm-6">WDEVPRL3</div>
		  </div>
		  <div class="row">
			  <div class="col-sm-6" style="background-color:lavender;">INDENT ROLE NAME</div>
			  <div class="col-sm-6">DEVELOPER-L3</div>
		  </div>
		  <div class="row">
			  <div class="col-sm-6" style="background-color:lavender;">INDENT ADDITIONAL SKILL(S)</div>
			   <div class="col-sm-6">N/A</div>
		  </div>
	  </div>
	  <div class="card" style="width: 18rem;float: right;">
		  <img class="card-img-top" src="images/wipro.png" alt="Employee Image">
		  <div class="card-body" style="text-align: center;">
		    <p class="card-text">Company: Wipro Limited</p>
		  </div>
	  </div>
	  <div class="card" style="width: 18rem;float: right;">
		  <img class="card-img-top" src="images/ProfilePic.png" alt="Employee Image">
		  <div class="card-body" style="text-align: center;">
		    <p class="card-text">Employee ID: 101010</p>
		  </div>
	  </div>
	  <p>&nbsp;</p><br/><br/><br/>
	  </div> 
	  <div class="card-footer" style="background-color: brown;color:white;text-align: center;">
	  	© 2019 Copyright: Fullstack Prerequisites Assignment
	  </div>
	</div>
	  
	  
	</div>
	<div id="section2" class="container-fluid" style="padding-top:70px;"> <!-- bg-warning -->
	  <div class="card">
		  <div class="card-header"  style="background-color: brown;color:white;text-align: center;">
		  	<h5>Technical Skills (Use of Table)</h5>
		  </div>
		  <div class="card-body" style="text-align: center;">
		  	<table class="table table-striped">
			    <thead>
			      <tr style="background-color: brown;color:white;text-align: center;">
			        <th>Technologies</th>
			        <th>Years Of Experience</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>JSP</td>
			        <td>5 Years</td>
			      </tr>
			      <tr>
			        <td>Servlet</td>
			        <td>5 Years</td>
			      </tr>
			      <tr>
			        <td>Spring</td>
			        <td>5 Years</td>
			      </tr>
			      <tr>
			        <td>Hibernate</td>
			        <td>5 Years</td>
			      </tr>
			      <tr>
			        <td>JSF</td>
			        <td>5 Years</td>
			      </tr>
			      <tr>
			        <td>Struts</td>
			        <td>5 Years</td>
			      </tr>
			      <tr>
			        <td>AWS Technology</td>
			        <td>5 Years</td>
			      </tr>
			      <tr>
			        <td>Web Services</td>
			        <td>5 Years</td>
			      </tr>
			    </tbody>
			  </table>
		  </div> 
		  <div class="card-footer" style="background-color: brown;color:white;text-align: center;">
		  	© 2019 Copyright: Fullstack Prerequisites Assignment
		  </div>
	  </div>	
	  
	  <p>&nbsp;</p>
	</div>
	<div id="section3" class="container-fluid">  <!-- bg-secondary -->
	  <div class="card">
		  <div class="card-header"  style="background-color: brown;color:white;text-align: center;">
		  	<h5>Project Details (Use of Accordion)</h5>
		  </div>
		  <div class="card-body">
		  	<div id="accordion">
		    <div class="card">
		      <div class="card-header">
		        <a class="card-link" data-toggle="collapse" href="#collapseOne">
		          National Register of Citizens (NRC) #1
		        </a>
		      </div>
		      <div id="collapseOne" class="collapse show" data-parent="#accordion">
		        <div class="card-body">
		          The National Register of Citizens (NRC) is the register containing names of Indian CITIZENS. The only time that a National Register of Citizens (NRC) was prepared was in 1951 when after conduct of the Census of 1951, the NRC was prepared by recording particulars of all the persons enumerated during that Census. The NRC will be now updated to include the names of those persons (or their descendants) who appear in the NRC, 1951, or in any of the Electoral Rolls up to the midnight of 24th March, 1971 or in any one of the other admissible documents issued upto mid-night of 24th March, 1971, which would prove their presence in Assam or in any part of India on or before 24th March, 1971. All the names appearing in the NRC, 1951, or any of the Electoral Rolls up to the midnight of 24th March, 1971 together are called Legacy Data. Thus, there will be two requirements for inclusion in updated NRC – 1.) existence of a person’s name in the pre-1971 period & 2.) proving linkage with that person. For getting their names included in the updated NRC, citizens shall have to submit Applications Forms (family-wise). Application Forms received by Govt shall be verified and based on the results of verification of particulars submitted by the citizens in their Application Forms, the updated NRC shall be prepared. However, to afford another opportunity to the applicants before publication of the final NRC, a draft NRC shall be published after verification of the Application Forms and the citizens given chance to submit claims, objections, corrections etc. After verification of all such claims and objections, the final NRC would be published.
		        </div>
		      </div>
		    </div>
		    <div class="card">
		      <div class="card-header">
		        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
		        Sistema Shyam TeleServices Limited (MTS) #2
		      </a>
		      </div>
		      <div id="collapseTwo" class="collapse" data-parent="#accordion">
		        <div class="card-body">
		          Mobile TeleSystems India (MTS India), was the joint venture and Indian subsidiary of the Russian mobile operator MTS. The company was headquartered in New Delhi, India. MTS India provided wireless voice, broadband Internet, messaging and data services in India. On 1 November 2017, MTS India merged with Reliance communication.

				  The company was acquired by Reliance Communications (RCom) on 14 January 2016 in an all stock deal, in which SSTL received a 10% share in RCom. SSTL was merged into RCom on 31 October 2017.
		        </div>
		      </div>
		    </div>
		  </div>
		  </div>
		  <div class="card-footer" style="background-color: brown;color:white;text-align: center;">
		  	© 2019 DevOps: 	Bank Fund Transfer - DevOps Program Demo Example
		  </div>
	 </div>
	 <div id="section4" class="container-fluid" style="padding-top:70px;"></div>
	</div>
</div>	
</body>
</html>