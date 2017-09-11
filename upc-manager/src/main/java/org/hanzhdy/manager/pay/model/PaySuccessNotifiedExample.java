package org.hanzhdy.manager.pay.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class PaySuccessNotifiedExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public PaySuccessNotifiedExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
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
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: pay_success_notified
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

        public Criteria andPaySuccessNotifiedIdIsNull() {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdIsNotNull() {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdEqualTo(Long value) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID =", value, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdNotEqualTo(Long value) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID <>", value, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdGreaterThan(Long value) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID >", value, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID >=", value, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdLessThan(Long value) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID <", value, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdLessThanOrEqualTo(Long value) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID <=", value, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdIn(List<Long> values) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID in", values, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdNotIn(List<Long> values) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID not in", values, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdBetween(Long value1, Long value2) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID between", value1, value2, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPaySuccessNotifiedIdNotBetween(Long value1, Long value2) {
            addCriterion("PAY_SUCCESS_NOTIFIED_ID not between", value1, value2, "paySuccessNotifiedId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdIsNull() {
            addCriterion("PAY_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdIsNotNull() {
            addCriterion("PAY_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdEqualTo(String value) {
            addCriterion("PAY_INFO_ID =", value, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdNotEqualTo(String value) {
            addCriterion("PAY_INFO_ID <>", value, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdGreaterThan(String value) {
            addCriterion("PAY_INFO_ID >", value, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_INFO_ID >=", value, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdLessThan(String value) {
            addCriterion("PAY_INFO_ID <", value, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdLessThanOrEqualTo(String value) {
            addCriterion("PAY_INFO_ID <=", value, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdLike(String value) {
            addCriterion("PAY_INFO_ID like", value, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdNotLike(String value) {
            addCriterion("PAY_INFO_ID not like", value, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdIn(List<String> values) {
            addCriterion("PAY_INFO_ID in", values, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdNotIn(List<String> values) {
            addCriterion("PAY_INFO_ID not in", values, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdBetween(String value1, String value2) {
            addCriterion("PAY_INFO_ID between", value1, value2, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andPayInfoIdNotBetween(String value1, String value2) {
            addCriterion("PAY_INFO_ID not between", value1, value2, "payInfoId");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNull() {
            addCriterion("NOTIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNotNull() {
            addCriterion("NOTIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeEqualTo(Date value) {
            addCriterion("NOTIFY_TIME =", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotEqualTo(Date value) {
            addCriterion("NOTIFY_TIME <>", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThan(Date value) {
            addCriterion("NOTIFY_TIME >", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NOTIFY_TIME >=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThan(Date value) {
            addCriterion("NOTIFY_TIME <", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("NOTIFY_TIME <=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIn(List<Date> values) {
            addCriterion("NOTIFY_TIME in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotIn(List<Date> values) {
            addCriterion("NOTIFY_TIME not in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeBetween(Date value1, Date value2) {
            addCriterion("NOTIFY_TIME between", value1, value2, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("NOTIFY_TIME not between", value1, value2, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("NOTIFY_URL is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("NOTIFY_URL is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("NOTIFY_URL =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("NOTIFY_URL <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("NOTIFY_URL >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_URL >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("NOTIFY_URL <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_URL <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("NOTIFY_URL like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("NOTIFY_URL not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("NOTIFY_URL in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("NOTIFY_URL not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("NOTIFY_URL between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_URL not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andReturnResultIsNull() {
            addCriterion("RETURN_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andReturnResultIsNotNull() {
            addCriterion("RETURN_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andReturnResultEqualTo(String value) {
            addCriterion("RETURN_RESULT =", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultNotEqualTo(String value) {
            addCriterion("RETURN_RESULT <>", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultGreaterThan(String value) {
            addCriterion("RETURN_RESULT >", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_RESULT >=", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultLessThan(String value) {
            addCriterion("RETURN_RESULT <", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultLessThanOrEqualTo(String value) {
            addCriterion("RETURN_RESULT <=", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultLike(String value) {
            addCriterion("RETURN_RESULT like", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultNotLike(String value) {
            addCriterion("RETURN_RESULT not like", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultIn(List<String> values) {
            addCriterion("RETURN_RESULT in", values, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultNotIn(List<String> values) {
            addCriterion("RETURN_RESULT not in", values, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultBetween(String value1, String value2) {
            addCriterion("RETURN_RESULT between", value1, value2, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultNotBetween(String value1, String value2) {
            addCriterion("RETURN_RESULT not between", value1, value2, "returnResult");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pay_success_notified
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: pay_success_notified
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