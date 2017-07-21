package com.postbox.model;

import com.postbox.enums.BoxGroupStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class TBoxGroupExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public TBoxGroupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
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
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_box_group
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

        public Criteria andBoxGroupIdIsNull() {
            addCriterion("BOX_GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdIsNotNull() {
            addCriterion("BOX_GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdEqualTo(Long value) {
            addCriterion("BOX_GROUP_ID =", value, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdNotEqualTo(Long value) {
            addCriterion("BOX_GROUP_ID <>", value, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdGreaterThan(Long value) {
            addCriterion("BOX_GROUP_ID >", value, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BOX_GROUP_ID >=", value, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdLessThan(Long value) {
            addCriterion("BOX_GROUP_ID <", value, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("BOX_GROUP_ID <=", value, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdIn(List<Long> values) {
            addCriterion("BOX_GROUP_ID in", values, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdNotIn(List<Long> values) {
            addCriterion("BOX_GROUP_ID not in", values, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdBetween(Long value1, Long value2) {
            addCriterion("BOX_GROUP_ID between", value1, value2, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("BOX_GROUP_ID not between", value1, value2, "boxGroupId");
            return (Criteria) this;
        }

        public Criteria andBoxNameIsNull() {
            addCriterion("BOX_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBoxNameIsNotNull() {
            addCriterion("BOX_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBoxNameEqualTo(String value) {
            addCriterion("BOX_NAME =", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotEqualTo(String value) {
            addCriterion("BOX_NAME <>", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameGreaterThan(String value) {
            addCriterion("BOX_NAME >", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameGreaterThanOrEqualTo(String value) {
            addCriterion("BOX_NAME >=", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLessThan(String value) {
            addCriterion("BOX_NAME <", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLessThanOrEqualTo(String value) {
            addCriterion("BOX_NAME <=", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameLike(String value) {
            addCriterion("BOX_NAME like", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotLike(String value) {
            addCriterion("BOX_NAME not like", value, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameIn(List<String> values) {
            addCriterion("BOX_NAME in", values, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotIn(List<String> values) {
            addCriterion("BOX_NAME not in", values, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameBetween(String value1, String value2) {
            addCriterion("BOX_NAME between", value1, value2, "boxName");
            return (Criteria) this;
        }

        public Criteria andBoxNameNotBetween(String value1, String value2) {
            addCriterion("BOX_NAME not between", value1, value2, "boxName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdIsNull() {
            addCriterion("REPAIRER_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdIsNotNull() {
            addCriterion("REPAIRER_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdEqualTo(Long value) {
            addCriterion("REPAIRER_INFO_ID =", value, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdNotEqualTo(Long value) {
            addCriterion("REPAIRER_INFO_ID <>", value, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdGreaterThan(Long value) {
            addCriterion("REPAIRER_INFO_ID >", value, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REPAIRER_INFO_ID >=", value, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdLessThan(Long value) {
            addCriterion("REPAIRER_INFO_ID <", value, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("REPAIRER_INFO_ID <=", value, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdIn(List<Long> values) {
            addCriterion("REPAIRER_INFO_ID in", values, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdNotIn(List<Long> values) {
            addCriterion("REPAIRER_INFO_ID not in", values, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdBetween(Long value1, Long value2) {
            addCriterion("REPAIRER_INFO_ID between", value1, value2, "repairerInfoId");
            return (Criteria) this;
        }

        public Criteria andRepairerInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("REPAIRER_INFO_ID not between", value1, value2, "repairerInfoId");
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

        public Criteria andStatusEqualTo(BoxGroupStatus value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(BoxGroupStatus value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(BoxGroupStatus value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(BoxGroupStatus value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(BoxGroupStatus value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(BoxGroupStatus value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(BoxGroupStatus value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(BoxGroupStatus value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<BoxGroupStatus> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<BoxGroupStatus> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(BoxGroupStatus value1, BoxGroupStatus value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(BoxGroupStatus value1, BoxGroupStatus value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_box_group
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_box_group
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