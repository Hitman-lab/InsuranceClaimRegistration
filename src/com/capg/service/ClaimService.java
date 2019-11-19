package com.capg.service;

import java.util.List;

import com.capg.model.Accounts;
import com.capg.model.Claim;
import com.capg.model.ClaimQuestions;

public interface ClaimService {
	List<ClaimQuestions> getAllClaimQuestions(long policyNumber);

	long insertClaimDetails(Claim claim);

	List<Claim> getAllClaims();

	List<Claim> getAllclaimReport();

	public Claim getClaimDetails(long policyNumber);

	String getClaimQuestions(int questionId);

	List<Accounts> getHandlerPolicyDetails(String userRole);

	List<Claim> getClaimHandlerCalim(String user_name);

	List<Claim> getInsuredClaim(String user_name);
}
