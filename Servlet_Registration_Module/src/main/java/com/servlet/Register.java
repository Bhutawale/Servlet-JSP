package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServerException,IOException
	{
		res.setContentType("text/HTML");
		PrintWriter out = res.getWriter();
		
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		//connecting to database using jdbc
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_servlet","root","root");
		String sql1="insert into register (uname,password,email) values (?,?,?)";
		
		PreparedStatement prepareStatement = con.prepareStatement(sql1);
		prepareStatement.setString(1, uname);
		prepareStatement.setString(2, password);
		prepareStatement.setString(3, email);
		
		prepareStatement.executeUpdate();
		con.close();
		out.println("Data inserted successfully!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Something Went Wrong!!");
		}
	}
}
