package com.infibeam.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infibeam.registration.business.Emailvalidation;
import com.infibeam.registration.business.UserExist;

public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isvalid = false;
		String title = request.getParameter("Title");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cnfpassword = request.getParameter("confirmPassword");
		String number = request.getParameter("phoneNumber");

		// check password and confirm password match - show msg
		// first name and last name should be between 2 to 20 chars
		// email should be valid email (use Java Regular Expression - copy from Google
		// uncle
		// number is optional for user to enter, but if entered, then it should be a
		// number of 9 digits.
		int firstName = firstname.length();
		int lastName = lastname.length();
		int num = number.length();

		
	
		
		if (title.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()
				|| cnfpassword.isEmpty()) {
			isvalid = true;
			request.setAttribute("title", "Please Enter Title");
			request.setAttribute("firstname", "Please Enter First Name");
			request.setAttribute("lastname", "Please Enter Last Name");
			request.setAttribute("email", "Please Enter Email");
			request.setAttribute("password", "Please Enter Password");
			request.setAttribute("cnfpassword", "Please Enter Confirm Password");

		}
		if (firstname != null && !firstname.equals("") || lastname != null && !lastname.equals("")) {
			if (firstName < 2 || firstName > 20 && lastName < 2 || lastName > 20) {
				isvalid = true;
				request.setAttribute("message1", "firstname & lastname must be in between 2 to 20");
			}
		}

		if (Emailvalidation.isemailvalid(email)) {
			isvalid = true;
			request.setAttribute("message2", "email is invalid");
		}

		if (!password.equals(cnfpassword)) {
			isvalid = true;
			request.setAttribute("message3", "password and confirmpassword should be same");
		}

		if (number != null && !number.equals("")) {
			if (num != 10) {
				isvalid = true;
				request.setAttribute("message4", "Mobile number should be of only 10 digit");
			}
		}

		if (isvalid) {
			RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
			req.forward(request, response);
		} else if (UserExist.isUserExist(email)) {

			request.setAttribute("message1", "user already exist please log in");
			RequestDispatcher req = request.getRequestDispatcher("login.jsp");
			req.forward(request, response);

		} else {

			RequestDispatcher req = request.getRequestDispatcher("save");
			req.forward(request, response);

		}
	}
}
