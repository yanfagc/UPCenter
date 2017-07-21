package com.postbox.model;

import com.postbox.enums.DataStatus;
import com.postbox.enums.Sex;
import java.io.Serializable;
import java.util.Date;

public class CustomerInfo implements Serializable {
    public static final long serialVersionUID = 336122529L;

    /**
     * 客户ID号: t_customer_info.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    private Long customerInfoId;

    /**
     * 绑定的外部帐号: t_customer_info.BIND_ACCOUNT
     * @author MyBatis Generator
     */
    private String bindAccount;

    /**
     * 登录名,唯一,自动生成,用户只能修改一次: t_customer_info.LOGIN_NAME
     * @author MyBatis Generator
     */
    private String loginName;

    /**
     * 登录密码: t_customer_info.PASSWORD
     * @author MyBatis Generator
     */
    private String password;

    /**
     * 国家: t_customer_info.COUNTRY
     * @author MyBatis Generator
     */
    private String country;

    /**
     * 省份: t_customer_info.PROVINCE
     * @author MyBatis Generator
     */
    private String province;

    /**
     * 城市: t_customer_info.CITY
     * @author MyBatis Generator
     */
    private String city;

    /**
     * 真实姓名: t_customer_info.REALNAME
     * @author MyBatis Generator
     */
    private String realname;

    /**
     * 性别: t_customer_info.SEX
     * @author MyBatis Generator
     */
    private Sex sex;

    /**
     * 客户手机号: t_customer_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    private String mobilePhone;

    /**
     * 状态,NORMAL正常,FROZEN冻结,DEMISE销户: t_customer_info.STATUS
     * @author MyBatis Generator
     */
    private DataStatus status;

    /**
     * 注册IP地址: t_customer_info.REGISTER_IP_ADDRESS
     * @author MyBatis Generator
     */
    private String registerIpAddress;

    /**
     * 注册时间: t_customer_info.REGISTER_TIME
     * @author MyBatis Generator
     */
    private Date registerTime;

    /**
     * 上次登录IP: t_customer_info.LAST_LOGIN_IP
     * @author MyBatis Generator
     */
    private String lastLoginIp;

    /**
     * 上次登录时间: t_customer_info.LAST_LOGIN_TIME
     * @author MyBatis Generator
     */
    private Date lastLoginTime;

    /**
     * 注册来源: t_customer_info.SOURCE
     * @author MyBatis Generator
     */
    private String source;

    /**
     * 客户头像存储路径: t_customer_info.HEAD_IMG_PATH
     * @author MyBatis Generator
     */
    private String headImgPath;

