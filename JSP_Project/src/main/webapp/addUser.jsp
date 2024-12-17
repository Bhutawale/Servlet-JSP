<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="viewUsers.jsp">View All Records</a>
<h2>Add New User</h2>
<form action="AddUser" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><input type="radio" name="gender" value="Male" id="maleradio" checked="checked">Male
				<input type="radio" name="gender" value="Female" id="femaleradio">Female
			</td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><select name="country">
				<option>India</option>
				<option>USA</option>
				<option>England</option>
				<option>Switzerland</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Add User">	
			</td>
		</tr>
	</table>

</form>
</body>
</html>