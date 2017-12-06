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
						<form action="saverentcar.html" modelAttribute="rental" method="post">
						<div class="form-group">
							<label for="inlineFormCustomSelect" style="margin-top: 10px">Select Customer Type</label>
						 	<div>
						 		<label class="radio-inline" id="radio1" style="margin-left: 0px">
						 	 		<input	class="form-check-input customerType" type="radio" name="custType"
									id="radioIndividual" value="Individual">Individual
								</label>
								<label class="radio-inline " id="radio2"> <input
									class="form-check-input customerType" type="radio" name="custType"
									id="radioCompany" value="Company">Company
								</label>
							</div>
						</div>
						<div class="form-group">
								<label class="mr-sm-2" for="inlineFormCustomSelect" style="margin-top: 10px">Select Customer</label>
								<div class="dropdown customerDropdown">
									<select class="form-control customer-select mb-2 mr-sm-2 mb-sm-0"
										id="inlineFormCustomSelect" name="customerName" >
									</select>
								</div>
						</div>
							<div class="form-group">
								<label for="labelStartDate">Start Date </label>
								<div class='input-group date'>
									<input type="text" class="form-control datepicker2"
										id="startDate" placeholder="Pick Start date" name="startDate"><span
										class="input-group-addon"> <span class="fa fa-calendar"></span>
									</span> </span>
								</div>
							</div>
							
								<div class="form-group rentaltype">
							<label for="inlineFormCustomSelect" style="margin-top: 10px">Select Rental Type</label>
						 	<div>
						 		<label class="radio-inline" id="radio3" style="margin-left: 0px">
						 	 		<input	class="form-check-input daily" type="radio" name="rentalType"
									id="radioDaily" value="Daily">Daily
								</label>
								<label class="radio-inline" id="radio4"> <input
									class="form-check-input weekly" type="radio" name="rentalType"
									id="radioWeekly" value="Weekly">Weekly
								</label>
							</div>
						</div>
							
							<div class="form-group days">
								<label for="labelStartDate">Number of Days</label>
								<div class='input-group date'>
									<input type="text" class="form-control"
										 placeholder="Number of Days"
										name="noOfDays"><span class="input-group-addon">
									</span>
								</div>
							</div>
							<div class="form-group weeks">
								<label for="labelStartDate">Number of Weeks</label>
								<div class='input-group date'>
									<input type="text" class="form-control"
										 placeholder="Number of Weeks"
										name="noOfWeeks"><span class="input-group-addon">
									</span>
								</div>
							</div>
							<div class="form-group">
								<label class="mr-sm-2" for="inlineFormCustomSelect">Select Car Type</label>
								<div class="dropdown carTypeDropDown">
									<select class="form-control custom-select mb-2 mr-sm-2 mb-sm-0"
										id="inlineFormCustomSelect" name="carType"
										onchange="getAvailableCars(this.value)">
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

							<div class="panel panel-primary tablepanel" style="margin:20px;">
								<div class="panel-heading">Cars Available</div>
								<!-- Table -->
								<table class="table table-bordered" data-click-to-select="true">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th name="carModel">Car Model</th>
											<th name="carType">Car Type</th>
											<th name="vehicleId">Vehicle Id</th>
											<th name="year"> Manufacture Year</th>
											<th name="dailyRate">Daily Rate</th>
											<th name="weeklyRate">Weekly Rate</th>	
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
    $('.btn').prop('disabled', true);
	$('.tablepanel').hide();
	
	$('.carTypeDropDown').change(function(){
		if($('.carTypeDropDown').click){
			$('.tablepanel').show(); 
		}
	});
});	  

function getAvailableCars(str) {
    $.ajax({
        "type" : "GET",
        "url" : "testAjax.html",
        "async" : true,
        "dataType": 'json',
        "data" : {
            "dropdownvalue" : str},
            success : function(data) {
            	$('.tablebody').html('');
            	console.log("size:"+data.length);
            	$.each(data,function(index,car){
            		$('.tablebody').append("<tr><td><input type='radio' name='radioBtn'></td><td>"+car.model+"</td><td>"+car.carType+"</td><td>"+car.vehicleId+"</td><td>"+car.year+"</td><td>"+car.dailyRate+"</td><td>"+car.weeklyRate+"</td></tr>");
            	}); 
                $('.btn').prop('disabled', false);
            },
            error : function(request, error) {
            	console.log("failure-"+error );
                alert("error");
            }
        });
    }
 
$('.customerType').click(function(){
	var custtype = $("input[name='custType']:checked").val();
	console.log("val:"+custtype);
	$.ajax({
        "type" : "GET",
        "url" : "getcustomers.html",
        "async" : true,
        "dataType": 'json',
        "data" : {"customerTypeId" : custtype},
            success : function(data) {
            	$('.customer-select').html('');
            	$.each(data,function(index,name){
            		$('.customer-select').append("<option value='"+name+"'>"+name+"</option>");
            	}); 
            },
            error : function(request, error) {
            	console.log("failure"+ error);
                alert("error");
            }
        });
	
});

var list;

$(document).on('click', ':radio[name="radioBtn"]', function () {
    list = $(this).parent().nextAll().map(function () {
        return $(this).text();
    }).get();
    
    
    $.ajax({
        "type" : "POST",
        "url" : "getCarDetails.html",
        "async" : true,
        "data" : 
        		{"carModel" : list[0],
        		 "carType" : list[1],
        		 "vehicleId" : list[2],
        		 "dailyRate" : list[4],
        		 "weeklyRate" : list[5]
        		},
            success : function(data) {
            	console.log("Data sent successfully"); 
            },
            error : function(request, error) {
            	console.log("failure"+ error);
                alert("error :"+ error);
            }
        });
});    
   

$('.days').hide();
$('.weeks').hide();
   
$('.daily').change(function(){
	if($('.daily').click){
		$('.days').show(); 
		$('.weeks').hide();
	}
});


$('.weekly').change(function(){
	if($('.weekly').click){
		$('.weeks').show(); 
		$('.days').hide(); 
	}
});
   
/* $('.btn').click(function(){
	$.ajax({
        "type" : "POST",
        "url" : "getCarDetails.html",
        "async" : true,
        "data" : 
        		{"carModel" : list[0],
        		 "carType" : list[1],
        		 "vehicleId" : list[2],
        		 "dailyRate" : list[4],
        		 "weeklyRate" : list[5]
        		},
            success : function(data) {
            	console.log("Data sent successfully"); 
            },
            error : function(request, error) {
            	console.log("failure"+ error);
                alert("error :"+ error);
            }
        });
	
}); */
    
</script>
</body>
</html>