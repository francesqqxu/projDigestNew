package com.chinasofti.projectDigest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.projectDigest.pojo.TUser;
import com.chinasofti.projectDigest.service.MyBatisUserService;

@Controller
@RequestMapping("/mybatis")
public class MyBatisController {

	@Autowired
	private MyBatisUserService myBatisUserService = null;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public TUser getUser(Integer id) {
		return myBatisUserService.getUser(id);
	}
	
}
