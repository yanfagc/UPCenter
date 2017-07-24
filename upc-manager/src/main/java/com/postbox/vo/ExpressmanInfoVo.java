package com.postbox.vo;

import com.postbox.enums.Sex;
import com.postbox.model.ExpressmanInfo;

import java.util.Date;

/**
 * Created by H.CAAHN on 2017/7/21.
 */
public class ExpressmanInfoVo extends ExpressmanInfo {
    private String country;
    
    private String province;
    
    private String city;
    
    private String realname;
    
    private Sex sex;
    
    private String mobilePhone;
    
    private String registerIpAddress;
    
    private Date registerTime;
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getProvince() {
        return province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getRealname() {
        return realname;
    }
    
    public void setRealname(String realname) {
        this.realname = realname;
    }
    
    public Sex getSex() {
        return sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public String getMobilePhone() {
        return mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    public String getRegisterIpAddress() {
        return registerIpAddress;
    }
    
    public void setRegisterIpAddress(String registerIpAddress) {
        this.registerIpAddress = registerIpAddress;
    }
    
    public Date getRegisterTime() {
        return registerTime;
    }
    
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
