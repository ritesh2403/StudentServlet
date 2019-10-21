package com.infibeam.registration.controller;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.infibeam.registration.business.DeleteUser;
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQLUSER = "sqluser";
	private static final String SQL_PASSWORD = "sqluserpw";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps = null;

		ResultSet rs = null;
		String id = null;

		String email = request.getParameter("email");

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTRATION", SQLUSER, SQL_PASSWORD);
			ps = con.prepareStatement("select * from student where Email=? ");
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getString("id");
				request.setAttribute("id", id);

			}

			RequestDispatcher req = request.getRequestDispatcher("deleteUser");
			req.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, ps, con);
		}

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
