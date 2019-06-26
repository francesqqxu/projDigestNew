package com.chinasofti.projectDigest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.projectDigest.dao.TApplicationMapper;
import com.chinasofti.projectDigest.exception.TipException;
import com.chinasofti.projectDigest.pojo.TApplication;
import com.chinasofti.projectDigest.pojo.TApplicationExample;
import com.chinasofti.projectDigest.service.MyBatisAppCategoryService;

@Service
public class MyBatisAppCategoryServiceImpl implements MyBatisAppCategoryService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisAppCategoryServiceImpl.class);
	
	HashMap<Object,Object> map = new HashMap<Object,Object>();
	
	@Autowired
	TApplicationMapper tApplicationMapper;
	
	public List<TApplication>get_appByFieldId(Integer id){
		
		TApplicationExample example = new TApplicationExample();
		example.createCriteria().andFieldIdEqualTo(id);
		return tApplicationMapper.selectByExample(example);
	}
	
	public List<TApplication>get_appCategory(){
		
		TApplicationExample example = new TApplicationExample();
		example.setOrderByClause("id asc");
		return tApplicationMapper.selectByExample(example);
		
	}
	
	public void add(TApplication tApplication) {
		
		TApplicationExample example = new TApplicationExample();
		TApplicationExample.Criteria criteria = example.createCriteria();
		criteria.andApplicationEqualTo(tApplication.getApplication());
	    criteria.andFieldIdEqualTo(tApplication.getFieldId());
	    
		if (tApplicationMapper.selectByExample(example).size() > 0) {
			throw  new TipException("应用类别已存在，请从下拉列表选择！");
		}
		
		tApplicationMapper.insert2(tApplication);
		
		
	}
	
	public List<TApplication> get_appById(Integer id){
		
		TApplicationExample example = new TApplicationExample();
		example.createCriteria().andIdEqualTo(id);
		return tApplicationMapper.selectByExample(example);
		
	}

}
