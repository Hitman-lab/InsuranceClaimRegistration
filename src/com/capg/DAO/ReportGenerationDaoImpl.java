package com.capg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.jdbcUtility.JdbcUtility;
import com.capg.model.Claim;

public class ReportGenerationDaoImpl implements ReportGenerationDao {

	@Override
	public List<Claim> getAllclaimReport() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Claim> getDetailsClaim = new ArrayList<Claim>();
		Connection con = JdbcUtility.getConnection();
		try {

			ps = con.prepareStatement("select * from claim");
			rs = ps.executeQuery();

			while (rs.next()) {
				long calimNumber = rs.getLong("claim_number");
				String claimReason = rs.getString("claim_reason");
				String claimType = rs.getString("claim_type");
				long policyNumber = rs.getLong("policy_number");
				Claim claim = new Claim(calimNumber, claimReason, claimType, policyNumber);

				getDetailsClaim.add(claim);
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
		return getDetailsClaim;
	}

}
