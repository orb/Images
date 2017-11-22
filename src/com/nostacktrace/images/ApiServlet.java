package com.nostacktrace.images;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImageManager manager = new ImageManager();
		request.setAttribute("images", manager.allImages());
		
		// this is bad because the JSP does not properly encode the JSON, but
		// I'm adding it anyways as a partial example of showing how to generate
		// different content types
		request.getRequestDispatcher("/WEB-INF/fakeapi.jsp").forward(request, response);
	}
}
