package com.postbox.vo;

import com.postbox.model.BoxInfo;

/**
 * Created by H.CAAHN on 2017/7/31.
 */
public class BoxInfoVo extends BoxInfo {
    private String boxGroupCode;
    
    private String boxGroupName;
    
    private String province;
    
    private String city;
    
    private String repairerName;
    
    private String companyName;
    
    public String getBoxGroupCode() {
        return boxGroupCode;
    }
    
    public void setBoxGroupCode(String boxGroupCode) {
        this.boxGroupCode = boxGroupCode;
    }
    
    public String getBoxGroupName() {
        return boxGroupName;
    }
    
    public void setBoxGroupName(String boxGroupName) {
        this.boxGroupName = boxGroupName;
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
    
    public String getRepairerName() {
        return repairerName;
    }
    
    public void setRepairerName(String repairerName) {
        this.repairerName = repairerName;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
