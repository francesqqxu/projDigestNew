package com.chinasofti.projectDigest.service;

import java.util.List;

import com.chinasofti.projectDigest.pojo.TApplication;

 
public interface MyBatisAppCategoryService {
	
	public List<TApplication>get_appByFieldId(Integer id);
	
	public List<TApplication>get_appCategory();
	
	public void add(TApplication tApplication);
	
	public List<TApplication> get_appById(Integer id);
	

}
