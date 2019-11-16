package com.capg.service;

import java.util.List;

import com.capg.model.Policy;
import com.capg.model.PolicyDetails;

public interface PolicyService {
	List<Policy> getPolicyList();
	boolean isPolicyNumber(long policyNumber);
	int insertPolicyDetails(PolicyDetails details);
}
