package com.chinasofti.projectDigest.service;

import java.util.List;

import com.chinasofti.projectDigest.pojo.TField;

public interface MyBatisFieldCategoryService {
	
	public List<TField> get_fieldByBusCategoryId(Integer id);
	
	public List<TField> get_fieldCategory();
	
	public void add(TField tField);
	
	public List<TField> get_fieldById(Integer id);
	

}
