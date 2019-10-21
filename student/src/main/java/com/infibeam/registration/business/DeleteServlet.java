package com.infibeam.registration.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException{
		doPost(request,response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  

        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        StudentDao.delete(id);
        response.sendRedirect("viewservlet");  
}
}