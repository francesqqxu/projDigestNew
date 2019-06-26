package com.chinasofti.projectDigest.controller;

import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.projectDigest.utils.TempUtil;

@Controller
@RequestMapping("/")
public class ProjectOutcomeController {
	
	@RequestMapping("hellogradle")
	@ResponseBody
	public String testHello() {
		return "hello gradle";
	}
	
	@RequestMapping("/projDigest")
	public String index(ServletRequest request,ServletResponse response) {
		
		HttpServletRequest httpReq = (HttpServletRequest)request;
		
		
		TempUtil.getReqInfo(httpReq); 
		
		return "mainbroad";
	}
	
	
}
