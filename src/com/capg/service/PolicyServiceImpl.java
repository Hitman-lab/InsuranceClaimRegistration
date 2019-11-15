package com.capg.service;

import java.util.List;

import com.capg.DAO.ClaimDao;
import com.capg.DAO.ClaimDaoImpl;
import com.capg.model.Policy;

public class PolicyServiceImpl implements PolicyService {

	ClaimDao cailmDao = new ClaimDaoImpl();

	@Override
	public List<Policy> getPolicyList() {

		return cailmDao.getPolicyList();
	}

}
