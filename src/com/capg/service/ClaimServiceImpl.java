package com.capg.service;

import java.util.List;

import com.capg.DAO.ClaimDao;
import com.capg.DAO.ClaimDaoImpl;
import com.capg.DAO.ClaimQuestionDao;
import com.capg.DAO.ClaimQuestionDaoImpl;
import com.capg.model.Claim;
import com.capg.model.ClaimQuestions;

public class ClaimServiceImpl implements ClaimService {

	ClaimQuestionDao claim = new ClaimQuestionDaoImpl();
	ClaimDao cDao = new ClaimDaoImpl();

	@Override
	public List<ClaimQuestions> getAllClaimQuestions(long policyNumber) {
		return claim.getAllClaimQuestions(policyNumber);
	}

	@Override
	public long insertClaimDetails(Claim claim) {
		return cDao.insertClaimDetails(claim);
	}

}
