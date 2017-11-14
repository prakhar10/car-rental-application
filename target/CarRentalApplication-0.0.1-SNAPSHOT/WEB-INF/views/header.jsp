<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Rental Application</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"><link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/font-awesome/css/font-awesome.css"/>" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" />

</head>

<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
	
<!-- 	<nav class="navbar navbar-inverse">
		<a class="navbar-brand" href="homepage.html">Car Rental Company</a>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        		<span class="sr-only">Toggle navigation</span>
       		 	<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
      		</button>
  		<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
   			<ul class="nav navbar-nav ">
      			<li class="nav-item">
        			<a class="nav-link" href="newcustomer.html">Add Customer <span class="sr-only">(current)</span></a>
      			</li>
      			<li class="nav-item">
       				<a class="nav-link" href="newcar.html">Add Car</a>
      			</li>
      			<li class="nav-item">
       				<a class="nav-link" href="rentcar.html">Rent a Car</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="updaterental.html">Update Rental Rates</a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="#">Weekly Report</a>
      			</li>
    		</ul>
  		</div>
	</nav> -->
	
<nav class="navbar navbar-inverse navbar-static-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
       	 	<span class="sr-only">Toggle navigation</span>
        	<span class="icon-bar"></span>
        	<span class="icon-bar"></span>
        	<span class="icon-bar"></span>
      	</button>
      	<a class="navbar-brand" href="homepage.html">Mavericks Car Rental </a>
    </div>
    <div class="collapse navbar-collapse justify-content-end" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="newcustomer.html">Add Customer <span class="sr-only">(current)</span></a></li>
      	<li><a href="newcar.html">Add Car</a></li>
      	<li><a href="rentcar.html">Rent a Car</a></li>
      	<li><a href="updaterental.html">Update Rental Rates</a></li>
      	<li><a href="report.html">Weekly Report</a></li>
      	<li><a href="catalog.html">Catalog</a></li>
      	<li><a href="uploaddata.html">Upload Data</a></li>
      </ul>
    </div>
  </div>
</nav>
	
</body>
</html>