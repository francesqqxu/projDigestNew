package com.chinasofti.projectDigest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

public class FilterTest2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 
		System.out.println("Filter initializer");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 System.out.println("start to filter handler");
		 HttpServletRequest httpReq = (HttpServletRequest)request;
		 
		 System.out.println(httpReq.getParameter("target"));
		 chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		 
		System.out.println("Filter is destroying");
		 
	}
	
	
	

}
