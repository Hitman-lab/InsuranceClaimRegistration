<%@page import="java.util.ArrayList"%>
<%@page import="com.capg.model.Policy"%>
<%@page import="java.util.List"%>
<%@page import="com.capg.service.PolicyServiceImpl"%>
<%@page import="com.capg.service.PolicyService"%>
<%@page import="com.capg.service.ClaimServiceImpl"%>
<%@page import="com.capg.service.ClaimService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Handler Check Policy</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<%
		List<Policy> policies = new ArrayList<>();
		PolicyService pService = new PolicyServiceImpl();
		String getAccNo = request.getParameter("accNum");
		long accNo = Long.parseLong(getAccNo);
		policies = pService.viewPolicies(accNo);
		session.setAttribute("policiesDetails", policies);
		if (policies.isEmpty()) {
	%>
	<div class="container" style="margin-top: 50px;">
		<div class="card-header alert alert-danger">
			<h5 style="color: red;">No policy For Account No ${param.accNum}</h5>
		</div>
	</div>
	<%
		} else {
	%>
	<div style="margin-top: 50px">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>Policy Number</th>
					<th>Policy Type</th>
					<th>Policy Premium</th>
					<th>Account Number</th>
					<th>CREATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${policiesDetails}" var="p">
					<tr>
						<td>${p.policy_number}</td>
						<td>${p.policyType}</td>
						<td>${p.policyPremium}</td>
						<td>${p.accountNumber}</td>
						<td><a class="btn btn-success" target="claim_ab"
							href="claimCreate.jsp?policyNum=${p.policy_number}">CREATE
								CLAIM</a></td>
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