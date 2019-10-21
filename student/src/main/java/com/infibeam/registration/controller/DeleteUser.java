package com.infibeam.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String SQLUSER = "sqluser";
	private static final String SQL_PASSWORD = "sqluserpw";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) request.getAttribute("id");

		String email = request.getParameter("email");
		Connection con = null;
		PreparedStatement ps = null;

		ResultSet rs = null;
		int count = 0;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTRATION", SQLUSER, SQL_PASSWORD);
			ps = con.prepareStatement("delete from student where id=? ");
			ps.setString(1, id);
			count = ps.executeUpdate();

			if (count > 0) {
				request.setAttribute("message1", email);
				request.setAttribute("message2", "your account has been removed");

				RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
				req.forward(request, response);
			}

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
