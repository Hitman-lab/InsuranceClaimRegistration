package com.capg.DAO;

import com.capg.model.UserRole;

public interface LoginDao {
	public boolean validateUser(UserRole user);
	public String getRoleCode(UserRole user);
}
