package org.hanzhdy.manager.support.enums;

/**
 * Created by H.CAAHN on 2017/7/27.
 */
public enum DictDataType {
    N("无数据"),
    
    B("布尔数据"),
    
    T("文本数据"),
    
    I("整型数据"),
    
    F("浮点型数据");
    
    private String remark;
    
    DictDataType(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return  this.remark;
    }
}
