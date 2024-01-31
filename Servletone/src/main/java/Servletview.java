

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servletview")
public class Servletview extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url,user,pass;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		url="jdbc:mysql://localhost:3306/batch123";
		user="root";
		pass="diksha123";
		
		try {
			String query="select * from student";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			out.print("<table border='1'>");
			out.print("<tr><th>Roll No</th><th>Name</th><th>Marks</th></tr>");
			
			while(rs.next())
			{
				out.print("<tr>");
				out.print("<td>"+rs.getString("rno")+"</td>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("<td>"+rs.getString("marks")+"</td>");
				
				out.print("<td><a href='Servletdelete?sid="+rs.getString("rno")+"'>Delete</a> &nbsp");
				out.print("<a href='Servletupdate?sid="+rs.getString("rno")+"'>Update</a></td>");
				out.print("</tr>");
			}		
			out.print("</table>");
			
				
			}catch(Exception e)
		{
				e.printStackTrace();
		}
	}

}
