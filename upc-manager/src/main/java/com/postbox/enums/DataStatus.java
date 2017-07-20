package com.postbox.enums;

/**
 * 状态字段
 * Created by H.CAAHN on 2017/7/20.
 */
public enum DataStatus {
    /** 正常 */
    NORMAL("正常"),
    
    /** 冻结 */
    FROZEN("冻结"),
    
    /** 注销 */
    DEMISE("注销");
    
    private String remark;
    
    private DataStatus(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
