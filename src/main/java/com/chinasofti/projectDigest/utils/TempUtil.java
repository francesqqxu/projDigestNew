package com.chinasofti.projectDigest.utils;

import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.icss.j2ee.util.StringUtil;
import com.icss.resourceone.encrypt.EncryptException;

public class TempUtil {
	
	 public byte[] decrypt(byte[] encryptedText) throws EncryptException
	 { 
		 return StringUtil.decodeBase64(new String(encryptedText)).getBytes(); 
	 }
	  
	 public static void getReqInfo(HttpServletRequest httpReq) {
			System.out.println("httpReq.target: " + httpReq.getParameter("target")); 
			System.out.println("httpReq.remoteUser: " + httpReq.getRemoteUser());
			System.out.println("httpReq.LTPAToken: " + httpReq.getParameter("LTPAToken"));
			
			System.out.println("------headers-----");
			Enumeration<String> headNames =  httpReq.getHeaderNames();
			
			while(headNames.hasMoreElements()) {
				String headName = headNames.nextElement();
				System.out.println(headName + ":" + httpReq.getHeader(headName));
			}
			
			System.out.println("-----paramters-----");
			Map<String,String[]> map = httpReq.getParameterMap();
			Set<String> keys = map.keySet();
			for(String key : keys) {
				String[] value = map.get(key);
				System.out.println(key + "= " + value[0]);
			}
			
			System.out.println("-----session-----");
			HttpSession session = httpReq.getSession();
			
			Enumeration<?> enumeration = session.getAttributeNames();
			while(enumeration.hasMoreElements()) {
				String name = enumeration.nextElement().toString();
				
				Object value = session.getAttribute(name);
				System.out.println("<B>" + name + "</B>=" + value + "<br>/n");
				
			}
			
					
			System.out.println("request.getContentLength():" + httpReq.getContentLength());
			System.out.println("request.getContentType():" + httpReq.getContentType());
			System.out.println("request.getcontextPath():" + httpReq.getContextPath());
			System.out.println("request.getMethod():" + httpReq.getMethod());
			System.out.println("request.getLocale():" + httpReq.getLocale());
			System.out.println("request.getQueryString():" + httpReq.getQueryString());
			System.out.println("request.getRequestURI():" + httpReq.getRequestURI());
			System.out.println("request.getRequestURL():" + httpReq.getRequestURL());
			System.out.println("request.getServletPath():" + httpReq.getServletPath());
			System.out.println("request.getRemoteAddr():" + httpReq.getRemoteAddr());
			System.out.println("request.getRemoteHost():" + httpReq.getRemoteHost());
			System.out.println("request.getRemotePort():" + httpReq.getRemotePort());
			System.out.println("request.getServerName():" + httpReq.getServerName());
			System.out.println("request.getServerPort();" + httpReq.getServerPort());
		}

	
	public static void main(String[] args) {
		
		
       System.out.println(StringUtil.decodeBase64(new String("aHR0cDovL2xvY2FsaG9zdDo4MDgwL3Byb2pEaWdlc3Q=")));
		
	}

}
