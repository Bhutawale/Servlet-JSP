<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.html" %>
<h3>
<%
out.println("Welcome to JSP....");
out.println(new Date().toString());
%>
</h3>

<h2>
<br>
<%= "Welcome Satish" %>
<br>
</h2>
<%!
	int square(int n)
	{
		return n*n;
	}
%>
<br>
<h5>
<%= "Square of 5 is: "+square(5) %>
</h5>
<br>
<%

	int n1=Integer.parseInt(request.getParameter("num1"));
	int n2=Integer.parseInt(request.getParameter("num2"));
	int n3=n1+n2;
	out.println("Sum of two numbers is: "+n3);
%>
<br>
<br>
<%@ include file="footer.html" %>
</body>
</html>