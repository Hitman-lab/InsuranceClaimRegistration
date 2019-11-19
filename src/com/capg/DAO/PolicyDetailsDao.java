package com.capg.DAO;

import java.util.List;

import com.capg.model.Policy;
import com.capg.model.PolicyDetails;

public interface PolicyDetailsDao {
	int insertPolicyDetails(PolicyDetails details);
	List<PolicyDetails> getPolicyDetails(long policyNumber);
	public List<Policy> viewInsuredPolicy(String userName);
}
