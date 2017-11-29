package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;

public class UserBasic implements Serializable {
    public static final long serialVersionUID = 510088327781913431L;

    /**
     * ID号: u_user_basic.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 登录名: u_user_basic.ACCOUNT
     * @author MyBatis Generator
     */
    private String account;

    /**
     * 登录密码: u_user_basic.PASSWORD
     * @author MyBatis Generator
     */
    private String password;

    /**
     * 密码盐值: u_user_basic.SALT
     * @author MyBatis Generator
     */
    private String salt;

    /**
     * 显示名: u_user_basic.NICKNAME
     * @author MyBatis Generator
     */
    private String nickname;

    /**
     * 属性表单ID: u_user_basic.FORMID
     * @author MyBatis Generator
     */
    private Long formId;

    /**
     * 本次登录时间: u_user_basic.CURRLOGINTIME
     * @author MyBatis Generator
     */
    private Date currlogintime;

    /**
     * 上次登录时间: u_user_basic.PRELOGINTIME
     * @author MyBatis Generator
     */
    private Date prelogintime;

    /**
     * 本次登录IP: u_user_basic.CURRLOGINIP
     * @author MyBatis Generator
     */
    private String currloginip;

    /**
     * 上次登录IP: u_user_basic.PRELOGINIP
     * @author MyBatis Generator
     */
    private String preloginip;

    /**
     * 获取ID号: u_user_basic.ID
     * @return ID号: u_user_basic.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: u_user_basic.ID
     * @param id 映射数据库字段: u_user_basic.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取登录名: u_user_basic.ACCOUNT
     * @return 登录名: u_user_basic.ACCOUNT
     * @author MyBatis Generator
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置登录名: u_user_basic.ACCOUNT
     * @param account 映射数据库字段: u_user_basic.ACCOUNT
     * @author MyBatis Generator
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取登录密码: u_user_basic.PASSWORD
     * @return 登录密码: u_user_basic.PASSWORD
     * @author MyBatis Generator
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码: u_user_basic.PASSWORD
     * @param password 映射数据库字段: u_user_basic.PASSWORD
     * @author MyBatis Generator
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取密码盐值: u_user_basic.SALT
     * @return 密码盐值: u_user_basic.SALT
     * @author MyBatis Generator
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置密码盐值: u_user_basic.SALT
     * @param salt 映射数据库字段: u_user_basic.SALT
     * @author MyBatis Generator
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取显示名: u_user_basic.NICKNAME
     * @return 显示名: u_user_basic.NICKNAME
     * @author MyBatis Generator
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置显示名: u_user_basic.NICKNAME
     * @param nickname 映射数据库字段: u_user_basic.NICKNAME
     * @author MyBatis Generator
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取属性表单ID: u_user_basic.FORMID
     * @return 属性表单ID: u_user_basic.FORMID
     * @author MyBatis Generator
     */
    public Long getFormId() {
        return formId;
    }

    /**
     * 设置属性表单ID: u_user_basic.FORMID
     * @param formId 映射数据库字段: u_user_basic.FORMID
     * @author MyBatis Generator
     */
    public void setFormId(Long formId) {
        this.formId = formId;
    }

    /**
     * 获取本次登录时间: u_user_basic.CURRLOGINTIME
     * @return 本次登录时间: u_user_basic.CURRLOGINTIME
     * @author MyBatis Generator
     */
    public Date getCurrlogintime() {
        return currlogintime;
    }

    /**
     * 设置本次登录时间: u_user_basic.CURRLOGINTIME
     * @param currlogintime 映射数据库字段: u_user_basic.CURRLOGINTIME
     * @author MyBatis Generator
     */
    public void setCurrlogintime(Date currlogintime) {
        this.currlogintime = currlogintime;
    }

    /**
     * 获取上次登录时间: u_user_basic.PRELOGINTIME
     * @return 上次登录时间: u_user_basic.PRELOGINTIME
     * @author MyBatis Generator
     */
    public Date getPrelogintime() {
        return prelogintime;
    }

    /**
     * 设置上次登录时间: u_user_basic.PRELOGINTIME
     * @param prelogintime 映射数据库字段: u_user_basic.PRELOGINTIME
     * @author MyBatis Generator
     */
    public void setPrelogintime(Date prelogintime) {
        this.prelogintime = prelogintime;
    }

    /**
     * 获取本次登录IP: u_user_basic.CURRLOGINIP
     * @return 本次登录IP: u_user_basic.CURRLOGINIP
     * @author MyBatis Generator
     */
    public String getCurrloginip() {
        return currloginip;
    }

    /**
     * 设置本次登录IP: u_user_basic.CURRLOGINIP
     * @param currloginip 映射数据库字段: u_user_basic.CURRLOGINIP
     * @author MyBatis Generator
     */
    public void setCurrloginip(String currloginip) {
        this.currloginip = currloginip == null ? null : currloginip.trim();
    }

    /**
     * 获取上次登录IP: u_user_basic.PRELOGINIP
     * @return 上次登录IP: u_user_basic.PRELOGINIP
     * @author MyBatis Generator
     */
    public String getPreloginip() {
        return preloginip;
    }

    /**
     * 设置上次登录IP: u_user_basic.PRELOGINIP
     * @param preloginip 映射数据库字段: u_user_basic.PRELOGINIP
     * @author MyBatis Generator
     */
    public void setPreloginip(String preloginip) {
        this.preloginip = preloginip == null ? null : preloginip.trim();
    }
}