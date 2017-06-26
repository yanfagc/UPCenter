package org.hanzhdy.manager.support.enums;

/**
 * @description Field's length type
 * @author H.CAAHN
 * @createtime 2017年6月16日 下午8:49:31
 */
public enum FieldLengthType {
    BYTE("字节"),
    
    CHAR("字符"),
    
    DBLB("双字节");
    
    private String remark;
    
    FieldLengthType(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
    }
    
    public String getName() {
        return this.name();
    }
}
