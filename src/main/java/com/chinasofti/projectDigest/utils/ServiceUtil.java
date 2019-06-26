package com.chinasofti.projectDigest.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.chinasofti.projectDigest.exception.TipException;
import com.chinasofti.projectDigest.pojo.TProjdigest;
import com.chinasofti.projectDigest.pojo.TProjdigestOld;

public class ServiceUtil {
	
   
	private static final ServiceUtil INSTANCE = new ServiceUtil();
	
	private	 List<RuleViolation> RuleViolations  = new ArrayList<RuleViolation>();
	
	public static ServiceUtil getInstance() {
		
		return INSTANCE;
	}
	
	public   RuleViolation   checkColumnTitle(String fileName,List<String> titles) {
		
		if(!titles.get(0).contains("项目成果ID") && !titles.get(1).contains("所属LOB")) {
			 
			return new RuleViolation(fileName," 文件格式有错，请检查！");
		}
		return null;
			 
	}
	
	
	public   List<String> transferToColumnTitle(String fileName,List<String> titles) {
    	
    	Map<String, String>  titlesMap = new HashMap<String, String>();
    	
    	titlesMap.put("项目成果ID","projOutcomeId");
    	titlesMap.put("所属LOB","Lob");
    	titlesMap.put("项目名称","projName");
    	titlesMap.put("项目编号","projNum");
    	titlesMap.put("客户名称","custName");
    	titlesMap.put("相关项目名称/编号1","relateProjName1");
    	titlesMap.put("相关项目名称/编号2","relateProjName2");
    	titlesMap.put("相关项目名称/编号3","relateProjName3");
    	titlesMap.put("工程分包说明","SubcontractState");
    	titlesMap.put("项目经理姓名","projManagerName");
    	titlesMap.put("项目经理ID","projManageId");
    	titlesMap.put("项目经理邮箱","projManageEmail");
    	titlesMap.put("项目经理电话","projManageTel");
    	titlesMap.put("项目经理主管姓名","projManagerDirectorName");
    	titlesMap.put("项目骨干员工1","projBackbone1");
    	titlesMap.put("项目骨干员工2","projBackbone2");
    	titlesMap.put("项目骨干员工3","projBackBone3");
    	titlesMap.put("项目开始日期","projBeginDate");
    	titlesMap.put("项目关闭日期","projEndDate");
    	titlesMap.put("填表日期","inputDate");
    	titlesMap.put("填表时项目状态","projState");
    	titlesMap.put("业务&技术关键字1","businessTechKey1");
    	titlesMap.put("业务&技术关键字2","businessTechKey2");
    	titlesMap.put("业务&技术关键字3","businessTechKey3");
    	titlesMap.put("业务简述","businessBrief");
    	titlesMap.put("业务功能","businessFunc");
    	titlesMap.put("性能指标","performanceIndex");
    	titlesMap.put("系统软件","systemSoft");
    	titlesMap.put("系统硬件","systemHard");
    	titlesMap.put("系统架构","systemArchitec");
    	titlesMap.put("相关标准","relaventStandard");
    	titlesMap.put("关键技术&技能","keyTechSkills");
    	titlesMap.put("所用工具","usetools");
    	titlesMap.put("遗留问题","remainingProb");
    	titlesMap.put("市场竞争力","marketCompeti");
    	titlesMap.put("约束与依赖关系","constraintDepend");
        	
    	if(titlesMap.size() != titles.size()) {
    		//throw exception;
    	}
    	
    	List<String> titlesColumn = new ArrayList<String>();
    	String title = "";
    	int j=0;
    	for(int i=0; i <titles.size(); i++){
    		if(null != titles.get(i) || "" != titles.get(i)) {
    			title = titles.get(i);
    		 
	    		Iterator<Entry<String, String>> entries = titlesMap.entrySet().iterator();
	    		while(entries.hasNext()){
	    			Map.Entry<String, String>   entry = (Entry<String, String>) entries.next();
	    			if(entry.getKey().equals(title)){
	    			      titlesColumn.add(j, (String)entry.getValue());
	    			      j++;
	    			      break; 
	    			}
	    					
	    		}
    		}
    		 
    	}
    	
    	return titlesColumn;
    }
    
	
	public  List<TProjdigest>  OldProjdigestToProjdigest (List<TProjdigestOld> tProjdigestOlds) {
		
		List<TProjdigest>  tProjDigests = new ArrayList<TProjdigest>();
		String projBrief = "";
		String keyTech = "";
		
		
		
		 
		for(TProjdigestOld tProjdigestOld:tProjdigestOlds) {
			
			TProjdigest tProjdigest = new TProjdigest();
			
			projBrief = tProjdigestOld.getRelateProjName1() + " " + tProjdigestOld.getRelateProjName2()  
					 + " " + tProjdigestOld.getRelateProjName3() + " " + tProjdigestOld.getProjBackbone1()  
					 + " " + tProjdigestOld.getProjBackbone2() + " " + tProjdigestOld.getProjBackbone3()
					 + " " + tProjdigestOld.getProjState() + " " + tProjdigestOld.getBusinessBrief() 
					 + " " + tProjdigestOld.getBusinessFunc() + " "  + tProjdigestOld.getPerformanceIndex()
					 + " " + tProjdigestOld.getSystemArchitec()  + " " + tProjdigestOld.getRelaventStandard()
					 + " " + tProjdigestOld.getUsetools() + " " + tProjdigestOld.getRemainingProb() 
					 + " " + tProjdigestOld.getMarketCompeti();
			keyTech = tProjdigestOld.getBusinessTechKey1() + " " + tProjdigestOld.getBusinessTechKey2()
			         + " " + tProjdigestOld.getBusinessTechKey3() + " " + tProjdigestOld.getKeyTechSkills();
			
			tProjdigest.setProjOutcomeId(tProjdigestOld.getProjOutcomeId());
			tProjdigest.setLob(tProjdigestOld.getLob());
			
			tProjdigest.setProjName(tProjdigestOld.getProjName());
			tProjdigest.setProjNum(tProjdigestOld.getProjNum());
			tProjdigest.setCustName(tProjdigestOld.getCustName());
			
			tProjdigest.setProjBeginDate(tProjdigestOld.getProjBeginDate());
			tProjdigest.setProjEndDate(tProjdigestOld.getProjEndDate());
			//tProjdigest.setUsedLanguage(tProjdigestOld.getKeyTechSkills());
			//tProjdigest.setUsedDatabase(tProjdigestOld.getKeyTechSkills());
			tProjdigest.setProjManagerName(tProjdigestOld.getProjManagerName());
			tProjdigest.setProjManageId(tProjdigestOld.getProjManageId());
			tProjdigest.setProjManageEmail(tProjdigestOld.getProjManageEmail());
			tProjdigest.setProjManageTel(tProjdigestOld.getProjManageTel());
			
			tProjdigest.setSystemSoft(tProjdigestOld.getSystemSoft());
			tProjdigest.setSystemHard(tProjdigestOld.getSystemHard());
			tProjdigest.setProjBrief(projBrief);
			tProjdigest.setKeyTechSkills(keyTech);
			tProjdigest.setIsImport("1");
			tProjDigests.add(tProjdigest);
		}
		
		
		return tProjDigests;
	}
	
