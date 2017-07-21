package com.postbox.controller.params;

import com.postbox.enums.ExpressmanStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/7/21.
 */
public class ExpressmanInfoParams extends DatatableParams {
    private String realName;
    
    private String mobilePhone;
    
    private ExpressmanStatus status;
    
    public String getRealName() {
        return realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    public String getMobilePhone() {
        return mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    public ExpressmanStatus getStatus() {
        return status;
    }
    
    public void setStatus(ExpressmanStatus status) {
        this.status = status;
    }
}
