package org.hanzhdy.manager.engine.constants;

/**
 * @description 表单字段类型
 * @author H.CAAHN
 * @createtime 2017年6月6日 下午10:06:59
 */
public enum FieldType {
    INPUT("文本输入框", false),
    
    TEXTAREA("多行文本框", false),
    
    SELECT("选择框", true),
    
    CHECKBOX("复选框组", true),
    
    RADIO("单选框组", true),
    
    MACROS("宏控件", false);
    
    private String  remark;
    
    private boolean hasItems;
    
    private FieldType(String remark, boolean hasItems) {
        this.remark = remark;
        this.hasItems = hasItems;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public boolean hasItems() {
        return hasItems;
    }
}
