package com.postbox.enums;

/**
 * Created by H.CAAHN on 2017/7/31.
 */
public enum BoxExpressStatus {
    /** 未存放快递 */
    EMPTY("未存放快递"),
    
    /** 已存放快递 */
    FULL("已存放快递");
    private String remark;
    
    private BoxExpressStatus(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
