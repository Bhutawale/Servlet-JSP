<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h2{
	text-align: center;
	}
input{
font-size: 15px;
	}
table{
	margin-left: auto;
	margin-right: auto;
	border-style: ridge;
}

label {
	font-size: 20px;
	color:yellow;
	font-style: italic;
	font-weight: bold;
}

button {
	background-color: aqua;
	color: red;
	font-size: 20px;
}

body {
	background-image: url("image/img.jpg");
	background-size: cover;
}
</style>
</head>
<body>
		<h2>Register Here</h2>
		<form action="register" method="post">
			<table>
				<tr>
					<td><label>Enter User Name:</label></td>
					<td><input type="text" name="username"
						placeholder="Enter Username"></td>
				</tr>
				<tr>
					<td><label>Enter User Password:</label></td>
					<td><input type="password" name="password"
						placeholder="Enter Password"></td>
				</tr>
				<tr>
					<td><label>Enter Email:</label></td>
					<td><input type="email" name="email" placeholder="Enter Email">
					</td>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Submit</button>
					</td>
			</table>
		</form>
</body>
</html>