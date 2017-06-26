package org.hanzhdy.manager.upc.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
    public static final long serialVersionUID = -1291346843L;

    /**
     * 用户ID: u_user_info.USERID
     * @author MyBatis Generator
     */
    private Long userId;

    /**
     * 手机号码: u_user_info.MOBILENO
     * @author MyBatis Generator
     */
    private String mobileno;

    /**
     * 邮箱地址: u_user_info.EMAIL
     * @author MyBatis Generator
     */
    private String email;

    /**
     * 证件类型: u_user_info.CERTTYPE
     * @author MyBatis Generator
     */
    private String certtype;

    /**
     * 证件号码: u_user_info.CERTNO
     * @author MyBatis Generator
     */
    private String certno;

    /**
     * 办公电话: u_user_info.OFFICEPHONE
     * @author MyBatis Generator
     */
    private String officephone;

    /**
     * 传真: u_user_info.FAXNO
     * @author MyBatis Generator
     */
    private String faxno;

    /**
     * 获取用户ID: u_user_info.USERID
     * @return 用户ID: u_user_info.USERID
     * @author MyBatis Generator
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID: u_user_info.USERID
     * @param userId 映射数据库字段: u_user_info.USERID
     * @author MyBatis Generator
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取手机号码: u_user_info.MOBILENO
     * @return 手机号码: u_user_info.MOBILENO
     * @author MyBatis Generator
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * 设置手机号码: u_user_info.MOBILENO
     * @param mobileno 映射数据库字段: u_user_info.MOBILENO
     * @author MyBatis Generator
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno == null ? null : mobileno.trim();
    }

    /**
     * 获取邮箱地址: u_user_info.EMAIL
     * @return 邮箱地址: u_user_info.EMAIL
     * @author MyBatis Generator
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址: u_user_info.EMAIL
     * @param email 映射数据库字段: u_user_info.EMAIL
     * @author MyBatis Generator
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取证件类型: u_user_info.CERTTYPE
     * @return 证件类型: u_user_info.CERTTYPE
     * @author MyBatis Generator
     */
    public String getCerttype() {
        return certtype;
    }

    /**
     * 设置证件类型: u_user_info.CERTTYPE
     * @param certtype 映射数据库字段: u_user_info.CERTTYPE
     * @author MyBatis Generator
     */
    public void setCerttype(String certtype) {
        this.certtype = certtype == null ? null : certtype.trim();
    }

    /**
     * 获取证件号码: u_user_info.CERTNO
     * @return 证件号码: u_user_info.CERTNO
     * @author MyBatis Generator
     */
    public String getCertno() {
        return certno;
    }

    /**
     * 设置证件号码: u_user_info.CERTNO
     * @param certno 映射数据库字段: u_user_info.CERTNO
     * @author MyBatis Generator
     */
    public void setCertno(String certno) {
        this.certno = certno == null ? null : certno.trim();
    }

    /**
     * 获取办公电话: u_user_info.OFFICEPHONE
     * @return 办公电话: u_user_info.OFFICEPHONE
     * @author MyBatis Generator
     */
    public String getOfficephone() {
        return officephone;
    }

    /**
     * 设置办公电话: u_user_info.OFFICEPHONE
     * @param officephone 映射数据库字段: u_user_info.OFFICEPHONE
     * @author MyBatis Generator
     */
    public void setOfficephone(String officephone) {
        this.officephone = officephone == null ? null : officephone.trim();
    }

    /**
     * 获取传真: u_user_info.FAXNO
     * @return 传真: u_user_info.FAXNO
     * @author MyBatis Generator
     */
    public String getFaxno() {
        return faxno;
    }

    /**
     * 设置传真: u_user_info.FAXNO
     * @param faxno 映射数据库字段: u_user_info.FAXNO
     * @author MyBatis Generator
     */
    public void setFaxno(String faxno) {
        this.faxno = faxno == null ? null : faxno.trim();
    }
}