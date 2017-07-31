package com.postbox.controller.params;

import com.postbox.enums.DataStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/7/20.
 */
public class CompanyInfoParams extends DatatableParams {
    private String companyCode;
    
    private String companyName;
    
    private String legalPersonName;
    
    private String contactName;
    
    private String contactPhone;
    
    private DataStatus status;
    
    public String getCompanyCode() {
        return companyCode;
    }
    
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    
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
    
    public DataStatus getStatus() {
        return status;
    }
    
    public void setStatus(DataStatus status) {
        this.status = status;
    }
}
