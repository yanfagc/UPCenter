package org.hanzhdy.manager.settings.vo;

/**
 * @description 表单字段
 * @author H.CAAHN
 * @createtime 2015年12月15日 下午9:21:03
 */
public class FormFieldVo {
    private Long    formid;
    
    private Long    fieldid;
    
    private Integer sort;
    
    private Integer colspan;
    
    private String  fieldcode;
    
    private String  fieldname;
    
    private String  status;
    
    public Long getFormid() {
        return formid;
    }
    
    public void setFormid(Long formid) {
        this.formid = formid;
    }
    
    public Long getFieldid() {
        return fieldid;
    }
    
    public void setFieldid(Long fieldid) {
        this.fieldid = fieldid;
    }
    
    public Integer getSort() {
        return sort;
    }
    
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getColspan() {
        return colspan;
    }

    public void setColspan(Integer colspan) {
        this.colspan = colspan;
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
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
