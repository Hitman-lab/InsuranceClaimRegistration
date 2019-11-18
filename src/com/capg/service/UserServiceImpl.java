package com.capg.service;

import com.capg.DAO.LoginDao;
import com.capg.DAO.LoginDaoImpl;
import com.capg.DAO.ProfileCreationDao;
import com.capg.DAO.ProfileCreationDaoImpl;
import com.capg.model.UserRole;

public class UserServiceImpl implements UserService {

	LoginDao logDao = new LoginDaoImpl();
	ProfileCreationDao pDao = new ProfileCreationDaoImpl();

	@Override
	public boolean validateUser(UserRole user) {
		return logDao.validateUser(user);
	}

	@Override
	public String getRoleCode(UserRole user) {
		return logDao.getRoleCode(user);
	}

	@Override
	public int profileCreation(UserRole newUser) {
		return pDao.profileCreation(newUser);
	}
}
