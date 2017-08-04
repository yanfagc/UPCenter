package com.postbox.model;

import com.postbox.enums.RepairOptype;
import java.io.Serializable;
import java.util.Date;

public class RepairStep implements Serializable {
    public static final long serialVersionUID = -604086738L;

    /**
     * 报修节点: t_repair_step.REPAIR_STEP_ID
     * @author MyBatis Generator
     */
    private Long repairStepId;

    /**
     * 报修记录ID: t_repair_step.REPAIR_RECORD_ID
     * @author MyBatis Generator
     */
    private Long repairRecordId;

    /**
     * 节点操作类型,APPLY申请: t_repair_step.OPTYPE
     * @author MyBatis Generator
     */
    private RepairOptype optype;

    /**
     * 节点操作时间: t_repair_step.OPTIME
     * @author MyBatis Generator
     */
    private Date optime;

    /**
     * 节点操作人编号: t_repair_step.OPSTAFFCODE
     * @author MyBatis Generator
     */
    private String opstaffcode;

    /**
     * 节点操作人姓名/昵称: t_repair_step.OPSTAFFNAME
     * @author MyBatis Generator
     */
    private String opstaffname;

    /**
     * 备注: t_repair_step.REMARK
     * @author MyBatis Generator
     */
    private String remark;

    /**
     * 获取报修节点: t_repair_step.REPAIR_STEP_ID
     * @return 报修节点: t_repair_step.REPAIR_STEP_ID
     * @author MyBatis Generator
     */
    public Long getRepairStepId() {
        return repairStepId;
    }

    /**
     * 设置报修节点: t_repair_step.REPAIR_STEP_ID
     * @param repairStepId 映射数据库字段: t_repair_step.REPAIR_STEP_ID
     * @author MyBatis Generator
     */
    public void setRepairStepId(Long repairStepId) {
        this.repairStepId = repairStepId;
    }

    /**
     * 获取报修记录ID: t_repair_step.REPAIR_RECORD_ID
     * @return 报修记录ID: t_repair_step.REPAIR_RECORD_ID
     * @author MyBatis Generator
     */
    public Long getRepairRecordId() {
        return repairRecordId;
    }

    /**
     * 设置报修记录ID: t_repair_step.REPAIR_RECORD_ID
     * @param repairRecordId 映射数据库字段: t_repair_step.REPAIR_RECORD_ID
     * @author MyBatis Generator
     */
    public void setRepairRecordId(Long repairRecordId) {
        this.repairRecordId = repairRecordId;
    }

    /**
     * 获取节点操作类型,APPLY申请: t_repair_step.OPTYPE
     * @return 节点操作类型,APPLY申请: t_repair_step.OPTYPE
     * @author MyBatis Generator
     */
    public RepairOptype getOptype() {
        return optype;
    }

    /**
     * 设置节点操作类型,APPLY申请: t_repair_step.OPTYPE
     * @param optype 映射数据库字段: t_repair_step.OPTYPE
     * @author MyBatis Generator
     */
    public void setOptype(RepairOptype optype) {
        this.optype = optype;
    }

    /**
     * 获取节点操作时间: t_repair_step.OPTIME
     * @return 节点操作时间: t_repair_step.OPTIME
     * @author MyBatis Generator
     */
    public Date getOptime() {
        return optime;
    }

    /**
     * 设置节点操作时间: t_repair_step.OPTIME
     * @param optime 映射数据库字段: t_repair_step.OPTIME
     * @author MyBatis Generator
     */
    public void setOptime(Date optime) {
        this.optime = optime;
    }

    /**
     * 获取节点操作人编号: t_repair_step.OPSTAFFCODE
     * @return 节点操作人编号: t_repair_step.OPSTAFFCODE
     * @author MyBatis Generator
     */
    public String getOpstaffcode() {
        return opstaffcode;
    }

    /**
     * 设置节点操作人编号: t_repair_step.OPSTAFFCODE
     * @param opstaffcode 映射数据库字段: t_repair_step.OPSTAFFCODE
     * @author MyBatis Generator
     */
    public void setOpstaffcode(String opstaffcode) {
        this.opstaffcode = opstaffcode == null ? null : opstaffcode.trim();
    }

    /**
     * 获取节点操作人姓名/昵称: t_repair_step.OPSTAFFNAME
     * @return 节点操作人姓名/昵称: t_repair_step.OPSTAFFNAME
     * @author MyBatis Generator
     */
    public String getOpstaffname() {
        return opstaffname;
    }

    /**
     * 设置节点操作人姓名/昵称: t_repair_step.OPSTAFFNAME
     * @param opstaffname 映射数据库字段: t_repair_step.OPSTAFFNAME
     * @author MyBatis Generator
     */
    public void setOpstaffname(String opstaffname) {
        this.opstaffname = opstaffname == null ? null : opstaffname.trim();
    }

    /**
     * 获取备注: t_repair_step.REMARK
     * @return 备注: t_repair_step.REMARK
     * @author MyBatis Generator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注: t_repair_step.REMARK
     * @param remark 映射数据库字段: t_repair_step.REMARK
     * @author MyBatis Generator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}