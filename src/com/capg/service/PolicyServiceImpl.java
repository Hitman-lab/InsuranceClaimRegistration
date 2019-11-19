package com.capg.service;

import java.util.List;

import com.capg.DAO.ClaimDao;
import com.capg.DAO.ClaimDaoImpl;
import com.capg.DAO.PolicyDetailsDao;
import com.capg.DAO.PolicyDetailsDaoImpl;
import com.capg.model.Policy;
import com.capg.model.PolicyDetails;

public class PolicyServiceImpl implements PolicyService {

	ClaimDao cailmDao = new ClaimDaoImpl();
	PolicyDetailsDao pdao = new PolicyDetailsDaoImpl();

	@Override
	public List<Policy> getPolicyList() {

		return cailmDao.getPolicyList();
	}

	@Override
	public boolean isPolicyNumber(long policyNumber) {
		return cailmDao.checkPolicyNumber(policyNumber);
	}

	@Override
	public int insertPolicyDetails(PolicyDetails details) {
		return pdao.insertPolicyDetails(details);
	}

	@Override
	public List<PolicyDetails> getPolicyDetails(long policyNumber) {
		return pdao.getPolicyDetails(policyNumber);
	}

	@Override
	public List<Policy> viewPolicies(long accountNumber) {
		return cailmDao.viewPolicies(accountNumber);
	}

	@Override
	public List<Policy> viewInsuredPolicy(String userName) {
		return pdao.viewInsuredPolicy(userName);
	}
}
