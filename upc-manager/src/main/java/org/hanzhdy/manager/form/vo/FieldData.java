package org.hanzhdy.manager.form.vo;

/**
 * @description 字段值
 * @author H.CAAHN
 * @createtime 2015年12月20日 下午11:23:45
 */
public class FieldData {
    private String fieldname;
    
    private String fieldcode;
    
    private String fieldtype;
    
    private String macrostype;
    
    private Object value;
    
    public String getFieldname() {
        return fieldname;
    }
    
    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }
    
    public String getFieldcode() {
        return fieldcode;
    }
    
    public void setFieldcode(String fieldcode) {
        this.fieldcode = fieldcode;
    }
    
    public String getFieldtype() {
        return fieldtype;
    }
    
    public void setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype;
    }
    
    public String getMacrostype() {
        return macrostype;
    }
    
    public void setMacrostype(String macrostype) {
        this.macrostype = macrostype;
    }
    
    public Object getValue() {
        return value;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
}
