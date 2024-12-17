package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/HTML");
		PrintWriter out = res.getWriter();
		
		String uname = req.getParameter("uname");
		out.println("<h2>Welcome "+uname+" this is cookie example</h2>");
		
		Cookie c=new Cookie("uname",uname);
		
		res.addCookie(c);
		
		
		out.println("<h3><a href='servlet2'>Go to Servlet 2</a></h3>");
		
	}
}
