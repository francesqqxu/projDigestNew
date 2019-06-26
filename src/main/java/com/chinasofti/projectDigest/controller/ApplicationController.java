package com.chinasofti.projectDigest.controller;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.projectDigest.controller.helper.ExceptionHelper;
import com.chinasofti.projectDigest.dto.RestResponseBo;
import com.chinasofti.projectDigest.exception.TipException;
import com.chinasofti.projectDigest.pojo.TApplication;
import com.chinasofti.projectDigest.service.MyBatisAppCategoryService;

@Controller
@RequestMapping("app")
public class ApplicationController {
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	MyBatisAppCategoryService myBatisAppCategoryService;
	
	@RequestMapping("/get_appByFieldId")
	@ResponseBody
	public Object get_appByFieldId(Integer id) {
		
		return myBatisAppCategoryService.get_appByFieldId(id);
	}
	
	@RequestMapping("/get_appCategory")
	@ResponseBody
	public Object get_appCategory() {
		
		return myBatisAppCategoryService.get_appCategory();
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add(TApplication tApplication) {
		
		 try {
			 myBatisAppCategoryService.add(tApplication);
		 }catch(TipException e) {
			 String msg = "添加应用类别失败";
		     return ExceptionHelper.handlerException(LOGGER, msg, e);
		 }
		 return RestResponseBo.ok(); 
	}
	
	@RequestMapping("/get_appById")
	@ResponseBody
	public List<TApplication> get_appById(Integer id){
		
		return myBatisAppCategoryService.get_appById(id);
	}

}
