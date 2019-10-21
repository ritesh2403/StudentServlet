package com.infibeam.registration.controller;

import java.sql.*;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SaveUser extends HttpServlet {

	private static final String SQL_PASSWORD = "sqluserpw";
	private static final String SQLUSER = "sqluser";
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cnfpassword = request.getParameter("confirmPassword");
		String number = request.getParameter("phoneNumber");

		String query = "insert into student(FirstName,lastName,Email,Password,ConfirmPassword,Contact) values (?,?,?,?,?,?)";
		try {
			int count = 0;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTRATION", SQLUSER, SQL_PASSWORD);
			ps = con.prepareStatement(query);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, cnfpassword);
			ps.setString(6, number);
			count = ps.executeUpdate();

			if (count > 0) {

				request.setAttribute("success", "user successfully registerd");
				RequestDispatcher req = request.getRequestDispatcher("login.jsp");
				req.forward(request, response);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
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
