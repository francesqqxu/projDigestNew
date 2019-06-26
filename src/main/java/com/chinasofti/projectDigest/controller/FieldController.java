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
import com.chinasofti.projectDigest.pojo.TField;
import com.chinasofti.projectDigest.service.MyBatisFieldCategoryService;

@Controller
@RequestMapping("field")
public class FieldController {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(FieldController.class);
			
	@Autowired
	MyBatisFieldCategoryService myBatisFieldCategoryService;
	
	@RequestMapping("/get_fieldByIndustryId")
	@ResponseBody
	public List<TField> get_industryCategory(Integer id){
		
		return myBatisFieldCategoryService.get_fieldByBusCategoryId(id);
	}
	
	@RequestMapping("/get_fieldCategory")
	@ResponseBody
	public List<TField>get_fieldCategory() {
		
		return myBatisFieldCategoryService.get_fieldCategory();
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add(TField tField) {
		try {
		 myBatisFieldCategoryService.add(tField);
		}catch(TipException e) {
			String msg = "添加领域类别失败";
		    return ExceptionHelper.handlerException(LOGGER, msg, e);
		}
		return RestResponseBo.ok(); 
	}
	
	@RequestMapping("/get_fieldById")
	@ResponseBody
	public List<TField> get_fieldById(Integer id){
		
		return myBatisFieldCategoryService.get_fieldById(id);
	}

}
