package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		User u1=new User(name, password, email, gender, country);
		
		session.save(u1);
		
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		out.println("User Added Successfully.");
		
		session.close();
		
		factory.close();
		out.println("<br>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("addUser.jsp");
		dispatcher.include(req, res);
	}
}
