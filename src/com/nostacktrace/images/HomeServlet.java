package com.nostacktrace.images;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public boolean flashNotice(HttpServletRequest request) {
		String flash = (String) request.getSession().getAttribute("flash");
		
		if (flash != null) {
			request.getSession().removeAttribute("flash");
			request.setAttribute("notice", flash);
			return true;
		} 
		return false;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		ImageManager manager = new ImageManager();

		if (!flashNotice(request)) {
			request.setAttribute("notice", "Please feel free to upload an image!");
		}
		
		request.setAttribute("images", manager.allImages());
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}
}
