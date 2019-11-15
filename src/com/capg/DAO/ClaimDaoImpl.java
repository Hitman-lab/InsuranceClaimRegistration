package com.capg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.jdbcUtility.JdbcUtility;
import com.capg.model.Policy;

public class ClaimDaoImpl implements ClaimDao {

	@Override
	public List<Policy> getPolicyList() {

		List<Policy> policyList = new ArrayList<>();
		Connection con = JdbcUtility.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from policy";
		try {

			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Policy p = new Policy();
				p.setPolicy_number(rs.getLong("policy_number"));
				p.setPolicyType(rs.getString("policy_type"));
				p.setPolicyPremium(rs.getDouble("policy_premium"));
				p.setAccountNumber(rs.getLong("account_number"));

				policyList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return policyList;
	}

}