	public String getColumnName (String columnNameFromFront) {
		
		String columnName = "";
		
		Map<String, String>  titlesMap = new HashMap<String, String>();
    	
    	titlesMap.put("项目成果ID","projOutcomeId");
    	titlesMap.put("所属LOB","Lob");
    	titlesMap.put("项目名称","projName");
    	titlesMap.put("项目编号","projNum");
    	titlesMap.put("客户名称","custName");
    	titlesMap.put("相关项目名称/编号1","relateProjName1");
    	titlesMap.put("相关项目名称/编号2","relateProjName2");
    	titlesMap.put("相关项目名称/编号3","relateProjName3");
    	titlesMap.put("工程分包说明","SubcontractState");
    	titlesMap.put("项目经理姓名","projManagerName");
    	titlesMap.put("项目经理ID","projManageId");
    	titlesMap.put("项目经理邮箱","projManageEmail");
    	titlesMap.put("项目经理电话","projManageTel");
    	titlesMap.put("项目经理主管姓名","projManagerDirectorName");
    	titlesMap.put("项目骨干员工1","projBackbone1");
    	titlesMap.put("项目骨干员工2","projBackbone2");
    	titlesMap.put("项目骨干员工3","projBackBone3");
    	titlesMap.put("项目开始日期","projBeginDate");
    	titlesMap.put("项目关闭日期","projEndDate");
    	titlesMap.put("填表日期","inputDate");
    	titlesMap.put("填表时项目状态","projState");
    	titlesMap.put("业务&技术关键字1","businessTechKey1");
    	titlesMap.put("业务&技术关键字2","businessTechKey2");
    	titlesMap.put("业务&技术关键字3","businessTechKey3");
    	titlesMap.put("业务简述","businessBrief");
    	titlesMap.put("业务功能","businessFunc");
    	titlesMap.put("性能指标","performanceIndex");
    	titlesMap.put("系统软件","systemSoft");
    	titlesMap.put("系统硬件","systemHard");
    	titlesMap.put("系统架构","systemArchitec");
    	titlesMap.put("相关标准","relaventStandard");
    	titlesMap.put("关键技术&技能","keyTechSkills");
    	titlesMap.put("所用工具","usetools");
    	titlesMap.put("遗留问题","remainingProb");
    	titlesMap.put("市场竞争力","marketCompeti");
    	titlesMap.put("约束与依赖关系","constraintDepend");
    	
    	Iterator<Entry<String, String>> entries = titlesMap.entrySet().iterator();
		while(entries.hasNext()){
			Map.Entry<String, String>   entry = (Entry<String, String>) entries.next();
			if(entry.getKey().equals(columnNameFromFront)){
			      columnName=entry.getValue();
			      break; 
			}
					
		}
		return columnName;
	}
	
	public class RuleViolation
    {
        public RuleViolation(String propertyName, String errorMessage)
        {
            PropertyName = propertyName;
            ErrorMessage = errorMessage;
        }
        
        String PropertyName;
        String ErrorMessage;
        
		public String getPropertyName() {
			return PropertyName;
		}
		public void setPropertyName(String propertyName) {
			PropertyName = propertyName;
		}
		public String getErrorMessage() {
			return ErrorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			ErrorMessage = errorMessage;
		}
        
    }  
	
	 public  String RuleViolationsString(List<RuleViolation> RuleViolations)
     {
         
             if (RuleViolations.size() <= 0) return  "";
             StringBuilder sb = new StringBuilder();
             for (RuleViolation rv : RuleViolations)
             {
                 sb.append (rv.PropertyName + ":" +  rv.ErrorMessage + "\n");
             }
             return sb.toString();
     }     

    public void validate(TProjdigest tProjdigest) {
    	
    	
    	
    	if(null==tProjdigest.getProjOutcomeId() || ""==tProjdigest.getProjOutcomeId()) {
    		RuleViolations.add(new RuleViolation("projOutcomeId", "项目成果ID必填" ));
    	}
    }

}
