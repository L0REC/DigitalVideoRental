package com.lukas.app.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingFilter implements Filter {

	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var req = (HttpServletRequest) request;

		log.info("{}: {}", req.getMethod(), req.getRequestURI());
		chain.doFilter(request, response);
	}
}
