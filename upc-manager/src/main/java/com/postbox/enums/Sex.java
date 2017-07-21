package com.postbox.enums;

/**
 * Created by H.CAAHN on 2017/7/21.
 */
public enum Sex {
    /** 男 */
    MALE("男"),
    
    /** 女 */
    FEMALE("女");
    
    private String remark;
    
    private Sex(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
