package org.hanzhdy.manager.form.model;

import java.util.ArrayList;
import java.util.List;
import org.hanzhdy.framework.bean.Page;
import org.hanzhdy.manager.engine.constants.FieldType;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.enums.YesOrNo;

public class FieldInfoExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public FieldInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
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
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: f_field_info
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFieldcodeIsNull() {
            addCriterion("FIELDCODE is null");
            return (Criteria) this;
        }

        public Criteria andFieldcodeIsNotNull() {
            addCriterion("FIELDCODE is not null");
            return (Criteria) this;
        }

        public Criteria andFieldcodeEqualTo(String value) {
            addCriterion("FIELDCODE =", value, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeNotEqualTo(String value) {
            addCriterion("FIELDCODE <>", value, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeGreaterThan(String value) {
            addCriterion("FIELDCODE >", value, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeGreaterThanOrEqualTo(String value) {
            addCriterion("FIELDCODE >=", value, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeLessThan(String value) {
            addCriterion("FIELDCODE <", value, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeLessThanOrEqualTo(String value) {
            addCriterion("FIELDCODE <=", value, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeLike(String value) {
            addCriterion("FIELDCODE like", value, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeNotLike(String value) {
            addCriterion("FIELDCODE not like", value, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeIn(List<String> values) {
            addCriterion("FIELDCODE in", values, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeNotIn(List<String> values) {
            addCriterion("FIELDCODE not in", values, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeBetween(String value1, String value2) {
            addCriterion("FIELDCODE between", value1, value2, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldcodeNotBetween(String value1, String value2) {
            addCriterion("FIELDCODE not between", value1, value2, "fieldcode");
            return (Criteria) this;
        }

        public Criteria andFieldnameIsNull() {
            addCriterion("FIELDNAME is null");
            return (Criteria) this;
        }

        public Criteria andFieldnameIsNotNull() {
            addCriterion("FIELDNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFieldnameEqualTo(String value) {
            addCriterion("FIELDNAME =", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotEqualTo(String value) {
            addCriterion("FIELDNAME <>", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameGreaterThan(String value) {
            addCriterion("FIELDNAME >", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameGreaterThanOrEqualTo(String value) {
            addCriterion("FIELDNAME >=", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLessThan(String value) {
            addCriterion("FIELDNAME <", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLessThanOrEqualTo(String value) {
            addCriterion("FIELDNAME <=", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLike(String value) {
            addCriterion("FIELDNAME like", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotLike(String value) {
            addCriterion("FIELDNAME not like", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameIn(List<String> values) {
            addCriterion("FIELDNAME in", values, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotIn(List<String> values) {
            addCriterion("FIELDNAME not in", values, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameBetween(String value1, String value2) {
            addCriterion("FIELDNAME between", value1, value2, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotBetween(String value1, String value2) {
            addCriterion("FIELDNAME not between", value1, value2, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldtypeIsNull() {
            addCriterion("FIELDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andFieldtypeIsNotNull() {
            addCriterion("FIELDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFieldtypeEqualTo(FieldType value) {
            addCriterion("FIELDTYPE =", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeNotEqualTo(FieldType value) {
            addCriterion("FIELDTYPE <>", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeGreaterThan(FieldType value) {
            addCriterion("FIELDTYPE >", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeGreaterThanOrEqualTo(FieldType value) {
            addCriterion("FIELDTYPE >=", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeLessThan(FieldType value) {
            addCriterion("FIELDTYPE <", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeLessThanOrEqualTo(FieldType value) {
            addCriterion("FIELDTYPE <=", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeLike(FieldType value) {
            addCriterion("FIELDTYPE like", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeNotLike(FieldType value) {
            addCriterion("FIELDTYPE not like", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeIn(List<FieldType> values) {
            addCriterion("FIELDTYPE in", values, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeNotIn(List<FieldType> values) {
            addCriterion("FIELDTYPE not in", values, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeBetween(FieldType value1, FieldType value2) {
            addCriterion("FIELDTYPE between", value1, value2, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeNotBetween(FieldType value1, FieldType value2) {
            addCriterion("FIELDTYPE not between", value1, value2, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeIsNull() {
            addCriterion("MACROTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMacrotypeIsNotNull() {
            addCriterion("MACROTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMacrotypeEqualTo(String value) {
            addCriterion("MACROTYPE =", value, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeNotEqualTo(String value) {
            addCriterion("MACROTYPE <>", value, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeGreaterThan(String value) {
            addCriterion("MACROTYPE >", value, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeGreaterThanOrEqualTo(String value) {
            addCriterion("MACROTYPE >=", value, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeLessThan(String value) {
            addCriterion("MACROTYPE <", value, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeLessThanOrEqualTo(String value) {
            addCriterion("MACROTYPE <=", value, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeLike(String value) {
            addCriterion("MACROTYPE like", value, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeNotLike(String value) {
            addCriterion("MACROTYPE not like", value, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeIn(List<String> values) {
            addCriterion("MACROTYPE in", values, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeNotIn(List<String> values) {
            addCriterion("MACROTYPE not in", values, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeBetween(String value1, String value2) {
            addCriterion("MACROTYPE between", value1, value2, "macrotype");
            return (Criteria) this;
        }

        public Criteria andMacrotypeNotBetween(String value1, String value2) {
            addCriterion("MACROTYPE not between", value1, value2, "macrotype");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(CommonStatus value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(CommonStatus value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(CommonStatus value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(CommonStatus value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(CommonStatus value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(CommonStatus value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(CommonStatus value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(CommonStatus value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<CommonStatus> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<CommonStatus> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(CommonStatus value1, CommonStatus value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(CommonStatus value1, CommonStatus value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNull() {
            addCriterion("REQUIRED is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("REQUIRED is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(YesOrNo value) {
            addCriterion("REQUIRED =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(YesOrNo value) {
            addCriterion("REQUIRED <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(YesOrNo value) {
            addCriterion("REQUIRED >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(YesOrNo value) {
            addCriterion("REQUIRED >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(YesOrNo value) {
            addCriterion("REQUIRED <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(YesOrNo value) {
            addCriterion("REQUIRED <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLike(YesOrNo value) {
            addCriterion("REQUIRED like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotLike(YesOrNo value) {
            addCriterion("REQUIRED not like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<YesOrNo> values) {
            addCriterion("REQUIRED in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<YesOrNo> values) {
            addCriterion("REQUIRED not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(YesOrNo value1, YesOrNo value2) {
            addCriterion("REQUIRED between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(YesOrNo value1, YesOrNo value2) {
            addCriterion("REQUIRED not between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andLengthtypeIsNull() {
            addCriterion("LENGTHTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLengthtypeIsNotNull() {
            addCriterion("LENGTHTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLengthtypeEqualTo(String value) {
            addCriterion("LENGTHTYPE =", value, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeNotEqualTo(String value) {
            addCriterion("LENGTHTYPE <>", value, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeGreaterThan(String value) {
            addCriterion("LENGTHTYPE >", value, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeGreaterThanOrEqualTo(String value) {
            addCriterion("LENGTHTYPE >=", value, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeLessThan(String value) {
            addCriterion("LENGTHTYPE <", value, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeLessThanOrEqualTo(String value) {
            addCriterion("LENGTHTYPE <=", value, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeLike(String value) {
            addCriterion("LENGTHTYPE like", value, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeNotLike(String value) {
            addCriterion("LENGTHTYPE not like", value, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeIn(List<String> values) {
            addCriterion("LENGTHTYPE in", values, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeNotIn(List<String> values) {
            addCriterion("LENGTHTYPE not in", values, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeBetween(String value1, String value2) {
            addCriterion("LENGTHTYPE between", value1, value2, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andLengthtypeNotBetween(String value1, String value2) {
            addCriterion("LENGTHTYPE not between", value1, value2, "lengthtype");
            return (Criteria) this;
        }

        public Criteria andMaxlengthIsNull() {
            addCriterion("MAXLENGTH is null");
            return (Criteria) this;
        }

        public Criteria andMaxlengthIsNotNull() {
            addCriterion("MAXLENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andMaxlengthEqualTo(Integer value) {
            addCriterion("MAXLENGTH =", value, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthNotEqualTo(Integer value) {
            addCriterion("MAXLENGTH <>", value, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthGreaterThan(Integer value) {
            addCriterion("MAXLENGTH >", value, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAXLENGTH >=", value, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthLessThan(Integer value) {
            addCriterion("MAXLENGTH <", value, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthLessThanOrEqualTo(Integer value) {
            addCriterion("MAXLENGTH <=", value, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthIn(List<Integer> values) {
            addCriterion("MAXLENGTH in", values, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthNotIn(List<Integer> values) {
            addCriterion("MAXLENGTH not in", values, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthBetween(Integer value1, Integer value2) {
            addCriterion("MAXLENGTH between", value1, value2, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMaxlengthNotBetween(Integer value1, Integer value2) {
            addCriterion("MAXLENGTH not between", value1, value2, "maxlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthIsNull() {
            addCriterion("MINLENGTH is null");
            return (Criteria) this;
        }

        public Criteria andMinlengthIsNotNull() {
            addCriterion("MINLENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andMinlengthEqualTo(Integer value) {
            addCriterion("MINLENGTH =", value, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthNotEqualTo(Integer value) {
            addCriterion("MINLENGTH <>", value, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthGreaterThan(Integer value) {
            addCriterion("MINLENGTH >", value, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("MINLENGTH >=", value, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthLessThan(Integer value) {
            addCriterion("MINLENGTH <", value, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthLessThanOrEqualTo(Integer value) {
            addCriterion("MINLENGTH <=", value, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthIn(List<Integer> values) {
            addCriterion("MINLENGTH in", values, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthNotIn(List<Integer> values) {
            addCriterion("MINLENGTH not in", values, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthBetween(Integer value1, Integer value2) {
            addCriterion("MINLENGTH between", value1, value2, "minlength");
            return (Criteria) this;
        }

        public Criteria andMinlengthNotBetween(Integer value1, Integer value2) {
            addCriterion("MINLENGTH not between", value1, value2, "minlength");
            return (Criteria) this;
        }

        public Criteria andMaxvalIsNull() {
            addCriterion("MAXVAL is null");
            return (Criteria) this;
        }

        public Criteria andMaxvalIsNotNull() {
            addCriterion("MAXVAL is not null");
            return (Criteria) this;
        }

        public Criteria andMaxvalEqualTo(String value) {
            addCriterion("MAXVAL =", value, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalNotEqualTo(String value) {
            addCriterion("MAXVAL <>", value, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalGreaterThan(String value) {
            addCriterion("MAXVAL >", value, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalGreaterThanOrEqualTo(String value) {
            addCriterion("MAXVAL >=", value, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalLessThan(String value) {
            addCriterion("MAXVAL <", value, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalLessThanOrEqualTo(String value) {
            addCriterion("MAXVAL <=", value, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalLike(String value) {
            addCriterion("MAXVAL like", value, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalNotLike(String value) {
            addCriterion("MAXVAL not like", value, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalIn(List<String> values) {
            addCriterion("MAXVAL in", values, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalNotIn(List<String> values) {
            addCriterion("MAXVAL not in", values, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalBetween(String value1, String value2) {
            addCriterion("MAXVAL between", value1, value2, "maxval");
            return (Criteria) this;
        }

        public Criteria andMaxvalNotBetween(String value1, String value2) {
            addCriterion("MAXVAL not between", value1, value2, "maxval");
            return (Criteria) this;
        }

        public Criteria andMinvalIsNull() {
            addCriterion("MINVAL is null");
            return (Criteria) this;
        }

        public Criteria andMinvalIsNotNull() {
            addCriterion("MINVAL is not null");
            return (Criteria) this;
        }

        public Criteria andMinvalEqualTo(String value) {
            addCriterion("MINVAL =", value, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalNotEqualTo(String value) {
            addCriterion("MINVAL <>", value, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalGreaterThan(String value) {
            addCriterion("MINVAL >", value, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalGreaterThanOrEqualTo(String value) {
            addCriterion("MINVAL >=", value, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalLessThan(String value) {
            addCriterion("MINVAL <", value, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalLessThanOrEqualTo(String value) {
            addCriterion("MINVAL <=", value, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalLike(String value) {
            addCriterion("MINVAL like", value, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalNotLike(String value) {
            addCriterion("MINVAL not like", value, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalIn(List<String> values) {
            addCriterion("MINVAL in", values, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalNotIn(List<String> values) {
            addCriterion("MINVAL not in", values, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalBetween(String value1, String value2) {
            addCriterion("MINVAL between", value1, value2, "minval");
            return (Criteria) this;
        }

        public Criteria andMinvalNotBetween(String value1, String value2) {
            addCriterion("MINVAL not between", value1, value2, "minval");
            return (Criteria) this;
        }

        public Criteria andMaxlimitIsNull() {
            addCriterion("MAXLIMIT is null");
            return (Criteria) this;
        }

        public Criteria andMaxlimitIsNotNull() {
            addCriterion("MAXLIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxlimitEqualTo(Long value) {
            addCriterion("MAXLIMIT =", value, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitNotEqualTo(Long value) {
            addCriterion("MAXLIMIT <>", value, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitGreaterThan(Long value) {
            addCriterion("MAXLIMIT >", value, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitGreaterThanOrEqualTo(Long value) {
            addCriterion("MAXLIMIT >=", value, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitLessThan(Long value) {
            addCriterion("MAXLIMIT <", value, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitLessThanOrEqualTo(Long value) {
            addCriterion("MAXLIMIT <=", value, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitIn(List<Long> values) {
            addCriterion("MAXLIMIT in", values, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitNotIn(List<Long> values) {
            addCriterion("MAXLIMIT not in", values, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitBetween(Long value1, Long value2) {
            addCriterion("MAXLIMIT between", value1, value2, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMaxlimitNotBetween(Long value1, Long value2) {
            addCriterion("MAXLIMIT not between", value1, value2, "maxlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitIsNull() {
            addCriterion("MINLIMIT is null");
            return (Criteria) this;
        }

        public Criteria andMinlimitIsNotNull() {
            addCriterion("MINLIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andMinlimitEqualTo(Long value) {
            addCriterion("MINLIMIT =", value, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitNotEqualTo(Long value) {
            addCriterion("MINLIMIT <>", value, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitGreaterThan(Long value) {
            addCriterion("MINLIMIT >", value, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitGreaterThanOrEqualTo(Long value) {
            addCriterion("MINLIMIT >=", value, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitLessThan(Long value) {
            addCriterion("MINLIMIT <", value, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitLessThanOrEqualTo(Long value) {
            addCriterion("MINLIMIT <=", value, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitIn(List<Long> values) {
            addCriterion("MINLIMIT in", values, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitNotIn(List<Long> values) {
            addCriterion("MINLIMIT not in", values, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitBetween(Long value1, Long value2) {
            addCriterion("MINLIMIT between", value1, value2, "minlimit");
            return (Criteria) this;
        }

        public Criteria andMinlimitNotBetween(Long value1, Long value2) {
            addCriterion("MINLIMIT not between", value1, value2, "minlimit");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueIsNull() {
            addCriterion("DEFAULTVALUE is null");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueIsNotNull() {
            addCriterion("DEFAULTVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueEqualTo(String value) {
            addCriterion("DEFAULTVALUE =", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueNotEqualTo(String value) {
            addCriterion("DEFAULTVALUE <>", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueGreaterThan(String value) {
            addCriterion("DEFAULTVALUE >", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueGreaterThanOrEqualTo(String value) {
            addCriterion("DEFAULTVALUE >=", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueLessThan(String value) {
            addCriterion("DEFAULTVALUE <", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueLessThanOrEqualTo(String value) {
            addCriterion("DEFAULTVALUE <=", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueLike(String value) {
            addCriterion("DEFAULTVALUE like", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueNotLike(String value) {
            addCriterion("DEFAULTVALUE not like", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueIn(List<String> values) {
            addCriterion("DEFAULTVALUE in", values, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueNotIn(List<String> values) {
            addCriterion("DEFAULTVALUE not in", values, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueBetween(String value1, String value2) {
            addCriterion("DEFAULTVALUE between", value1, value2, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueNotBetween(String value1, String value2) {
            addCriterion("DEFAULTVALUE not between", value1, value2, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andLinkageIsNull() {
            addCriterion("LINKAGE is null");
            return (Criteria) this;
        }

        public Criteria andLinkageIsNotNull() {
            addCriterion("LINKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andLinkageEqualTo(String value) {
            addCriterion("LINKAGE =", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageNotEqualTo(String value) {
            addCriterion("LINKAGE <>", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageGreaterThan(String value) {
            addCriterion("LINKAGE >", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageGreaterThanOrEqualTo(String value) {
            addCriterion("LINKAGE >=", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageLessThan(String value) {
            addCriterion("LINKAGE <", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageLessThanOrEqualTo(String value) {
            addCriterion("LINKAGE <=", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageLike(String value) {
            addCriterion("LINKAGE like", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageNotLike(String value) {
            addCriterion("LINKAGE not like", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageIn(List<String> values) {
            addCriterion("LINKAGE in", values, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageNotIn(List<String> values) {
            addCriterion("LINKAGE not in", values, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageBetween(String value1, String value2) {
            addCriterion("LINKAGE between", value1, value2, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageNotBetween(String value1, String value2) {
            addCriterion("LINKAGE not between", value1, value2, "linkage");
            return (Criteria) this;
        }

        public Criteria andRegularIsNull() {
            addCriterion("REGULAR is null");
            return (Criteria) this;
        }

        public Criteria andRegularIsNotNull() {
            addCriterion("REGULAR is not null");
            return (Criteria) this;
        }

        public Criteria andRegularEqualTo(String value) {
            addCriterion("REGULAR =", value, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularNotEqualTo(String value) {
            addCriterion("REGULAR <>", value, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularGreaterThan(String value) {
            addCriterion("REGULAR >", value, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularGreaterThanOrEqualTo(String value) {
            addCriterion("REGULAR >=", value, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularLessThan(String value) {
            addCriterion("REGULAR <", value, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularLessThanOrEqualTo(String value) {
            addCriterion("REGULAR <=", value, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularLike(String value) {
            addCriterion("REGULAR like", value, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularNotLike(String value) {
            addCriterion("REGULAR not like", value, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularIn(List<String> values) {
            addCriterion("REGULAR in", values, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularNotIn(List<String> values) {
            addCriterion("REGULAR not in", values, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularBetween(String value1, String value2) {
            addCriterion("REGULAR between", value1, value2, "regular");
            return (Criteria) this;
        }

        public Criteria andRegularNotBetween(String value1, String value2) {
            addCriterion("REGULAR not between", value1, value2, "regular");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table f_field_info
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: f_field_info
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