package com.capg.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capg.model.PolicyDetails;
import com.capg.service.PolicyService;
import com.capg.service.PolicyServiceImpl;

@WebServlet({ "/ClaimQuestionsHandler", "/QuestionHandler" })
public class ClaimQuestionsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClaimQuestionsHandler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext conText = getServletContext();
		PolicyService pService = new PolicyServiceImpl();

		long policyNumber = (long) conText.getAttribute("policyNumber");
		long claimNumber = (long) conText.getAttribute("claimNumber");

//		System.out.println(claimNumber);

		for (int i = 1; i < 5; i++) {
			int quesId = i;
			String ans = request.getParameter(Integer.toString(i));
			PolicyDetails details = new PolicyDetails(policyNumber, quesId, ans);
			pService.insertPolicyDetails(details);
		}
		if (claimNumber > 0) {
			response.sendRedirect("claimQuestions.jsp?claim_no=" + claimNumber);
		}
	}
}
