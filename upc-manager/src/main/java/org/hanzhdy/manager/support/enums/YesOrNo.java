package org.hanzhdy.manager.support.enums;

/**
 * @description yes or no
 * @author H.CAAHN
 * @createtime 2017年6月16日 下午8:10:30
 */
public enum YesOrNo {
    Y("是"),
    
    N("否");
    
    private String remark;
    
    YesOrNo(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
    
    public String getName() {
        return this.name();
    }
}
