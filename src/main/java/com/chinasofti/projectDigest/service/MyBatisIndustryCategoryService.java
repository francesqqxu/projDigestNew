package com.chinasofti.projectDigest.service;

import java.util.List;

import com.chinasofti.projectDigest.pojo.TIndustry;

public interface MyBatisIndustryCategoryService {
	
	public List<TIndustry> getIndustryCategory();
	
	public List<TIndustry> getIndustryById(Integer id);
	
	public void addIndustry(TIndustry tIndustry);

}
