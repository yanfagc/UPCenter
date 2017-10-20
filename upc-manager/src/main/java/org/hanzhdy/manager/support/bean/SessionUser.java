package org.hanzhdy.manager.support.bean;

import org.hanzhdy.manager.support.enums.LoginUserStatus;

import java.util.Date;

/**
 * @description 登录用户信息
 * @author H.CAAHN
 * @createtime 2017年3月31日 下午8:45:25
 */
public class SessionUser {
    private Long            id;
    
    private String          account;
    
    private String          nickname;
    
    private LoginUserStatus status;
    
    private Date            logintime;
    
    private String          loginip;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LoginUserStatus getStatus() {
        return status;
    }

    public void setStatus(LoginUserStatus status) {
        this.status = status;
    }
    
    public Date getLogintime() {
        return logintime;
    }
    
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
    
    public String getLoginip() {
        return loginip;
    }
    
    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }
}
