package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			response.setContentType("text/html");
			String n1 = request.getParameter("n1");
			String n2 = request.getParameter("n2");
			int num1 = Integer.parseInt(n1);
			int num2 = Integer.parseInt(n2);
			
			int sum=num1+num2;
			
			request.setAttribute("sum",sum);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("mul");
			dispatcher.forward(request, response);
	}

}
