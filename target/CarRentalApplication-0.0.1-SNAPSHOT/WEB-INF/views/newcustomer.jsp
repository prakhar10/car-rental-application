<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Rental Application</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"><link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/font-awesome/css/font-awesome.css"/>" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" />

</head>
<body>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-lg-offset-4">
				<div class="panel panel-primary  align-content-center">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: center">Add a new
							Customer</h4>
					</div>
					<div class="panel-body">
						<form action="savecustomer.html" method="POST"
							modelAttribute="customer">
							<div class="form-group">
								<label for="labelName">Name</label> <input type="text"
									class="form-control" id="name" name="name"
									placeholder="Enter your name" />
							</div>
							<div class="form-group">
								<label for="labelAddress">Address</label> <input type="text"
									class="form-control" id="inputAddress" name="address"
									placeholder="Enter your address" />
							</div>
							<div class="form-group">
								<label for="labelAge">Age</label> <input type="text"
									class="form-control" id="inputAge" name="age"
									placeholder="Enter your age" />
							</div>
							<div class="form-group">
								<label for="labelPhNumber">Phone Number</label> <input
									type="text" class="form-control" id="inputPhNumber"
									name="phoneNumber" placeholder="Enter your phone number" />
							</div>
							<div class="form-group">
								<label for="labelLicenseNo">License Number</label> <input
									type="text" class="form-control" id="inputLicenseNo"
									name="licenseNo" placeholder="Enter your license number" />
							</div>
							<label class="radio-inline" id="radio1"> <input
								class="form-check-input" type="radio" name="type"
								id="radioIndividual" value="individual">Individual
							</label> <label class="radio-inline" id="radio2"> <input
								class="form-check-input" type="radio" name="type"
								id="radioCompany" value="company">Company
							</label>
							<div>
								<button type="submit" class="btn btn-primary"
									style="margin-left: 20px; margin-top: 10px; display: inline">Submit</button>
								<h5 style="display: inline; font-size: 15px">${submitMessage}</h5>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>