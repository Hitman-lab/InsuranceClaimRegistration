package com.capg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capg.model.UserRole;
import com.capg.service.UserService;
import com.capg.service.UserServiceImpl;

@WebServlet({ "/ProfileCreationController", "/ProfileControl" })
public class ProfileCreationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileCreationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService user_service = new UserServiceImpl();

		String usrName = request.getParameter("user_name");
		String usrPass = request.getParameter("pass");
		String roleCode = request.getParameter("roleCode");

		UserRole newUser = new UserRole(usrName, usrPass, roleCode);
		int result = user_service.profileCreation(newUser);
		if (result > 0) {
			response.sendRedirect("CreateProfile.jsp?successMsg=Profile Created Successfully!!");
		} else {
			response.sendRedirect("CreateProfile.jsp?errorMsg=Error While Creating Profile!!");
		}

	}
}
