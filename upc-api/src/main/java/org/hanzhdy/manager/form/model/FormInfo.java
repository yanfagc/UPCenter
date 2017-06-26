package org.hanzhdy.manager.form.model;

import java.io.Serializable;
import java.util.Date;
import org.hanzhdy.manager.support.enums.CommonStatus;

public class FormInfo implements Serializable {
    public static final long serialVersionUID = -1042515744L;

    /**
     * ID号: f_form_info.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 表单编码: f_form_info.FORMCODE
     * @author MyBatis Generator
     */
    private String formcode;

    /**
     * 表单名称: f_form_info.FORMNAME
     * @author MyBatis Generator
     */
    private String formname;

    /**
     * 每行显示多少个字段列: f_form_info.COLCOUNTS
     * @author MyBatis Generator
     */
    private Integer colcounts;

    /**
     * 状态.N正常,F冻结: f_form_info.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 备注: f_form_info.REMARK
     * @author MyBatis Generator
     */
    private String remark;

    /**
     * 创建时间: f_form_info.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 更新时间: f_form_info.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: f_form_info.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: f_form_info.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取ID号: f_form_info.ID
     * @return ID号: f_form_info.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: f_form_info.ID
     * @param id 映射数据库字段: f_form_info.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取表单编码: f_form_info.FORMCODE
     * @return 表单编码: f_form_info.FORMCODE
     * @author MyBatis Generator
     */
    public String getFormcode() {
        return formcode;
    }

    /**
     * 设置表单编码: f_form_info.FORMCODE
     * @param formcode 映射数据库字段: f_form_info.FORMCODE
     * @author MyBatis Generator
     */
    public void setFormcode(String formcode) {
        this.formcode = formcode == null ? null : formcode.trim();
    }

    /**
     * 获取表单名称: f_form_info.FORMNAME
     * @return 表单名称: f_form_info.FORMNAME
     * @author MyBatis Generator
     */
    public String getFormname() {
        return formname;
    }

    /**
     * 设置表单名称: f_form_info.FORMNAME
     * @param formname 映射数据库字段: f_form_info.FORMNAME
     * @author MyBatis Generator
     */
    public void setFormname(String formname) {
        this.formname = formname == null ? null : formname.trim();
    }

    /**
     * 获取每行显示多少个字段列: f_form_info.COLCOUNTS
     * @return 每行显示多少个字段列: f_form_info.COLCOUNTS
     * @author MyBatis Generator
     */
    public Integer getColcounts() {
        return colcounts;
    }

    /**
     * 设置每行显示多少个字段列: f_form_info.COLCOUNTS
     * @param colcounts 映射数据库字段: f_form_info.COLCOUNTS
     * @author MyBatis Generator
     */
    public void setColcounts(Integer colcounts) {
        this.colcounts = colcounts;
    }

    /**
     * 获取状态.N正常,F冻结: f_form_info.STATUS
     * @return 状态.N正常,F冻结: f_form_info.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态.N正常,F冻结: f_form_info.STATUS
     * @param status 映射数据库字段: f_form_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取备注: f_form_info.REMARK
     * @return 备注: f_form_info.REMARK
     * @author MyBatis Generator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注: f_form_info.REMARK
     * @param remark 映射数据库字段: f_form_info.REMARK
     * @author MyBatis Generator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建时间: f_form_info.CREATETIME
     * @return 创建时间: f_form_info.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: f_form_info.CREATETIME
     * @param createtime 映射数据库字段: f_form_info.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间: f_form_info.UPDATETIME
     * @return 更新时间: f_form_info.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: f_form_info.UPDATETIME
     * @param updatetime 映射数据库字段: f_form_info.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: f_form_info.CREATOR
     * @return 创建人: f_form_info.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: f_form_info.CREATOR
     * @param creator 映射数据库字段: f_form_info.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: f_form_info.UPDATER
     * @return 更新人: f_form_info.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: f_form_info.UPDATER
     * @param updater 映射数据库字段: f_form_info.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}