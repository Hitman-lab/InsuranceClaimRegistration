<%@page import="java.util.ArrayList"%>
<%@page import="com.capg.model.Policy"%>
<%@page import="java.util.List"%>
<%@page import="com.capg.service.PolicyServiceImpl"%>
<%@page import="com.capg.service.PolicyService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>View Policy</title>
</head>
<body>
	<%
		PolicyService pService = new PolicyServiceImpl();
		List<Policy> pList = new ArrayList<>();

		String userName = request.getParameter("usrName");
		out.print(userName);
		pList = pService.viewInsuredPolicy(userName);

		session.setAttribute("pDetails", pList);
		if (pList.isEmpty()) {
	%>
	<div class="container" style="margin-top: 20px;">
		<div class="card-header alert alert-danger">
			<h5 style="color: red;">No Policy has Created!</h5>
		</div>
	</div>
	<%
		} else {
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
				<c:forEach items="${pDetails}" var="p">
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