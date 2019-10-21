package com.infibeam.registration.controller;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
 
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.infibeam.registration.business.StudentDao;  
public class ViewServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
     response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     out.println("<body>");  
     out.println("<h1>Student List</h1>");  
       
     List<Student> list=StudentDao.getAllStudent();  
       
     out.print("<table border='1' width='100%'");  
     out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email Id</th><th>Password</th><th>Confirm Password</th><th>Contact</th><th>Delete</th></tr>");  
    
     for(Student e:list){  
    	  out.print("<tr><td>"+e.getId()+"</td><td>"+e.getFirstname()+"</td><td>"+e.getLastname()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+"</td><td>"+e.getConfirmpasssword()+"</td><td>"+e.getContact()+
    			  "</td><td><a href=deleteservlet?id="+e.getId()+">delete</a></td>");
     }  
    
     out.print("</table>");  
 
   out.println("</body>");  
     out.close();  
 }  
}
