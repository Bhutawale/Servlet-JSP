package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Percentage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String firstname = (String) req.getAttribute("firstname");
		String middlename = (String) req.getAttribute("middlename");
		String lastname = (String) req.getAttribute("lastname");
		String email = (String) req.getAttribute("email");
		String contact = (String) req.getAttribute("contact");

		writer.println("<h3>First Name :" + firstname + "</h3>");
		writer.println("<h3>Middle Name :" + middlename + "</h3>");
		writer.println("<h3>Last Name :" + lastname + "</h3>");
		writer.println("<h3>Email :" + email + "</h3>");
		writer.println("<h3>Contact :" + contact + "</h3>");

		int m1 = (int) req.getAttribute("s1");
		int m2 = (int) req.getAttribute("s2");
		int m3 = (int) req.getAttribute("s3");
		int m4 = (int) req.getAttribute("s4");
		int m5 = (int) req.getAttribute("s5");

		int sum = m1 + m2 + m3 + m4 + m5;
		double a=(double) sum / 500;
		double per=(double) a * 100;
		writer.println("<h2>Percentage of " +firstname + " is " + per+" %</h2>");

	}

}
