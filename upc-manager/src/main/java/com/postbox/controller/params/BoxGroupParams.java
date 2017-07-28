package com.postbox.controller.params;

import com.postbox.enums.BoxGroupStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/7/24.
 */
public class BoxGroupParams extends DatatableParams {
    private String groupName;
    
    private String country;
    
    private String province;
    
    private String city;
    
    private Long companyInfoId;
    
    private Long repairerInfoId;
    
    private BoxGroupStatus status;
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
    
    public Long getCompanyInfoId() {
        return companyInfoId;
    }
    
    public void setCompanyInfoId(Long companyInfoId) {
        this.companyInfoId = companyInfoId;
    }
    
    public Long getRepairerInfoId() {
        return repairerInfoId;
    }
    
    public void setRepairerInfoId(Long repairerInfoId) {
        this.repairerInfoId = repairerInfoId;
    }
    
    public BoxGroupStatus getStatus() {
        return status;
    }
    
    public void setStatus(BoxGroupStatus status) {
        this.status = status;
    }
}
