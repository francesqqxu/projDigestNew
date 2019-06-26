package com.chinasofti.projectDigest.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.projectDigest.exception.TipException;
import com.chinasofti.projectDigest.pojo.TProjdigest;
import com.chinasofti.projectDigest.pojo.TProjdigestOld;
import com.chinasofti.projectDigest.utils.ServiceUtil.RuleViolation;

  

/** 
 * 读取Excel 
 *  
 * @author   
 */  
public class ExcelUtils {  
	
    private static final  Logger logger = LoggerFactory.getLogger(ExcelUtils.class);  
    private static Workbook wb = null;
   
    public static <T> T transToObject(List<String> titles,List<Object> values,Class<T> clz) throws Exception{
        T t = clz.newInstance();
        int size = titles.size();
        for(int i = 0;i<size;i++){
            if(values.size()<=i){
                break;
            }
            String title = titles.get(i).trim();
            Object value = values.get(i);
            setValue(t,clz,title,value);
        }
        return t;
    }
     
    private static void setValue(Object o,Class<?>clz,String title,Object value) throws Exception{
        
    	Method m = null;
        m = getSetMethod(title, clz);
        setValue(o, m, title,value);
    }
     
    private static void setValue(Object o,Method method,String title,Object value) throws Exception{
    	
        Class<?>[] clazz = method.getParameterTypes();  
       // String type = clazz[0].getName();
        if(null == value || "".equals(value)){
            return;
        }
        method.invoke(o, ConvertUtils.convert(value,clazz[0] ));
      
    }
     
    private static Method getSetMethod(String propName,Class<?> clz){
    	
        Method[] methods = clz.getMethods();
        
        for(Method method : methods){
            if(method.getName().toLowerCase().equals("set"+propName.toLowerCase())){
            	
                Class<?>[] clazz = method.getParameterTypes();
                if(clazz.length == 1){
                    return method;
                }
            }
        }
        return null;
    }
    
    /** 
     * 读取Excel表格表头的内容 
     *  
     * @param InputStream 
     * @return String 表头内容的数组 
     * @author 
     */  
    public static String[] readExcelTitle(String fileName,InputStream in) throws Exception{  
    	
    	// 获得工作簿对象
        wb = getWorkBook(fileName, in);
    	Sheet sheet = null;
    	Row row = null;
    	
        if(wb==null){  
            throw new Exception("Workbook对象为空！");  
        }  
        sheet = wb.getSheetAt(0);  
        int rowNum = sheet.getLastRowNum();   
        logger.info("rownum : {}" , rowNum);
        String[] titles = new String[rowNum - 1];  
        int j = 0;
        for (int i = 1; i < rowNum; i++) { 
        	 row = sheet.getRow(i);
        	 if(null != row) {
	        	logger.info("row.getCell({}) = {}", i, row.getCell(0));
	             titles[j] =(String)getCellFormatValue(row.getCell(0));  
	            //logger.info("title[{}] = {}", i, titles[j]);
	             j++;
        	 }
        }  
        return titles;  
    }  
    
      
    
    
    /** 
     * 读取Excel数据内容 
     *  
     * @param InputStream 
     * @return Map 包含单元格数据内容的Map对象 
     * @author  
     */  
    public static List<Object>  readExcelContent(String fileName,InputStream in) throws Exception{ 
    	
    	Sheet sheet = null;
    	Row row = null;
    	
        if(wb==null){  
            throw new Exception("Workbook对象为空！");  
        }  
                        
        sheet = wb.getSheetAt(0);  
        // 得到总行数  
        int rowNum = sheet.getLastRowNum();  
        row = sheet.getRow(0);  
        List<Object> cellValues = new ArrayList<Object>();
        Object obj = null;
        
        // 正文内容应该从第二行开始,第一行为表头的标题  
        for (int i = 1; i < rowNum; i++) {  
            row = sheet.getRow(i); 
            if(null != row) {
           //内容为第二列，第一列为标题
	            obj = getCellFormatValue(row.getCell(1));  
	            cellValues.add(obj);  
	             
	        }
             
        }  
        wb.close();
        return cellValues;
    }  
  
    
      
