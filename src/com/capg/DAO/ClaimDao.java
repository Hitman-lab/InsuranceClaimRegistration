package com.capg.DAO;

import java.util.List;

import com.capg.model.Accounts;
import com.capg.model.Claim;
import com.capg.model.Policy;

public interface ClaimDao {
	List<Policy> getPolicyList();

	boolean checkPolicyNumber(long policyNumber);

	long insertClaimDetails(Claim claim);

	List<Claim> getAllClaims();

	public Claim getClaimDetails(long policyNumber);

	public List<Accounts> getHandlerPolicyDetails(String userRole);

	List<Policy> viewPolicies(long accountNumber);
	
	public List<Claim> getClaimHandlerCalim(String user_name);
}
