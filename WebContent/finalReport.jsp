<%@page import="com.capg.model.PolicyDetails"%>
<%@page import="com.capg.service.PolicyServiceImpl"%>
<%@page import="com.capg.service.PolicyService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.capg.model.Claim"%>
<%@page import="java.util.List"%>
<%@page import="com.capg.service.ClaimServiceImpl"%>
<%@page import="com.capg.service.ClaimService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Generation</title>
</head>
<body>
	<!-- 	<h4>Final Report will be print here!! progress is going
		on...........</h4> -->
	<%
		String policyNo = request.getParameter("policyNumber");
		long policyNumber = (long) Long.parseLong(policyNo);

		Claim claim = new Claim();
		ClaimService cService = new ClaimServiceImpl();
		claim = cService.getClaimDetails(policyNumber);
		session.setAttribute("claimObj", claim);

		// retrieving the Questions Id and answers from the policyDetails
		List<PolicyDetails> pList = new ArrayList<>();
		PolicyService pService = new PolicyServiceImpl();
		pList = pService.getPolicyDetails(policyNumber);
		session.setAttribute("policyDetails", pList);

		// retrieving the questions from the database
	%>

	<jsp:useBean id="claimObj" class="com.capg.model.Claim" scope="session"></jsp:useBean>
	<div class="container" style="margin-top: 50px;">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>CLAIM REPORT</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Calim Number</td>
					<td>${claimObj.claimNumber }</td>
				</tr>
				<tr>
					<td>Calim Reason</td>
					<td>${claimObj.claimReason }</td>
				</tr>
				<tr>
					<td>Calim Location</td>
					<td>${claimObj.incidentLocation }</td>
				</tr>
				<tr>
					<td>Calim City</td>
					<td>${claimObj.incidentCity }</td>
				</tr>
				<tr>
					<td>Calim State</td>
					<td>${claimObj.incidentState }</td>
				</tr>
				<tr>
					<td>Pin Code</td>
					<td>${claimObj.incidentZip }</td>
				</tr>
				<tr>
					<td>Calim Type</td>
					<td>${claimObj.claimType }</td>
				</tr>
				<tr>
					<td>Policy Number</td>
					<td>${claimObj.policyNumber }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container" style="margin-top: 0px;">
		<table class="table">
			<thead class="thead-light">
				<!-- 			<tr>
					<th>Question ID</th>
					<th>Question DESC</th>
					<th>Answer</th>
				</tr> -->
			</thead>
			<tbody>
				<tr>
					<%
						for (PolicyDetails pDetails : pList) {
							out.println("<td>" + pDetails.getQuestionId() + "</td>");
							String question = cService.getClaimQuestions(pDetails.getQuestionId());
							out.println("<td>" + question + "</td>");
							out.println("<td>" + pDetails.getAnswer() + "</td>");
						}
					%>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>