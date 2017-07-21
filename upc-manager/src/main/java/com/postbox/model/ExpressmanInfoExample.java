package com.postbox.model;

import com.postbox.enums.ExpressmanStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class ExpressmanInfoExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public ExpressmanInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
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

        public Criteria andExpressmanInfoIdIsNull() {
            addCriterion("EXPRESSMAN_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdIsNotNull() {
            addCriterion("EXPRESSMAN_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdEqualTo(Long value) {
            addCriterion("EXPRESSMAN_INFO_ID =", value, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdNotEqualTo(Long value) {
            addCriterion("EXPRESSMAN_INFO_ID <>", value, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdGreaterThan(Long value) {
            addCriterion("EXPRESSMAN_INFO_ID >", value, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("EXPRESSMAN_INFO_ID >=", value, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdLessThan(Long value) {
            addCriterion("EXPRESSMAN_INFO_ID <", value, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("EXPRESSMAN_INFO_ID <=", value, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdIn(List<Long> values) {
            addCriterion("EXPRESSMAN_INFO_ID in", values, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdNotIn(List<Long> values) {
            addCriterion("EXPRESSMAN_INFO_ID not in", values, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdBetween(Long value1, Long value2) {
            addCriterion("EXPRESSMAN_INFO_ID between", value1, value2, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressmanInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("EXPRESSMAN_INFO_ID not between", value1, value2, "expressmanInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdIsNull() {
            addCriterion("CUSTOMER_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdIsNotNull() {
            addCriterion("CUSTOMER_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdEqualTo(Long value) {
            addCriterion("CUSTOMER_INFO_ID =", value, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdNotEqualTo(Long value) {
            addCriterion("CUSTOMER_INFO_ID <>", value, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdGreaterThan(Long value) {
            addCriterion("CUSTOMER_INFO_ID >", value, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CUSTOMER_INFO_ID >=", value, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdLessThan(Long value) {
            addCriterion("CUSTOMER_INFO_ID <", value, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("CUSTOMER_INFO_ID <=", value, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdIn(List<Long> values) {
            addCriterion("CUSTOMER_INFO_ID in", values, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdNotIn(List<Long> values) {
            addCriterion("CUSTOMER_INFO_ID not in", values, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdBetween(Long value1, Long value2) {
            addCriterion("CUSTOMER_INFO_ID between", value1, value2, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andCustomerInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("CUSTOMER_INFO_ID not between", value1, value2, "customerInfoId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNull() {
            addCriterion("EXPRESS_COMPANY is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNotNull() {
            addCriterion("EXPRESS_COMPANY is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyEqualTo(String value) {
            addCriterion("EXPRESS_COMPANY =", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotEqualTo(String value) {
            addCriterion("EXPRESS_COMPANY <>", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThan(String value) {
            addCriterion("EXPRESS_COMPANY >", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_COMPANY >=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThan(String value) {
            addCriterion("EXPRESS_COMPANY <", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_COMPANY <=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLike(String value) {
            addCriterion("EXPRESS_COMPANY like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotLike(String value) {
            addCriterion("EXPRESS_COMPANY not like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIn(List<String> values) {
            addCriterion("EXPRESS_COMPANY in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotIn(List<String> values) {
            addCriterion("EXPRESS_COMPANY not in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyBetween(String value1, String value2) {
            addCriterion("EXPRESS_COMPANY between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_COMPANY not between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathIsNull() {
            addCriterion("IDCARD_IMG_PATH is null");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathIsNotNull() {
            addCriterion("IDCARD_IMG_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathEqualTo(String value) {
            addCriterion("IDCARD_IMG_PATH =", value, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathNotEqualTo(String value) {
            addCriterion("IDCARD_IMG_PATH <>", value, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathGreaterThan(String value) {
            addCriterion("IDCARD_IMG_PATH >", value, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("IDCARD_IMG_PATH >=", value, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathLessThan(String value) {
            addCriterion("IDCARD_IMG_PATH <", value, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathLessThanOrEqualTo(String value) {
            addCriterion("IDCARD_IMG_PATH <=", value, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathLike(String value) {
            addCriterion("IDCARD_IMG_PATH like", value, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathNotLike(String value) {
            addCriterion("IDCARD_IMG_PATH not like", value, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathIn(List<String> values) {
            addCriterion("IDCARD_IMG_PATH in", values, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathNotIn(List<String> values) {
            addCriterion("IDCARD_IMG_PATH not in", values, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathBetween(String value1, String value2) {
            addCriterion("IDCARD_IMG_PATH between", value1, value2, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andIdcardImgPathNotBetween(String value1, String value2) {
            addCriterion("IDCARD_IMG_PATH not between", value1, value2, "idcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathIsNull() {
            addCriterion("WORKCARD_IMG_PATH is null");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathIsNotNull() {
            addCriterion("WORKCARD_IMG_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathEqualTo(String value) {
            addCriterion("WORKCARD_IMG_PATH =", value, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathNotEqualTo(String value) {
            addCriterion("WORKCARD_IMG_PATH <>", value, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathGreaterThan(String value) {
            addCriterion("WORKCARD_IMG_PATH >", value, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("WORKCARD_IMG_PATH >=", value, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathLessThan(String value) {
            addCriterion("WORKCARD_IMG_PATH <", value, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathLessThanOrEqualTo(String value) {
            addCriterion("WORKCARD_IMG_PATH <=", value, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathLike(String value) {
            addCriterion("WORKCARD_IMG_PATH like", value, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathNotLike(String value) {
            addCriterion("WORKCARD_IMG_PATH not like", value, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathIn(List<String> values) {
            addCriterion("WORKCARD_IMG_PATH in", values, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathNotIn(List<String> values) {
            addCriterion("WORKCARD_IMG_PATH not in", values, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathBetween(String value1, String value2) {
            addCriterion("WORKCARD_IMG_PATH between", value1, value2, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andWorkcardImgPathNotBetween(String value1, String value2) {
            addCriterion("WORKCARD_IMG_PATH not between", value1, value2, "workcardImgPath");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(ExpressmanStatus value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(ExpressmanStatus value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(ExpressmanStatus value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(ExpressmanStatus value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(ExpressmanStatus value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(ExpressmanStatus value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(ExpressmanStatus value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(ExpressmanStatus value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<ExpressmanStatus> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<ExpressmanStatus> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(ExpressmanStatus value1, ExpressmanStatus value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(ExpressmanStatus value1, ExpressmanStatus value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("APPLYTIME is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("APPLYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Date value) {
            addCriterion("APPLYTIME =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Date value) {
            addCriterion("APPLYTIME <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Date value) {
            addCriterion("APPLYTIME >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLYTIME >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Date value) {
            addCriterion("APPLYTIME <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLYTIME <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Date> values) {
            addCriterion("APPLYTIME in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Date> values) {
            addCriterion("APPLYTIME not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Date value1, Date value2) {
            addCriterion("APPLYTIME between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLYTIME not between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andActivetimeIsNull() {
            addCriterion("ACTIVETIME is null");
            return (Criteria) this;
        }

        public Criteria andActivetimeIsNotNull() {
            addCriterion("ACTIVETIME is not null");
            return (Criteria) this;
        }

        public Criteria andActivetimeEqualTo(Date value) {
            addCriterion("ACTIVETIME =", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotEqualTo(Date value) {
            addCriterion("ACTIVETIME <>", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeGreaterThan(Date value) {
            addCriterion("ACTIVETIME >", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ACTIVETIME >=", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeLessThan(Date value) {
            addCriterion("ACTIVETIME <", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeLessThanOrEqualTo(Date value) {
            addCriterion("ACTIVETIME <=", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeIn(List<Date> values) {
            addCriterion("ACTIVETIME in", values, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotIn(List<Date> values) {
            addCriterion("ACTIVETIME not in", values, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeBetween(Date value1, Date value2) {
            addCriterion("ACTIVETIME between", value1, value2, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotBetween(Date value1, Date value2) {
            addCriterion("ACTIVETIME not between", value1, value2, "activetime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_expressman_info
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
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
}