package org.hanzhdy.manager.form.model;

import java.io.Serializable;

public class FormData implements Serializable {
    public static final long serialVersionUID = -1042676772L;

    /**
     * ID号: f_form_data.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 表单字段ID: f_form_data.FIELDID
     * @author MyBatis Generator
     */
    private Long fieldid;

    /**
     * 表单字段值: f_form_data.VALUE
     * @author MyBatis Generator
     */
    private String value;

    /**
     * 扩展表类型: f_form_data.DATATYPE
     * @author MyBatis Generator
     */
    private String datatype;

    /**
     * 扩展表映射的数据记录DI: f_form_data.RECORDID
     * @author MyBatis Generator
     */
    private Long recordid;

    /**
     * 获取ID号: f_form_data.ID
     * @return ID号: f_form_data.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: f_form_data.ID
     * @param id 映射数据库字段: f_form_data.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取表单字段ID: f_form_data.FIELDID
     * @return 表单字段ID: f_form_data.FIELDID
     * @author MyBatis Generator
     */
    public Long getFieldid() {
        return fieldid;
    }

    /**
     * 设置表单字段ID: f_form_data.FIELDID
     * @param fieldid 映射数据库字段: f_form_data.FIELDID
     * @author MyBatis Generator
     */
    public void setFieldid(Long fieldid) {
        this.fieldid = fieldid;
    }

    /**
     * 获取表单字段值: f_form_data.VALUE
     * @return 表单字段值: f_form_data.VALUE
     * @author MyBatis Generator
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置表单字段值: f_form_data.VALUE
     * @param value 映射数据库字段: f_form_data.VALUE
     * @author MyBatis Generator
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取扩展表类型: f_form_data.DATATYPE
     * @return 扩展表类型: f_form_data.DATATYPE
     * @author MyBatis Generator
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * 设置扩展表类型: f_form_data.DATATYPE
     * @param datatype 映射数据库字段: f_form_data.DATATYPE
     * @author MyBatis Generator
     */
    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    /**
     * 获取扩展表映射的数据记录DI: f_form_data.RECORDID
     * @return 扩展表映射的数据记录DI: f_form_data.RECORDID
     * @author MyBatis Generator
     */
    public Long getRecordid() {
        return recordid;
    }

    /**
     * 设置扩展表映射的数据记录DI: f_form_data.RECORDID
     * @param recordid 映射数据库字段: f_form_data.RECORDID
     * @author MyBatis Generator
     */
    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }
}