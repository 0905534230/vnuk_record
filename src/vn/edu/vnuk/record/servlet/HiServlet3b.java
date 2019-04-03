package vn.edu.vnuk.record.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet3" , urlPatterns = {"/xin-chao" , "/chao-buoi-sang"})
@SuppressWarnings("serial")
public class HiServlet3b extends HttpServlet {
	protected void service (HttpServletRequest request , HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet 3 </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Chao buoi sang </h1>");
		out.println("</body>");
		out.println("</html>");	
	}
}
