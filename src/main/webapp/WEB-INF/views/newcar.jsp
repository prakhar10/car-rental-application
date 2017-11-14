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

</head>
<body>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-lg-offset-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: center">Add a new
							Car</h4>
					</div>
					<div class="panel-body">
						<form action="savecar.html" method="POST" modelAttribute="car">
							<div class="form-group">
								<label for="labelModel">Car Model</label> <input type="text"
									class="form-control" id="model" name="model"
									placeholder="Enter car model" />
							</div>
							<div class="form-group">
								<label for="labelVehicleId">Vehicle Id</label> <input
									type="text" class="form-control" id="vehicleId"
									name="vehicleId" placeholder="Enter vehicle Id" />
							</div>
							<div class="form-group">
								<label for="labelYear">Manufactured Year</label> <input
									type="text" class="form-control" id="year" name="year"
									placeholder="Enter manufacture year" />
							</div>
							<div class="form-row align-items-center">
								<div class="col-auto">
									<label class="mr-sm-2" for="inlineFormCustomSelect">Owned
										by</label> <select class="custom-select mb-2 mr-sm-2 mb-sm-0"
										id="inlineFormCustomSelect" name="ownedBy">
										<option selected>SELECT</option>
										<option value="Company">Company</option>
										<option value="Bank">Bank</option>
										<option value="Individual">Individual</option>
									</select> <label class="mr-sm-2" for="inlineFormCustomSelect">Type
										of Car</label> <select class="custom-select mb-2 mr-sm-2 mb-sm-0"
										id="inlineFormCustomSelect" name="type">
										<option selected>SELECT</option>
										<option value="Compact">Compact</option>
										<option value="Medium">Medium</option>
										<option value="Large">Large</option>
										<option value="SUV">SUV</option>
										<option value="Truck">Truck</option>
										<option value="Van">Van</option>
									</select>
								</div>
								</div>
							<div class="form-group" style="margin-top: 10px;">
								<label for="labelOwnerName">Owner Name</label> <input
									type="text" class="form-control" id="inputOwnerName"
									name="ownerName" placeholder="Enter Owner Name" />
							</div>
							<div class="form-group">
								<label for="labelDailyRate">Daily Rate ($/hour)</label> <input
									type="text" class="form-control" id="inputDailyRate"
									name="dailyRate" placeholder="Enter daily rate" />
							</div>
							<div class="form-group">
								<label for="labelPhNumber">Weekly Rate ($/hour)</label> <input
									type="text" class="form-control" id="inputWeeklyRate"
									name="weeklyRate" placeholder="Enter weekly rate" />
							</div>
							<div>
								<button type="submit" class="btn btn-primary"
									style="margin-left: 20px; display: inline">Submit</button>
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