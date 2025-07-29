package com.lukas.app.filter;

import java.io.IOException;
import java.time.ZonedDateTime;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var req = (HttpServletRequest) request;

		logger.info("{}: {}", req.getMethod(), req.getRequestURI());
		logger.info("リクエスト:{}", ZonedDateTime.now());
		chain.doFilter(request, response);
		logger.info("レスポンス:{}", ZonedDateTime.now());
	}
}
