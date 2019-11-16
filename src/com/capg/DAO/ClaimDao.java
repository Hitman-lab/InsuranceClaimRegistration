package com.capg.DAO;

import java.util.List;

import com.capg.model.Policy;

public interface ClaimDao {
	List<Policy> getPolicyList();
	boolean checkPolicyNumber(long policyNumber);
}
