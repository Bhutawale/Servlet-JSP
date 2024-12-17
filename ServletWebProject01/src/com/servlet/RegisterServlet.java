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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String name=req.getParameter("username");
		String password=req.getParameter("userpassword");
		String email=req.getParameter("useremail");
		String gender=req.getParameter("gender");
		String course=req.getParameter("course");
		String condition=req.getParameter("condition");
		
		if(condition!=null)
		{
			if(condition.equals("checked"))
			{
		
			writer.println("Entered Details are: ");
			writer.println("<h3>Name: "+name+"<h3>");
			writer.println("<h3>Password: "+password+"</h3>");
			writer.println("<h3>Email: "+email+"</h3>");
			writer.println("<h3>Gender: "+gender+"<h3>");
			writer.println("<h3>Course: "+course+"<h3>");
			
			}
			else
			{
				writer.println("Condition Not Checked");
			}
		}
		else
		{
			writer.println("Please agree the condition!!");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
			dispatcher.forward(req, resp);
		}
		
	}
	
}
