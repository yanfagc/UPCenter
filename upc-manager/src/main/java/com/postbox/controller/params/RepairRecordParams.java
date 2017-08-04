package com.postbox.controller.params;

import com.postbox.enums.RepairStatus;
import org.hanzhdy.web.bean.DatatableParams;

import java.util.Date;

/**
 * 维修记录查询参数
 * Created by H.CAAHN on 2017/8/3.
 */
public class RepairRecordParams extends DatatableParams {
    /** 箱子唯一编号 */
    private String boxUniqueCode;
    
    private String country;
    
    private String province;
    
    private String city;
    
    private RepairStatus status;
    
    private RepairStatus[] statusArray;
    
    private Date beginApplytime;
    
    private Date endApplytime;
    
    private int history;
    
    public String getBoxUniqueCode() {
        return boxUniqueCode;
    }
    
    public void setBoxUniqueCode(String boxUniqueCode) {
        this.boxUniqueCode = boxUniqueCode;
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
    
    public RepairStatus getStatus() {
        return status;
    }
    
    public void setStatus(RepairStatus status) {
        this.status = status;
    }
    
    public RepairStatus[] getStatusArray() {
        return statusArray;
    }
    
    public void setStatusArray(RepairStatus[] statusArray) {
        this.statusArray = statusArray;
    }
    
    public Date getBeginApplytime() {
        return beginApplytime;
    }
    
    public void setBeginApplytime(Date beginApplytime) {
        this.beginApplytime = beginApplytime;
    }
    
    public Date getEndApplytime() {
        return endApplytime;
    }
    
    public void setEndApplytime(Date endApplytime) {
        this.endApplytime = endApplytime;
    }
    
    public int getHistory() {
        return history;
    }
    
    public void setHistory(int history) {
        this.history = history;
    }
}
