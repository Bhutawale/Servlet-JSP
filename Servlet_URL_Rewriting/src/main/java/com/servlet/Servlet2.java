package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServerException,IOException
	{
		res.setContentType("text/Html");
		PrintWriter out = res.getWriter();
		
		String uname = req.getParameter("uname");
		
		out.println("<h2>Welcome Back "+uname+"</h2>");
	}
}
