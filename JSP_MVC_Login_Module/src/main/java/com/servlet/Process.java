package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Process extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		
		if(uname.equals("admin") && password.equals("admin"))
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
			dispatcher.forward(req, res);
		}
		else
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
			dispatcher.forward(req, res);
		}
	}
}
