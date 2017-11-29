package org.hanzhdy.manager.settings.model;

import java.io.Serializable;
import org.hanzhdy.manager.support.enums.CommonStatus;

public class FieldItem implements Serializable {
    public static final long serialVersionUID = 510088327746199678L;

    /**
     * ID号: f_field_item.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 选项值: f_field_item.ITEMVALUE
     * @author MyBatis Generator
     */
    private String itemvalue;

    /**
     * 选项名称: f_field_item.ITEMNAME
     * @author MyBatis Generator
     */
    private String itemname;

    /**
     * 表单属性ID: f_field_item.FIELDID
     * @author MyBatis Generator
     */
    private Long fieldid;

    /**
     * 状态.N正常,F冻结,D注销: f_field_item.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 排序: f_field_item.SORT
     * @author MyBatis Generator
     */
    private Short sort;

    /**
     * 获取ID号: f_field_item.ID
     * @return ID号: f_field_item.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: f_field_item.ID
     * @param id 映射数据库字段: f_field_item.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取选项值: f_field_item.ITEMVALUE
     * @return 选项值: f_field_item.ITEMVALUE
     * @author MyBatis Generator
     */
    public String getItemvalue() {
        return itemvalue;
    }

    /**
     * 设置选项值: f_field_item.ITEMVALUE
     * @param itemvalue 映射数据库字段: f_field_item.ITEMVALUE
     * @author MyBatis Generator
     */
    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue == null ? null : itemvalue.trim();
    }

    /**
     * 获取选项名称: f_field_item.ITEMNAME
     * @return 选项名称: f_field_item.ITEMNAME
     * @author MyBatis Generator
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * 设置选项名称: f_field_item.ITEMNAME
     * @param itemname 映射数据库字段: f_field_item.ITEMNAME
     * @author MyBatis Generator
     */
    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    /**
     * 获取表单属性ID: f_field_item.FIELDID
     * @return 表单属性ID: f_field_item.FIELDID
     * @author MyBatis Generator
     */
    public Long getFieldid() {
        return fieldid;
    }

    /**
     * 设置表单属性ID: f_field_item.FIELDID
     * @param fieldid 映射数据库字段: f_field_item.FIELDID
     * @author MyBatis Generator
     */
    public void setFieldid(Long fieldid) {
        this.fieldid = fieldid;
    }

    /**
     * 获取状态.N正常,F冻结,D注销: f_field_item.STATUS
     * @return 状态.N正常,F冻结,D注销: f_field_item.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态.N正常,F冻结,D注销: f_field_item.STATUS
     * @param status 映射数据库字段: f_field_item.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取排序: f_field_item.SORT
     * @return 排序: f_field_item.SORT
     * @author MyBatis Generator
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置排序: f_field_item.SORT
     * @param sort 映射数据库字段: f_field_item.SORT
     * @author MyBatis Generator
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }
}