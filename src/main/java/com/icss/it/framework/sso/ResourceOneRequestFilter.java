package com.icss.it.framework.sso;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

public class ResourceOneRequestFilter implements Filter {
	
	private static final Logger  LOGGER = LoggerFactory.getLogger(ResourceOneRequestFilter.class);

	 

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 try
		 {
			 System.out.println("start ResourceOneRequestFilter handler");
			 
			 HttpServletRequest httpReq = (HttpServletRequest)request;
			 
			 System.out.println(httpReq.getParameter("target"));
			 chain.doFilter(request, response); 
			 
		 }
		 catch(Exception e) {
			 LOGGER.error("ResOneReqInterceptor.requestInterceptor: ", e.getMessage(),e);
		 }
		
	}

	@Override
	public void destroy() {
		 
		System.out.println("ResourceOneRequestFilter is destroying");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("ResourceOneRequestFilter initializer");
	}
	
	
	
	

}
