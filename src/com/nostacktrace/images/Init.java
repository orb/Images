package com.nostacktrace.images;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class Init implements ServletContextListener, ServletRequestListener {
	public HttpServletRequest request(ServletRequestEvent sre) {
		ServletRequest request = sre.getServletRequest();
		if (request instanceof HttpServletRequest) {
			return (HttpServletRequest) request;
		} else {
			return null;
		}
	}

	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = request(sre);
		if (request != null) {
			System.out.println("REQ: " + request.getRequestURI());
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("--- APP");
	}

	public void contextInitialized(ServletContextEvent sce) {
		Database.init();
		System.out.println("+++ APP");
		

	}
}
