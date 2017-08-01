package com.postbox.model;

import com.postbox.enums.BoxExpressStatus;
import com.postbox.enums.BoxInfoStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class BoxInfoExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public BoxInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
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
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_box_info
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

        public Criteria andBoxInfoIdIsNull() {
            addCriterion("BOX_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdIsNotNull() {
            addCriterion("BOX_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdEqualTo(Long value) {
            addCriterion("BOX_INFO_ID =", value, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdNotEqualTo(Long value) {
            addCriterion("BOX_INFO_ID <>", value, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdGreaterThan(Long value) {
            addCriterion("BOX_INFO_ID >", value, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BOX_INFO_ID >=", value, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdLessThan(Long value) {
            addCriterion("BOX_INFO_ID <", value, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("BOX_INFO_ID <=", value, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdIn(List<Long> values) {
            addCriterion("BOX_INFO_ID in", values, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdNotIn(List<Long> values) {
            addCriterion("BOX_INFO_ID not in", values, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdBetween(Long value1, Long value2) {
            addCriterion("BOX_INFO_ID between", value1, value2, "boxInfoId");
            return (Criteria) this;
        }

        public Criteria andBoxInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("BOX_INFO_ID not between", value1, value2, "boxInfoId");
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

        public Criteria andBoxCodeIsNull() {
            addCriterion("BOX_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBoxCodeIsNotNull() {
            addCriterion("BOX_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBoxCodeEqualTo(String value) {
            addCriterion("BOX_CODE =", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeNotEqualTo(String value) {
            addCriterion("BOX_CODE <>", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeGreaterThan(String value) {
            addCriterion("BOX_CODE >", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BOX_CODE >=", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeLessThan(String value) {
            addCriterion("BOX_CODE <", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeLessThanOrEqualTo(String value) {
            addCriterion("BOX_CODE <=", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeLike(String value) {
            addCriterion("BOX_CODE like", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeNotLike(String value) {
            addCriterion("BOX_CODE not like", value, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeIn(List<String> values) {
            addCriterion("BOX_CODE in", values, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeNotIn(List<String> values) {
            addCriterion("BOX_CODE not in", values, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeBetween(String value1, String value2) {
            addCriterion("BOX_CODE between", value1, value2, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxCodeNotBetween(String value1, String value2) {
            addCriterion("BOX_CODE not between", value1, value2, "boxCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeIsNull() {
            addCriterion("BOX_UNIQUE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeIsNotNull() {
            addCriterion("BOX_UNIQUE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeEqualTo(String value) {
            addCriterion("BOX_UNIQUE_CODE =", value, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeNotEqualTo(String value) {
            addCriterion("BOX_UNIQUE_CODE <>", value, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeGreaterThan(String value) {
            addCriterion("BOX_UNIQUE_CODE >", value, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BOX_UNIQUE_CODE >=", value, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeLessThan(String value) {
            addCriterion("BOX_UNIQUE_CODE <", value, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeLessThanOrEqualTo(String value) {
            addCriterion("BOX_UNIQUE_CODE <=", value, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeLike(String value) {
            addCriterion("BOX_UNIQUE_CODE like", value, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeNotLike(String value) {
            addCriterion("BOX_UNIQUE_CODE not like", value, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeIn(List<String> values) {
            addCriterion("BOX_UNIQUE_CODE in", values, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeNotIn(List<String> values) {
            addCriterion("BOX_UNIQUE_CODE not in", values, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeBetween(String value1, String value2) {
            addCriterion("BOX_UNIQUE_CODE between", value1, value2, "boxUniqueCode");
            return (Criteria) this;
        }

        public Criteria andBoxUniqueCodeNotBetween(String value1, String value2) {
            addCriterion("BOX_UNIQUE_CODE not between", value1, value2, "boxUniqueCode");
            return (Criteria) this;
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

        public Criteria andSecKeyIsNull() {
            addCriterion("SEC_KEY is null");
            return (Criteria) this;
        }

        public Criteria andSecKeyIsNotNull() {
            addCriterion("SEC_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andSecKeyEqualTo(String value) {
            addCriterion("SEC_KEY =", value, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyNotEqualTo(String value) {
            addCriterion("SEC_KEY <>", value, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyGreaterThan(String value) {
            addCriterion("SEC_KEY >", value, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyGreaterThanOrEqualTo(String value) {
            addCriterion("SEC_KEY >=", value, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyLessThan(String value) {
            addCriterion("SEC_KEY <", value, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyLessThanOrEqualTo(String value) {
            addCriterion("SEC_KEY <=", value, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyLike(String value) {
            addCriterion("SEC_KEY like", value, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyNotLike(String value) {
            addCriterion("SEC_KEY not like", value, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyIn(List<String> values) {
            addCriterion("SEC_KEY in", values, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyNotIn(List<String> values) {
            addCriterion("SEC_KEY not in", values, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyBetween(String value1, String value2) {
            addCriterion("SEC_KEY between", value1, value2, "secKey");
            return (Criteria) this;
        }

        public Criteria andSecKeyNotBetween(String value1, String value2) {
            addCriterion("SEC_KEY not between", value1, value2, "secKey");
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

        public Criteria andStatusEqualTo(BoxInfoStatus value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(BoxInfoStatus value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(BoxInfoStatus value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(BoxInfoStatus value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(BoxInfoStatus value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(BoxInfoStatus value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(BoxInfoStatus value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(BoxInfoStatus value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<BoxInfoStatus> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<BoxInfoStatus> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(BoxInfoStatus value1, BoxInfoStatus value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(BoxInfoStatus value1, BoxInfoStatus value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExpressStatusIsNull() {
            addCriterion("EXPRESS_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andExpressStatusIsNotNull() {
            addCriterion("EXPRESS_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andExpressStatusEqualTo(BoxExpressStatus value) {
            addCriterion("EXPRESS_STATUS =", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusNotEqualTo(BoxExpressStatus value) {
            addCriterion("EXPRESS_STATUS <>", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusGreaterThan(BoxExpressStatus value) {
            addCriterion("EXPRESS_STATUS >", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusGreaterThanOrEqualTo(BoxExpressStatus value) {
            addCriterion("EXPRESS_STATUS >=", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusLessThan(BoxExpressStatus value) {
            addCriterion("EXPRESS_STATUS <", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusLessThanOrEqualTo(BoxExpressStatus value) {
            addCriterion("EXPRESS_STATUS <=", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusLike(BoxExpressStatus value) {
            addCriterion("EXPRESS_STATUS like", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusNotLike(BoxExpressStatus value) {
            addCriterion("EXPRESS_STATUS not like", value, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusIn(List<BoxExpressStatus> values) {
            addCriterion("EXPRESS_STATUS in", values, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusNotIn(List<BoxExpressStatus> values) {
            addCriterion("EXPRESS_STATUS not in", values, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusBetween(BoxExpressStatus value1, BoxExpressStatus value2) {
            addCriterion("EXPRESS_STATUS between", value1, value2, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andExpressStatusNotBetween(BoxExpressStatus value1, BoxExpressStatus value2) {
            addCriterion("EXPRESS_STATUS not between", value1, value2, "expressStatus");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("MOBILE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("MOBILE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("MOBILE_PHONE =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("MOBILE_PHONE <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("MOBILE_PHONE >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE_PHONE >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("MOBILE_PHONE <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("MOBILE_PHONE <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("MOBILE_PHONE like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("MOBILE_PHONE not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("MOBILE_PHONE in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("MOBILE_PHONE not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("MOBILE_PHONE between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("MOBILE_PHONE not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdIsNull() {
            addCriterion("PROXY_CUSTOMER_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdIsNotNull() {
            addCriterion("PROXY_CUSTOMER_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdEqualTo(String value) {
            addCriterion("PROXY_CUSTOMER_INFO_ID =", value, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdNotEqualTo(String value) {
            addCriterion("PROXY_CUSTOMER_INFO_ID <>", value, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdGreaterThan(String value) {
            addCriterion("PROXY_CUSTOMER_INFO_ID >", value, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROXY_CUSTOMER_INFO_ID >=", value, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdLessThan(String value) {
            addCriterion("PROXY_CUSTOMER_INFO_ID <", value, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdLessThanOrEqualTo(String value) {
            addCriterion("PROXY_CUSTOMER_INFO_ID <=", value, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdLike(String value) {
            addCriterion("PROXY_CUSTOMER_INFO_ID like", value, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdNotLike(String value) {
            addCriterion("PROXY_CUSTOMER_INFO_ID not like", value, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdIn(List<String> values) {
            addCriterion("PROXY_CUSTOMER_INFO_ID in", values, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdNotIn(List<String> values) {
            addCriterion("PROXY_CUSTOMER_INFO_ID not in", values, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdBetween(String value1, String value2) {
            addCriterion("PROXY_CUSTOMER_INFO_ID between", value1, value2, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andProxyCustomerInfoIdNotBetween(String value1, String value2) {
            addCriterion("PROXY_CUSTOMER_INFO_ID not between", value1, value2, "proxyCustomerInfoId");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andOpentimeIsNull() {
            addCriterion("OPENTIME is null");
            return (Criteria) this;
        }

        public Criteria andOpentimeIsNotNull() {
            addCriterion("OPENTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOpentimeEqualTo(Date value) {
            addCriterion("OPENTIME =", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotEqualTo(Date value) {
            addCriterion("OPENTIME <>", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeGreaterThan(Date value) {
            addCriterion("OPENTIME >", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPENTIME >=", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeLessThan(Date value) {
            addCriterion("OPENTIME <", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeLessThanOrEqualTo(Date value) {
            addCriterion("OPENTIME <=", value, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeIn(List<Date> values) {
            addCriterion("OPENTIME in", values, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotIn(List<Date> values) {
            addCriterion("OPENTIME not in", values, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeBetween(Date value1, Date value2) {
            addCriterion("OPENTIME between", value1, value2, "opentime");
            return (Criteria) this;
        }

        public Criteria andOpentimeNotBetween(Date value1, Date value2) {
            addCriterion("OPENTIME not between", value1, value2, "opentime");
            return (Criteria) this;
        }

        public Criteria andChecknumIsNull() {
            addCriterion("CHECKNUM is null");
            return (Criteria) this;
        }

        public Criteria andChecknumIsNotNull() {
            addCriterion("CHECKNUM is not null");
            return (Criteria) this;
        }

        public Criteria andChecknumEqualTo(Integer value) {
            addCriterion("CHECKNUM =", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotEqualTo(Integer value) {
            addCriterion("CHECKNUM <>", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumGreaterThan(Integer value) {
            addCriterion("CHECKNUM >", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHECKNUM >=", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumLessThan(Integer value) {
            addCriterion("CHECKNUM <", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumLessThanOrEqualTo(Integer value) {
            addCriterion("CHECKNUM <=", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumIn(List<Integer> values) {
            addCriterion("CHECKNUM in", values, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotIn(List<Integer> values) {
            addCriterion("CHECKNUM not in", values, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumBetween(Integer value1, Integer value2) {
            addCriterion("CHECKNUM between", value1, value2, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotBetween(Integer value1, Integer value2) {
            addCriterion("CHECKNUM not between", value1, value2, "checknum");
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

        public Criteria andRepairtimeIsNull() {
            addCriterion("REPAIRTIME is null");
            return (Criteria) this;
        }

        public Criteria andRepairtimeIsNotNull() {
            addCriterion("REPAIRTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRepairtimeEqualTo(Date value) {
            addCriterion("REPAIRTIME =", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeNotEqualTo(Date value) {
            addCriterion("REPAIRTIME <>", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeGreaterThan(Date value) {
            addCriterion("REPAIRTIME >", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REPAIRTIME >=", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeLessThan(Date value) {
            addCriterion("REPAIRTIME <", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeLessThanOrEqualTo(Date value) {
            addCriterion("REPAIRTIME <=", value, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeIn(List<Date> values) {
            addCriterion("REPAIRTIME in", values, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeNotIn(List<Date> values) {
            addCriterion("REPAIRTIME not in", values, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeBetween(Date value1, Date value2) {
            addCriterion("REPAIRTIME between", value1, value2, "repairtime");
            return (Criteria) this;
        }

        public Criteria andRepairtimeNotBetween(Date value1, Date value2) {
            addCriterion("REPAIRTIME not between", value1, value2, "repairtime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeIsNull() {
            addCriterion("DEMISETIME is null");
            return (Criteria) this;
        }

        public Criteria andDemisetimeIsNotNull() {
            addCriterion("DEMISETIME is not null");
            return (Criteria) this;
        }

        public Criteria andDemisetimeEqualTo(Date value) {
            addCriterion("DEMISETIME =", value, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeNotEqualTo(Date value) {
            addCriterion("DEMISETIME <>", value, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeGreaterThan(Date value) {
            addCriterion("DEMISETIME >", value, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DEMISETIME >=", value, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeLessThan(Date value) {
            addCriterion("DEMISETIME <", value, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeLessThanOrEqualTo(Date value) {
            addCriterion("DEMISETIME <=", value, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeIn(List<Date> values) {
            addCriterion("DEMISETIME in", values, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeNotIn(List<Date> values) {
            addCriterion("DEMISETIME not in", values, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeBetween(Date value1, Date value2) {
            addCriterion("DEMISETIME between", value1, value2, "demisetime");
            return (Criteria) this;
        }

        public Criteria andDemisetimeNotBetween(Date value1, Date value2) {
            addCriterion("DEMISETIME not between", value1, value2, "demisetime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_box_info
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_box_info
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