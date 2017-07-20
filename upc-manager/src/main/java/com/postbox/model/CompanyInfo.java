package com.postbox.model;

import com.postbox.enums.DataStatus;
import java.io.Serializable;
import java.util.Date;

public class CompanyInfo implements Serializable {
    public static final long serialVersionUID = 581468982L;

    /**
     * 企业ID号: t_company_info.COMPANY_INFO_ID
     * @author MyBatis Generator
     */
    private Long companyInfoId;

    /**
     * 企业名称: t_company_info.COMPANY_NAME
     * @author MyBatis Generator
     */
    private String companyName;

    /**
     * 法人姓名: t_company_info.LEGAL_PERSON_NAME
     * @author MyBatis Generator
     */
    private String legalPersonName;

    /**
     * 联系人: t_company_info.CONTACT_NAME
     * @author MyBatis Generator
     */
    private String contactName;

    /**
     * 联系方式: t_company_info.CONTACT_PHONE
     * @author MyBatis Generator
     */
    private String contactPhone;

    /**
     * 状态: t_company_info.STATUS
     * @author MyBatis Generator
     */
    private DataStatus status;

    /**
     * 鉴权: t_company_info.AUTH
     * @author MyBatis Generator
     */
    private String auth;

    /**
     * 创建时间: t_company_info.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 获取企业ID号: t_company_info.COMPANY_INFO_ID
     * @return 企业ID号: t_company_info.COMPANY_INFO_ID
     * @author MyBatis Generator
     */
    public Long getCompanyInfoId() {
        return companyInfoId;
    }

    /**
     * 设置企业ID号: t_company_info.COMPANY_INFO_ID
     * @param companyInfoId 映射数据库字段: t_company_info.COMPANY_INFO_ID
     * @author MyBatis Generator
     */
    public void setCompanyInfoId(Long companyInfoId) {
        this.companyInfoId = companyInfoId;
    }

    /**
     * 获取企业名称: t_company_info.COMPANY_NAME
     * @return 企业名称: t_company_info.COMPANY_NAME
     * @author MyBatis Generator
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置企业名称: t_company_info.COMPANY_NAME
     * @param companyName 映射数据库字段: t_company_info.COMPANY_NAME
     * @author MyBatis Generator
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取法人姓名: t_company_info.LEGAL_PERSON_NAME
     * @return 法人姓名: t_company_info.LEGAL_PERSON_NAME
     * @author MyBatis Generator
     */
    public String getLegalPersonName() {
        return legalPersonName;
    }

    /**
     * 设置法人姓名: t_company_info.LEGAL_PERSON_NAME
     * @param legalPersonName 映射数据库字段: t_company_info.LEGAL_PERSON_NAME
     * @author MyBatis Generator
     */
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName == null ? null : legalPersonName.trim();
    }

    /**
     * 获取联系人: t_company_info.CONTACT_NAME
     * @return 联系人: t_company_info.CONTACT_NAME
     * @author MyBatis Generator
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人: t_company_info.CONTACT_NAME
     * @param contactName 映射数据库字段: t_company_info.CONTACT_NAME
     * @author MyBatis Generator
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取联系方式: t_company_info.CONTACT_PHONE
     * @return 联系方式: t_company_info.CONTACT_PHONE
     * @author MyBatis Generator
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系方式: t_company_info.CONTACT_PHONE
     * @param contactPhone 映射数据库字段: t_company_info.CONTACT_PHONE
     * @author MyBatis Generator
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * 获取状态: t_company_info.STATUS
     * @return 状态: t_company_info.STATUS
     * @author MyBatis Generator
     */
    public DataStatus getStatus() {
        return status;
    }

    /**
     * 设置状态: t_company_info.STATUS
     * @param status 映射数据库字段: t_company_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(DataStatus status) {
        this.status = status;
    }

    /**
     * 获取鉴权: t_company_info.AUTH
     * @return 鉴权: t_company_info.AUTH
     * @author MyBatis Generator
     */
    public String getAuth() {
        return auth;
    }

    /**
     * 设置鉴权: t_company_info.AUTH
     * @param auth 映射数据库字段: t_company_info.AUTH
     * @author MyBatis Generator
     */
    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }

    /**
     * 获取创建时间: t_company_info.CREATETIME
     * @return 创建时间: t_company_info.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: t_company_info.CREATETIME
     * @param createtime 映射数据库字段: t_company_info.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}