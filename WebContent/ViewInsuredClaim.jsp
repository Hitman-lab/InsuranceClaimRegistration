<%@page import="java.util.ArrayList"%>
<%@page import="com.capg.model.Claim"%>
<%@page import="java.util.List"%>
<%@page import="com.capg.service.ClaimServiceImpl"%>
<%@page import="com.capg.service.ClaimService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Insured Claim</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<%
		ClaimService cService = new ClaimServiceImpl();
		String user_name = request.getParameter("usrName");

		// retirieving the calim for insured (USED JOIN QUERY)
		List<Claim> claims = new ArrayList<>();
		claims = cService.getInsuredClaim(user_name);
		session.setAttribute("insuredClaimView", claims);

		if (claims.isEmpty()) {
	%>
	<div class="container" style="margin-top: 50px;">
		<div class="card-header alert alert-danger">
			<h5 style="color: red;">No Claim Generated!!</h5>
		</div>
	</div>
	<%
		} else {
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
				<c:forEach items="${insuredClaimView }" var="ic">
					<tr>
						<td>${ic.claimNumber }</td>
						<td>${ic.claimReason }</td>
						<td>${ic.incidentLocation }</td>
						<td>${ic.incidentCity }</td>
						<td>${ic.incidentState }</td>
						<td>${ic.incidentZip }</td>
						<td>${ic.claimType }</td>
						<td>${ic.policyNumber }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%
		}
	%>
</body>
</html>