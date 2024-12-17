package com.formDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet
{

	public void doPost
		(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException 
	{
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h2>Welcome</h2>");
		String name=req.getParameter("username");
		String password=req.getParameter("userpassword");
		String email=req.getParameter("useremail");
		String gender=req.getParameter("gender");
		String course=req.getParameter("course");
		String condition=req.getParameter("condition");
		
		if(condition.equals("checked"))
		{
			writer.println("Name : "+name);
			writer.println("Password : "+password);
			writer.println("Gender : "+gender);
			writer.println("Email : "+email);
			writer.println("Course : "+course);
					
		}
		else
		{
			writer.println("Not accepted the condition");
		}
				
		
	}
	
}
