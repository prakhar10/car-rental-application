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
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title" style="text-align: center">Rent a Car</h4>
					</div>
					<div class="panel-body">
						<form class="form-inline" action="saverentcar.html">
							<div class="form-group">
								<label for="labelStartDate">Start Date </label>
								<div class='input-group date'>
									<input type="text" class="form-control datepicker2"
										id="startDate" placeholder="Pick Start date" name="startDate"><span
										class="input-group-addon"> <span class="fa fa-calendar"></span>
									</span> </span>
								</div>
							</div>
							<div class="form-group">
								<label for="labelStartDate">Return Date </label>
								<div class='input-group date'>
									<input type="text" class="form-control datepicker2"
										id="returnDate" placeholder="Pick Return date"
										name="returnDate"><span class="input-group-addon">
										<span class="fa fa-calendar"></span>
									</span> </span>
								</div>
							</div>
							<div class="form-group">
								<label class="mr-sm-2" for="inlineFormCustomSelect">Select Car Type</label>
								<div class="dropdown">
									<select class="form-control custom-select mb-2 mr-sm-2 mb-sm-0"
										id="inlineFormCustomSelect" name="type"
										onchange="getAvailableCars(this.value)">
										<option selected>Select</option>
										<option value="Compact">Compact</option>
										<option value="Medium">Medium</option>
										<option value="Large">Large</option>
										<option value="SUV">SUV</option>
										<option value="Truck">Truck</option>
										<option value="Van">Van</option>
									</select>
								</div>
							</div>

							<div class="panel panel-primary tablepanel" style="margin:20px;">
								<!-- Default panel contents -->
								<div class="panel-heading">Cars Available</div>

								<!-- Table -->
								<table class="table table-bordered" data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th>Car Model</th>
											<th>Car Type</th>
											<th>Vehicle Id</th>
											<th>Daily Rate ($/hour)</th>
											<th>Weekly Rate ($/hour)</th>	
										</tr>
									</thead>
									<tbody class="tablebody">
									</tbody>
								</table>
							</div>
								<button class="btn btn-primary" type="submit" value="submit" name="submit">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script>
$(document).ready(function() {
    $(".datepicker2").datepicker();
    $(".btn").hide();
	$('.tablepanel').hide();
	
	$('.dropdown').change(function(){
		if($('.dropdown').click){
			$('.tablepanel').show(); 
		}
	});
});	  

function getAvailableCars(str) {
    $.ajax({
        "type" : "GET",
        "url" : "testAjax.html",
        //"headers": {"Accept": "application/json"},
        "async" : true,
        "dataType": 'json',
        "data" : {
            "dropdownvalue" : str},
            success : function(data) {
            	console.log('response success ajax call');
            	//$('.carDropDown').html('');
            	$.each(data,function(index,car){
            		$('.tablebody').append("<tr><td><input type='radio' name='radio'></td><td>"+car.model+"</td><td>"+car.type+"</td><td>"+car.vehicleId+"</td><td>"+car.dailyRate+"</td><td>"+car.weeklyRate+"</td></tr>");
            	}); 
            	$('.btn').show();
            },
            error : function(request, error,xhr) {
            	console.log("failure"+error+xhr);
                alert("error");
            }
        });
    }
</script>
</body>
</html>