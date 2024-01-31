

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String rno,name,marks;
		String url,user,pass;
		url="jdbc:mysql://localhost:3306/batch123";
		user="root";
		pass="diksha123";
		
		rno=request.getParameter("rno");
		name=request.getParameter("name");
		marks=request.getParameter("marks");
		try {
			String query="Insert into student values(?,?,?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, rno);
			pst.setString(2, name);
		    pst.setString(3, marks);
		    pst.execute();
		    
		    //out.print("Data inserted successfully....");
		    
		    response.sendRedirect("Servletview");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
				
		
		
}
