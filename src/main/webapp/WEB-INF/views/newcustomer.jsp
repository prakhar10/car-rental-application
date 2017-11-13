<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Rental Application</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/font-awesome/css/font-awesome.css"/>" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" />

</head>
<body>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	
<jsp:include page="header.jsp" />

<form action="savecustomer.html" method="POST" modelAttribute="customer">
	<div class="form-group">
		<label for="labelName">Name</label>
		<input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" />
	</div>
	<div class="form-group">
		<label for="labelAddress">Address</label>
		<input type="text" class="form-control" id="inputAddress" name="address" placeholder="Enter your address" />
	</div>
	<div class="form-group">
		<label for="labelAge">Age</label>
		<input type="text" class="form-control" id="inputAge" name="age" placeholder="Enter your age" />
	</div>
	<div class="form-group">
		<label for="labelPhNumber">Phone Number</label>
		<input type="text" class="form-control" id="inputPhNumber" name="phoneNumber" placeholder="Enter your phone number" />
	</div>
	<div class="form-group">
		<label for="labelLicenseNo">License Number</label>
		<input type="text" class="form-control" id="inputLicenseNo" name="licenseNo" placeholder="Enter your license number" />
	</div>
	<div class="form-check form-check-inline">
  		<label class="form-check-label" id="radio1">
    		<input class="form-check-input" type="radio" name="type" id="radioIndividual" value="individual">Individual
  		</label>
	</div>
	<div class="form-check form-check-inline">
  		<label class="form-check-label" id="radio2">
    		<input class="form-check-input" type="radio" name="type" id="radioCompany" value="company">Company
  		</label>
	</div>
  	<div>		
  	<button type="submit" class="btn btn-primary" style="margin-left:20px;display:inline">Submit</button>
  	<h5 style="display:inline;font-size: 15px">${submitMessage}</h5>
	</div>
	
</form>

</body>
</html>