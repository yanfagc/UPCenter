package org.hanzhdy.manager.pay.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class PrepayInfoExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public PrepayInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
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
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: prepay_info
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

        public Criteria andPrepayInfoIdIsNull() {
            addCriterion("PREPAY_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdIsNotNull() {
            addCriterion("PREPAY_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdEqualTo(String value) {
            addCriterion("PREPAY_INFO_ID =", value, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdNotEqualTo(String value) {
            addCriterion("PREPAY_INFO_ID <>", value, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdGreaterThan(String value) {
            addCriterion("PREPAY_INFO_ID >", value, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("PREPAY_INFO_ID >=", value, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdLessThan(String value) {
            addCriterion("PREPAY_INFO_ID <", value, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdLessThanOrEqualTo(String value) {
            addCriterion("PREPAY_INFO_ID <=", value, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdLike(String value) {
            addCriterion("PREPAY_INFO_ID like", value, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdNotLike(String value) {
            addCriterion("PREPAY_INFO_ID not like", value, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdIn(List<String> values) {
            addCriterion("PREPAY_INFO_ID in", values, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdNotIn(List<String> values) {
            addCriterion("PREPAY_INFO_ID not in", values, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdBetween(String value1, String value2) {
            addCriterion("PREPAY_INFO_ID between", value1, value2, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andPrepayInfoIdNotBetween(String value1, String value2) {
            addCriterion("PREPAY_INFO_ID not between", value1, value2, "prepayInfoId");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoIsNull() {
            addCriterion("APP_TRADE_NO is null");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoIsNotNull() {
            addCriterion("APP_TRADE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoEqualTo(String value) {
            addCriterion("APP_TRADE_NO =", value, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoNotEqualTo(String value) {
            addCriterion("APP_TRADE_NO <>", value, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoGreaterThan(String value) {
            addCriterion("APP_TRADE_NO >", value, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("APP_TRADE_NO >=", value, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoLessThan(String value) {
            addCriterion("APP_TRADE_NO <", value, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoLessThanOrEqualTo(String value) {
            addCriterion("APP_TRADE_NO <=", value, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoLike(String value) {
            addCriterion("APP_TRADE_NO like", value, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoNotLike(String value) {
            addCriterion("APP_TRADE_NO not like", value, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoIn(List<String> values) {
            addCriterion("APP_TRADE_NO in", values, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoNotIn(List<String> values) {
            addCriterion("APP_TRADE_NO not in", values, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoBetween(String value1, String value2) {
            addCriterion("APP_TRADE_NO between", value1, value2, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppTradeNoNotBetween(String value1, String value2) {
            addCriterion("APP_TRADE_NO not between", value1, value2, "appTradeNo");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
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

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andAppIpIsNull() {
            addCriterion("APP_IP is null");
            return (Criteria) this;
        }

        public Criteria andAppIpIsNotNull() {
            addCriterion("APP_IP is not null");
            return (Criteria) this;
        }

        public Criteria andAppIpEqualTo(String value) {
            addCriterion("APP_IP =", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpNotEqualTo(String value) {
            addCriterion("APP_IP <>", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpGreaterThan(String value) {
            addCriterion("APP_IP >", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpGreaterThanOrEqualTo(String value) {
            addCriterion("APP_IP >=", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpLessThan(String value) {
            addCriterion("APP_IP <", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpLessThanOrEqualTo(String value) {
            addCriterion("APP_IP <=", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpLike(String value) {
            addCriterion("APP_IP like", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpNotLike(String value) {
            addCriterion("APP_IP not like", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpIn(List<String> values) {
            addCriterion("APP_IP in", values, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpNotIn(List<String> values) {
            addCriterion("APP_IP not in", values, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpBetween(String value1, String value2) {
            addCriterion("APP_IP between", value1, value2, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpNotBetween(String value1, String value2) {
            addCriterion("APP_IP not between", value1, value2, "appIp");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table prepay_info
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: prepay_info
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