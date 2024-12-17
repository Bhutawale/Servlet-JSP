package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Operation extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String n1=req.getParameter("num1");
		String n2=req.getParameter("num2");
		int num1=Integer.parseInt(n1);
		int num2=Integer.parseInt(n2);
		int num3=num1+num2;
		
		req.setAttribute("sum", num3);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("operation2");
		dispatcher.forward(req, resp);
	}
	
}
