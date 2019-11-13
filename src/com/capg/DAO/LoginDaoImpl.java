package com.capg.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.model.UserRole;

public class LoginDaoImpl {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Connection getConnection() {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "web_project";
		String password = "project123";

		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public boolean validateUser(UserRole user) {
		con = getConnection();
		boolean validateFlag = false;
		try {
			ps = con.prepareStatement("select * from user_role where user_name=? and passwords=?");
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

	public String getRole(UserRole user) {

		String result = null;
		con = getConnection();

		try {

			ps = con.prepareStatement("select role_code from user_role where user_name=? and passwords=?");
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

	/*
	 * public static void main(String[] args) {
	 * 
	 * UserRole u1 = new UserRole("Admin", "Admin123"); new
	 * LoginDaoImpl().getRole(u1);
	 * 
	 * }
	 */

}
