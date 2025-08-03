package com.lukas.app.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var req = (HttpServletRequest) request;
		var res = (HttpServletResponse) response;

		if (req.getSession().getAttribute("loginId") == null) {
			log.warn("不正なアクセス");
			res.sendRedirect("/login");
			return;
		}

		chain.doFilter(request, response);

	}

}
