package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Edit extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html");
	    PrintWriter writer = resp.getWriter();

	    writer.println("<center><h2>Update Employee</h2><center>");
	    int id = Integer.parseInt(req.getParameter("id"));
	    //writer.println(id);

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_project06", "root", "root");
	        String query = "SELECT * FROM employee WHERE id=?";
	        PreparedStatement statement = con.prepareStatement(query);
	        statement.setInt(1, id); // Set the value for the placeholder to the 'id' variable
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) 
	        {
	        	int id1 = resultSet.getInt(1);
	            String name = resultSet.getString(2);
	            String password = resultSet.getString(3);
	            String email = resultSet.getString(4);
	            String country = resultSet.getString(5);
	            //writer.println(name);
	            //writer.println(password);
	            //writer.println(email);
	            //writer.println(country);
	            
	    		writer.println("<html>");
	    		writer.println("<body>");
	    		writer.println("<form action='editEmployee' method='post'>");
	    		
	    		writer.println("<table align='center'>");
	    		

	    		writer.println("<tr>"
	    				+ "<td><input type='hidden' name='id' value="+id1+"></td></tr>");
	    		
	    		writer.println("<tr><td>Name: </td>"
	    				+ "<td><input type='text' name='name' value="+name+"></td></tr>");
	    		
	    		writer.println("<tr><td>Password: </td>"
	    				+ "<td><input type='text' name='password' value="+password+"></td></tr>");
	    		
	    		writer.println("<tr><td>Email: </td>"
	    				+ "<td><input type='email' name='email' value="+email+"></td></tr>");
	    		
	    		writer.println("<tr><td>Country: </td>"
	    				+ "<td><input type='text' name='country' value="+country+"></td></tr>");
	    		
	    		writer.println("<tr><td colspan='2'><button type='submit'>Update Record</button></td></tr>");
	    		
	    		writer.println("</table>");
	    		
	    		writer.println("</form>");
	    		writer.println("</body>");
	    		writer.println("</html>");	
	    		
	    		
	    		
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        writer.println("Something went wrong!!");
	    }
	}
}	

