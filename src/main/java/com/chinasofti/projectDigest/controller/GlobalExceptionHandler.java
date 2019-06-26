package com.chinasofti.projectDigest.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.chinasofti.projectDigest.exception.TipException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = TipException.class)
	public String tipExceptionHandler(Exception e) {
		LOGGER.error("find exception: e+{}", e.getMessage());
		return "error.html";
	}
	
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Exception e) {
		LOGGER.error("find exception: e+{}",e.getMessage());
		return "error.html";
	}
	

}
