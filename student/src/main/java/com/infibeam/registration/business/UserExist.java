package com.infibeam.registration.business;

import java.sql.*;

public class UserExist {

	private static final String SQL_PASSWORD = "sqluserpw";
	private static final String SQLUSER = "sqluser";

	public static boolean isUserExist(String email) {
		boolean exists = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTRATION", SQLUSER, SQL_PASSWORD);

			ps = con.prepareStatement("SELECT * from student WHERE Email=? ");

			ps.setString(1, email);

			rs = ps.executeQuery();

			if (rs.next()) {
				exists = true;

			}
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
