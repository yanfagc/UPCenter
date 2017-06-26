package org.hanzhdy.manager.form.model;

import java.io.Serializable;
import org.hanzhdy.manager.engine.constants.FieldType;
import org.hanzhdy.manager.support.enums.CommonStatus;
import org.hanzhdy.manager.support.enums.YesOrNo;

public class FieldInfo implements Serializable {
    public static final long serialVersionUID = 1517388090L;

    /**
     * ID号: f_field_info.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 字段编码: f_field_info.FIELDCODE
     * @author MyBatis Generator
     */
    private String fieldcode;

    /**
     * 字段名称: f_field_info.FIELDNAME
     * @author MyBatis Generator
     */
    private String fieldname;

    /**
     * 字段类型.input,checkbox,radio,select: f_field_info.FIELDTYPE
     * @author MyBatis Generator
     */
    private FieldType fieldtype;

    /**
     * 宏类型,即字段子类型,如文本框中可以分为普通文本,邮箱地址,数字型等: f_field_info.MACROTYPE
     * @author MyBatis Generator
     */
    private String macrotype;

    /**
     * 所占列数,部分表单字段可能占多个位置: f_field_info.COLSPAN
     * @author MyBatis Generator
     */
    private Integer colspan;

    /**
     * 状态.N正常(可正常使用),F冻结(不可新添加该字段,已添加字段不影响),D注销(所有表单不可用): f_field_info.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 是否必填: f_field_info.REQUIRED
     * @author MyBatis Generator
     */
    private YesOrNo required;

    /**
     * 长度类型: f_field_info.LENGTHTYPE
     * @author MyBatis Generator
     */
    private String lengthtype;

    /**
     * 最大长度: f_field_info.MAXLENGTH
     * @author MyBatis Generator
     */
    private Integer maxlength;

    /**
     * 最小长度: f_field_info.MINLENGTH
     * @author MyBatis Generator
     */
    private Integer minlength;

    /**
     * 最大值: f_field_info.MAXVAL
     * @author MyBatis Generator
     */
    private String maxval;

    /**
     * 最小值: f_field_info.MINVAL
     * @author MyBatis Generator
     */
    private String minval;

    /**
     * 最大值对比字段: f_field_info.MAXLIMIT
     * @author MyBatis Generator
     */
    private Long maxlimit;

    /**
     * 最小值对比字段: f_field_info.MINLIMIT
     * @author MyBatis Generator
     */
    private Long minlimit;

    /**
     * 默认值: f_field_info.DEFAULTVALUE
     * @author MyBatis Generator
     */
    private String defaultvalue;

    /**
     * 字段联动: f_field_info.LINKAGE
     * @author MyBatis Generator
     */
    private String linkage;

    /**
     * 正则表达式: f_field_info.REGULAR
     * @author MyBatis Generator
     */
    private String regular;

    /**
     * 获取ID号: f_field_info.ID
     * @return ID号: f_field_info.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: f_field_info.ID
     * @param id 映射数据库字段: f_field_info.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字段编码: f_field_info.FIELDCODE
     * @return 字段编码: f_field_info.FIELDCODE
     * @author MyBatis Generator
     */
    public String getFieldcode() {
        return fieldcode;
    }

    /**
     * 设置字段编码: f_field_info.FIELDCODE
     * @param fieldcode 映射数据库字段: f_field_info.FIELDCODE
     * @author MyBatis Generator
     */
    public void setFieldcode(String fieldcode) {
        this.fieldcode = fieldcode == null ? null : fieldcode.trim();
    }

    /**
     * 获取字段名称: f_field_info.FIELDNAME
     * @return 字段名称: f_field_info.FIELDNAME
     * @author MyBatis Generator
     */
    public String getFieldname() {
        return fieldname;
    }

    /**
     * 设置字段名称: f_field_info.FIELDNAME
     * @param fieldname 映射数据库字段: f_field_info.FIELDNAME
     * @author MyBatis Generator
     */
    public void setFieldname(String fieldname) {
        this.fieldname = fieldname == null ? null : fieldname.trim();
    }

