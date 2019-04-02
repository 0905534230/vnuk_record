package vn.edu.vnuk.record.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyStudies extends HttpServlet{
	
	@Override
	protected void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Studies</title>");
		out.println("<link rel=\"stylesheet\"  type=\"text/css\" href=\"css/studies.css\">");		
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>My Studies</h1>");
		
		out.println("<table>");
		
		out.println("<thead>");
		out.println("<tr>");
		out.println("<tr>");
		out.println("<th> Year </th>");		
		out.println("<th> School </th>");	
		out.println("<th> Town </th>");
		out.println("<th> Country </th>");
		out.println("</tr>");		
		out.println("</tr>");
		out.println("</thead>");
		
		out.println("<tbody>");
				
		out.println("<tr>");
		out.println("<td> 2017-now </td>");		
		out.println("<td> VNUK University </td>");	
		out.println("<td > Da Nang </td>");
		out.println("<td rowspan = \"5\"> Viet Nam </td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td> 2014-2017 </td>");		
		out.println("<td> 	Da Nang High School </td>");	
		out.println("<td > Da Nang </td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td> 2010-2014 </td>");		
		out.println("<td> Da Nang Secondary School </td>");	
		out.println("<td > Da Nang </td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td> 2005-2010 </td>");		
		out.println("<td> 	Da Nang Primary School </td>");	
		out.println("<td > Da Nang </td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td> 2013-2017 </td>");		
		out.println("<td> Ho Chi Minh Kingdergarten </td>");	
		out.println("<td > Ho Chi Minh </td>");
		out.println("</tr>");
		
		out.println("</tbody>");
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}