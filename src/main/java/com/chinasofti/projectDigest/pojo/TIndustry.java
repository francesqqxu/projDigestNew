package com.chinasofti.projectDigest.pojo;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_industry
 */
public class TIndustry {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_industry.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_industry.industry
	 * @mbg.generated
	 */
	private String industry;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_industry.id
	 * @return  the value of t_industry.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_industry.id
	 * @param id  the value for t_industry.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_industry.industry
	 * @return  the value of t_industry.industry
	 * @mbg.generated
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_industry.industry
	 * @param industry  the value for t_industry.industry
	 * @mbg.generated
	 */
	public void setIndustry(String industry) {
		this.industry = industry == null ? null : industry.trim();
	}
}