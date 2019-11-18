<%@page import="com.capg.model.Accounts"%>
<%@page import="java.util.List"%>
<%@page import="com.capg.model.UserRole"%>
<%@page import="com.capg.service.ClaimServiceImpl"%>
<%@page import="com.capg.service.ClaimService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Claim Creation</title>
</head>
<body>
	<%
		ClaimService cService = new ClaimServiceImpl();
		String userRole = request.getParameter("usrName");
		/* out.print(userRole); */
		List<Accounts> accDetails = cService.getHandlerPolicyDetails(userRole);
		session.setAttribute("accDetails", accDetails);
		if (accDetails.isEmpty()) {
	%>
	<div class="container" style="margin-top: 50px;">
		<div class="card-header alert alert-danger">
			<h5 style="color: red;">No Insured registered!</h5>
		</div>
	</div>
	<%
		} else {
	%>
	<div class="container" style="margin-top: 50px;">
		<div class="card-header alert alert-danger">
			<h5 style="color: red;">Welcome "${param.usrName}" Your INSURED
				Person's are</h5>
		</div>
	</div>

	<div class="container" style="margin-top: 10px;">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>Account Number</th>
					<th>Insured Name</th>
					<th>Handler Name</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${accDetails }" var="vc">
					<tr>
						<td>${vc.accNo }</td>
						<td>${vc.incName }</td>
						<td>${vc.userName }</td>
						<td><a class="btn btn-success" target="claim_a"
							href="HandlerCheckPolicy.jsp?accNum=${vc.accNo}">Check Policy</a>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<%
		}
	%>
	<div class="container">
		<iframe src="" height="250px" width="100%" style="border: none;"
			name="claim_a"></iframe>
		<iframe src="" height="550px" width="100%" style="border: none;"
			name="claim_ab"></iframe>
	</div>
</body>
</html>