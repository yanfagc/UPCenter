package org.hanzhdy.manager.support.enums;

/**
 * @description 一般的状态定义
 * @author H.CAAHN
 * @createtime 2017年4月10日 下午10:35:58
 */
public enum CommonStatus {
    /** 正常 */
    N("正常"),
    
    /** 冻结 */
    F("冻结"),
    
    /** 注销 */
    D("注销");
    
    private String remark;
    
    private CommonStatus(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