    /**
     * 获取字段类型.input,checkbox,radio,select: f_field_info.FIELDTYPE
     * @return 字段类型.input,checkbox,radio,select: f_field_info.FIELDTYPE
     * @author MyBatis Generator
     */
    public FieldType getFieldtype() {
        return fieldtype;
    }

    /**
     * 设置字段类型.input,checkbox,radio,select: f_field_info.FIELDTYPE
     * @param fieldtype 映射数据库字段: f_field_info.FIELDTYPE
     * @author MyBatis Generator
     */
    public void setFieldtype(FieldType fieldtype) {
        this.fieldtype = fieldtype;
    }

    /**
     * 获取宏类型,即字段子类型,如文本框中可以分为普通文本,邮箱地址,数字型等: f_field_info.MACROTYPE
     * @return 宏类型,即字段子类型,如文本框中可以分为普通文本,邮箱地址,数字型等: f_field_info.MACROTYPE
     * @author MyBatis Generator
     */
    public String getMacrotype() {
        return macrotype;
    }

    /**
     * 设置宏类型,即字段子类型,如文本框中可以分为普通文本,邮箱地址,数字型等: f_field_info.MACROTYPE
     * @param macrotype 映射数据库字段: f_field_info.MACROTYPE
     * @author MyBatis Generator
     */
    public void setMacrotype(String macrotype) {
        this.macrotype = macrotype == null ? null : macrotype.trim();
    }

    /**
     * 获取所占列数,部分表单字段可能占多个位置: f_field_info.COLSPAN
     * @return 所占列数,部分表单字段可能占多个位置: f_field_info.COLSPAN
     * @author MyBatis Generator
     */
    public Integer getColspan() {
        return colspan;
    }

    /**
     * 设置所占列数,部分表单字段可能占多个位置: f_field_info.COLSPAN
     * @param colspan 映射数据库字段: f_field_info.COLSPAN
     * @author MyBatis Generator
     */
    public void setColspan(Integer colspan) {
        this.colspan = colspan;
    }

    /**
     * 获取状态.N正常(可正常使用),F冻结(不可新添加该字段,已添加字段不影响),D注销(所有表单不可用): f_field_info.STATUS
     * @return 状态.N正常(可正常使用),F冻结(不可新添加该字段,已添加字段不影响),D注销(所有表单不可用): f_field_info.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态.N正常(可正常使用),F冻结(不可新添加该字段,已添加字段不影响),D注销(所有表单不可用): f_field_info.STATUS
     * @param status 映射数据库字段: f_field_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取是否必填: f_field_info.REQUIRED
     * @return 是否必填: f_field_info.REQUIRED
     * @author MyBatis Generator
     */
    public YesOrNo getRequired() {
        return required;
    }

    /**
     * 设置是否必填: f_field_info.REQUIRED
     * @param required 映射数据库字段: f_field_info.REQUIRED
     * @author MyBatis Generator
     */
    public void setRequired(YesOrNo required) {
        this.required = required;
    }

    /**
     * 获取长度类型: f_field_info.LENGTHTYPE
     * @return 长度类型: f_field_info.LENGTHTYPE
     * @author MyBatis Generator
     */
    public String getLengthtype() {
        return lengthtype;
    }

    /**
     * 设置长度类型: f_field_info.LENGTHTYPE
     * @param lengthtype 映射数据库字段: f_field_info.LENGTHTYPE
     * @author MyBatis Generator
     */
    public void setLengthtype(String lengthtype) {
        this.lengthtype = lengthtype == null ? null : lengthtype.trim();
    }

    /**
     * 获取最大长度: f_field_info.MAXLENGTH
     * @return 最大长度: f_field_info.MAXLENGTH
     * @author MyBatis Generator
     */
    public Integer getMaxlength() {
        return maxlength;
    }

    /**
     * 设置最大长度: f_field_info.MAXLENGTH
     * @param maxlength 映射数据库字段: f_field_info.MAXLENGTH
     * @author MyBatis Generator
     */
    public void setMaxlength(Integer maxlength) {
        this.maxlength = maxlength;
    }

