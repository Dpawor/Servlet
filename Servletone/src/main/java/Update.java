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

@WebServlet("/Update")
public class Update extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String name,marks,rno;
		String url="jdbc:mysql://localhost:3306/login";
		String uname="root";
		String pass="diksha123";
		
		try {
			rno=request.getParameter("rno");
		    name=request.getParameter("nm");
		    marks=request.getParameter("mk");
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection(url,name,pass);
		    
		    PreparedStatement pst=con.prepareStatement("update student set name=?,marks=? where rno=?");
		    
		    pst.setString(1, name); 
		    pst.setString(2, marks);
		    pst.setString(3, rno);
		    
		    pst.executeUpdate();
		    
		    response.sendRedirect("Servletview");
		    
		}
		
		
	}

}
