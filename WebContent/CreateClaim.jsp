<%@page import="com.capg.service.PolicyServiceImpl"%>
<%@page import="com.capg.service.PolicyService"%>
<%@page import="com.capg.model.Policy"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claim Creation</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<%
	PolicyService psService = new PolicyServiceImpl();
%>
<body>
	<%
		List<Policy> policiesList = new ArrayList<Policy>();
		policiesList = psService.getPolicyList();
		session.setAttribute("policyList", policiesList);
	%>

	<div class="container" style="margin-top: 50px">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Policy Number</th>
					<th>Policy Type</th>
					<th>Policy Premium</th>
					<th>Account Number</th>
					<th>CREATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${policyList}" var="p">
					<tr>
						<td>${p.policy_number}</td>
						<td>${p.policyType}</td>
						<td>${p.policyPremium}</td>
						<td>${p.accountNumber}</td>
						<td><a class="btn btn-success" target="claim_a"
							href="claimCreate.jsp?policyNum=${p.policy_number}">CREATE
								CLAIM</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<iframe src="" height="550px" width="100%" style="border: none;"
			name="claim_a"></iframe>
		<iframe src="" height="550px" width="100%" style="border: none;"
			name="claim_next"></iframe>
	</div>
</body>
</html>