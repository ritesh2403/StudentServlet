package com.infibeam.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infibeam.registration.business.UserValidation;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); //remove
		PrintWriter out = response.getWriter();
        boolean isvalid=false;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.isEmpty()||password.isEmpty())
		{   
			request.setAttribute("message1", "Please enter Username" +"._.");
			request.setAttribute("message2", "Please enter Password" +"._.");
			 RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
				rs.forward(request, response);
		}
		else
		{
			if (UserValidation.isUserExisting(email, password)) {
				RequestDispatcher rs = request.getRequestDispatcher("welcome.jsp");
				rs.forward(request, response); //redirect
			}
			
			else {
				request.setAttribute("message3", "Username or Password incorrect" +"._.");
	            RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
				rs.forward(request, response); //forward with message
				
			}
			
		}
	
		// passing to the validate class for validation with database
		if(isvalid)
		{
		
		}
	}
}
