package com.lukas.app.config;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class Config {

	@Bean
	FilterRegistrationBean<Filter> authFilter() {
		var filter = new FilterRegistrationBean<Filter>((request, response, chain) -> {
		var req = (HttpServletRequest) request;
		var res = (HttpServletResponse) response;
		
		if(req.getSession().getAttribute("user")==null) {
			log.warn("不正なアクセス");
			res.sendRedirect("/login");
			return;
		}
		
		chain.doFilter(request, response);
		
		});
		filter.addUrlPatterns("/dashboard/*", "/catalog/*");
		filter.setOrder(2);
		return filter;
	}
	
	@Bean
	FilterRegistrationBean<Filter> loggingFilter() {
		var filter = new FilterRegistrationBean<Filter>((request, response, chain) -> {
			var req = (HttpServletRequest) request;
			String uri = req.getRequestURI();
			
			if(!uri.endsWith(".css")&&!uri.endsWith(".js") && !uri.endsWith(".ico") 
	                && !uri.endsWith(".png") && !uri.endsWith(".jpg") && !uri.endsWith(".gif")) {
				log.info("{}:{}", req.getMethod(), uri);
			}
			
			chain.doFilter(request, response);
			
		});
		
		filter.addUrlPatterns("/*");
		filter.setOrder(1);
		return filter;
	}
}
