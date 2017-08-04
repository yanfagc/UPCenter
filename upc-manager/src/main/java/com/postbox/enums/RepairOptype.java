package com.postbox.enums;

/**
 * Created by H.CAAHN on 2017/8/3.
 */
public enum RepairOptype {
    /** 报修申请 */
    CREATE("报修申请"),
    
    /** 报修确认 */
    CONFIRM("报修确认"),
    
    /** 任务转交 */
    TRANSFER("任务转交"),
    
    /** 修理完成 */
    COMPLETE("修理完成"),
    
    /** 任务取消 */
    CANCEL("取消");
    
    private String remark;
    
    private RepairOptype(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
