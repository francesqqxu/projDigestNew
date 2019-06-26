package com.chinasofti.projectDigest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.projectDigest.controller.helper.ExceptionHelper;
import com.chinasofti.projectDigest.dto.RestResponseBo;
import com.chinasofti.projectDigest.exception.TipException;
import com.chinasofti.projectDigest.pojo.TIndustry;
import com.chinasofti.projectDigest.service.MyBatisIndustryCategoryService;

@Controller
@RequestMapping("industry")
public class IndustryCategoryController {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(IndustryCategoryController.class);

	@Autowired
	MyBatisIndustryCategoryService myBatisIndustryCategoryService;
	
	@RequestMapping("/get_industryCategory")
	@ResponseBody
	public Object get_businessCategory() {
		
		return myBatisIndustryCategoryService.getIndustryCategory();
		
	}
	
	@RequestMapping("/get_industryById")
	@ResponseBody
	public Object getIndustryById(Integer id) {
		
		return myBatisIndustryCategoryService.getIndustryById(id);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add(TIndustry tIndustry) {
		
		 try {
		 myBatisIndustryCategoryService.addIndustry(tIndustry);
		 }catch(TipException e){
			 String msg = "添加行业类别失败";
			    return ExceptionHelper.handlerException(LOGGER, msg, e);
		 }
		 return RestResponseBo.ok(); 
	}
}
