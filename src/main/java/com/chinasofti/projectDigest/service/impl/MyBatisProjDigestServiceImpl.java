package com.chinasofti.projectDigest.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
 
import java.util.List;
 

import javax.servlet.http.HttpServletRequest;

import org.apache.coyote.RequestGroupInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.projectDigest.configure.ConfigBeanProp;
import com.chinasofti.projectDigest.dao.TProjdigestMapper;
import com.chinasofti.projectDigest.dao.TProjdigestOldMapper;
import com.chinasofti.projectDigest.dto.Lob;
import com.chinasofti.projectDigest.exception.TipException;
import com.chinasofti.projectDigest.pojo.TProjdigest;
import com.chinasofti.projectDigest.pojo.TProjdigestExample;
import com.chinasofti.projectDigest.pojo.TProjdigestOld;
import com.chinasofti.projectDigest.pojo.TProjdigestOldExample;
import com.chinasofti.projectDigest.service.MyBatisProjDigestService;
import com.chinasofti.projectDigest.utils.ExcelUtils;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chinasofti.projectDigest.utils.ServiceUtil;
import com.chinasofti.projectDigest.utils.ServiceUtil.RuleViolation;

@Service
public class MyBatisProjDigestServiceImpl implements MyBatisProjDigestService {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(MyBatisProjDigestServiceImpl.class);
	
	
	@Autowired
	TProjdigestOldMapper tProjdigestOldMapper;
	@Autowired
	TProjdigestMapper tProjdigestMapper;
	@Autowired
	HttpServletRequest request;
	@Autowired
	ConfigBeanProp configBeanProp;
	
	public void addProjDigests(MultipartFile[] files) {
		
		LOGGER.info("addProjDigests");
		String fileName = "";
		InputStream in = null;
		 
		List<TProjdigestOld>  tProjdigestOlds = new ArrayList<TProjdigestOld>();
		List<RuleViolation> RuleViolations = new ArrayList<RuleViolation>();
		RuleViolation ruleViolation = null;
		
		LOGGER.info("files.length: {}", files.length);
		 
		LOGGER.info("fileSize: {}",files[0].getSize());
		LOGGER.info("fileName: {}",files[0].getOriginalFilename());
		LOGGER.info("fileContentType: {}", files[0].getContentType());
		LOGGER.info("fileResouce: {}", files[0].getResource());
		if(files.length <=1 && files[0].getSize() <=0 ) {
			throw new TipException("请选择需要导入的文件！");
		}
		
		try {
			
			/*删除旧的项目摘要表全部内容*/
			TProjdigestOldExample example = new TProjdigestOldExample();
			example.setOrderByClause("id asc");
			tProjdigestOldMapper.deleteByExample(example);
			
			/*删除新的项目摘要表中已导入内容，is_import="1" */
			TProjdigestExample tProjdigestExample = new TProjdigestExample();
			tProjdigestExample.createCriteria().andIsImportEqualTo("1");
			tProjdigestMapper.deleteByExample(tProjdigestExample);
			ServiceUtil serviceUtil = ServiceUtil.getInstance();
			
			for(MultipartFile excelfile : files) {
				if(excelfile.getSize() > 0 ) {
					    fileName = excelfile.getOriginalFilename();
					    in = excelfile.getInputStream();
						List<String>  titles = java.util.Arrays.asList( ExcelUtils.readExcelTitle(fileName,in));
						List<String> titlesColumn= serviceUtil.transferToColumnTitle(fileName,titles);
						ruleViolation = serviceUtil.checkColumnTitle(fileName, titles);
						if(null != ruleViolation) {
							RuleViolations.add(ruleViolation);
						}
						else
						{
							List<Object> cellValues = ExcelUtils.readExcelContent(fileName, in);
							
							TProjdigestOld tProjDigestOld = new TProjdigestOld();
							
							tProjDigestOld = ExcelUtils.transToObject(titlesColumn, cellValues, TProjdigestOld.class);
						    
							tProjdigestOlds.add(tProjDigestOld);
						}
					
					}
					 
				} // end of for
				for(TProjdigestOld tProjdigestOld:tProjdigestOlds ) {
					LOGGER.info("tProjDigestsOld[{}].projOutComeId = {}", tProjdigestOlds.indexOf(tProjdigestOld),tProjdigestOld.getProjOutcomeId());
				}
		
				LOGGER.info("tProjDigestOlds number {}",tProjdigestOlds.size());
		        
				List<TProjdigest> tProjdigests = serviceUtil.OldProjdigestToProjdigest(tProjdigestOlds);
				
				for(TProjdigest tProjdigest : tProjdigests) {
					tProjdigest.setUserId(configBeanProp.getAdmin());
				}
				
				LOGGER.info("tProjDigests number {}",tProjdigests.size());
		        
				for(TProjdigestOld tProjdigestOld:tProjdigestOlds ) {
					tProjdigestOldMapper.insert3(tProjdigestOld);
			    }
				
				for(TProjdigest tProjdigest:tProjdigests) {
					tProjdigestMapper.insert3(tProjdigest);
				}
				
				if(RuleViolations.size() > 0 ) {
					throw new TipException( serviceUtil.RuleViolationsString(RuleViolations));
				}
		}catch(Exception ex){
			throw new TipException("导入项目摘要信息出错，请联系管理人员 " + ex.getMessage());
		}   
		 
			
	}// end of addProjDigests
		
