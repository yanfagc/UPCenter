package org.hanzhdy.manager.settings.engine.constants;

/**
 * @description input类型的macrostype
 * @author H.CAAHN
 * @createtime 2017年6月8日 下午1:34:00
 */
public enum InputMacrosType {
    TEXT("普通文本"),
    
    INT("整形数值"),
    
    FLOAT("浮点数值"),
    
    EMAIL("电子邮箱");
    
    private String remark;
    
    InputMacrosType(String remark) {
        this.remark = remark;
    }
    
    public String getName() {
        return this.name();
    }
    
    public String getRemark() {
        return this.remark;
    }
}
