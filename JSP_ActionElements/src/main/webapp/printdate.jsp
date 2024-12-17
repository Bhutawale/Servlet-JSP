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
<jsp:include page="header.jsp"/>
<% out.println(new Date().toString()); %>
<br>
<% 
	String name=request.getParameter("name");
	
	out.println("Welcome back "+name);
%>
<br>
<jsp:useBean id="cal" class="com.jspactionelements.Calculation"/>
<%
	int n=5;
	int square=cal.calSquare(5);
	out.println("The square of 5 is: "+square);
%>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>