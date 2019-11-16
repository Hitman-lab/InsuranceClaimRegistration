<%@page import="com.capg.service.PolicyServiceImpl"%>
<%@page import="com.capg.service.PolicyService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim Create</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="LoginFormValidation.js" type="text/javascript"></script>
</head>
<body>
	<%-- <h4>${param.policyNum }</h4> --%>
	<%
		PolicyService pService = new PolicyServiceImpl();
		long policyNumberClaim = Long.parseLong(request.getParameter("policyNum"));

		// checking the Claim has Created or not
		boolean checkPolicy = pService.isPolicyNumber(policyNumberClaim);

		if (checkPolicy == false) {
	%>

	<div class="container" style="margin-top: 50px">

		<div class="row">
			<div class="col-lg-4 col-lg-5 col-md-5" style="margin-left:;">
				<div class="card">
					<h3 class="card-header alert alert-danger" style="color: maroon;">Create
						Claim</h3>
					<div class="card-body">
						<form action="#" method="post" name="claimForm">
							<div class="form-group">
								<input type="text" class="form-control" id="claimReason"
									placeholder="Enter Claim Reason" name="claimReason"
									required="required"> <span id="claim_reason"
									style="color: red;"></span>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="location"
									placeholder="Enter Accident Location" name="claimLocation"
									required="required"> <span id="location_check"
									style="color: red;"></span>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="city"
									placeholder="Enter Accident city" name="accidentCity"
									required="required"> <span id="city_check"
									style="color: red;"></span>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="state"
									placeholder="Enter Accident State" name="accidentState"
									required="required"> <span id="state_check"
									style="color: red;"></span>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="zip"
									placeholder="Enter Accident Zip Code" name="accidentZip"
									required="required"> <span id="zipCode_check"
									style="color: red;"></span>
							</div>
							<div class="form-group">
								<select class="custom-select" id="cliamType" name="claimType">
									<option selected>Choose Claim Type .....</option>
									<option value="AUTOMOBILE">AUTOMOBILE</option>
									<option value="MEDICAL">MEDICAL</option>
									<option value="FRAUD">FRAUD</option>
									<!-- <option value="INSURED">CLAIM ADJUSTER</option> -->
								</select>
							</div>
							<!-- <input type="submit" value="Submit" class="btn btn-danger"
								onclick='return(ClaimFieldValidate())'> -->
							<a href="claimQuestions.jsp" class="btn btn-danger"
								target="claim_a">NEXT</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		} else {
	%>
	<div class="container">
		<div class="card-header alert alert-info">
			<h5 style="color: red;">Claim Has Been Created for Policy No:
				${param.policyNum }</h5>
		</div>
	</div>
	<%
		}
	%>


</body>
</html>