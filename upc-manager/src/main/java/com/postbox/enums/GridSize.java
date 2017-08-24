package com.postbox.enums;

/**
 * 快递格子大小
 * Created by H.CAAHN on 2017/8/21.
 */
public enum GridSize {
    /** 中型 */
    MEDIUM("中型"),
    
    /** 小型 */
    SMALL("小型"),
    
    /** 大型 */
    LARGE("大型");
    
    private String remark;
    
    private GridSize(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
