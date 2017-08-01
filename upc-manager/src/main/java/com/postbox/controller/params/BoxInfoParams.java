package com.postbox.controller.params;

import com.postbox.enums.BoxInfoStatus;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * Created by H.CAAHN on 2017/7/31.
 */
public class BoxInfoParams extends DatatableParams {
    private String province;
    
    private String city;
    
    private Long boxGroupId;
    
    private String boxCode;
    
    private String boxUniqueCode;
    
    private BoxInfoStatus status;
    
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
    
    public String getBoxCode() {
        return boxCode;
    }
    
    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }
    
    public String getBoxUniqueCode() {
        return boxUniqueCode;
    }
    
    public void setBoxUniqueCode(String boxUniqueCode) {
        this.boxUniqueCode = boxUniqueCode;
    }
    
    public BoxInfoStatus getStatus() {
        return status;
    }
    
    public void setStatus(BoxInfoStatus status) {
        this.status = status;
    }
}
