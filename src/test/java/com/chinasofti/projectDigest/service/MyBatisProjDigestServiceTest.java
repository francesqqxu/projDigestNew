package com.chinasofti.projectDigest.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.chinasofti.projectDigest.dao.TProjdigestMapper;
import com.chinasofti.projectDigest.pojo.TProjdigest;
import com.chinasofti.projectDigest.utils.ExcelUtils;
import com.chinasofti.projectDigest.utils.ServiceUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisProjDigestServiceTest {
	
	
	@Autowired
	private  TProjdigestMapper    tProjdigestMapper;
	
	@Test
	public void  addProjDigests() {
		List<String>  files = new ArrayList<String>();
		InputStream in = null;
		ServiceUtil serviceUtil = ServiceUtil.getInstance();
		
		files.add("D:\\质量\\问题跟踪\\查询工具\\data\\1\\PROJ_20140616_P14444060_01.xlsm");
		files.add("D:\\质量\\问题跟踪\\查询工具\\data\\1\\PROJ_20151221_P154A3002_01.xlsm");
		
		List<TProjdigest>  tProjDigests = new ArrayList<TProjdigest>();
		for(String file: files) {
			try {  
                
	            // 对读取Excel表格标题测试  
				in = new FileInputStream(file);
		        List<String> titles = java.util.Arrays.asList(ExcelUtils.readExcelTitle(file, in));  
		        System.out.println("获得Excel表格的标题:");  
		         for (String s : titles) {  
		              System.out.print(s + " ");  
		         }  
		        List<String> titlesColumn= serviceUtil.transferToColumnTitle(file,titles);
		         
	            // 对读取Excel表格内容测试  
	            List<Object> cellValues = ExcelUtils.readExcelContent(file,in);  
	            System.out.println("获得Excel表格的内容:");  
	            for (int i = 0; i < cellValues.size(); i++) {  
	                System.out.println(cellValues.get(i));  
	            }  
	            
	            TProjdigest tProjectDigest = new TProjdigest();
				 
	            tProjectDigest = ExcelUtils.transToObject(titlesColumn, cellValues, TProjdigest.class);
			    
	            tProjDigests.add(tProjectDigest);
				
				for(TProjdigest tProjDigest:tProjDigests) {
					System.out.println("ProjOutcomeId= " + tProjDigest.getProjOutcomeId());
					System.out.println("KeyTechSkill= " + tProjDigest.getKeyTechSkills());
					
				}
				
				
	            
	        } catch (FileNotFoundException e) {  
	            System.out.println("未找到指定路径的文件!");  
	            e.printStackTrace();  
	        }catch (Exception e) {  
	            e.printStackTrace();  
	        }  
       }
	   for(TProjdigest tProjDigest:tProjDigests ) {
			tProjdigestMapper.insert3(tProjDigest);
	   }
	}	
	 
}
