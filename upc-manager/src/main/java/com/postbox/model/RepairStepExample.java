package com.postbox.model;

import com.postbox.enums.RepairOptype;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class RepairStepExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public RepairStepExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
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
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_repair_step
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

        public Criteria andRepairStepIdIsNull() {
            addCriterion("REPAIR_STEP_ID is null");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdIsNotNull() {
            addCriterion("REPAIR_STEP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdEqualTo(Long value) {
            addCriterion("REPAIR_STEP_ID =", value, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdNotEqualTo(Long value) {
            addCriterion("REPAIR_STEP_ID <>", value, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdGreaterThan(Long value) {
            addCriterion("REPAIR_STEP_ID >", value, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REPAIR_STEP_ID >=", value, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdLessThan(Long value) {
            addCriterion("REPAIR_STEP_ID <", value, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdLessThanOrEqualTo(Long value) {
            addCriterion("REPAIR_STEP_ID <=", value, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdIn(List<Long> values) {
            addCriterion("REPAIR_STEP_ID in", values, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdNotIn(List<Long> values) {
            addCriterion("REPAIR_STEP_ID not in", values, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdBetween(Long value1, Long value2) {
            addCriterion("REPAIR_STEP_ID between", value1, value2, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairStepIdNotBetween(Long value1, Long value2) {
            addCriterion("REPAIR_STEP_ID not between", value1, value2, "repairStepId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdIsNull() {
            addCriterion("REPAIR_RECORD_ID is null");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdIsNotNull() {
            addCriterion("REPAIR_RECORD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdEqualTo(Long value) {
            addCriterion("REPAIR_RECORD_ID =", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotEqualTo(Long value) {
            addCriterion("REPAIR_RECORD_ID <>", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdGreaterThan(Long value) {
            addCriterion("REPAIR_RECORD_ID >", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REPAIR_RECORD_ID >=", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdLessThan(Long value) {
            addCriterion("REPAIR_RECORD_ID <", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("REPAIR_RECORD_ID <=", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdIn(List<Long> values) {
            addCriterion("REPAIR_RECORD_ID in", values, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotIn(List<Long> values) {
            addCriterion("REPAIR_RECORD_ID not in", values, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdBetween(Long value1, Long value2) {
            addCriterion("REPAIR_RECORD_ID between", value1, value2, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("REPAIR_RECORD_ID not between", value1, value2, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andOptypeIsNull() {
            addCriterion("OPTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOptypeIsNotNull() {
            addCriterion("OPTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOptypeEqualTo(RepairOptype value) {
            addCriterion("OPTYPE =", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeNotEqualTo(RepairOptype value) {
            addCriterion("OPTYPE <>", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeGreaterThan(RepairOptype value) {
            addCriterion("OPTYPE >", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeGreaterThanOrEqualTo(RepairOptype value) {
            addCriterion("OPTYPE >=", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeLessThan(RepairOptype value) {
            addCriterion("OPTYPE <", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeLessThanOrEqualTo(RepairOptype value) {
            addCriterion("OPTYPE <=", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeLike(RepairOptype value) {
            addCriterion("OPTYPE like", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeNotLike(RepairOptype value) {
            addCriterion("OPTYPE not like", value, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeIn(List<RepairOptype> values) {
            addCriterion("OPTYPE in", values, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeNotIn(List<RepairOptype> values) {
            addCriterion("OPTYPE not in", values, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeBetween(RepairOptype value1, RepairOptype value2) {
            addCriterion("OPTYPE between", value1, value2, "optype");
            return (Criteria) this;
        }

        public Criteria andOptypeNotBetween(RepairOptype value1, RepairOptype value2) {
            addCriterion("OPTYPE not between", value1, value2, "optype");
            return (Criteria) this;
        }

        public Criteria andOptimeIsNull() {
            addCriterion("OPTIME is null");
            return (Criteria) this;
        }

        public Criteria andOptimeIsNotNull() {
            addCriterion("OPTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOptimeEqualTo(Date value) {
            addCriterion("OPTIME =", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeNotEqualTo(Date value) {
            addCriterion("OPTIME <>", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeGreaterThan(Date value) {
            addCriterion("OPTIME >", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPTIME >=", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeLessThan(Date value) {
            addCriterion("OPTIME <", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeLessThanOrEqualTo(Date value) {
            addCriterion("OPTIME <=", value, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeIn(List<Date> values) {
            addCriterion("OPTIME in", values, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeNotIn(List<Date> values) {
            addCriterion("OPTIME not in", values, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeBetween(Date value1, Date value2) {
            addCriterion("OPTIME between", value1, value2, "optime");
            return (Criteria) this;
        }

        public Criteria andOptimeNotBetween(Date value1, Date value2) {
            addCriterion("OPTIME not between", value1, value2, "optime");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeIsNull() {
            addCriterion("OPSTAFFCODE is null");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeIsNotNull() {
            addCriterion("OPSTAFFCODE is not null");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeEqualTo(String value) {
            addCriterion("OPSTAFFCODE =", value, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeNotEqualTo(String value) {
            addCriterion("OPSTAFFCODE <>", value, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeGreaterThan(String value) {
            addCriterion("OPSTAFFCODE >", value, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeGreaterThanOrEqualTo(String value) {
            addCriterion("OPSTAFFCODE >=", value, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeLessThan(String value) {
            addCriterion("OPSTAFFCODE <", value, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeLessThanOrEqualTo(String value) {
            addCriterion("OPSTAFFCODE <=", value, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeLike(String value) {
            addCriterion("OPSTAFFCODE like", value, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeNotLike(String value) {
            addCriterion("OPSTAFFCODE not like", value, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeIn(List<String> values) {
            addCriterion("OPSTAFFCODE in", values, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeNotIn(List<String> values) {
            addCriterion("OPSTAFFCODE not in", values, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeBetween(String value1, String value2) {
            addCriterion("OPSTAFFCODE between", value1, value2, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffcodeNotBetween(String value1, String value2) {
            addCriterion("OPSTAFFCODE not between", value1, value2, "opstaffcode");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameIsNull() {
            addCriterion("OPSTAFFNAME is null");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameIsNotNull() {
            addCriterion("OPSTAFFNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameEqualTo(String value) {
            addCriterion("OPSTAFFNAME =", value, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameNotEqualTo(String value) {
            addCriterion("OPSTAFFNAME <>", value, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameGreaterThan(String value) {
            addCriterion("OPSTAFFNAME >", value, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameGreaterThanOrEqualTo(String value) {
            addCriterion("OPSTAFFNAME >=", value, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameLessThan(String value) {
            addCriterion("OPSTAFFNAME <", value, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameLessThanOrEqualTo(String value) {
            addCriterion("OPSTAFFNAME <=", value, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameLike(String value) {
            addCriterion("OPSTAFFNAME like", value, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameNotLike(String value) {
            addCriterion("OPSTAFFNAME not like", value, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameIn(List<String> values) {
            addCriterion("OPSTAFFNAME in", values, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameNotIn(List<String> values) {
            addCriterion("OPSTAFFNAME not in", values, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameBetween(String value1, String value2) {
            addCriterion("OPSTAFFNAME between", value1, value2, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andOpstaffnameNotBetween(String value1, String value2) {
            addCriterion("OPSTAFFNAME not between", value1, value2, "opstaffname");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_repair_step
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_repair_step
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