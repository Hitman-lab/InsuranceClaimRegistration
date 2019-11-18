package com.capg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.jdbcUtility.JdbcUtility;
import com.capg.model.PolicyDetails;

public class PolicyDetailsDaoImpl implements PolicyDetailsDao {

	@Override
	public int insertPolicyDetails(PolicyDetails details) {

		Connection con = JdbcUtility.getConnection();
		PreparedStatement ps = null;
		int result = 0;

		try {

			ps = con.prepareStatement("insert into policy_details values(?,?,?)");
			ps.setLong(1, details.getPolicyNumber());
			ps.setInt(2, details.getQuestionId());
			ps.setString(3, details.getAnswer());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<PolicyDetails> getPolicyDetails(long policyNumber) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		Connection con = JdbcUtility.getConnection();
		List<PolicyDetails> pDetails = new ArrayList<PolicyDetails>();
		try {

			ps = con.prepareStatement("select * from policy_details where policy_number=?");
			ps.setLong(1, policyNumber);

			rs = ps.executeQuery();
			while (rs.next()) {
				long number = rs.getLong("POLICY_NUMBER");
				int qId = rs.getInt("QUESTION_ID");
				String answers = rs.getString("ANSWER");

				PolicyDetails p = new PolicyDetails(number, qId, answers);
				pDetails.add(p);
			}
//			System.out.println(pDetails);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pDetails;
	}
	
	// public static void main(String[] args) {
	// new PolicyDetailsDaoImpl().getPolicyDetails(10001);
	// }

}
