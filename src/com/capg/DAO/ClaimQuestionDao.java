package com.capg.DAO;

import java.util.List;

import com.capg.model.ClaimQuestions;

public interface ClaimQuestionDao {

	List<ClaimQuestions> getAllClaimQuestions(long policyNumber);
}
