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
						<h4 class="panel-title" style="text-align: center">Return Car</h4>
					</div>
					<div class="panel-body">
						<form action="returncar1.html" modelAttribute="returncar" method="get">
						
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
						
						
						<button class="btn btn-primary" type="submit" value="submit" name="submit">Return Car</button>
						
						<div class="form-group amount" style="margin-top: 10px">
						<label class="mr-sm-2" for="inlineFormCustomSelect">Amount To be Paid : </label>
  							<label><h4>${amount}$</h4></label>
						</div>						
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script>
$(".datepicker2").datepicker();

	
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


</script>
</body>
</html>