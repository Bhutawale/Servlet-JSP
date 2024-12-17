package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServerException,IOException
	{
		res.setContentType("text/HTML");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		
		out.println("<h2>Welcome "+name+"<h2>");
		
		out.println("<a href='Servlet2?uname="+name+"'>Go to Servlet 2</a>");
	}
}
