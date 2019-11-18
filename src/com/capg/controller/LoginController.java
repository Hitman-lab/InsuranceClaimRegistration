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

@WebServlet({ "/LoginController", "/Login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService usrService = new UserServiceImpl();

		String userName = request.getParameter("user_name");
		String userPass = request.getParameter("pass");

		// assigning the user values into the POJO class
		UserRole user = new UserRole(userName, userPass);

		// Checking the user_name and Password with database
		boolean result = usrService.validateUser(user);

		if (result) {
			String roleCode = usrService.getRoleCode(user);
			user.setRoleCode(roleCode);

			switch (roleCode) {
			case "CLAIM ADJUSTER":
				response.sendRedirect("ClaimAdjuster.jsp");
				break;

			case "CLAIM HANDLER":
				response.sendRedirect("ClaimHandler.jsp?userName=" + user.getUserName());
				break;

			case "INSURED":
				response.sendRedirect("insuredPage.jsp");
				break;

			default:
				break;
			}
		} else {
			response.sendRedirect("ErrorLogin.jsp");
		}
	}

}
