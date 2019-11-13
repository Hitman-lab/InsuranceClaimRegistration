package com.capg.service;

import com.capg.DAO.LoginDaoImpl;
import com.capg.model.UserRole;

public class UserService {
	
	LoginDaoImpl logDao = new LoginDaoImpl();
	
	public boolean validateUser(UserRole user) {
		return logDao.validateUser(user);
	}

	public String getRoleCode(UserRole user) {
		return logDao.getRole(user);
	}
}
