package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEmployee extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project06", "root", "root");
			String query="select * from employee";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			
			writer.println("<center><h2><a href='addEmployee.html'>Add Employee</a><h2></center>");
			
			writer.println("<h2 align='center'>Employee Information</h2>");
			writer.print("<table border='1' align='center'>");
			writer.print("<tr> <th>Id</th> <th>Name</th> <th>Password</th> <th>Email</th> <th>Country</th> <th>Delete</td> <th>Edit</th> </tr>");
			while (set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String password = set.getString(3);
				String email = set.getString(4);
				String country = set.getString(5);
				writer.print("<tr>");
				writer.print("<td>"+id+"</td>");
				writer.print("<td>"+name+"</td>");
				writer.print("<td>"+password+"</td>");
				writer.print("<td>"+email+"</td>");
				writer.print("<td>"+country+"</td>");
				writer.print("<td><a href='delete?id="+id+"'>Delete</td>");
				writer.print("<td><a href='edit?id="+id+"'>Edit</td>");
				writer.print("</tr>");
				
			}
			
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
