package org.hanzhdy.manager.support.enums;

/**
 * 菜单的显示与否
 * Created by H.CAAHN on 2017/10/20.
 */
public enum ShowFlag {
    SHOW("显示"),
    
    HIDDEN("隐藏");
    
    private String remark;
    
    ShowFlag(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
}
