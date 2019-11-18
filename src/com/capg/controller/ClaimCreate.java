package com.capg.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capg.model.Claim;
import com.capg.service.ClaimService;
import com.capg.service.ClaimServiceImpl;

@WebServlet("/ClaimCreate")
public class ClaimCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClaimCreate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClaimService cService = new ClaimServiceImpl();

		// retrieving the policy Number
		ServletContext cContext = getServletContext();
		long policyNumber = (long) cContext.getAttribute("policyNumber");

		String claimReason = request.getParameter("claimReason");
		String incLocation = request.getParameter("claimLocation");
		String incCity = request.getParameter("incidentCity");
		String incState = request.getParameter("incidentState");

		String zip = request.getParameter("incidentZip");
		int incZipCode = Integer.parseInt(zip);

		String claimType = request.getParameter("claimType");

		Claim userClaim = new Claim(claimReason, incLocation, incCity, incState, incZipCode, claimType, policyNumber);

		long claimNumber = cService.insertClaimDetails(userClaim);
		cContext.setAttribute("claimNumber", claimNumber);
		
		if (claimNumber > 0) {
			response.sendRedirect("claimQuestions.jsp?claim_no=" + claimNumber+"policyNum"+policyNumber);
		}
		
	}

}
