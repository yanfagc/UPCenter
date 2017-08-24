package com.postbox.controller.params;

import com.postbox.enums.ActiveStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/7/31.
 */
public class BoxInfoParams extends DatatableParams {
    private String province;
    
    private String city;
    
    private Long boxGroupId;
    
    private ActiveStatus status;
    
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
    
    public Long getBoxGroupId() {
        return boxGroupId;
    }
    
    public void setBoxGroupId(Long boxGroupId) {
        this.boxGroupId = boxGroupId;
    }
    
    public ActiveStatus getStatus() {
        return status;
    }
    
    public void setStatus(ActiveStatus status) {
        this.status = status;
    }
}
