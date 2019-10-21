package com.infibeam.registration.business;

import java.util.*;

import javax.ws.rs.core.Response;

import com.infibeam.registration.controller.Student;

import java.sql.*;  

public class StudentDao {

	private static final String SQL_PASSWORD = "sqluserpw";
	private static final String SQLUSER = "sqluser";
	   
	 
	public static List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		
		  
		   Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
		   List<Student> list=new ArrayList<Student>(); 
		   
		   	   
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTRATION", SQLUSER, SQL_PASSWORD);
				ps = con.prepareStatement("SELECT * from student");
			    rs=ps.executeQuery();  
			    
			    while(rs.next()){  
	                Student s=new Student();  
	                s.setId(rs.getInt(1));  
	                s.setFirstname(rs.getString(2));  
	                s.setLastname(rs.getString(3));
	                s.setEmail(rs.getString(4));
	                s.setPassword(rs.getString(5));
	                s.setConfirmpasssword(rs.getString(6));
	                s.setContact(rs.getString(7));
	                list.add(s);  
	            }  
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			finally {
				close(rs, ps, con);
			}
		return list;
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
	public static int delete(int id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTRATION", SQLUSER, SQL_PASSWORD);
			ps = con.prepareStatement("delete from student where id=? ");
			ps.setInt(1,id);
			count = ps.executeUpdate();
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(rs, ps, con);
			
		}
		return count;
		

		
	}
	
	}
