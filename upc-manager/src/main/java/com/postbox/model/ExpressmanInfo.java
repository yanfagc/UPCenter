package com.postbox.model;

import com.postbox.enums.ExpressmanStatus;
import java.io.Serializable;
import java.util.Date;

public class ExpressmanInfo implements Serializable {
    public static final long serialVersionUID = 1090102125L;

    /**
     * 快递员ID号: t_expressman_info.EXPRESSMAN_INFO_ID
     * @author MyBatis Generator
     */
    private Long expressmanInfoId;

    /**
     * 映射客户ID: t_expressman_info.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    private Long customerInfoId;

    /**
     * 所属快递公司: t_expressman_info.EXPRESS_COMPANY
     * @author MyBatis Generator
     */
    private String expressCompany;

    /**
     * 身份证图片存储路径: t_expressman_info.IDCARD_IMG_PATH
     * @author MyBatis Generator
     */
    private String idcardImgPath;

    /**
     * 工作证件照存储路径: t_expressman_info.WORKCARD_IMG_PATH
     * @author MyBatis Generator
     */
    private String workcardImgPath;

    /**
     * 状态,NOACTIVE未激活,NORMAL正常,FROZEN冻结,DEMISE销户: t_expressman_info.STATUS
     * @author MyBatis Generator
     */
    private ExpressmanStatus status;

    /**
     * 申请时间: t_expressman_info.APPLYTIME
     * @author MyBatis Generator
     */
    private Date applytime;

    /**
     * 激活时间: t_expressman_info.ACTIVETIME
     * @author MyBatis Generator
     */
    private Date activetime;

    /**
     * 获取快递员ID号: t_expressman_info.EXPRESSMAN_INFO_ID
     * @return 快递员ID号: t_expressman_info.EXPRESSMAN_INFO_ID
     * @author MyBatis Generator
     */
    public Long getExpressmanInfoId() {
        return expressmanInfoId;
    }

    /**
     * 设置快递员ID号: t_expressman_info.EXPRESSMAN_INFO_ID
     * @param expressmanInfoId 映射数据库字段: t_expressman_info.EXPRESSMAN_INFO_ID
     * @author MyBatis Generator
     */
    public void setExpressmanInfoId(Long expressmanInfoId) {
        this.expressmanInfoId = expressmanInfoId;
    }

    /**
     * 获取映射客户ID: t_expressman_info.CUSTOMER_INFO_ID
     * @return 映射客户ID: t_expressman_info.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public Long getCustomerInfoId() {
        return customerInfoId;
    }

    /**
     * 设置映射客户ID: t_expressman_info.CUSTOMER_INFO_ID
     * @param customerInfoId 映射数据库字段: t_expressman_info.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public void setCustomerInfoId(Long customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    /**
     * 获取所属快递公司: t_expressman_info.EXPRESS_COMPANY
     * @return 所属快递公司: t_expressman_info.EXPRESS_COMPANY
     * @author MyBatis Generator
     */
    public String getExpressCompany() {
        return expressCompany;
    }

    /**
     * 设置所属快递公司: t_expressman_info.EXPRESS_COMPANY
     * @param expressCompany 映射数据库字段: t_expressman_info.EXPRESS_COMPANY
     * @author MyBatis Generator
     */
    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    /**
     * 获取身份证图片存储路径: t_expressman_info.IDCARD_IMG_PATH
     * @return 身份证图片存储路径: t_expressman_info.IDCARD_IMG_PATH
     * @author MyBatis Generator
     */
    public String getIdcardImgPath() {
        return idcardImgPath;
    }

    /**
     * 设置身份证图片存储路径: t_expressman_info.IDCARD_IMG_PATH
     * @param idcardImgPath 映射数据库字段: t_expressman_info.IDCARD_IMG_PATH
     * @author MyBatis Generator
     */
    public void setIdcardImgPath(String idcardImgPath) {
        this.idcardImgPath = idcardImgPath == null ? null : idcardImgPath.trim();
    }

    /**
     * 获取工作证件照存储路径: t_expressman_info.WORKCARD_IMG_PATH
     * @return 工作证件照存储路径: t_expressman_info.WORKCARD_IMG_PATH
     * @author MyBatis Generator
     */
    public String getWorkcardImgPath() {
        return workcardImgPath;
    }

    /**
     * 设置工作证件照存储路径: t_expressman_info.WORKCARD_IMG_PATH
     * @param workcardImgPath 映射数据库字段: t_expressman_info.WORKCARD_IMG_PATH
     * @author MyBatis Generator
     */
    public void setWorkcardImgPath(String workcardImgPath) {
        this.workcardImgPath = workcardImgPath == null ? null : workcardImgPath.trim();
    }

    /**
     * 获取状态,NOACTIVE未激活,NORMAL正常,FROZEN冻结,DEMISE销户: t_expressman_info.STATUS
     * @return 状态,NOACTIVE未激活,NORMAL正常,FROZEN冻结,DEMISE销户: t_expressman_info.STATUS
     * @author MyBatis Generator
     */
    public ExpressmanStatus getStatus() {
        return status;
    }

    /**
     * 设置状态,NOACTIVE未激活,NORMAL正常,FROZEN冻结,DEMISE销户: t_expressman_info.STATUS
     * @param status 映射数据库字段: t_expressman_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(ExpressmanStatus status) {
        this.status = status;
    }

    /**
     * 获取申请时间: t_expressman_info.APPLYTIME
     * @return 申请时间: t_expressman_info.APPLYTIME
     * @author MyBatis Generator
     */
    public Date getApplytime() {
        return applytime;
    }

    /**
     * 设置申请时间: t_expressman_info.APPLYTIME
     * @param applytime 映射数据库字段: t_expressman_info.APPLYTIME
     * @author MyBatis Generator
     */
    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    /**
     * 获取激活时间: t_expressman_info.ACTIVETIME
     * @return 激活时间: t_expressman_info.ACTIVETIME
     * @author MyBatis Generator
     */
    public Date getActivetime() {
        return activetime;
    }

    /**
     * 设置激活时间: t_expressman_info.ACTIVETIME
     * @param activetime 映射数据库字段: t_expressman_info.ACTIVETIME
     * @author MyBatis Generator
     */
    public void setActivetime(Date activetime) {
        this.activetime = activetime;
    }
}