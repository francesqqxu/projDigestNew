package com.chinasofti.projectDigest.configure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chinasofti.projectDigest.filter.FilterTest2;
import com.icss.it.framework.sso.ResourceOneRequestFilter;
import com.icss.resourceone.sso.client.SSOClient;



@Configuration
public class WebConfig {
	
	
	  @Bean public FilterRegistrationBean<SSOClient> SSOClientFilter() {
	  
	  FilterRegistrationBean<SSOClient> registrationBean = new
	  FilterRegistrationBean<SSOClient>();
	  
	  SSOClient ssoClient = new SSOClient();
	  
	  registrationBean.setFilter(ssoClient); List<String> urls = new
	  ArrayList<String>();
	  
	  urls.add("/*"); registrationBean.setUrlPatterns(urls);
	  registrationBean.addInitParameter("_except_urlpattern", "\\.xml$");
	  registrationBean.addInitParameter("URIEncoding", "utf-8");
	  registrationBean.addInitParameter("_server_site_url",
	  "http://ics.chinasoftosg.com/servlet/SSOServer");
	  registrationBean.setName("SSOClientFilter"); registrationBean.setOrder(1);
	  
	  return registrationBean;
	  
	  }
	 
	
	 @Bean
	  public FilterRegistrationBean<ResourceOneRequestFilter> RORFilter(){
		  
		  FilterRegistrationBean<ResourceOneRequestFilter> registrationBean = new
		  FilterRegistrationBean<ResourceOneRequestFilter>();
		  
		  ResourceOneRequestFilter RorFilter = new ResourceOneRequestFilter();
		  registrationBean.setFilter(RorFilter);
		  List<String> urls = new ArrayList<String>(); 
		  urls.add("/*"); registrationBean.setUrlPatterns(urls);
		  registrationBean.setName("RORFilter");
		  registrationBean.setOrder(2);
		  
		  return registrationBean;
		  
		  
		  
		  }
		 
	
	  @Bean
	  public FilterRegistrationBean<FilterTest2> test2Filter(){
	  
	  FilterRegistrationBean<FilterTest2> registrationBean = new
	  FilterRegistrationBean<FilterTest2>();
	  
	  FilterTest2 filterTest2 = new FilterTest2();
	  registrationBean.setFilter(filterTest2); List<String> urls = new
	  ArrayList<String>(); urls.add("/*"); registrationBean.setUrlPatterns(urls);
	  registrationBean.setName("test2Filter");
	  registrationBean.setOrder(3);
	  
	  return registrationBean;
	  
	  
	  
	  }
	 
}
