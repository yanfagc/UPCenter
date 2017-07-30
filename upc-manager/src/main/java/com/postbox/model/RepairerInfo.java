package com.postbox.model;

import com.postbox.enums.DataStatus;
import java.io.Serializable;
import java.util.Date;

public class RepairerInfo implements Serializable {
    public static final long serialVersionUID = -194125379L;

    /**
     * 维修人员ID: t_repairer_info.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    private Long repairerInfoid;

    /**
     * 维修员工号: t_repairer_info.REPAIRER_NO
     * @author MyBatis Generator
     */
    private String repairerNo;

    /**
     * 维修人员姓名: t_repairer_info.REALNAME
     * @author MyBatis Generator
     */
    private String realname;

    /**
     * 维修人员手机号: t_repairer_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    private String mobilePhone;

    /**
     * 维修人员图片: t_repairer_info.REPAIRER_IMG_PATH
     * @author MyBatis Generator
     */
    private String repairerImgPath;

    /**
     * 国家: t_repairer_info.COUNTRY
     * @author MyBatis Generator
     */
    private String country;

    /**
     * 省份: t_repairer_info.PROVINCE
     * @author MyBatis Generator
     */
    private String province;

    /**
     * 城市: t_repairer_info.CITY
     * @author MyBatis Generator
     */
    private String city;

    /**
     * 状态,NORMAL正常,FROZEN冻结,DEMISE销户: t_repairer_info.STATUS
     * @author MyBatis Generator
     */
    private DataStatus status;

    /**
     * 创建时间: t_repairer_info.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 获取维修人员ID: t_repairer_info.REPAIRER_INFO_ID
     * @return 维修人员ID: t_repairer_info.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    public Long getRepairerInfoid() {
        return repairerInfoid;
    }

    /**
     * 设置维修人员ID: t_repairer_info.REPAIRER_INFO_ID
     * @param repairerInfoid 映射数据库字段: t_repairer_info.REPAIRER_INFO_ID
     * @author MyBatis Generator
     */
    public void setRepairerInfoid(Long repairerInfoid) {
        this.repairerInfoid = repairerInfoid;
    }

    /**
     * 获取维修员工号: t_repairer_info.REPAIRER_NO
     * @return 维修员工号: t_repairer_info.REPAIRER_NO
     * @author MyBatis Generator
     */
    public String getRepairerNo() {
        return repairerNo;
    }

    /**
     * 设置维修员工号: t_repairer_info.REPAIRER_NO
     * @param repairerNo 映射数据库字段: t_repairer_info.REPAIRER_NO
     * @author MyBatis Generator
     */
    public void setRepairerNo(String repairerNo) {
        this.repairerNo = repairerNo == null ? null : repairerNo.trim();
    }

    /**
     * 获取维修人员姓名: t_repairer_info.REALNAME
     * @return 维修人员姓名: t_repairer_info.REALNAME
     * @author MyBatis Generator
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置维修人员姓名: t_repairer_info.REALNAME
     * @param realname 映射数据库字段: t_repairer_info.REALNAME
     * @author MyBatis Generator
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 获取维修人员手机号: t_repairer_info.MOBILE_PHONE
     * @return 维修人员手机号: t_repairer_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置维修人员手机号: t_repairer_info.MOBILE_PHONE
     * @param mobilePhone 映射数据库字段: t_repairer_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 获取维修人员图片: t_repairer_info.REPAIRER_IMG_PATH
     * @return 维修人员图片: t_repairer_info.REPAIRER_IMG_PATH
     * @author MyBatis Generator
     */
    public String getRepairerImgPath() {
        return repairerImgPath;
    }

    /**
     * 设置维修人员图片: t_repairer_info.REPAIRER_IMG_PATH
     * @param repairerImgPath 映射数据库字段: t_repairer_info.REPAIRER_IMG_PATH
     * @author MyBatis Generator
     */
    public void setRepairerImgPath(String repairerImgPath) {
        this.repairerImgPath = repairerImgPath == null ? null : repairerImgPath.trim();
    }

    /**
     * 获取国家: t_repairer_info.COUNTRY
     * @return 国家: t_repairer_info.COUNTRY
     * @author MyBatis Generator
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家: t_repairer_info.COUNTRY
     * @param country 映射数据库字段: t_repairer_info.COUNTRY
     * @author MyBatis Generator
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取省份: t_repairer_info.PROVINCE
     * @return 省份: t_repairer_info.PROVINCE
     * @author MyBatis Generator
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份: t_repairer_info.PROVINCE
     * @param province 映射数据库字段: t_repairer_info.PROVINCE
     * @author MyBatis Generator
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取城市: t_repairer_info.CITY
     * @return 城市: t_repairer_info.CITY
     * @author MyBatis Generator
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市: t_repairer_info.CITY
     * @param city 映射数据库字段: t_repairer_info.CITY
     * @author MyBatis Generator
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取状态,NORMAL正常,FROZEN冻结,DEMISE销户: t_repairer_info.STATUS
     * @return 状态,NORMAL正常,FROZEN冻结,DEMISE销户: t_repairer_info.STATUS
     * @author MyBatis Generator
     */
    public DataStatus getStatus() {
        return status;
    }

    /**
     * 设置状态,NORMAL正常,FROZEN冻结,DEMISE销户: t_repairer_info.STATUS
     * @param status 映射数据库字段: t_repairer_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(DataStatus status) {
        this.status = status;
    }

    /**
     * 获取创建时间: t_repairer_info.CREATETIME
     * @return 创建时间: t_repairer_info.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: t_repairer_info.CREATETIME
     * @param createtime 映射数据库字段: t_repairer_info.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}