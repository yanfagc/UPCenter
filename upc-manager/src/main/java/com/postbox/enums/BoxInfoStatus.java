package com.postbox.enums;

/**
 * Created by H.CAAHN on 2017/7/31.
 */
public enum BoxInfoStatus {
    /** 未激活 */
    NOACTIVE("未激活"),
    
    /** 正常 */
    NORMAL("正常"),
    
    /** 维修 */
    REPAIR("维修"),
    
    /** 注销 */
    DEMISE("注销");
    
    private String remark;
    
    private BoxInfoStatus(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
