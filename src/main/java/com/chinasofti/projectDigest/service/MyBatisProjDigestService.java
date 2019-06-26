package com.chinasofti.projectDigest.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.projectDigest.dto.Lob;
import com.chinasofti.projectDigest.pojo.TProjdigest;
import com.chinasofti.projectDigest.pojo.TProjdigestOld;
import com.github.pagehelper.PageInfo;
 

public interface MyBatisProjDigestService {

	public void addProjDigests(MultipartFile[] files);
	
	public void addProjDigest(TProjdigest tProjdigest);
	
	public void updateProjDigest(TProjdigest tProjdigest);
	
	public PageInfo<TProjdigest> findProjDigests(String order, int page, int rows, String sort
			,String projOutcomeId, String projName,String projNum, String lob  );
	
	public List<Lob> get_distinctLob();
	
	public void delByIds(String ids);
	
	
}