    /**
     * 获取最小长度: f_field_info.MINLENGTH
     * @return 最小长度: f_field_info.MINLENGTH
     * @author MyBatis Generator
     */
    public Integer getMinlength() {
        return minlength;
    }

    /**
     * 设置最小长度: f_field_info.MINLENGTH
     * @param minlength 映射数据库字段: f_field_info.MINLENGTH
     * @author MyBatis Generator
     */
    public void setMinlength(Integer minlength) {
        this.minlength = minlength;
    }

    /**
     * 获取最大值: f_field_info.MAXVAL
     * @return 最大值: f_field_info.MAXVAL
     * @author MyBatis Generator
     */
    public String getMaxval() {
        return maxval;
    }

    /**
     * 设置最大值: f_field_info.MAXVAL
     * @param maxval 映射数据库字段: f_field_info.MAXVAL
     * @author MyBatis Generator
     */
    public void setMaxval(String maxval) {
        this.maxval = maxval == null ? null : maxval.trim();
    }

    /**
     * 获取最小值: f_field_info.MINVAL
     * @return 最小值: f_field_info.MINVAL
     * @author MyBatis Generator
     */
    public String getMinval() {
        return minval;
    }

    /**
     * 设置最小值: f_field_info.MINVAL
     * @param minval 映射数据库字段: f_field_info.MINVAL
     * @author MyBatis Generator
     */
    public void setMinval(String minval) {
        this.minval = minval == null ? null : minval.trim();
    }

    /**
     * 获取最大值对比字段: f_field_info.MAXLIMIT
     * @return 最大值对比字段: f_field_info.MAXLIMIT
     * @author MyBatis Generator
     */
    public Long getMaxlimit() {
        return maxlimit;
    }

    /**
     * 设置最大值对比字段: f_field_info.MAXLIMIT
     * @param maxlimit 映射数据库字段: f_field_info.MAXLIMIT
     * @author MyBatis Generator
     */
    public void setMaxlimit(Long maxlimit) {
        this.maxlimit = maxlimit;
    }

    /**
     * 获取最小值对比字段: f_field_info.MINLIMIT
     * @return 最小值对比字段: f_field_info.MINLIMIT
     * @author MyBatis Generator
     */
    public Long getMinlimit() {
        return minlimit;
    }

    /**
     * 设置最小值对比字段: f_field_info.MINLIMIT
     * @param minlimit 映射数据库字段: f_field_info.MINLIMIT
     * @author MyBatis Generator
     */
    public void setMinlimit(Long minlimit) {
        this.minlimit = minlimit;
    }

    /**
     * 获取默认值: f_field_info.DEFAULTVALUE
     * @return 默认值: f_field_info.DEFAULTVALUE
     * @author MyBatis Generator
     */
    public String getDefaultvalue() {
        return defaultvalue;
    }

    /**
     * 设置默认值: f_field_info.DEFAULTVALUE
     * @param defaultvalue 映射数据库字段: f_field_info.DEFAULTVALUE
     * @author MyBatis Generator
     */
    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue == null ? null : defaultvalue.trim();
    }

    /**
     * 获取字段联动: f_field_info.LINKAGE
     * @return 字段联动: f_field_info.LINKAGE
     * @author MyBatis Generator
     */
    public String getLinkage() {
        return linkage;
    }

    /**
     * 设置字段联动: f_field_info.LINKAGE
     * @param linkage 映射数据库字段: f_field_info.LINKAGE
     * @author MyBatis Generator
     */
    public void setLinkage(String linkage) {
        this.linkage = linkage == null ? null : linkage.trim();
    }

    /**
     * 获取正则表达式: f_field_info.REGULAR
     * @return 正则表达式: f_field_info.REGULAR
     * @author MyBatis Generator
     */
    public String getRegular() {
        return regular;
    }

    /**
     * 设置正则表达式: f_field_info.REGULAR
     * @param regular 映射数据库字段: f_field_info.REGULAR
     * @author MyBatis Generator
     */
    public void setRegular(String regular) {
        this.regular = regular == null ? null : regular.trim();
    }
}