	public void  addProjDigest(TProjdigest tProjdigest) {
		
		LOGGER.info("tprojdigest.projOutcomdId:={}", tProjdigest.getProjOutcomeId());
		tProjdigest.setIsImport("0");
		String userId = request.getRemoteUser();
		tProjdigest.setUserId(userId);
		
		//tProjdigestMapper.insertSelective2(tProjdigest);
		tProjdigestMapper.insert3(tProjdigest);
		 
	}
	
	public void updateProjDigest(TProjdigest tProjdigest) {
		
		LOGGER.info("tprojdigest.projOutcomdId:={}", tProjdigest.getProjOutcomeId());
		
				
		tProjdigestMapper.updateByPrimaryKeySelective(tProjdigest);
		 
		
	}
	
	public PageInfo<TProjdigest> findProjDigests(String order, int page, int rows, String sort
			,String projOutcomeId,String projName,String projNum, String lob  ){
		
		
		LOGGER.info("rows: " + rows);
		LOGGER.info("page: " + page);
		
		String userId = request.getRemoteUser();
	    String admin = configBeanProp.getAdmin();
	    
	    LOGGER.info("userId: " + userId);
	    LOGGER.info("admin: " + admin );
	    
		TProjdigestExample  example = new TProjdigestExample();
		example.setOrderByClause(sort + " " + order);
		TProjdigestExample.Criteria criteria = example.createCriteria();
		if(""!=projOutcomeId) {
			criteria.andProjOutcomeIdEqualTo(projOutcomeId);
		}
		if(""!=projName) {
			criteria.andProjNameEqualTo(projName);
		}
		if(""!=projNum) {
			criteria.andProjNumEqualTo(projNum);
		}
		if(lob.equals("--请选择--")) {
			lob="";
		}
		if(""!=lob) {
			criteria.andLobEqualTo(lob);
		}
		if(""!=userId && admin != userId) {
			criteria.andUserIdEqualTo(userId);
		}
		 
		if(userId.equals(admin)) {
			userId = "";
		}
		LOGGER.info("userId: " + userId); 
		PageHelper.startPage(page,rows);
		
	    //List<TProjdigest> tProjdigests = tProjdigestMapper.selectByExample(example);
		List<TProjdigest> tProjdigests = tProjdigestMapper.selectTProjdigestIndustryFieldApp(projOutcomeId, projName, projNum, lob,userId );
		PageInfo<TProjdigest> pageinfo = new PageInfo<>(tProjdigests);
		return pageinfo;
		
	}
	
	public List<Lob> get_distinctLob() {
		
		List<String> lobs =  tProjdigestMapper.selectDistinctLob();
		
		List<Lob> lobsList = new ArrayList<Lob>();
		Lob l = new Lob();
		l.setId(0);
		l.setLob("--请选择--");
		lobsList.add(l);
		for(int i=0; i<lobs.size(); i++) {
		    l = new Lob();
			l.setId(i+1);
			l.setLob(lobs.get(i));
			lobsList.add(l);
		}
		return lobsList; 
	}
	
	public void delByIds(String ids) {
		
		String[] idStr = ids.split(",");
		List<Integer> idList = new ArrayList<Integer>();
		
		for(String id: idStr) {
			idList.add(Integer.valueOf(id));
		}
		
		TProjdigestExample  example = new TProjdigestExample();
		example.createCriteria().andIdIn(idList);
		
	    tProjdigestMapper.deleteByExample(example);
	    
	    
	}
	
	
}
