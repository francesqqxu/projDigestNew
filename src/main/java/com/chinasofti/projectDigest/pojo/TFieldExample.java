package com.chinasofti.projectDigest.pojo;

import java.util.ArrayList;
import java.util.List;

public class TFieldExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_field
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_field
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_field
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public TFieldExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_field
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_field
	 * @mbg.generated
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIndustryIdIsNull() {
			addCriterion("industry_id is null");
			return (Criteria) this;
		}

		public Criteria andIndustryIdIsNotNull() {
			addCriterion("industry_id is not null");
			return (Criteria) this;
		}

		public Criteria andIndustryIdEqualTo(Integer value) {
			addCriterion("industry_id =", value, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdNotEqualTo(Integer value) {
			addCriterion("industry_id <>", value, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdGreaterThan(Integer value) {
			addCriterion("industry_id >", value, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("industry_id >=", value, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdLessThan(Integer value) {
			addCriterion("industry_id <", value, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdLessThanOrEqualTo(Integer value) {
			addCriterion("industry_id <=", value, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdIn(List<Integer> values) {
			addCriterion("industry_id in", values, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdNotIn(List<Integer> values) {
			addCriterion("industry_id not in", values, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdBetween(Integer value1, Integer value2) {
			addCriterion("industry_id between", value1, value2, "industryId");
			return (Criteria) this;
		}

		public Criteria andIndustryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("industry_id not between", value1, value2, "industryId");
			return (Criteria) this;
		}

		public Criteria andFieldIsNull() {
			addCriterion("field is null");
			return (Criteria) this;
		}

		public Criteria andFieldIsNotNull() {
			addCriterion("field is not null");
			return (Criteria) this;
		}

		public Criteria andFieldEqualTo(String value) {
			addCriterion("field =", value, "field");
			return (Criteria) this;
		}

		public Criteria andFieldNotEqualTo(String value) {
			addCriterion("field <>", value, "field");
			return (Criteria) this;
		}

		public Criteria andFieldGreaterThan(String value) {
			addCriterion("field >", value, "field");
			return (Criteria) this;
		}

		public Criteria andFieldGreaterThanOrEqualTo(String value) {
			addCriterion("field >=", value, "field");
			return (Criteria) this;
		}

		public Criteria andFieldLessThan(String value) {
			addCriterion("field <", value, "field");
			return (Criteria) this;
		}

		public Criteria andFieldLessThanOrEqualTo(String value) {
			addCriterion("field <=", value, "field");
			return (Criteria) this;
		}

		public Criteria andFieldLike(String value) {
			addCriterion("field like", value, "field");
			return (Criteria) this;
		}

		public Criteria andFieldNotLike(String value) {
			addCriterion("field not like", value, "field");
			return (Criteria) this;
		}

		public Criteria andFieldIn(List<String> values) {
			addCriterion("field in", values, "field");
			return (Criteria) this;
		}

		public Criteria andFieldNotIn(List<String> values) {
			addCriterion("field not in", values, "field");
			return (Criteria) this;
		}

		public Criteria andFieldBetween(String value1, String value2) {
			addCriterion("field between", value1, value2, "field");
			return (Criteria) this;
		}

		public Criteria andFieldNotBetween(String value1, String value2) {
			addCriterion("field not between", value1, value2, "field");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_field
	 * @mbg.generated
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_field
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}