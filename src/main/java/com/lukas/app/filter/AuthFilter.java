package com.lukas.app.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AuthFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var req = (HttpServletRequest) request;
		var res = (HttpServletResponse) response;
				
		if(req.getSession().getAttribute("loginId") == null) {
			logger.warn("不正なアクセス");
			res.sendRedirect("/login");
		}
		
		chain.doFilter(request, response);

	}

}
