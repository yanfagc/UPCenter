package org.hanzhdy.manager.support.enums;

/**
 * @description 用户状态定义
 * @author H.CAAHN
 * @createtime 2017年4月10日 下午10:32:50
 */
public enum LoginUserStatus {
    /** 正常 */
    N("正常"),
    
    /** 锁定 */
    L("锁定"),
    
    /** 冻结 */
    F("冻结"),
    
    /** 注销 */
    D("注销");
    
    private String remark;
    
    private LoginUserStatus(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
