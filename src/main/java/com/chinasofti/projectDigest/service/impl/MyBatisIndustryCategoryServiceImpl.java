package com.chinasofti.projectDigest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.projectDigest.dao.TIndustryMapper;
import com.chinasofti.projectDigest.exception.TipException;
import com.chinasofti.projectDigest.pojo.TIndustry;
import com.chinasofti.projectDigest.pojo.TIndustryExample;
import com.chinasofti.projectDigest.service.MyBatisIndustryCategoryService;

@Service
public class MyBatisIndustryCategoryServiceImpl implements MyBatisIndustryCategoryService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisIndustryCategoryServiceImpl.class);
	
	HashMap<Object, Object> map = new HashMap<Object,Object>();
	@Autowired
	private TIndustryMapper tIndustryMapper;
	
	public List<TIndustry> getIndustryCategory(){
		
		TIndustryExample example = new TIndustryExample();
		example.setOrderByClause("id asc");
		return tIndustryMapper.selectByExample(example);
		
	}
	
	public List<TIndustry> getIndustryById(Integer id) {
		
		TIndustryExample example = new TIndustryExample();
		example.createCriteria().andIdEqualTo(id);
		return tIndustryMapper.selectByExample(example);
	}
	
	public void addIndustry(TIndustry tIndustry) {
		
		TIndustryExample example = new TIndustryExample();
		example.createCriteria().andIndustryEqualTo(tIndustry.getIndustry());
		if(tIndustryMapper.selectByExample(example).size() > 0 ) {
			throw new TipException("行业信息已存在，请从下拉列表中选取！");
		}
		tIndustryMapper.insert2(tIndustry);
		
		 
	}

}
