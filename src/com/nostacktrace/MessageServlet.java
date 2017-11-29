package com.nostacktrace;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    MessageManager manager = new MessageManager();
		int id = Integer.parseInt(req.getParameter("id"));
		
		req.setAttribute("message", manager.messageById(id));
		req.getRequestDispatcher("/WEB-INF/message.jsp").forward(req, resp);		
	}

}
