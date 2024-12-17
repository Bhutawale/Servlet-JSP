<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.User"%>
<%@page import="java.util.List"%>
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
	Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	
	Session se=factory.openSession();
	
	List<User> userList=new ArrayList<User>(); 
	
	userList=se.createQuery("From User",User.class).getResultList();
	
	if (userList != null && !userList.isEmpty()) {
        out.println("<h2>User Details</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Gender</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
        for (User user : userList) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getName() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td>" + user.getGender() + "</td>");
            out.println("<td>" + user.getCountry() + "</td>");
            out.println("<td>"+ "<a href='edit.jsp?id="+user.getId()+"'>Edit</a>" + "</td>");
            out.println("<td>"+ "<a href='delete.jsp?id="+user.getId()+"'>Delete</a>" + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    } else {
        out.println("<p>No users found.</p>");
    }
		
	se.close();
	
	factory.close();
	
	
%>
<a href="addUser.jsp">Add New User</a>
</body>
</html>