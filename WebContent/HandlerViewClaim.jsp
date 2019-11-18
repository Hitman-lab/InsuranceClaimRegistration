<%@page import="com.capg.service.ClaimServiceImpl"%>
<%@page import="com.capg.service.ClaimService"%>
<%@page import="com.capg.model.Claim"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claim Handler View</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<%
		ClaimService cService = new ClaimServiceImpl();
		String user_name = request.getParameter("usrName");

		// Retrieving the Claim for Handler
		List<Claim> claims = new ArrayList<>();
		claims = cService.getClaimHandlerCalim(user_name);
		session.setAttribute("HandlerClaimView", claims);
	%>
	<div class="container" style="margin-top: 50px;">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Claim Number</th>
					<th>Claim Reason</th>
					<th>Street Name</th>
					<th>City</th>
					<th>State</th>
					<th>Pin Code</th>
					<th>Claim Type</th>
					<th>Policy Number</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${HandlerClaimView }" var="vc">
					<tr>
						<td>${vc.claimNumber }</td>
						<td>${vc.claimReason }</td>
						<td>${vc.incidentLocation }</td>
						<td>${vc.incidentCity }</td>
						<td>${vc.incidentState }</td>
						<td>${vc.incidentZip }</td>
						<td>${vc.claimType }</td>
						<td>${vc.policyNumber }</td>
					</tr>
				</c:forEach>
		</table>
	</div>
</body>
</html>