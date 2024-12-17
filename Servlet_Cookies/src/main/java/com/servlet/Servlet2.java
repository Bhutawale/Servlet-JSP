package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/HTML");
		PrintWriter out = res.getWriter();
		
		Cookie[] cookies = req.getCookies();
		for(Cookie c:cookies)
		{
		
			String name = c.getName();
			if(name.equals("uname"))
			{
				String u_name = c.getValue();
				out.println("<h2>Welcome back "+u_name+"</h2>");
			}
			else
			{
				out.println("<h2>You are new user</h2>");
			}
		}	
	}
}
