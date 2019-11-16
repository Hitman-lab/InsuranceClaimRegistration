package com.capg.service;

import java.util.List;

import com.capg.model.Claim;
import com.capg.model.ClaimQuestions;

public interface ClaimService {
	List<ClaimQuestions> getAllClaimQuestions(long policyNumber);
	long insertClaimDetails(Claim claim);
}
