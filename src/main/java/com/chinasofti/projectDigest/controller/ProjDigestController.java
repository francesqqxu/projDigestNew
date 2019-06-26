package com.chinasofti.projectDigest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.projectDigest.configure.ConfigBeanProp;
import com.chinasofti.projectDigest.controller.helper.ExceptionHelper;
import com.chinasofti.projectDigest.dto.Lob;
import com.chinasofti.projectDigest.dto.RestResponseBo;
import com.chinasofti.projectDigest.pojo.TProjdigest;
import com.chinasofti.projectDigest.service.MyBatisProjDigestService;
import com.github.pagehelper.PageInfo;
 
 

@Controller
@RequestMapping("/projDigest")
public class ProjDigestController {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(ProjDigestController.class);
	
	HashMap<Object,Object> map = new HashMap<Object,Object>();
	
	@Autowired
	private MyBatisProjDigestService myBatisProjDigestService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	ConfigBeanProp configBeanProp;
	
	@RequestMapping("multiUpload")
	public String multiUpload() {
		return "multiUpload";
	}
	
	@RequestMapping("multiUploading")
	@ResponseBody
	public Object multiUploading(@RequestParam("multiFileUpload") MultipartFile[] files) {
		
		/*
		 * for(MultipartFile file:files) {
		 * 
		 * if(file.getSize() > 0 ) { String filename = file.getOriginalFilename();
		 * String path = "D:/fileupload/"; File dest = new File(path, filename); try {
		 * file.transferTo(dest); LOGGER.info("文件上传成功!"); }catch(IOException e ) {
		 * LOGGER.error(e.toString(), e); return "文件上传失败!"; } }
		 * 
		 * } return "文件上传成功!";
		 */
	     LOGGER.info("multiUploading");	
	     String userId = request.getRemoteUser();
	     String admin = configBeanProp.getAdmin();
	      
	     if(userId.equals(admin)) {
		     try {
		    	 myBatisProjDigestService.addProjDigests(files);
		     }catch (Exception e) {
		    	String msg = "上传文件失败";
		    	return ExceptionHelper.handlerException(LOGGER, msg, e);
		    	 
		     }
	     }else {
	    	 String msg="上传文件需要管理员权限！";
	    	 Exception e = new Exception();
	    	 return ExceptionHelper.handlerException(LOGGER, msg, e);
	     }
	     
	     return RestResponseBo.ok(); 
	      
	}
	
	@RequestMapping("projDigestQuery")
	public String projDigestQuery() {
		return "projDigestQuery";
	}
	
	
	@RequestMapping("get_projDigest")
	@ResponseBody
	public Object getProjDigestList(@RequestParam("order")String order,@RequestParam("page")int page, @RequestParam("rows") int rows
				,@RequestParam("sort")String sort,@RequestParam("projOutcomeId") String projOutcomeId
				, @RequestParam("projName")String projName,@RequestParam("projNum") String projNum
				, @RequestParam("lob")String lob ){
		LOGGER.info("get_projDigest");
		LOGGER.info("order: " + order);
		LOGGER.info("page: " + page);
		LOGGER.info("rows: " + rows);
		LOGGER.info("sort: " + sort);
		try { 
			PageInfo<TProjdigest> pageInfo = myBatisProjDigestService.findProjDigests(order,page,rows,sort,projOutcomeId, projName,projNum, lob );
			
			for(TProjdigest projDigest: pageInfo.getList()) {
				LOGGER.info("id: " + projDigest.getId());
				LOGGER.info("projOutcomeId: " + projDigest.getProjOutcomeId());
				LOGGER.info("lob: " + projDigest.getLob());
				LOGGER.info("projName: " + projDigest.getProjName());
			}
			
			Map<Object,Object> resultMap = new HashMap<Object,Object>();
			resultMap.put("total", pageInfo.getTotal());
			resultMap.put("rows", pageInfo.getList());
			LOGGER.info("resultMap:" + resultMap.get("total"));
			return resultMap;		
		}catch (Exception e) {
			String msg = "查询摘要失败";
	    	return ExceptionHelper.handlerException(LOGGER, msg, e); 
		}
					
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Object projDigestAdd(TProjdigest tProjdigest) {
		LOGGER.info("add");
		try {
		 myBatisProjDigestService.addProjDigest(tProjdigest);
		}catch(Exception e) {
			String msg = "添加摘要失败";
	    	return ExceptionHelper.handlerException(LOGGER, msg, e);
		}
		 return RestResponseBo.ok();  
	}
	
	
	@RequestMapping("update")
	@ResponseBody
	public Object projDigestUpdate(TProjdigest tProjdigest) {
		LOGGER.info("add");
		try {
			myBatisProjDigestService.updateProjDigest(tProjdigest);
		}catch(Exception e) {
			String msg = "修改摘要失败";
	    	return ExceptionHelper.handlerException(LOGGER, msg, e);
		}
		return RestResponseBo.ok();
	}
	
	@RequestMapping("/get_distinctLob")
	@ResponseBody
	public Object get_distinctLob() {
		try {
			List<Lob> lobs = myBatisProjDigestService.get_distinctLob();
			return lobs;
		}catch(Exception e) {
			String msg = "获取LOB失败";
	    	return ExceptionHelper.handlerException(LOGGER, msg, e);
		}
		
		
	}
	
	@RequestMapping("/delByIds")
	@ResponseBody
	public Object delByIds(String ids) {
		try {
			myBatisProjDigestService.delByIds(ids);
		}catch(Exception e) {
			String msg = "删除摘要失败";
	    	return ExceptionHelper.handlerException(LOGGER, msg, e);
		}
		return RestResponseBo.ok();
	}
	
			
}
