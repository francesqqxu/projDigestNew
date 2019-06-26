package com.chinasofti.projectDigest.pojo;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_projdigest
 */
public class TProjdigest {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_outcome_id
	 * @mbg.generated
	 */
	private String projOutcomeId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.lob
	 * @mbg.generated
	 */
	private String lob;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_name
	 * @mbg.generated
	 */
	private String projName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_num
	 * @mbg.generated
	 */
	private String projNum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.cust_name
	 * @mbg.generated
	 */
	private String custName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_brief
	 * @mbg.generated
	 */
	private String projBrief;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_begin_date
	 * @mbg.generated
	 */
	private String projBeginDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_end_date
	 * @mbg.generated
	 */
	private String projEndDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.archive_path
	 * @mbg.generated
	 */
	private String archivePath;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_manager_name
	 * @mbg.generated
	 */
	private String projManagerName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_manage_id
	 * @mbg.generated
	 */
	private String projManageId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_manage_email
	 * @mbg.generated
	 */
	private String projManageEmail;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.proj_manage_tel
	 * @mbg.generated
	 */
	private String projManageTel;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.industry_category
	 * @mbg.generated
	 */
	private String industryCategory;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.field_category
	 * @mbg.generated
	 */
	private String fieldCategory;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.application_category
	 * @mbg.generated
	 */
	private String applicationCategory;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.used_language
	 * @mbg.generated
	 */
	private String usedLanguage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.system_soft
	 * @mbg.generated
	 */
	private String systemSoft;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.system_hard
	 * @mbg.generated
	 */
	private String systemHard;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.used_database
	 * @mbg.generated
	 */
	private String usedDatabase;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.test_framework
	 * @mbg.generated
	 */
	private String testFramework;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.key_tech_skills
	 * @mbg.generated
	 */
	private String keyTechSkills;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.user_id
	 * @mbg.generated
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_projdigest.is_import
	 * @mbg.generated
	 */
	private String isImport;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.id
	 * @return  the value of t_projdigest.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.id
	 * @param id  the value for t_projdigest.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_outcome_id
	 * @return  the value of t_projdigest.proj_outcome_id
	 * @mbg.generated
	 */
	public String getProjOutcomeId() {
		return projOutcomeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_outcome_id
	 * @param projOutcomeId  the value for t_projdigest.proj_outcome_id
	 * @mbg.generated
	 */
	public void setProjOutcomeId(String projOutcomeId) {
		this.projOutcomeId = projOutcomeId == null ? null : projOutcomeId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.lob
	 * @return  the value of t_projdigest.lob
	 * @mbg.generated
	 */
	public String getLob() {
		return lob;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.lob
	 * @param lob  the value for t_projdigest.lob
	 * @mbg.generated
	 */
	public void setLob(String lob) {
		this.lob = lob == null ? null : lob.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_name
	 * @return  the value of t_projdigest.proj_name
	 * @mbg.generated
	 */
	public String getProjName() {
		return projName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_name
	 * @param projName  the value for t_projdigest.proj_name
	 * @mbg.generated
	 */
	public void setProjName(String projName) {
		this.projName = projName == null ? null : projName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_num
	 * @return  the value of t_projdigest.proj_num
	 * @mbg.generated
	 */
	public String getProjNum() {
		return projNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_num
	 * @param projNum  the value for t_projdigest.proj_num
	 * @mbg.generated
	 */
	public void setProjNum(String projNum) {
		this.projNum = projNum == null ? null : projNum.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.cust_name
	 * @return  the value of t_projdigest.cust_name
	 * @mbg.generated
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.cust_name
	 * @param custName  the value for t_projdigest.cust_name
	 * @mbg.generated
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_brief
	 * @return  the value of t_projdigest.proj_brief
	 * @mbg.generated
	 */
	public String getProjBrief() {
		return projBrief;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_brief
	 * @param projBrief  the value for t_projdigest.proj_brief
	 * @mbg.generated
	 */
	public void setProjBrief(String projBrief) {
		this.projBrief = projBrief == null ? null : projBrief.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_begin_date
	 * @return  the value of t_projdigest.proj_begin_date
	 * @mbg.generated
	 */
	public String getProjBeginDate() {
		return projBeginDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_begin_date
	 * @param projBeginDate  the value for t_projdigest.proj_begin_date
	 * @mbg.generated
	 */
	public void setProjBeginDate(String projBeginDate) {
		this.projBeginDate = projBeginDate == null ? null : projBeginDate.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_end_date
	 * @return  the value of t_projdigest.proj_end_date
	 * @mbg.generated
	 */
	public String getProjEndDate() {
		return projEndDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_end_date
	 * @param projEndDate  the value for t_projdigest.proj_end_date
	 * @mbg.generated
	 */
	public void setProjEndDate(String projEndDate) {
		this.projEndDate = projEndDate == null ? null : projEndDate.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.archive_path
	 * @return  the value of t_projdigest.archive_path
	 * @mbg.generated
	 */
	public String getArchivePath() {
		return archivePath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.archive_path
	 * @param archivePath  the value for t_projdigest.archive_path
	 * @mbg.generated
	 */
	public void setArchivePath(String archivePath) {
		this.archivePath = archivePath == null ? null : archivePath.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_manager_name
	 * @return  the value of t_projdigest.proj_manager_name
	 * @mbg.generated
	 */
	public String getProjManagerName() {
		return projManagerName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_manager_name
	 * @param projManagerName  the value for t_projdigest.proj_manager_name
	 * @mbg.generated
	 */
	public void setProjManagerName(String projManagerName) {
		this.projManagerName = projManagerName == null ? null : projManagerName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_manage_id
	 * @return  the value of t_projdigest.proj_manage_id
	 * @mbg.generated
	 */
	public String getProjManageId() {
		return projManageId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_manage_id
	 * @param projManageId  the value for t_projdigest.proj_manage_id
	 * @mbg.generated
	 */
	public void setProjManageId(String projManageId) {
		this.projManageId = projManageId == null ? null : projManageId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_manage_email
	 * @return  the value of t_projdigest.proj_manage_email
	 * @mbg.generated
	 */
	public String getProjManageEmail() {
		return projManageEmail;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_manage_email
	 * @param projManageEmail  the value for t_projdigest.proj_manage_email
	 * @mbg.generated
	 */
	public void setProjManageEmail(String projManageEmail) {
		this.projManageEmail = projManageEmail == null ? null : projManageEmail.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.proj_manage_tel
	 * @return  the value of t_projdigest.proj_manage_tel
	 * @mbg.generated
	 */
	public String getProjManageTel() {
		return projManageTel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.proj_manage_tel
	 * @param projManageTel  the value for t_projdigest.proj_manage_tel
	 * @mbg.generated
	 */
	public void setProjManageTel(String projManageTel) {
		this.projManageTel = projManageTel == null ? null : projManageTel.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.industry_category
	 * @return  the value of t_projdigest.industry_category
	 * @mbg.generated
	 */
	public String getIndustryCategory() {
		return industryCategory;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.industry_category
	 * @param industryCategory  the value for t_projdigest.industry_category
	 * @mbg.generated
	 */
	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory == null ? null : industryCategory.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.field_category
	 * @return  the value of t_projdigest.field_category
	 * @mbg.generated
	 */
	public String getFieldCategory() {
		return fieldCategory;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.field_category
	 * @param fieldCategory  the value for t_projdigest.field_category
	 * @mbg.generated
	 */
	public void setFieldCategory(String fieldCategory) {
		this.fieldCategory = fieldCategory == null ? null : fieldCategory.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.application_category
	 * @return  the value of t_projdigest.application_category
	 * @mbg.generated
	 */
	public String getApplicationCategory() {
		return applicationCategory;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.application_category
	 * @param applicationCategory  the value for t_projdigest.application_category
	 * @mbg.generated
	 */
	public void setApplicationCategory(String applicationCategory) {
		this.applicationCategory = applicationCategory == null ? null : applicationCategory.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.used_language
	 * @return  the value of t_projdigest.used_language
	 * @mbg.generated
	 */
	public String getUsedLanguage() {
		return usedLanguage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.used_language
	 * @param usedLanguage  the value for t_projdigest.used_language
	 * @mbg.generated
	 */
	public void setUsedLanguage(String usedLanguage) {
		this.usedLanguage = usedLanguage == null ? null : usedLanguage.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.system_soft
	 * @return  the value of t_projdigest.system_soft
	 * @mbg.generated
	 */
	public String getSystemSoft() {
		return systemSoft;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.system_soft
	 * @param systemSoft  the value for t_projdigest.system_soft
	 * @mbg.generated
	 */
	public void setSystemSoft(String systemSoft) {
		this.systemSoft = systemSoft == null ? null : systemSoft.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.system_hard
	 * @return  the value of t_projdigest.system_hard
	 * @mbg.generated
	 */
	public String getSystemHard() {
		return systemHard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.system_hard
	 * @param systemHard  the value for t_projdigest.system_hard
	 * @mbg.generated
	 */
	public void setSystemHard(String systemHard) {
		this.systemHard = systemHard == null ? null : systemHard.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.used_database
	 * @return  the value of t_projdigest.used_database
	 * @mbg.generated
	 */
	public String getUsedDatabase() {
		return usedDatabase;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.used_database
	 * @param usedDatabase  the value for t_projdigest.used_database
	 * @mbg.generated
	 */
	public void setUsedDatabase(String usedDatabase) {
		this.usedDatabase = usedDatabase == null ? null : usedDatabase.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.test_framework
	 * @return  the value of t_projdigest.test_framework
	 * @mbg.generated
	 */
	public String getTestFramework() {
		return testFramework;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.test_framework
	 * @param testFramework  the value for t_projdigest.test_framework
	 * @mbg.generated
	 */
	public void setTestFramework(String testFramework) {
		this.testFramework = testFramework == null ? null : testFramework.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.key_tech_skills
	 * @return  the value of t_projdigest.key_tech_skills
	 * @mbg.generated
	 */
	public String getKeyTechSkills() {
		return keyTechSkills;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.key_tech_skills
	 * @param keyTechSkills  the value for t_projdigest.key_tech_skills
	 * @mbg.generated
	 */
	public void setKeyTechSkills(String keyTechSkills) {
		this.keyTechSkills = keyTechSkills == null ? null : keyTechSkills.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.user_id
	 * @return  the value of t_projdigest.user_id
	 * @mbg.generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.user_id
	 * @param userId  the value for t_projdigest.user_id
	 * @mbg.generated
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_projdigest.is_import
	 * @return  the value of t_projdigest.is_import
	 * @mbg.generated
	 */
	public String getIsImport() {
		return isImport;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_projdigest.is_import
	 * @param isImport  the value for t_projdigest.is_import
	 * @mbg.generated
	 */
	public void setIsImport(String isImport) {
		this.isImport = isImport == null ? null : isImport.trim();
	}
}