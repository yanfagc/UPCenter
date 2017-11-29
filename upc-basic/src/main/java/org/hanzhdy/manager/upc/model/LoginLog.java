package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    public static final long serialVersionUID = 510088330163997799L;

    /**
     * ID号: g_login_log.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 用户ID: g_login_log.USERID
     * @author MyBatis Generator
     */
    private Long userid;

    /**
     * 登录名: g_login_log.ACCOUNT
     * @author MyBatis Generator
     */
    private String account;

    /**
     * 用户昵称: g_login_log.NICKNAME
     * @author MyBatis Generator
     */
    private String nickname;

    /**
     * 登录IP: g_login_log.LOGINIP
     * @author MyBatis Generator
     */
    private String loginip;

    /**
     * 登录时间: g_login_log.LOGINTIME
     * @author MyBatis Generator
     */
    private Date logintime;

    /**
     * 备注: g_login_log.REMARK
     * @author MyBatis Generator
     */
    private String remark;

    /**
     * 获取ID号: g_login_log.ID
     * @return ID号: g_login_log.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: g_login_log.ID
     * @param id 映射数据库字段: g_login_log.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID: g_login_log.USERID
     * @return 用户ID: g_login_log.USERID
     * @author MyBatis Generator
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户ID: g_login_log.USERID
     * @param userid 映射数据库字段: g_login_log.USERID
     * @author MyBatis Generator
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取登录名: g_login_log.ACCOUNT
     * @return 登录名: g_login_log.ACCOUNT
     * @author MyBatis Generator
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置登录名: g_login_log.ACCOUNT
     * @param account 映射数据库字段: g_login_log.ACCOUNT
     * @author MyBatis Generator
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取用户昵称: g_login_log.NICKNAME
     * @return 用户昵称: g_login_log.NICKNAME
     * @author MyBatis Generator
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称: g_login_log.NICKNAME
     * @param nickname 映射数据库字段: g_login_log.NICKNAME
     * @author MyBatis Generator
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取登录IP: g_login_log.LOGINIP
     * @return 登录IP: g_login_log.LOGINIP
     * @author MyBatis Generator
     */
    public String getLoginip() {
        return loginip;
    }

    /**
     * 设置登录IP: g_login_log.LOGINIP
     * @param loginip 映射数据库字段: g_login_log.LOGINIP
     * @author MyBatis Generator
     */
    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    /**
     * 获取登录时间: g_login_log.LOGINTIME
     * @return 登录时间: g_login_log.LOGINTIME
     * @author MyBatis Generator
     */
    public Date getLogintime() {
        return logintime;
    }

    /**
     * 设置登录时间: g_login_log.LOGINTIME
     * @param logintime 映射数据库字段: g_login_log.LOGINTIME
     * @author MyBatis Generator
     */
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    /**
     * 获取备注: g_login_log.REMARK
     * @return 备注: g_login_log.REMARK
     * @author MyBatis Generator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注: g_login_log.REMARK
     * @param remark 映射数据库字段: g_login_log.REMARK
     * @author MyBatis Generator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}