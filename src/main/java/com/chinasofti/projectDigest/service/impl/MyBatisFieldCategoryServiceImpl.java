package com.chinasofti.projectDigest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.projectDigest.dao.TFieldMapper;
import com.chinasofti.projectDigest.exception.TipException;
import com.chinasofti.projectDigest.pojo.TField;
import com.chinasofti.projectDigest.pojo.TFieldExample;
import com.chinasofti.projectDigest.service.MyBatisFieldCategoryService;

@Service
public class MyBatisFieldCategoryServiceImpl implements MyBatisFieldCategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisFieldCategoryServiceImpl.class);
	
	private HashMap<Object,Object> map = new HashMap<Object, Object>();
	
	@Autowired
	TFieldMapper tFieldMapper; 
	
	public List<TField> get_fieldByBusCategoryId(Integer id){
		
			TFieldExample  example = new TFieldExample();
			example.createCriteria().andIndustryIdEqualTo(id);
		    return tFieldMapper.selectByExample(example);
	}
	
	public List<TField> get_fieldCategory(){
		
		   TFieldExample example = new TFieldExample();
		   example.setOrderByClause("id asc");
		   return tFieldMapper.selectByExample(example);
	}
	
	public void add(TField tField) {
		
		TFieldExample example = new TFieldExample();
		TFieldExample.Criteria criteria = example.createCriteria();
		criteria.andFieldEqualTo(tField.getField());
		criteria.andIndustryIdEqualTo(tField.getIndustryId());
		if(tFieldMapper.selectByExample(example).size() > 0 ) {
			throw new TipException("领域类别已存在，请从下拉列表选择！");
		}
		tFieldMapper.insert2(tField);
		 
		
	}
	
	public List<TField> get_fieldById(Integer id){
		
		TFieldExample  example = new TFieldExample();
		example.createCriteria().andIdEqualTo(id);
	    return tFieldMapper.selectByExample(example);
	}
	
}
