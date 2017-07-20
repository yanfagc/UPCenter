package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;
import org.hanzhdy.manager.support.enums.CommonStatus;

public class DictData implements Serializable {
    public static final long serialVersionUID = -1195025972L;

    /**
     * ID号: s_dictdata.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 字典编码: s_dictdata.DATACODE
     * @author MyBatis Generator
     */
    private String datacode;

    /**
     * 字典名称: s_dictdata.DATANAME
     * @author MyBatis Generator
     */
    private String dataname;

    /**
     * 字典类型: s_dictdata.TYPEID
     * @author MyBatis Generator
     */
    private Long typeId;

    /**
     * 排序: s_dictdata.SORT
     * @author MyBatis Generator
     */
    private Short sort;

    /**
     * 状态: s_dictdata.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 字典值: s_dictdata.DATAVALUE
     * @author MyBatis Generator
     */
    private String datavalue;

    /**
     * 创建时间: s_dictdata.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 更新时间: s_dictdata.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: s_dictdata.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: s_dictdata.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取ID号: s_dictdata.ID
     * @return ID号: s_dictdata.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: s_dictdata.ID
     * @param id 映射数据库字段: s_dictdata.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字典编码: s_dictdata.DATACODE
     * @return 字典编码: s_dictdata.DATACODE
     * @author MyBatis Generator
     */
    public String getDatacode() {
        return datacode;
    }

    /**
     * 设置字典编码: s_dictdata.DATACODE
     * @param datacode 映射数据库字段: s_dictdata.DATACODE
     * @author MyBatis Generator
     */
    public void setDatacode(String datacode) {
        this.datacode = datacode == null ? null : datacode.trim();
    }

    /**
     * 获取字典名称: s_dictdata.DATANAME
     * @return 字典名称: s_dictdata.DATANAME
     * @author MyBatis Generator
     */
    public String getDataname() {
        return dataname;
    }

    /**
     * 设置字典名称: s_dictdata.DATANAME
     * @param dataname 映射数据库字段: s_dictdata.DATANAME
     * @author MyBatis Generator
     */
    public void setDataname(String dataname) {
        this.dataname = dataname == null ? null : dataname.trim();
    }

    /**
     * 获取字典类型: s_dictdata.TYPEID
     * @return 字典类型: s_dictdata.TYPEID
     * @author MyBatis Generator
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置字典类型: s_dictdata.TYPEID
     * @param typeId 映射数据库字段: s_dictdata.TYPEID
     * @author MyBatis Generator
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取排序: s_dictdata.SORT
     * @return 排序: s_dictdata.SORT
     * @author MyBatis Generator
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置排序: s_dictdata.SORT
     * @param sort 映射数据库字段: s_dictdata.SORT
     * @author MyBatis Generator
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 获取状态: s_dictdata.STATUS
     * @return 状态: s_dictdata.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态: s_dictdata.STATUS
     * @param status 映射数据库字段: s_dictdata.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取字典值: s_dictdata.DATAVALUE
     * @return 字典值: s_dictdata.DATAVALUE
     * @author MyBatis Generator
     */
    public String getDatavalue() {
        return datavalue;
    }

    /**
     * 设置字典值: s_dictdata.DATAVALUE
     * @param datavalue 映射数据库字段: s_dictdata.DATAVALUE
     * @author MyBatis Generator
     */
    public void setDatavalue(String datavalue) {
        this.datavalue = datavalue == null ? null : datavalue.trim();
    }

    /**
     * 获取创建时间: s_dictdata.CREATETIME
     * @return 创建时间: s_dictdata.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: s_dictdata.CREATETIME
     * @param createtime 映射数据库字段: s_dictdata.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间: s_dictdata.UPDATETIME
     * @return 更新时间: s_dictdata.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: s_dictdata.UPDATETIME
     * @param updatetime 映射数据库字段: s_dictdata.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: s_dictdata.CREATOR
     * @return 创建人: s_dictdata.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: s_dictdata.CREATOR
     * @param creator 映射数据库字段: s_dictdata.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: s_dictdata.UPDATER
     * @return 更新人: s_dictdata.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: s_dictdata.UPDATER
     * @param updater 映射数据库字段: s_dictdata.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}