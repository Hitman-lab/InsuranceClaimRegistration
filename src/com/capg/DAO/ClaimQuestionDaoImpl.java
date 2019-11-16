package com.capg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.jdbcUtility.JdbcUtility;
import com.capg.model.ClaimQuestions;

public class ClaimQuestionDaoImpl implements ClaimQuestionDao {

	@Override
	public List<ClaimQuestions> getAllClaimQuestions(long policyNumber) {

		List<ClaimQuestions> claimsQ = new ArrayList<>();
		Connection con = JdbcUtility.getConnection();

		String query = "select * from claim_questions where policy_type in "
				+ "(select policy_type from policy where policy_number=? )";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, policyNumber);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ques_id");
				String policyType = rs.getString("policy_type");
				String question = rs.getString("ques_desc");
				String answer1 = rs.getString("ques_ans1");
				String answer2 = rs.getString("ques_ans2");

				ClaimQuestions claimQues = new ClaimQuestions(id, policyType, question, answer1, answer2);
				claimsQ.add(claimQues);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return claimsQ;
	}

}