    /** 
     *  
     * 根据Cell类型设置数据 
     *  
     * @param cell 
     * @return 
     * @author  
     */  
    private static Object getCellFormatValue(Cell cell) throws ParseException{  
        
    	Object cellvalue = "";  
        if (cell != null) {  
            // 判断当前Cell的Type  
            switch (cell.getCellType()) { 
            
            case NUMERIC :// 如果当前Cell的Type为NUMERIC  
            	 // 判断当前的cell是否为Date  
                if (DateUtil.isCellDateFormatted(cell)) {  
                    // 如果是Date类型则，转化为Data格式  
                    // data格式是带时分秒的：2013-7-10 0:00:00  
                    // cellvalue = cell.getDateCellValue().toLocaleString();  
                    // data格式是不带带时分秒的：2013-7-10  
                    Date date =  cell.getDateCellValue();
                    SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
                    
                    cellvalue = formatter.format(date); 
                } else {// 如果是纯数字  
  
                    // 取得当前Cell的数值  
                	DecimalFormat df = new DecimalFormat("#.00");
                	cellvalue = df.format(cell.getNumericCellValue());
                  //  cellvalue = String.valueOf(cell.getNumericCellValue());  
                }  
                break;  
            case  FORMULA: 
                 cellvalue = cell.getCellFormula();
                 break;
            case  STRING:// 如果当前Cell的Type为STRING  
                // 取得当前的Cell字符串  
                cellvalue = cell.getRichStringCellValue().getString();  
                break;  
            case  BLANK:     
            	cellvalue = "";
                break;
            case  BOOLEAN: 
            	cellvalue = cell.getBooleanCellValue();
            	break;
            case  ERROR: 
            	cellvalue = "";
            	break;
            default:// 默认的Cell值  
                cellvalue = "";  
            }  
        } else {  
            cellvalue = "";  
        }  
        return cellvalue;  
    }  
    
    /**
     * 获得工作簿对象
     *
     * @param excelFile excel文件
     * @return 工作簿对象
     */
    public static Workbook getWorkBook(String fileName, InputStream in) throws Exception {
        
    	//检查文件
    	checkFile(fileName);
        // 创建Workbook工作簿对象，表示整个excel
        Workbook workbook = null;
        
        // 根据文件后缀名不同(xls和xlsx)获得不同的workbook实现类对象
        if (fileName.endsWith("xls")) {
            // 2003版本
            workbook = new HSSFWorkbook(in);
        } else if (fileName.endsWith("xlsx") || (fileName.endsWith("xlsm"))) {
            // 2007版本
            workbook = new XSSFWorkbook(in);
        }
     
        return workbook;
    }
   
  
    /**
     * 检查文件
     *
     * @param excelFile excel文件
     * @throws IOException
     */
    public static void checkFile(String fileName) throws IOException {
        //判断文件是否存在
        if (null == fileName) {
            throw new FileNotFoundException("文件不存在");
        }
               
        //判断文件是否是excel文件
        if (!fileName.endsWith("xls") &&  !fileName.endsWith("xlsx") && !fileName.endsWith("xlsm")) {
            throw new IOException(fileName + "不是excel文件");
        }
    }


    public static void main(String[] args) throws ParseException{  
    	    	     	
    	List<TProjdigestOld>  tProjectDigestOlds = new ArrayList<TProjdigestOld>();
    	InputStream in = null;
    	ServiceUtil serviceUtil = ServiceUtil.getInstance();
    	RuleViolation ruleViolation = null;
    	List<RuleViolation> RuleViolations = new ArrayList<RuleViolation>();
    	
        try {  
            String fileName = "D:\\质量\\问题跟踪\\查询工具\\data\\1\\项目标签标准关键字汇总版-20190322.xlsx";  
            
            // 对读取Excel表格标题测试  
            in = new FileInputStream(fileName);
	        List<String> titles = java.util.Arrays.asList(ExcelUtils.readExcelTitle(fileName, in));  
	        System.out.println("获得Excel表格的标题:");  
	         for (String s : titles) {  
	              System.out.print(s + " ");  
	         }  
	        List<String> titlesColumn= serviceUtil.transferToColumnTitle(fileName,titles);
	        ruleViolation = serviceUtil.checkColumnTitle(fileName, titles); 
	        if(null != ruleViolation) {
				RuleViolations.add(ruleViolation);
			}
			else
			{
	            // 对读取Excel表格内容测试  
	            List<Object> cellValues = ExcelUtils.readExcelContent(fileName,in);  
	            System.out.println("获;得Excel表格的内容:");  
	            for (int i = 0; i < cellValues.size(); i++) {  
	                System.out.println(cellValues.get(i));  
	            }  
	            
	            TProjdigestOld tProjectDigestOld = new TProjdigestOld();
				 
	            tProjectDigestOld = ExcelUtils.transToObject(titlesColumn, cellValues, TProjdigestOld.class);
			    
	            tProjectDigestOlds.add(tProjectDigestOld);
			}
            
	        if(RuleViolations.size() > 0 ) {
				throw new TipException( serviceUtil.RuleViolationsString(RuleViolations));
			}
        } catch (FileNotFoundException e) {  
            System.out.println("未找到指定路径的文件!");  
            e.printStackTrace();  
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  