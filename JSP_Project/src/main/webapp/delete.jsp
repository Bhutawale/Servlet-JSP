<%@page import="org.hibernate.Transaction"%>
<%@page import="com.servlet.User"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	
	Configuration cfg=new Configuration().configure("hibernate.cfg.xml");

	SessionFactory factory=cfg.buildSessionFactory();
	
 	Session ses=factory.openSession();
	
 	Transaction tx=ses.beginTransaction();
 	
	User user=ses.get(User.class, id);	
	
	ses.delete(user);
	
	tx.commit();
	
	out.println("User Deleted Successfully.");
 	ses.close();
	factory.close();
	
%>
<%
	RequestDispatcher dis= request.getRequestDispatcher("viewUsers.jsp");
	dis.include(request, response);
%>
</body>
</html>