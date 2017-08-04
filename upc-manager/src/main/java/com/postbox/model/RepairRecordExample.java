package com.postbox.model;

import com.postbox.enums.RepairStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hanzhdy.web.bean.Page;

public class RepairRecordExample {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    protected String orderByClause;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    protected Page page;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    protected boolean distinct;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    protected List<Criteria> oredCriteria;

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public RepairRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public Page getPage() {
        return page;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
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
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_repair_record
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

        public Criteria andRepairImgPathIsNull() {
            addCriterion("REPAIR_IMG_PATH is null");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathIsNotNull() {
            addCriterion("REPAIR_IMG_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathEqualTo(String value) {
            addCriterion("REPAIR_IMG_PATH =", value, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathNotEqualTo(String value) {
            addCriterion("REPAIR_IMG_PATH <>", value, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathGreaterThan(String value) {
            addCriterion("REPAIR_IMG_PATH >", value, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("REPAIR_IMG_PATH >=", value, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathLessThan(String value) {
            addCriterion("REPAIR_IMG_PATH <", value, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathLessThanOrEqualTo(String value) {
            addCriterion("REPAIR_IMG_PATH <=", value, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathLike(String value) {
            addCriterion("REPAIR_IMG_PATH like", value, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathNotLike(String value) {
            addCriterion("REPAIR_IMG_PATH not like", value, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathIn(List<String> values) {
            addCriterion("REPAIR_IMG_PATH in", values, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathNotIn(List<String> values) {
            addCriterion("REPAIR_IMG_PATH not in", values, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathBetween(String value1, String value2) {
            addCriterion("REPAIR_IMG_PATH between", value1, value2, "repairImgPath");
            return (Criteria) this;
        }

        public Criteria andRepairImgPathNotBetween(String value1, String value2) {
            addCriterion("REPAIR_IMG_PATH not between", value1, value2, "repairImgPath");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(RepairStatus value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(RepairStatus value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(RepairStatus value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(RepairStatus value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(RepairStatus value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(RepairStatus value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(RepairStatus value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(RepairStatus value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<RepairStatus> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<RepairStatus> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(RepairStatus value1, RepairStatus value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(RepairStatus value1, RepairStatus value2) {
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

        public Criteria andAutoRemarkIsNull() {
            addCriterion("AUTO_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkIsNotNull() {
            addCriterion("AUTO_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkEqualTo(String value) {
            addCriterion("AUTO_REMARK =", value, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkNotEqualTo(String value) {
            addCriterion("AUTO_REMARK <>", value, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkGreaterThan(String value) {
            addCriterion("AUTO_REMARK >", value, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("AUTO_REMARK >=", value, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkLessThan(String value) {
            addCriterion("AUTO_REMARK <", value, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkLessThanOrEqualTo(String value) {
            addCriterion("AUTO_REMARK <=", value, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkLike(String value) {
            addCriterion("AUTO_REMARK like", value, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkNotLike(String value) {
            addCriterion("AUTO_REMARK not like", value, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkIn(List<String> values) {
            addCriterion("AUTO_REMARK in", values, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkNotIn(List<String> values) {
            addCriterion("AUTO_REMARK not in", values, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkBetween(String value1, String value2) {
            addCriterion("AUTO_REMARK between", value1, value2, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAutoRemarkNotBetween(String value1, String value2) {
            addCriterion("AUTO_REMARK not between", value1, value2, "autoRemark");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNull() {
            addCriterion("AUDITTIME is null");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNotNull() {
            addCriterion("AUDITTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAudittimeEqualTo(Date value) {
            addCriterion("AUDITTIME =", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotEqualTo(Date value) {
            addCriterion("AUDITTIME <>", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThan(Date value) {
            addCriterion("AUDITTIME >", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AUDITTIME >=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThan(Date value) {
            addCriterion("AUDITTIME <", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThanOrEqualTo(Date value) {
            addCriterion("AUDITTIME <=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeIn(List<Date> values) {
            addCriterion("AUDITTIME in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotIn(List<Date> values) {
            addCriterion("AUDITTIME not in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeBetween(Date value1, Date value2) {
            addCriterion("AUDITTIME between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotBetween(Date value1, Date value2) {
            addCriterion("AUDITTIME not between", value1, value2, "audittime");
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

        public Criteria andCompletetimeIsNull() {
            addCriterion("COMPLETETIME is null");
            return (Criteria) this;
        }

        public Criteria andCompletetimeIsNotNull() {
            addCriterion("COMPLETETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCompletetimeEqualTo(Date value) {
            addCriterion("COMPLETETIME =", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeNotEqualTo(Date value) {
            addCriterion("COMPLETETIME <>", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeGreaterThan(Date value) {
            addCriterion("COMPLETETIME >", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("COMPLETETIME >=", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeLessThan(Date value) {
            addCriterion("COMPLETETIME <", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeLessThanOrEqualTo(Date value) {
            addCriterion("COMPLETETIME <=", value, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeIn(List<Date> values) {
            addCriterion("COMPLETETIME in", values, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeNotIn(List<Date> values) {
            addCriterion("COMPLETETIME not in", values, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeBetween(Date value1, Date value2) {
            addCriterion("COMPLETETIME between", value1, value2, "completetime");
            return (Criteria) this;
        }

        public Criteria andCompletetimeNotBetween(Date value1, Date value2) {
            addCriterion("COMPLETETIME not between", value1, value2, "completetime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeIsNull() {
            addCriterion("CANCELTIME is null");
            return (Criteria) this;
        }

        public Criteria andCanceltimeIsNotNull() {
            addCriterion("CANCELTIME is not null");
            return (Criteria) this;
        }

        public Criteria andCanceltimeEqualTo(Date value) {
            addCriterion("CANCELTIME =", value, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeNotEqualTo(Date value) {
            addCriterion("CANCELTIME <>", value, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeGreaterThan(Date value) {
            addCriterion("CANCELTIME >", value, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CANCELTIME >=", value, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeLessThan(Date value) {
            addCriterion("CANCELTIME <", value, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeLessThanOrEqualTo(Date value) {
            addCriterion("CANCELTIME <=", value, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeIn(List<Date> values) {
            addCriterion("CANCELTIME in", values, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeNotIn(List<Date> values) {
            addCriterion("CANCELTIME not in", values, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeBetween(Date value1, Date value2) {
            addCriterion("CANCELTIME between", value1, value2, "canceltime");
            return (Criteria) this;
        }

        public Criteria andCanceltimeNotBetween(Date value1, Date value2) {
            addCriterion("CANCELTIME not between", value1, value2, "canceltime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_repair_record
     * @author do_not_delete_during_merge MyBatis Generator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类由Mybatis Generator自动生成
     * 映射数据库: t_repair_record
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