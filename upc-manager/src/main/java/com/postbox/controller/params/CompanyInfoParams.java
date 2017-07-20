package com.postbox.controller.params;

import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/7/20.
 */
public class CompanyInfoParams extends DatatableParams {
    private String companyName;
    
    private String legalPersonName;
    
    private String contactName;
    
    private String contactPhone;
    
    private CommonStatus status;
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getLegalPersonName() {
        return legalPersonName;
    }
    
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }
    
    public String getContactName() {
        return contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    public String getContactPhone() {
        return contactPhone;
    }
    
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    
    public CommonStatus getStatus() {
        return status;
    }
    
    public void setStatus(CommonStatus status) {
        this.status = status;
    }
}
