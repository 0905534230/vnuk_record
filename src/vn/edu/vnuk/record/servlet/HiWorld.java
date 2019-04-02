package vn.edu.vnuk.record.servlet;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HiWorld extends HttpServlet{

	@Override
	protected void service (HttpServletRequest request , HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>First Servlet </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Our first servlet </h1>");
		out.println("</body>");
		out.println("</html>");	
	}
}