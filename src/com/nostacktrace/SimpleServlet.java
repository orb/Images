package com.nostacktrace;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/simple")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    MessageManager manager = new MessageManager();
	    
		req.setAttribute("now", new Date());	   
		req.setAttribute("messages", manager.loadMessages());
	    
		req.getRequestDispatcher("/WEB-INF/simple.jsp").forward(req,	resp);	
	}
}
