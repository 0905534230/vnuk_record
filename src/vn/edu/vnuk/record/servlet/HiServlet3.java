package vn.edu.vnuk.record.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi-servlet3")
@SuppressWarnings("serial")
public class HiServlet3 extends HttpServlet {
	@Override
	protected void service (HttpServletRequest request , HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet 3 </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Servlet 3 </h1>");
		out.println("</body>");
		out.println("</html>");	
	}

}
