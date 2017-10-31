package org.hanzhdy.manager.upc.vo;

import org.hanzhdy.manager.support.enums.LoginUserStatus;

/**
 * @description 用户VO
 * @author H.CAAHN
 * @createtime 2015年12月20日 下午10:19:45
 */
public class UserVo {
    private Long            id;
    
    private String          account;
    
    private String          password;
    
    private String          nickname;
    
    private Long            formid;
    
    private String          mobileno;
    
    private String          email;
    
    private String          certtype;
    
    private String          certno;
    
    private String          officephone;
    
    private String          faxno;
    
    private String          imgurl;
    
    private LoginUserStatus status;
    
    private Long            creator;
    
    private Long            updater;
    
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public Long getFormid() {
        return formid;
    }
    
    public void setFormid(Long formid) {
        this.formid = formid;
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
    
    public String getCerttype() {
        return certtype;
    }
    
    public void setCerttype(String certtype) {
        this.certtype = certtype;
    }
    
    public String getCertno() {
        return certno;
    }
    
    public void setCertno(String certno) {
        this.certno = certno;
    }
    
    public String getOfficephone() {
        return officephone;
    }
    
    public void setOfficephone(String officephone) {
        this.officephone = officephone;
    }
    
    public String getFaxno() {
        return faxno;
    }
    
    public void setFaxno(String faxno) {
        this.faxno = faxno;
    }
    
    public String getImgurl() {
        return imgurl;
    }
    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    
    public LoginUserStatus getStatus() {
        return status;
    }
    
    public void setStatus(LoginUserStatus status) {
        this.status = status;
    }
    
    public Long getCreator() {
        return creator;
    }
    
    public void setCreator(Long creator) {
        this.creator = creator;
    }
    
    public Long getUpdater() {
        return updater;
    }
    
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}
