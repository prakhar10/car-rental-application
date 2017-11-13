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

<body>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<jsp:include page="header.jsp" />

<form action="saverentcar.html" method="POST" modelAttribute="rentcar">
	<div class="form-group">
		<label for="labelStartDate">Start Date</label>
		<div class='input-group date'>
			<input type='text' class="form-control datepicker2"/>
             <span class="input-group-addon">
                 <span class="fa fa-calendar"></span>
             </span>
        </div>
   	</div>
	<div class="form-group">
		<label for="labelEndDate">End Date</label>
			<div class='input-group date'>
				<input type='text' class="form-control datepicker2" />
             		<span class="input-group-addon">
                 		<span class="fa fa-calendar"></span>
             		</span>
        	</div>
	</div>
	<div class="form-row align-items-center">
    	<div class="col-auto">
      		<label class="mr-sm-2" for="inlineFormCustomSelect">Type of Car</label>
      		<select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="inlineFormCustomSelect" name="type" onchange="testCall(this.value)">
        		<option selected>SELECT</option>
        		<option value="Compact">Compact</option>
        		<option value="Medium">Medium</option>
       			<option value="Large">Large</option>
        		<option value="SUV">SUV</option>
       		 	<option value="Truck">Truck</option>
        		<option value="Van">Van</option>
      		</select>
      		<label class="mr-sm-2" for="inlineFormCustomSelect">Available cars</label>
      		<select class="custom-select mb-2 mr-sm-2 mb-sm-0 carDropDown" name="type">
        		 <%-- <c:forEach items="${carList}" var="temp">
                    <option value="${temp}">${temp}</option>
                </c:forEach> --%>
      		</select>
    	</div>
    </div>
    <div class="container" id="table-container">
    	<div class="row">
    		<table class="table">
  				<thead>
    				<tr>
      					<th scope="col">#</th>
      					<th scope="col">Car Model</th>
      					<th scope="col">Car Type</th>
      					<th scope="col">Daily Rate ($\hr)</th>
      					<th scope="col">Weekly Rate ($\hr)</th>
    				</tr>
  				</thead>
  				<tbody>
    				<tr>
      					<th scope="row">1</th>
      						<td>Ecosport</td>
      						<td>SUV</td>
      						<td>10</td>
      						<td>50</td>
    				</tr>
    				<tr>
      					<th scope="row">2</th>
      						<td>Maruti</td>
      						<td>Compact</td>
      						<td>40</td>
      						<td>60</td>
    				</tr>
  				</tbody>
			</table>
    	</div>
   	</div>
  	<div>		
  	<button type="submit" class="btn btn-primary" style="margin-left:20px;display:inline">Submit</button>
  	<h5 style="display:inline;font-size: 15px">${submitMessage}</h5>
	</div>
	
</form>

<script>

$(document).ready(function() {
    $(".datepicker2").datepicker();
    
	$('#table-container').hide();
		$('#drpDownCars').change(function(){
			  if($('#drpDownCars').click){
			 	 $('#table-container').show(); 
			  }
		  });
	  });	  

function testCall(str) {
	console.log("in func");
    $.ajax({
        "type" : "GET",
        "url" : "testAjax.html",
        "headers": {"Accept": "application/json"},
        "async" : true,
        "data" : {
            "dropdownvalue" : str},
            success : function(data) {
            	console.log(data.get(0));
            	$.each(data, function(index, cars) {
            		$('.carDropDown').append("<option value = "+cars+">"+cars+"</option>");
                }); 
            },
            error : function() {
            	console.log("failure");
                alert("error");
            }
        });
    }

</script>
</body>
</html>