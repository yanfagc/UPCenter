package org.hanzhdy.api.vo;

import org.hanzhdy.manager.support.enums.LoginUserStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    
    private LoginUserStatus status;

    private Date            currlogintime;

    private Date            prelogintime;

    private String          currloginip;

    private String          preloginip;

    private List<Option>    optionList;

    public void addOption(Option option) {
        if (optionList == null) {
            optionList = new ArrayList<>();
        }
        optionList.add(option);
    }

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
    
    public LoginUserStatus getStatus() {
        return status;
    }
    
    public void setStatus(LoginUserStatus status) {
        this.status = status;
    }

    public Date getCurrlogintime() {
        return currlogintime;
    }

    public void setCurrlogintime(Date currlogintime) {
        this.currlogintime = currlogintime;
    }

    public Date getPrelogintime() {
        return prelogintime;
    }

    public void setPrelogintime(Date prelogintime) {
        this.prelogintime = prelogintime;
    }

    public String getCurrloginip() {
        return currloginip;
    }

    public void setCurrloginip(String currloginip) {
        this.currloginip = currloginip;
    }

    public String getPreloginip() {
        return preloginip;
    }

    public void setPreloginip(String preloginip) {
        this.preloginip = preloginip;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
