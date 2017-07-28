package com.postbox.controller.params;

import com.postbox.enums.DataStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/7/24.
 */
public class RepairerInfoParams extends DatatableParams {
    private String realname;
    
    private String country;
    
    private String province;
    
    private String city;
    
    private String mobilePhone;
    
    private DataStatus status;
    
    public String getRealname() {
        return realname;
    }
    
    public void setRealname(String realname) {
        this.realname = realname;
    }
    
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
    
    public String getMobilePhone() {
        return mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    public DataStatus getStatus() {
        return status;
    }
    
    public void setStatus(DataStatus status) {
        this.status = status;
    }
}
