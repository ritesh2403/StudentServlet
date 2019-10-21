package com.infibeam.registration.business;

import java.sql.*;

public class UserValidation {

	private static final String SQL_PASSWORD = "sqluserpw";
	private static final String SQLUSER = "sqluser";

	public static boolean isUserExisting(String email, String password) {

		boolean exists = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTRATION", SQLUSER, SQL_PASSWORD);

			ps = con.prepareStatement("SELECT * from student WHERE Email=? and Password=?");

			ps.setString(1, email);
			ps.setString(2, password);

			// execute query
			rs = ps.executeQuery();
			exists = rs.next(); // if record exists then user must exist

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {

			close(rs, ps, con);
		}
		return exists;
	}

	private static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
				}
			}
		}

	}

}
