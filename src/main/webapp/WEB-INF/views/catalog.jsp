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

<jsp:include page="header.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: center">Customer Catalog</h4>
					</div>
					<div class="panel-body">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Customer Name</th>
									<th>Customer Address</th>
									<th>Phone</th>
									<th>Customer Type</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="customer" items="${customerList}" varStatus="loop"> 
								<tr>
									<td>${loop.count }</td>
									<td>${customer.name}</td>
									<td>${customer.address }</td>
									<td>${customer.phone }</td>
									<td>${customer.customerType }</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			<br>
			<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: center">Car Catalog</h4>
					</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>Car Model</th>
								<th>Year</th>
								<th>Car Type</th>
								<th>Vehicle Id</th>
								<th>Daily Rate</th>
								<th>Weekly Rate</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="car" items="${carsList}" varStatus="loop">
							<tr>
								<td>${loop.count}</td>
								<td>${car.model }</td>
								<td>${car.year }</td>
								<td>${car.carType }</td>
								<td>${car.vehicleId }</td>
								<td>${car.dailyRate }</td>
								<td>${car.weeklyRate }</td>
								<td>${car.status }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</div>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-12">
		<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: center">Owner Catalog</h4>
					</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>Owner Name</th>
								<th>Owner Type</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="owner" items="${ownerList}" varStatus="loop">
							<tr>
								<td>${loop.count}</td>
								<td>${owner.name }</td>
								<td>${owner.ownerType }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</div>
			</div>
		</div>
		</div>
		</div>
	<script>
	
	$('.table').dataTable();
</script>
</body>
</html>