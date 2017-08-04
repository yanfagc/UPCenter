package com.postbox.model;

import com.postbox.enums.RepairStatus;
import java.io.Serializable;
import java.util.Date;

public class RepairRecord implements Serializable {
    public static final long serialVersionUID = -749309133L;

    /**
     * 报修申请ID: t_repair_record.REPAIR_RECORD_ID
     * @author MyBatis Generator
     */
    private Long repairRecordId;

    /**
     * 报修客户ID: t_repair_record.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    private Long customerInfoId;

    /**
     * 维修人员ID: t_repair_record.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    private Long repairerInfoId;

    /**
     * 箱子ID: t_repair_record.BOX_INFO_ID
     * @author MyBatis Generator
     */
    private Long boxInfoId;

    /**
     * 箱子唯一编码: t_repair_record.BOX_UNIQUE_CODE
     * @author MyBatis Generator
     */
    private String boxUniqueCode;

    /**
     * 拍照截图路径: t_repair_record.REPAIR_IMG_PATH
     * @author MyBatis Generator
     */
    private String repairImgPath;

    /**
     * 备注: t_repair_record.REMARK
     * @author MyBatis Generator
     */
    private String remark;

    /**
     * 报销状态,CHECKING待审核,PENDING待处理,REPAIRING修理中,COMPLETE修理完成,CANCEL取消: t_repair_record.STATUS
     * @author MyBatis Generator
     */
    private RepairStatus status;

    /**
     * 报修时间: t_repair_record.APPLYTIME
     * @author MyBatis Generator
     */
    private Date applytime;

    /**
     * 系统自动备注,可用于自动录入GPS信息、报错信息来源（如待领包裹列表）、审批信息等: t_repair_record.AUTO_REMARK
     * @author MyBatis Generator
     */
    private String autoRemark;

    /**
     * 审核时间: t_repair_record.AUDITTIME
     * @author MyBatis Generator
     */
    private Date audittime;

    /**
     * 修理开始时间: t_repair_record.REPAIRTIME
     * @author MyBatis Generator
     */
    private Date repairtime;

    /**
     * 修理完成时间: t_repair_record.COMPLETETIME
     * @author MyBatis Generator
     */
    private Date completetime;

    /**
     * 取消时间: t_repair_record.CANCELTIME
     * @author MyBatis Generator
     */
    private Date canceltime;

    /**
     * 获取报修申请ID: t_repair_record.REPAIR_RECORD_ID
     * @return 报修申请ID: t_repair_record.REPAIR_RECORD_ID
     * @author MyBatis Generator
     */
    public Long getRepairRecordId() {
        return repairRecordId;
    }

    /**
     * 设置报修申请ID: t_repair_record.REPAIR_RECORD_ID
     * @param repairRecordId 映射数据库字段: t_repair_record.REPAIR_RECORD_ID
     * @author MyBatis Generator
     */
    public void setRepairRecordId(Long repairRecordId) {
        this.repairRecordId = repairRecordId;
    }

    /**
     * 获取报修客户ID: t_repair_record.CUSTOMER_INFO_ID
     * @return 报修客户ID: t_repair_record.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public Long getCustomerInfoId() {
        return customerInfoId;
    }

    /**
     * 设置报修客户ID: t_repair_record.CUSTOMER_INFO_ID
     * @param customerInfoId 映射数据库字段: t_repair_record.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public void setCustomerInfoId(Long customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    /**
     * 获取维修人员ID: t_repair_record.REPAIRER_INFO_ID
     * @return 维修人员ID: t_repair_record.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    public Long getRepairerInfoId() {
        return repairerInfoId;
    }

    /**
     * 设置维修人员ID: t_repair_record.REPAIRER_INFO_ID
     * @param repairerInfoId 映射数据库字段: t_repair_record.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    public void setRepairerInfoId(Long repairerInfoId) {
        this.repairerInfoId = repairerInfoId;
    }

    /**
     * 获取箱子ID: t_repair_record.BOX_INFO_ID
     * @return 箱子ID: t_repair_record.BOX_INFO_ID
     * @author MyBatis Generator
     */
    public Long getBoxInfoId() {
        return boxInfoId;
    }

    /**
     * 设置箱子ID: t_repair_record.BOX_INFO_ID
     * @param boxInfoId 映射数据库字段: t_repair_record.BOX_INFO_ID
     * @author MyBatis Generator
     */
    public void setBoxInfoId(Long boxInfoId) {
        this.boxInfoId = boxInfoId;
    }

    /**
     * 获取箱子唯一编码: t_repair_record.BOX_UNIQUE_CODE
     * @return 箱子唯一编码: t_repair_record.BOX_UNIQUE_CODE
     * @author MyBatis Generator
     */
    public String getBoxUniqueCode() {
        return boxUniqueCode;
    }

    /**
     * 设置箱子唯一编码: t_repair_record.BOX_UNIQUE_CODE
     * @param boxUniqueCode 映射数据库字段: t_repair_record.BOX_UNIQUE_CODE
     * @author MyBatis Generator
     */
    public void setBoxUniqueCode(String boxUniqueCode) {
        this.boxUniqueCode = boxUniqueCode == null ? null : boxUniqueCode.trim();
    }

