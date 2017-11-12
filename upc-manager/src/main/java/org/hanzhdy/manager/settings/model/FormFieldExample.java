package org.hanzhdy.manager.settings.model;

import java.util.ArrayList;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class FormFieldExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public FormFieldExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
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
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: f_form_field
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

        public Criteria andFormIdIsNull() {
            addCriterion("FORMID is null");
            return (Criteria) this;
        }

        public Criteria andFormIdIsNotNull() {
            addCriterion("FORMID is not null");
            return (Criteria) this;
        }

        public Criteria andFormIdEqualTo(Long value) {
            addCriterion("FORMID =", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotEqualTo(Long value) {
            addCriterion("FORMID <>", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThan(Long value) {
            addCriterion("FORMID >", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FORMID >=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThan(Long value) {
            addCriterion("FORMID <", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThanOrEqualTo(Long value) {
            addCriterion("FORMID <=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdIn(List<Long> values) {
            addCriterion("FORMID in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotIn(List<Long> values) {
            addCriterion("FORMID not in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdBetween(Long value1, Long value2) {
            addCriterion("FORMID between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotBetween(Long value1, Long value2) {
            addCriterion("FORMID not between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNull() {
            addCriterion("FIELDID is null");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNotNull() {
            addCriterion("FIELDID is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIdEqualTo(Long value) {
            addCriterion("FIELDID =", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotEqualTo(Long value) {
            addCriterion("FIELDID <>", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThan(Long value) {
            addCriterion("FIELDID >", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FIELDID >=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThan(Long value) {
            addCriterion("FIELDID <", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThanOrEqualTo(Long value) {
            addCriterion("FIELDID <=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIn(List<Long> values) {
            addCriterion("FIELDID in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotIn(List<Long> values) {
            addCriterion("FIELDID not in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdBetween(Long value1, Long value2) {
            addCriterion("FIELDID between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotBetween(Long value1, Long value2) {
            addCriterion("FIELDID not between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andColspanIsNull() {
            addCriterion("COLSPAN is null");
            return (Criteria) this;
        }

        public Criteria andColspanIsNotNull() {
            addCriterion("COLSPAN is not null");
            return (Criteria) this;
        }

        public Criteria andColspanEqualTo(Integer value) {
            addCriterion("COLSPAN =", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotEqualTo(Integer value) {
            addCriterion("COLSPAN <>", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanGreaterThan(Integer value) {
            addCriterion("COLSPAN >", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLSPAN >=", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLessThan(Integer value) {
            addCriterion("COLSPAN <", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLessThanOrEqualTo(Integer value) {
            addCriterion("COLSPAN <=", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanIn(List<Integer> values) {
            addCriterion("COLSPAN in", values, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotIn(List<Integer> values) {
            addCriterion("COLSPAN not in", values, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanBetween(Integer value1, Integer value2) {
            addCriterion("COLSPAN between", value1, value2, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotBetween(Integer value1, Integer value2) {
            addCriterion("COLSPAN not between", value1, value2, "colspan");
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

        public Criteria andSortEqualTo(Short value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Short value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Short value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Short value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Short value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Short value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Short> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Short> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Short value1, Short value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Short value1, Short value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table f_form_field
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: f_form_field
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