

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		
		
		//hidden form feild
         
		if(pass.equals("admin123"))
		{
			p.print("Servlet1: <br>");

			p.print("Hello : "+name);
			p.print("<form action='Servlet2'>");
			p.print("<input type='hidden' name ='uname' value ='"+name+"'>");

	        p.print("<input type='submit' value ='Go'>");

			p.print("</form>  ");
		}
		
		else
		{
			request.getRequestDispatcher("Index.html").include(request, response);
			p.print("<p>Wrong Password try again !</p>");
		}

}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
