package com.capg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.jdbcUtility.JdbcUtility;
import com.capg.model.Accounts;
import com.capg.model.Claim;
import com.capg.model.Policy;
import com.sun.corba.se.impl.orb.PrefixParserAction;

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

	@Override
	public boolean checkPolicyNumber(long policyNumber) {

		boolean validatePolicy = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = JdbcUtility.getConnection();
		try {
			String query = "select * from claim where policy_number = ?";
			ps = con.prepareStatement(query);
			ps.setLong(1, policyNumber);

			rs = ps.executeQuery();
			validatePolicy = rs.next();
			// System.out.println(validatePolicy);
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

		return validatePolicy;
	}

	@Override
	public long insertClaimDetails(Claim claim) {

		PreparedStatement statement = null;

		long result = 0;
		Connection con = JdbcUtility.getConnection();
		try {

			statement = con.prepareStatement("insert into claim values(claim_number_seq.nextval,?,?,?,?,?,?,?)");
			statement.setString(1, claim.getClaimReason());
			statement.setString(2, claim.getIncidentLocation());
			statement.setString(3, claim.getIncidentCity());
			statement.setString(4, claim.getIncidentState());
			statement.setInt(5, claim.getIncidentZip());
			statement.setString(6, claim.getClaimType());
			statement.setLong(7, claim.getPolicyNumber());

			statement.executeUpdate();

			PreparedStatement ps = con.prepareStatement("select claim_number_seq.currval from dual");
			ResultSet rs = ps.executeQuery();

			rs.next();
			result = rs.getLong(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Claim> getAllClaims() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Claim> claims = new ArrayList<>();
		Connection con = JdbcUtility.getConnection();
		try {

			ps = con.prepareStatement("select * from claim");
			rs = ps.executeQuery();

			while (rs.next()) {
				Claim cl = new Claim(rs.getLong("claim_number"), rs.getString("claim_reason"),
						rs.getString("accident_location_street"), rs.getString("accident_city"),
						rs.getString("accident_state"), rs.getInt("accident_zip"), rs.getString("claim_type"),
						rs.getLong("policy_number"));
				claims.add(cl);
			}
		} catch (Exception e) {
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
		return claims;
	}

	@Override
	public Claim getClaimDetails(long policyNumber) {

		PreparedStatement ps = null;
		Claim claim = new Claim();

		Connection con = JdbcUtility.getConnection();
		try {
			ps = con.prepareStatement("select * from claim where policy_number=?");
			ps.setLong(1, policyNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				long claimNumber = rs.getLong("CLAIM_NUMBER");
				String claimReason = rs.getString("CLAIM_REASON");
				String location = rs.getString("ACCIDENT_LOCATION_STREET");
				String city = rs.getString("ACCIDENT_CITY");
				String state = rs.getString("ACCIDENT_STATE");
				int pinCode = rs.getInt("ACCIDENT_ZIP");
				String claimType = rs.getString("CLAIM_TYPE");
				long policyNum = rs.getLong("POLICY_NUMBER");

				claim = new Claim(claimNumber, claimReason, location, city, state, pinCode, claimType, policyNum);
			} else {
				System.out.println("Could not fetch the data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claim;
	}

	@Override
	public List<Accounts> getHandlerPolicyDetails(String userRole) {

		PreparedStatement ps = null;
		List<Accounts> accList = new ArrayList<>();

		Connection con = JdbcUtility.getConnection();
		try {

			ps = con.prepareStatement("select * from accounts where user_name=?");
			ps.setString(1, userRole);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Accounts acc = new Accounts();
				acc.setAccNo(rs.getLong("account_number"));
				acc.setIncName(rs.getString("insured_name"));
				acc.setUserName(rs.getString("user_name"));
				accList.add(acc);
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
		return accList;
	}

	@Override
	public List<Policy> viewPolicies(long accountNumber) {
		Connection con = JdbcUtility.getConnection();
		PreparedStatement ps = null;
		List<Policy> policies = new ArrayList<>();
		try {

			ps = con.prepareStatement("select * from policy where account_number=?");
			ps.setLong(1, accountNumber);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long policyNumber = rs.getLong("POLICY_NUMBER");
				String policyType = rs.getString("POLICY_TYPE");
				double premium = rs.getDouble("POLICY_PREMIUM");
				long accountNo = rs.getLong("ACCOUNT_NUMBER");

				Policy policy = new Policy(policyNumber, policyType, accountNo, premium);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return policies;
	}

	@Override
	public List<Claim> getClaimHandlerCalim(String user_name) {

		List<Claim> claimDetail = new ArrayList<>();
		PreparedStatement ps = null;
		Connection con = JdbcUtility.getConnection();

		String fetchClaim = "select * from claim c \n" + "inner join policy p on c.policy_number = p.policy_number\n"
				+ "inner join accounts a on p.account_number = a.account_number \n" + "where a.user_name=?";

		try {
			ps = con.prepareStatement(fetchClaim);
			ps.setString(1, user_name);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Claim cl = new Claim(rs.getLong("claim_number"), rs.getString("claim_reason"),
						rs.getString("accident_location_street"), rs.getString("accident_city"),
						rs.getString("accident_state"), rs.getInt("accident_zip"), rs.getString("claim_type"),
						rs.getLong("policy_number"));
				claimDetail.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return claimDetail;
	}

}
