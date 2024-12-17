package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditEmployee extends HttpServlet 
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project06", "root", "root");
			String query="update employee set name=?,password=?,email=?,country=? where id=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(5, id);
			statement.setString(1, name);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setString(4, country);
			
			int update = statement.executeUpdate();
			
			if (update > 0) 
			{
	            writer.println("<center><h2>Record Updated Successfully.</h2><center>");
	        }
			else 
			{
	            writer.println("No records were updated.");
	        }
			writer.println("<center>");
			writer.println("<br>");
			writer.println("<a href='view'><h3>View All Employees</h3></a>");
			writer.println("</center>");
			statement.close();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			writer.println("Something went wrong!! Please try again..");
		}

		
	}
	
}
