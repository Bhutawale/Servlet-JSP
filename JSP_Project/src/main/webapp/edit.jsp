
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="com.servlet.User" %>
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
	int uid=Integer.parseInt(request.getParameter("id"));

	Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();

	Session sess=factory.openSession();
	Transaction tx=sess.beginTransaction();	

	
	User user=sess.get(User.class, uid);
	
	String name=user.getName();
	String password=user.getPassword();
	String email=user.getEmail();
	String gender=user.getGender();
	String country=user.getCountry();
	tx.commit();	
	sess.close();
	factory.close();
%>
<h2>Edit Form</h2>
<form action="Edit" method="post">
	<table>
	 <input type="hidden" name="id" value="<%= uid %>">
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="<%= name %>"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" value="<%= password %>"></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email" value="<%= email %>"></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><input type="radio" name="gender" value="Male" id="maleradio" <%= gender.equals("Male") ? "checked" :""%>>Male
				<input type="radio" name="gender" value="Female" id="femaleradio" <%= gender.equals("Female") ? "checked" :""%>>Female
			</td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><select name="country">
				<option <%= country.equals("India") ? "selected" : "" %>>India</option>
				<option <%= country.equals("USA") ? "selected" : "" %>>USA</option>
				<option <%= country.equals("England") ? "selected" : "" %>>England</option>
				<option <%= country.equals("Switzerland") ? "selected" : "" %>>Switzerland</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Edit User">	
			</td>
		</tr>
	</table>	
</form>
</body>
</html>