package org.hanzhdy.manager.settings.model;

import java.io.Serializable;

public class FormField extends FormFieldKey implements Serializable {
    public static final long serialVersionUID = 2038829832L;

    /**
     * 所占列数,默认1: f_form_field.COLSPAN
     * @author MyBatis Generator
     */
    private Integer colspan;

    /**
     * 排序: f_form_field.SORT
     * @author MyBatis Generator
     */
    private Short sort;

    /**
     * 获取所占列数,默认1: f_form_field.COLSPAN
     * @return 所占列数,默认1: f_form_field.COLSPAN
     * @author MyBatis Generator
     */
    public Integer getColspan() {
        return colspan;
    }

    /**
     * 设置所占列数,默认1: f_form_field.COLSPAN
     * @param colspan 映射数据库字段: f_form_field.COLSPAN
     * @author MyBatis Generator
     */
    public void setColspan(Integer colspan) {
        this.colspan = colspan;
    }

    /**
     * 获取排序: f_form_field.SORT
     * @return 排序: f_form_field.SORT
     * @author MyBatis Generator
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置排序: f_form_field.SORT
     * @param sort 映射数据库字段: f_form_field.SORT
     * @author MyBatis Generator
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }
}