package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mul extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		Object sum = request.getAttribute("sum");
		
		int num1 = Integer.parseInt(request.getParameter("n1"));
		int num2 = Integer.parseInt(request.getParameter("n2"));
		
		int mul=num1*num2;
		
		writer.println("<h2>");
		writer.println("Sum is "+sum);
		writer.println("<br>");
		writer.println("Product is "+mul);
		writer.println("</h2>");
	}

}
