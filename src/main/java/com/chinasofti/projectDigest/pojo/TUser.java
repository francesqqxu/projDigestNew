package com.chinasofti.projectDigest.pojo;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_user
 */
public class TUser {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.username
	 * @mbg.generated
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.password
	 * @mbg.generated
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.chinesename
	 * @mbg.generated
	 */
	private String chinesename;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.id
	 * @return  the value of t_user.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.id
	 * @param id  the value for t_user.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.username
	 * @return  the value of t_user.username
	 * @mbg.generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.username
	 * @param username  the value for t_user.username
	 * @mbg.generated
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.password
	 * @return  the value of t_user.password
	 * @mbg.generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.password
	 * @param password  the value for t_user.password
	 * @mbg.generated
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.chinesename
	 * @return  the value of t_user.chinesename
	 * @mbg.generated
	 */
	public String getChinesename() {
		return chinesename;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.chinesename
	 * @param chinesename  the value for t_user.chinesename
	 * @mbg.generated
	 */
	public void setChinesename(String chinesename) {
		this.chinesename = chinesename == null ? null : chinesename.trim();
	}
}