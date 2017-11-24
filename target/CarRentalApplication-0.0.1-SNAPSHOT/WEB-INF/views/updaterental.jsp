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

<body>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	

<jsp:include page="header.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-lg-offset-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: center">Update Rental Rates</h4>
					</div>
					<div class="panel-body">
						<form action="saveupdatedrental.html" method="GET">
						<div class="form-group">
								<label class="mr-sm-2" for="inlineFormCustomSelect">Select Car Type</label>
								<div class="dropdown">
									<select class="form-control custom-select mb-2 mr-sm-2 mb-sm-0"
										id="inlineFormCustomSelect"
										name="carType">
										<option selected></option>
										<option value="Compact">Compact</option>
										<option value="Medium">Medium</option>
										<option value="Large">Large</option>
										<option value="SUV">SUV</option>
										<option value="Truck">Truck</option>
										<option value="Van">Van</option>
									</select>
								</div>
						</div>
						<div class="form-group">
						<label class="mr-sm-2" for="inlineFormCustomSelect">Daily Rate</label>
							<div class="input-group">
  									<span class="input-group-addon">$</span>
  									<input type="text" class="form-control dailyRate" name="dailyRate"aria-label="Amount (to the nearest dollar)">
							</div>
						</div>
						<div class="form-group">
						<label class="mr-sm-2" for="inlineFormCustomSelect">Weekly Rate</label>
							<div class="input-group">
  									<span class="input-group-addon">$</span>
  									<input type="text" class="form-control weeklyRate" name="weeklyRate" aria-label="Amount (to the nearest dollar)">
							</div>
						</div>
								<button class="btn btn-primary" type="submit" value="Submit" name="submit">Submit</button>
								<h5 style="display: inline; font-size: 15px">${updatedMessage}</h5>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script>
</script>
</body>
</html>