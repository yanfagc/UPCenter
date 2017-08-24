package com.postbox.enums;

/**
 * Created by H.CAAHN on 2017/8/22.
 */
public enum ActiveStatus {
    /** 未激活 */
    NOACTIVE("未激活"),
    
    /** 正常 */
    NORMAL("正常"),
    
    /** 冻结 */
    FROZEN("冻结"),
    
    /** 注销 */
    DEMISE("注销");
    
    private String remark;
    
    private ActiveStatus(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
