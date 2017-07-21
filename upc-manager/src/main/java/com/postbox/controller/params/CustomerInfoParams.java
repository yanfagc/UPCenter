package com.postbox.controller.params;

import com.postbox.enums.DataStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * 客户管理查询条件
 * Created by H.CAAHN on 2017/7/21.
 */
public class CustomerInfoParams extends DatatableParams {
    private String realName;
    
    private String mobilePhone;
    
    private DataStatus status;
    
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
    
    public DataStatus getStatus() {
        return status;
    }
    
    public void setStatus(DataStatus status) {
        this.status = status;
    }
}
