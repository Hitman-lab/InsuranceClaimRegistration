<%@page import="com.capg.model.ClaimQuestions"%>
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
<title>Claim Questions</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<%!%>
<body>

	<%-- <jsp:useBean id=""></jsp:useBean> --%>
	<%
		ClaimService cService = new ClaimServiceImpl();

		ServletContext cContext = getServletContext();
		long policyNumber = (long) cContext.getAttribute("policyNumber");

		String claimReason = request.getParameter("claimReason");
		String incLocation = request.getParameter("claimLocation");
		String incCity = request.getParameter("incidentCity");
		String incState = request.getParameter("incidentState");
		String incZip = request.getParameter("incidentZip");
		String claimType = request.getParameter("claimType");
		String incZipCode = request.getParameter("incidentZip");

		Claim userClaim = new Claim(claimReason, incLocation, incCity, incState, incZipCode, claimType,
				policyNumber);

		long claimNumber = cService.insertClaimDetails(userClaim);
		cContext.setAttribute("claimNumber", claimNumber);
	%>
	<%
		/* ServletContext cContexts = getServletContext();
		long policyNumbers = (long) cContext.getAttribute("policyNumber"); */
		List<ClaimQuestions> questionsDetails = new ArrayList<ClaimQuestions>();

		// retirieving the policy number from the Servlet Context

		questionsDetails = cService.getAllClaimQuestions(policyNumber);
		session.setAttribute("Questions", questionsDetails);
	%>
	<div class="container" style="margin-top: 50px">
		<form action="QuestionHandler" method="post">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>QUES ID</th>
						<th>Question</th>
						<th>Choice 1</th>
						<th>Choice 2</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Questions}" var="c">
						<tr>
							<td>${c.quesId}</td>
							<td>${c.quesDesc}</td>
							<td>
								<div class="form-check">
									<input type="radio" class="form-check-input" id="check1"
										value="yes" name="${c.quesId}">
								</div>
								<div style="margin-left: 30px;">${c.quesAns1}</div>
							</td>
							<td>
								<div class="form-check">
									<input type="radio" class="form-check-input" id="check2"
										value="no" name="${c.quesId}" />
								</div>
								<div style="margin-left: 30px;">${c.quesAns2}</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="submit" value="CREATE CLAIM" class="btn btn-danger">
		</form>
	</div>
	<div class="container">
		<div class="card-header alert alert-info">
			<h5 style="color: red;">
				Claim Details Inserted With Claim Number: ${param.claim_no } and
				Policy Number:
				<%=cContext.getAttribute("policyNumber")%>
			</h5>
		</div>
	</div>
</body>
</html>