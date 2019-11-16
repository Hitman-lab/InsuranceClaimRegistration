package com.capg.service;

import java.util.List;

import com.capg.model.Policy;

public interface PolicyService {
	List<Policy> getPolicyList();
	boolean isPolicyNumber(long policyNumber);
}
