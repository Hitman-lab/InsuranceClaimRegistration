package com.capg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.jdbcUtility.JdbcUtility;
import com.capg.model.UserRole;

public class LoginDaoImpl implements LoginDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public boolean validateUser(UserRole user) {

		// Getting the connection
		Connection con = JdbcUtility.getConnection();

		boolean validateFlag = false;
		try {
			ps = con.prepareStatement("select * from user_role where user_name=? and password=?");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());

			rs = ps.executeQuery();
			validateFlag = rs.next();
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
		return validateFlag;
	}

	@Override
	public String getRoleCode(UserRole user) {

		// getting the connection
		Connection con = JdbcUtility.getConnection();
		String result = null;

		try {

			ps = con.prepareStatement("select role_code from user_role where user_name=? and password=?");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());

			rs = ps.executeQuery();
			rs.next();
			result = rs.getString("role_code");
//			System.out.println(result);
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

		return result;
	}

	
//	  public static void main(String[] args) {
//	  
//		
//		  
//	  UserRole u1 = new UserRole("Tanuj", "Tanuj123"); new
//	  LoginDaoImpl().getRoleCode(u1);
//	  
//	  }
	 
}
