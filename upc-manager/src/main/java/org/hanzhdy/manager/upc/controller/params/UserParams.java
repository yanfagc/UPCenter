package org.hanzhdy.manager.upc.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description User查询条件
 * @author H.CAAHN
 * @createtime 2015年12月20日 下午8:44:50
 */
public class UserParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = -1382923223135252327L;
    
    /** 登录帐号 */
    private String            account;
    
    /** 显示名 */
    private String            nickname;
    
    /** 移动电话 */
    private String            mobileno;
    
    /** 邮箱地址 */
    private String            email;
    
    /** 状态 */
    private String            status;
    
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
    
    public String getMobileno() {
        return mobileno;
    }
    
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
