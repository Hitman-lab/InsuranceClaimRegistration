package com.capg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		}
		return result;
	}

}
