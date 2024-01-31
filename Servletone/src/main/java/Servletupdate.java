

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servletupdate")
public class Servletupdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String url="jdbc:mysql://localhost:3306/login";
		String name="root";
		String pass="diksha123";
		String rn=request.getParameter("sid");
		
		out.print("<form action='Update' method='get'>");
		out.print("Id:<input type='text' value="+rn+" name='rno' disable><br>");
		out.print("Enter name:<input type='text' name='nm'><br>");
		out.print("Enter marks:<input type='text' name='mk'><br>");
		out.print("<input type='submit' value='update'>");
		out.print("</form>");
		
	}

}