    /**
     * 获取客户ID号: t_customer_info.CUSTOMER_INFO_ID
     * @return 客户ID号: t_customer_info.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public Long getCustomerInfoId() {
        return customerInfoId;
    }

    /**
     * 设置客户ID号: t_customer_info.CUSTOMER_INFO_ID
     * @param customerInfoId 映射数据库字段: t_customer_info.CUSTOMER_INFO_ID
     * @author MyBatis Generator
     */
    public void setCustomerInfoId(Long customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    /**
     * 获取绑定的外部帐号: t_customer_info.BIND_ACCOUNT
     * @return 绑定的外部帐号: t_customer_info.BIND_ACCOUNT
     * @author MyBatis Generator
     */
    public String getBindAccount() {
        return bindAccount;
    }

    /**
     * 设置绑定的外部帐号: t_customer_info.BIND_ACCOUNT
     * @param bindAccount 映射数据库字段: t_customer_info.BIND_ACCOUNT
     * @author MyBatis Generator
     */
    public void setBindAccount(String bindAccount) {
        this.bindAccount = bindAccount == null ? null : bindAccount.trim();
    }

    /**
     * 获取登录名,唯一,自动生成,用户只能修改一次: t_customer_info.LOGIN_NAME
     * @return 登录名,唯一,自动生成,用户只能修改一次: t_customer_info.LOGIN_NAME
     * @author MyBatis Generator
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名,唯一,自动生成,用户只能修改一次: t_customer_info.LOGIN_NAME
     * @param loginName 映射数据库字段: t_customer_info.LOGIN_NAME
     * @author MyBatis Generator
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取登录密码: t_customer_info.PASSWORD
     * @return 登录密码: t_customer_info.PASSWORD
     * @author MyBatis Generator
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码: t_customer_info.PASSWORD
     * @param password 映射数据库字段: t_customer_info.PASSWORD
     * @author MyBatis Generator
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取国家: t_customer_info.COUNTRY
     * @return 国家: t_customer_info.COUNTRY
     * @author MyBatis Generator
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家: t_customer_info.COUNTRY
     * @param country 映射数据库字段: t_customer_info.COUNTRY
     * @author MyBatis Generator
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取省份: t_customer_info.PROVINCE
     * @return 省份: t_customer_info.PROVINCE
     * @author MyBatis Generator
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份: t_customer_info.PROVINCE
     * @param province 映射数据库字段: t_customer_info.PROVINCE
     * @author MyBatis Generator
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取城市: t_customer_info.CITY
     * @return 城市: t_customer_info.CITY
     * @author MyBatis Generator
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市: t_customer_info.CITY
     * @param city 映射数据库字段: t_customer_info.CITY
     * @author MyBatis Generator
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取真实姓名: t_customer_info.REALNAME
     * @return 真实姓名: t_customer_info.REALNAME
     * @author MyBatis Generator
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名: t_customer_info.REALNAME
     * @param realname 映射数据库字段: t_customer_info.REALNAME
     * @author MyBatis Generator
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 获取性别: t_customer_info.SEX
     * @return 性别: t_customer_info.SEX
     * @author MyBatis Generator
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * 设置性别: t_customer_info.SEX
     * @param sex 映射数据库字段: t_customer_info.SEX
     * @author MyBatis Generator
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * 获取客户手机号: t_customer_info.MOBILE_PHONE
     * @return 客户手机号: t_customer_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置客户手机号: t_customer_info.MOBILE_PHONE
     * @param mobilePhone 映射数据库字段: t_customer_info.MOBILE_PHONE
     * @author MyBatis Generator
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 获取状态,NORMAL正常,FROZEN冻结,DEMISE销户: t_customer_info.STATUS
     * @return 状态,NORMAL正常,FROZEN冻结,DEMISE销户: t_customer_info.STATUS
     * @author MyBatis Generator
     */
    public DataStatus getStatus() {
        return status;
    }

    /**
     * 设置状态,NORMAL正常,FROZEN冻结,DEMISE销户: t_customer_info.STATUS
     * @param status 映射数据库字段: t_customer_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(DataStatus status) {
        this.status = status;
    }

    /**
     * 获取注册IP地址: t_customer_info.REGISTER_IP_ADDRESS
     * @return 注册IP地址: t_customer_info.REGISTER_IP_ADDRESS
     * @author MyBatis Generator
     */
    public String getRegisterIpAddress() {
        return registerIpAddress;
    }

    /**
     * 设置注册IP地址: t_customer_info.REGISTER_IP_ADDRESS
     * @param registerIpAddress 映射数据库字段: t_customer_info.REGISTER_IP_ADDRESS
     * @author MyBatis Generator
     */
    public void setRegisterIpAddress(String registerIpAddress) {
        this.registerIpAddress = registerIpAddress == null ? null : registerIpAddress.trim();
    }

    /**
     * 获取注册时间: t_customer_info.REGISTER_TIME
     * @return 注册时间: t_customer_info.REGISTER_TIME
     * @author MyBatis Generator
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间: t_customer_info.REGISTER_TIME
     * @param registerTime 映射数据库字段: t_customer_info.REGISTER_TIME
     * @author MyBatis Generator
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取上次登录IP: t_customer_info.LAST_LOGIN_IP
     * @return 上次登录IP: t_customer_info.LAST_LOGIN_IP
     * @author MyBatis Generator
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置上次登录IP: t_customer_info.LAST_LOGIN_IP
     * @param lastLoginIp 映射数据库字段: t_customer_info.LAST_LOGIN_IP
     * @author MyBatis Generator
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * 获取上次登录时间: t_customer_info.LAST_LOGIN_TIME
     * @return 上次登录时间: t_customer_info.LAST_LOGIN_TIME
     * @author MyBatis Generator
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置上次登录时间: t_customer_info.LAST_LOGIN_TIME
     * @param lastLoginTime 映射数据库字段: t_customer_info.LAST_LOGIN_TIME
     * @author MyBatis Generator
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取注册来源: t_customer_info.SOURCE
     * @return 注册来源: t_customer_info.SOURCE
     * @author MyBatis Generator
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置注册来源: t_customer_info.SOURCE
     * @param source 映射数据库字段: t_customer_info.SOURCE
     * @author MyBatis Generator
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取客户头像存储路径: t_customer_info.HEAD_IMG_PATH
     * @return 客户头像存储路径: t_customer_info.HEAD_IMG_PATH
     * @author MyBatis Generator
     */
    public String getHeadImgPath() {
        return headImgPath;
    }

    /**
     * 设置客户头像存储路径: t_customer_info.HEAD_IMG_PATH
     * @param headImgPath 映射数据库字段: t_customer_info.HEAD_IMG_PATH
     * @author MyBatis Generator
     */
    public void setHeadImgPath(String headImgPath) {
        this.headImgPath = headImgPath == null ? null : headImgPath.trim();
    }
}