package com.capg.service;

import com.capg.DAO.LoginDao;
import com.capg.DAO.LoginDaoImpl;
import com.capg.model.UserRole;

public class UserServiceImpl implements UserService{
	
	LoginDao logDao = new LoginDaoImpl();
	
	public boolean validateUser(UserRole user) {
		return logDao.validateUser(user);
	}

	public String getRoleCode(UserRole user) {
		return logDao.getRoleCode(user);
	}
}
