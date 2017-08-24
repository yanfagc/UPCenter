package com.postbox.model;

import com.postbox.enums.BoxExpressStatus;
import com.postbox.enums.BoxGridStatus;
import com.postbox.enums.GridSize;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class BoxGridExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public BoxGridExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
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
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_box_grid
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

        public Criteria andBoxGridIdIsNull() {
            addCriterion("BOX_GRID_ID is null");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdIsNotNull() {
            addCriterion("BOX_GRID_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdEqualTo(Long value) {
            addCriterion("BOX_GRID_ID =", value, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdNotEqualTo(Long value) {
            addCriterion("BOX_GRID_ID <>", value, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdGreaterThan(Long value) {
            addCriterion("BOX_GRID_ID >", value, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BOX_GRID_ID >=", value, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdLessThan(Long value) {
            addCriterion("BOX_GRID_ID <", value, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdLessThanOrEqualTo(Long value) {
            addCriterion("BOX_GRID_ID <=", value, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdIn(List<Long> values) {
            addCriterion("BOX_GRID_ID in", values, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdNotIn(List<Long> values) {
            addCriterion("BOX_GRID_ID not in", values, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdBetween(Long value1, Long value2) {
            addCriterion("BOX_GRID_ID between", value1, value2, "boxGridId");
            return (Criteria) this;
        }

        public Criteria andBoxGridIdNotBetween(Long value1, Long value2) {
            addCriterion("BOX_GRID_ID not between", value1, value2, "boxGridId");
            return (Criteria) this;
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

        public Criteria andGridCodeIsNull() {
            addCriterion("GRID_CODE is null");
            return (Criteria) this;
        }

        public Criteria andGridCodeIsNotNull() {
            addCriterion("GRID_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andGridCodeEqualTo(String value) {
            addCriterion("GRID_CODE =", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeNotEqualTo(String value) {
            addCriterion("GRID_CODE <>", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeGreaterThan(String value) {
            addCriterion("GRID_CODE >", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeGreaterThanOrEqualTo(String value) {
            addCriterion("GRID_CODE >=", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeLessThan(String value) {
            addCriterion("GRID_CODE <", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeLessThanOrEqualTo(String value) {
            addCriterion("GRID_CODE <=", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeLike(String value) {
            addCriterion("GRID_CODE like", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeNotLike(String value) {
            addCriterion("GRID_CODE not like", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeIn(List<String> values) {
            addCriterion("GRID_CODE in", values, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeNotIn(List<String> values) {
            addCriterion("GRID_CODE not in", values, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeBetween(String value1, String value2) {
            addCriterion("GRID_CODE between", value1, value2, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeNotBetween(String value1, String value2) {
            addCriterion("GRID_CODE not between", value1, value2, "gridCode");
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

        public Criteria andStatusEqualTo(BoxGridStatus value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(BoxGridStatus value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(BoxGridStatus value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(BoxGridStatus value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(BoxGridStatus value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(BoxGridStatus value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(BoxGridStatus value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(BoxGridStatus value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<BoxGridStatus> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<BoxGridStatus> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(BoxGridStatus value1, BoxGridStatus value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(BoxGridStatus value1, BoxGridStatus value2) {
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

        public Criteria andGridSizeIsNull() {
            addCriterion("GRID_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andGridSizeIsNotNull() {
            addCriterion("GRID_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andGridSizeEqualTo(GridSize value) {
            addCriterion("GRID_SIZE =", value, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeNotEqualTo(GridSize value) {
            addCriterion("GRID_SIZE <>", value, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeGreaterThan(GridSize value) {
            addCriterion("GRID_SIZE >", value, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeGreaterThanOrEqualTo(GridSize value) {
            addCriterion("GRID_SIZE >=", value, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeLessThan(GridSize value) {
            addCriterion("GRID_SIZE <", value, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeLessThanOrEqualTo(GridSize value) {
            addCriterion("GRID_SIZE <=", value, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeLike(GridSize value) {
            addCriterion("GRID_SIZE like", value, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeNotLike(GridSize value) {
            addCriterion("GRID_SIZE not like", value, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeIn(List<GridSize> values) {
            addCriterion("GRID_SIZE in", values, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeNotIn(List<GridSize> values) {
            addCriterion("GRID_SIZE not in", values, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeBetween(GridSize value1, GridSize value2) {
            addCriterion("GRID_SIZE between", value1, value2, "gridSize");
            return (Criteria) this;
        }

        public Criteria andGridSizeNotBetween(GridSize value1, GridSize value2) {
            addCriterion("GRID_SIZE not between", value1, value2, "gridSize");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_box_grid
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_box_grid
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