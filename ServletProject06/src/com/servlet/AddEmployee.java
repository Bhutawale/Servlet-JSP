package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployee extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project06", "root", "root");
			String query="insert into employee (name,password,email,country) values(?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setString(4, country);
			statement.executeUpdate();
			writer.println("<h3>Employee Added Successfully.</h3>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("addEmployee.html");
			dispatcher.include(req, resp);
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
			writer.println("<h2>Something went wrong!! Data not inserted.</h2>");
		}
		
	}
	
}
