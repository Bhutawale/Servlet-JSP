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

public class Edit extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		User user=session.get(User.class, id);
		
		Transaction transaction = session.beginTransaction();
		
		if(user!=null)
		{
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setGender(gender);
			user.setCountry(country);
			
			session.update(user);

			transaction.commit();
			
			out.println("User Updated Successfully.");

		}
		else
		{
			out.println("User Not Found.");
		}

		
		session.close();
		
		factory.close();
		out.println("<br>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewUsers.jsp");
		dispatcher.include(req, res);
	}
}
