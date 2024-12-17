package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String username=req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
				
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project04", "root", "root");
		 	String query="insert into user(name,password,email) values (?,?,?)";
		 	PreparedStatement statement = con.prepareStatement(query);
		 	statement.setString(1, username);
		 	statement.setString(2, password);
		 	statement.setString(3, email);
		 	statement.executeUpdate();
		 	writer.println("Data Inserted and Registered Successsfully");
		 	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			writer.println("Something went Wrong");
		}
		
	}
	
}