    /**
     * 获取拍照截图路径: t_repair_record.REPAIR_IMG_PATH
     * @return 拍照截图路径: t_repair_record.REPAIR_IMG_PATH
     * @author MyBatis Generator
     */
    public String getRepairImgPath() {
        return repairImgPath;
    }

    /**
     * 设置拍照截图路径: t_repair_record.REPAIR_IMG_PATH
     * @param repairImgPath 映射数据库字段: t_repair_record.REPAIR_IMG_PATH
     * @author MyBatis Generator
     */
    public void setRepairImgPath(String repairImgPath) {
        this.repairImgPath = repairImgPath == null ? null : repairImgPath.trim();
    }

    /**
     * 获取备注: t_repair_record.REMARK
     * @return 备注: t_repair_record.REMARK
     * @author MyBatis Generator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注: t_repair_record.REMARK
     * @param remark 映射数据库字段: t_repair_record.REMARK
     * @author MyBatis Generator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取报销状态,CHECKING待审核,PENDING待处理,REPAIRING修理中,COMPLETE修理完成,CANCEL取消: t_repair_record.STATUS
     * @return 报销状态,CHECKING待审核,PENDING待处理,REPAIRING修理中,COMPLETE修理完成,CANCEL取消: t_repair_record.STATUS
     * @author MyBatis Generator
     */
    public RepairStatus getStatus() {
        return status;
    }

    /**
     * 设置报销状态,CHECKING待审核,PENDING待处理,REPAIRING修理中,COMPLETE修理完成,CANCEL取消: t_repair_record.STATUS
     * @param status 映射数据库字段: t_repair_record.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(RepairStatus status) {
        this.status = status;
    }

    /**
     * 获取报修时间: t_repair_record.APPLYTIME
     * @return 报修时间: t_repair_record.APPLYTIME
     * @author MyBatis Generator
     */
    public Date getApplytime() {
        return applytime;
    }

    /**
     * 设置报修时间: t_repair_record.APPLYTIME
     * @param applytime 映射数据库字段: t_repair_record.APPLYTIME
     * @author MyBatis Generator
     */
    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    /**
     * 获取系统自动备注,可用于自动录入GPS信息、报错信息来源（如待领包裹列表）、审批信息等: t_repair_record.AUTO_REMARK
     * @return 系统自动备注,可用于自动录入GPS信息、报错信息来源（如待领包裹列表）、审批信息等: t_repair_record.AUTO_REMARK
     * @author MyBatis Generator
     */
    public String getAutoRemark() {
        return autoRemark;
    }

    /**
     * 设置系统自动备注,可用于自动录入GPS信息、报错信息来源（如待领包裹列表）、审批信息等: t_repair_record.AUTO_REMARK
     * @param autoRemark 映射数据库字段: t_repair_record.AUTO_REMARK
     * @author MyBatis Generator
     */
    public void setAutoRemark(String autoRemark) {
        this.autoRemark = autoRemark == null ? null : autoRemark.trim();
    }

    /**
     * 获取审核时间: t_repair_record.AUDITTIME
     * @return 审核时间: t_repair_record.AUDITTIME
     * @author MyBatis Generator
     */
    public Date getAudittime() {
        return audittime;
    }

    /**
     * 设置审核时间: t_repair_record.AUDITTIME
     * @param audittime 映射数据库字段: t_repair_record.AUDITTIME
     * @author MyBatis Generator
     */
    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    /**
     * 获取修理开始时间: t_repair_record.REPAIRTIME
     * @return 修理开始时间: t_repair_record.REPAIRTIME
     * @author MyBatis Generator
     */
    public Date getRepairtime() {
        return repairtime;
    }

    /**
     * 设置修理开始时间: t_repair_record.REPAIRTIME
     * @param repairtime 映射数据库字段: t_repair_record.REPAIRTIME
     * @author MyBatis Generator
     */
    public void setRepairtime(Date repairtime) {
        this.repairtime = repairtime;
    }

    /**
     * 获取修理完成时间: t_repair_record.COMPLETETIME
     * @return 修理完成时间: t_repair_record.COMPLETETIME
     * @author MyBatis Generator
     */
    public Date getCompletetime() {
        return completetime;
    }

    /**
     * 设置修理完成时间: t_repair_record.COMPLETETIME
     * @param completetime 映射数据库字段: t_repair_record.COMPLETETIME
     * @author MyBatis Generator
     */
    public void setCompletetime(Date completetime) {
        this.completetime = completetime;
    }

    /**
     * 获取取消时间: t_repair_record.CANCELTIME
     * @return 取消时间: t_repair_record.CANCELTIME
     * @author MyBatis Generator
     */
    public Date getCanceltime() {
        return canceltime;
    }

    /**
     * 设置取消时间: t_repair_record.CANCELTIME
     * @param canceltime 映射数据库字段: t_repair_record.CANCELTIME
     * @author MyBatis Generator
     */
    public void setCanceltime(Date canceltime) {
        this.canceltime = canceltime;
    }
}