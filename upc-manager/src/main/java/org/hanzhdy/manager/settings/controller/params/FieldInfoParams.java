package org.hanzhdy.manager.settings.controller.params;

import org.hanzhdy.manager.support.enums.FieldType;
import org.hanzhdy.web.bean.DatatableParams;

/**
 * @description FieldInfo查询条件
 * @author H.CAAHN
 * @createtime 2015年12月1日 下午11:33:08
 */
public class FieldInfoParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = 5765046118347231784L;
    
    private Long              formid;
    
    private String            fieldcode;
    
    private String            fieldname;
    
    private FieldType fieldtype;
    
    public Long getFormid() {
        return formid;
    }
    
    public void setFormid(Long formid) {
        this.formid = formid;
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
    
    public FieldType getFieldtype() {
        return fieldtype;
    }
    
    public void setFieldtype(FieldType fieldtype) {
        this.fieldtype = fieldtype;
    }
}
