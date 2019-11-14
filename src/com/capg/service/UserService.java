package com.capg.service;

import com.capg.model.UserRole;

public interface UserService {
	public boolean validateUser(UserRole user);

	public String getRoleCode(UserRole user);

	public int profileCreation(UserRole user);
}
