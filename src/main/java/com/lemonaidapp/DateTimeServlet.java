package com.lemonaidapp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateTimeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String dateTime = new SimpleDateFormat().format(new Date());
		
		resp.getOutputStream().println("<html>");
		resp.getOutputStream().println("<head><title>Hello World Servlet</title></head>");
		resp.getOutputStream().println("<body>");
		resp.getOutputStream().println("<h1>Hello from a Servlet!</h1>");
		resp.getOutputStream().println("The current date and time is " + dateTime);
		resp.getOutputStream().println("</body>");
		resp.getOutputStream().println("</html>");
	}
}
