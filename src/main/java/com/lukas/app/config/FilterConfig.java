package com.lukas.app.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lukas.app.filter.LoggingFilter;

@Configuration
public class FilterConfig {

	@Bean
	FilterRegistrationBean<LoggingFilter> loggingFilter() {
		var filter = new FilterRegistrationBean<>(new LoggingFilter());
		filter.addUrlPatterns("/*");
		filter.setOrder(1);
		return filter;
	}
}
