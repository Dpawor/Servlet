

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servletdelete")
public class Servletdelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url="jdbc:mysql://localhost:3306/batch123";
		String user="root";
		String pass="diksha123";
		
		String id=request.getParameter("sid");
		response.setContentType("test/html");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			String query="delete from student where rno=?";
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setString(1, id);
		    pst.executeUpdate();
		    
		    response.sendRedirect("Servletview");
		    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
 
}
