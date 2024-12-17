package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends HttpServlet 
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String firstname = req.getParameter("firstname");
		String middlename = req.getParameter("middlename");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String condition = req.getParameter("condition");
		
		int s1=Integer.parseInt(req.getParameter("sub1"));
		int s2=Integer.parseInt(req.getParameter("sub2"));
		int s3=Integer.parseInt(req.getParameter("sub3"));
		int s4=Integer.parseInt(req.getParameter("sub4"));
		int s5=Integer.parseInt(req.getParameter("sub5"));
		
		if(condition!=null)
		{
			if(condition.equals("checked"))
			{
				//writer.println("<h3>First Name :" + firstname+ "</h3>");
				//writer.println("<h3>Middle Name :" + middlename+ "</h3>");
				//writer.println("<h3>Last Name :" + lastname+ "</h3>");
				//writer.println("<h3>Email :" + email+ "</h3>");
				//writer.println("<h3>Contact :" + contact+ "</h3>");
				
				req.setAttribute("firstname", firstname);
				req.setAttribute("middlename", middlename);
				req.setAttribute("lastname", lastname);
				req.setAttribute("email", email);
				req.setAttribute("contact", contact);
				
				req.setAttribute("s1", s1);
				req.setAttribute("s2", s2);
				req.setAttribute("s3", s3);
				req.setAttribute("s4", s4);
				req.setAttribute("s5", s5);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("percentage");
				dispatcher.forward(req, resp);
				
			}
		}
		else
		{
			writer.println("<h2><center>Fill all the details correctly and check the box to proceed</center></h2>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
			dispatcher.include(req, resp);
		}
	}
	
}
