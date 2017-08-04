package com.postbox.vo;

import com.postbox.enums.BoxExpressStatus;
import com.postbox.model.RepairRecord;

/**
 * Created by H.CAAHN on 2017/8/3.
 */
public class RepairRecordVo extends RepairRecord {
    private String boxCode;
    
    private BoxExpressStatus expressStatus;
    
    private String country;
    
    private String province;
    
    private String city;
    
    private String boxGroupName;
    
    public String getBoxCode() {
        return boxCode;
    }
    
    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }
    
    public BoxExpressStatus getExpressStatus() {
        return expressStatus;
    }
    
    public void setExpressStatus(BoxExpressStatus expressStatus) {
        this.expressStatus = expressStatus;
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
    
    public String getBoxGroupName() {
        return boxGroupName;
    }
    
    public void setBoxGroupName(String boxGroupName) {
        this.boxGroupName = boxGroupName;
    }
}
