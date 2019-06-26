package com.chinasofti.projectDigest.dao;

import com.chinasofti.projectDigest.pojo.TProjdigest;
import com.chinasofti.projectDigest.pojo.TProjdigestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TProjdigestMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	long countByExample(TProjdigestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	int deleteByExample(TProjdigestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	int insert(TProjdigest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	int insertSelective(TProjdigest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	List<TProjdigest> selectByExample(TProjdigestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	TProjdigest selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") TProjdigest record, @Param("example") TProjdigestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") TProjdigest record, @Param("example") TProjdigestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(TProjdigest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_projdigest
	 * @mbg.generated
	 */
	int updateByPrimaryKey(TProjdigest record);

	//insert by useGeneratedKeys
    int insert2(TProjdigest record);
    
    //insert by selectKey(after)
    int insert3(TProjdigest record);
    
    //insert by selectKey(after)
    int insertSelective2(TProjdigest record);
    
    List<String> selectDistinctLob();
    
    List<TProjdigest> selectTProjdigestIndustryFieldApp(@Param("projOutcomeId") String projOutcomeId
    		, @Param("projName") String projName, @Param("projNum") String projNum, @Param("lob") String lob
    		, @Param("userId") String userId);
   
}