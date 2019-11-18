<%@page import="com.capg.service.ClaimServiceImpl"%>
<%@page import="com.capg.service.ClaimService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.capg.model.Claim"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Generation</title>
</head>
<body>
	<%
		ClaimService cService = new ClaimServiceImpl();
		List<Claim> claimReport = new ArrayList<>();
		claimReport = cService.getAllclaimReport();
		session.setAttribute("claimReport", claimReport);
		if (claimReport.isEmpty()) {
	%>
	<div class="container">
		<div class="card-header alert alert-info">
			<h4 style="color: red;">No Claims Available!!</h4>
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
					<th>Claim Type</th>
					<th>Policy Number</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${claimReport }" var="c">
					<tr>
						<td>${c.claimNumber }</td>
						<td>${c.claimReason }</td>
						<td>${c.claimType }</td>
						<td>${c.policyNumber }</td>
						<td><a class="btn btn-success" target="finalReportView"
							href="finalReport.jsp?policyNumber=${c.policyNumber}">GENERATE
								REPORT</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%
		}
	%>
	<div class="container">
		<iframe src="" height="550px" width="100%" style="border: none;"
			name="finalReportView"></iframe>
	</div>

</body>
</html>