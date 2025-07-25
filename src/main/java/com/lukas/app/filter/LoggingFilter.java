package com.lukas.app.filter;

import java.io.IOException;
import java.time.ZonedDateTime;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var req = (HttpServletRequest) request;
		
		System.out.println("\n-------");
		System.out.println(req.getMethod() + ": " + req.getRequestURI());
		System.out.println("リクエスト: " + ZonedDateTime.now());
		chain.doFilter(request, response);
		System.out.println("レスポンス: " + ZonedDateTime.now());
		System.out.println("-------");

	}
}
