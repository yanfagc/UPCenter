package org.hanzhdy.proxy.request;

/**
 * 用户登录请求
 * Created by H.CAAHN on 2017/12/8.
 */
public class UserLoginRequest extends BasicRequest {
    private String account;
    
    private String password;
    
    private String captcha;
    
    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCaptcha() {
        return captcha;
    }
    
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
