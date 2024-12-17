package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Loginservlet implements Servlet 
{
	ServletConfig  conf;
	
	//LifeCycle Methods.
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
		System.out.println("Creating Object");
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException 
	{
		System.out.println("Servicing");
		arg1.setContentType("text/html");
		PrintWriter writer = arg1.getWriter();
		writer.println("Servlet is running");
		writer.println(new Date().toString());
		
	}
	@Override
	public void destroy() {
		System.out.println("Destroy");
		
	}

	//Non-life cycle methods
	
	
	@Override
	public ServletConfig getServletConfig() {
		
		return conf;
	}

	@Override
	public String getServletInfo() {
		
		return "This servlet is creted by Satish";
	}

	

}
