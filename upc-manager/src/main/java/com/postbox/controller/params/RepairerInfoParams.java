package com.postbox.controller.params;

import com.postbox.enums.DataStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/7/24.
 */
public class RepairerInfoParams extends DatatableParams {
    private String realname;
    
    private String mobilePhone;
    
    private DataStatus status;
    
    public String getRealname() {
        return realname;
    }
    
    public void setRealname(String realname) {
        this.realname = realname;
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
