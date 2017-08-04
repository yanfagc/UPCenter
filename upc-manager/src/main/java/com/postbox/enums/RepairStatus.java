package com.postbox.enums;

/**
 * 维修状态
 * Created by H.CAAHN on 2017/8/3.
 */
public enum RepairStatus {
    /** 待审核 */
    CHECKING("待审核"),
    
    /** 待处理 */
    PENDING("待处理"),
    
    /** 修理中 */
    REPAIRING("修理中"),
    
    /** 修理完成 */
    COMPLETE("修理完成"),
    
    /** 取消 */
    CANCEL("取消");
    
    private String remark;
    
    private RepairStatus(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
