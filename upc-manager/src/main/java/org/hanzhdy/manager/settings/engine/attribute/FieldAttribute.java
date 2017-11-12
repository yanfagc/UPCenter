package org.hanzhdy.manager.settings.engine.attribute;

import org.hanzhdy.manager.support.enums.FieldType;

/**
 * @description 表单字段的属性
 * @author H.CAAHN
 * @createtime 2017年6月8日 上午11:00:37
 */
public abstract class FieldAttribute implements HtmlAttribute {
    private Long      id;
    
    private String    fieldcode;
    
    private String    fieldname;
    
    private String    fieldtips;
    
    private FieldType fieldtype;
    
    private String    value;
    
    /** 实际占用table的td个数，一般一个label+一个input，至少占用2个td */
    private int       colspan;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFieldcode() {
        return fieldcode;
    }
    
    public void setFieldcode(String fieldcode) {
        this.fieldcode = fieldcode;
    }
    
    public String getFieldname() {
        return fieldname;
    }
    
    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }
    
    public String getFieldtips() {
        return fieldtips;
    }
    
    public void setFieldtips(String fieldtips) {
        this.fieldtips = fieldtips;
    }
    
    public FieldType getFieldtype() {
        return fieldtype;
    }
    
    public void setFieldtype(FieldType fieldtype) {
        this.fieldtype = fieldtype;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public int getColspan() {
        return colspan;
    }
    
    public void setColspan(int colspan) {
        this.colspan = colspan;
    }
}
