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

public class DeleteEmployee extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		int id =Integer.parseInt(req.getParameter("id"));
		//writer.println(id);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project06", "root", "root");
			String query="delete from employee where id=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			int delete = statement.executeUpdate();
			
			if(delete>0)
			{
				writer.println("<center><h2>Data Deleted Successfully<h2><center>");
			}
			else
			{
				writer.println("Something went wrong!!");
			}
			
			writer.println("<center><h3><a href='view'>View All Employees</a><h3></center>");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			writer.println("Something went wrong!!");
		}
		
	}
	
}
