package org.hanzhdy.manager.form.model;

public class FormFieldKey {
    /**
     * 表单ID: f_form_field.FORMID
     * @author MyBatis Generator
     */
    private Long formId;

    /**
     * 表单属性ID: f_form_field.FIELDID
     * @author MyBatis Generator
     */
    private Long fieldId;

    /**
     * 获取表单ID: f_form_field.FORMID
     * @return 表单ID: f_form_field.FORMID
     * @author MyBatis Generator
     */
    public Long getFormId() {
        return formId;
    }

    /**
     * 设置表单ID: f_form_field.FORMID
     * @param formId 映射数据库字段: f_form_field.FORMID
     * @author MyBatis Generator
     */
    public void setFormId(Long formId) {
        this.formId = formId;
    }

    /**
     * 获取表单属性ID: f_form_field.FIELDID
     * @return 表单属性ID: f_form_field.FIELDID
     * @author MyBatis Generator
     */
    public Long getFieldId() {
        return fieldId;
    }

    /**
     * 设置表单属性ID: f_form_field.FIELDID
     * @param fieldId 映射数据库字段: f_form_field.FIELDID
     * @author MyBatis Generator
     */
    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }
}