package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println("<h3>Registration..</h3>");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String course = req.getParameter("course");
		String condition = req.getParameter("condition");
		
		if(condition!=null)
		{
			if(condition.equals("checked"))
			{
			writer.println(name+"<br>");
			writer.println(password+"<br>");
			writer.println(email+"<br>");
			writer.println(gender+"<br>");
			writer.println(course);
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("SuccessServlet");
			dispatcher.forward(req, res);
		}
		else
		{
			writer.println("<h2>You have not accepted terms and conditions..</h2>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
			dispatcher.include(req, res);
		}
		
		
		
		
	}
	
}
