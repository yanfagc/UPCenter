package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;
import org.hanzhdy.manager.support.enums.CommonStatus;

public class DictType implements Serializable {
    public static final long serialVersionUID = -1194526372L;

    /**
     * ID号: s_dicttype.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 类型编码: s_dicttype.TYPECODE
     * @author MyBatis Generator
     */
    private String typecode;

    /**
     * 类型名称: s_dicttype.TYPENAME
     * @author MyBatis Generator
     */
    private String typename;

    /**
     * 字典值类型,N:无数据;B:布尔数据;T:文本数据;I:整型数据;F浮点型数据: s_dicttype.VALUETYPE
     * @author MyBatis Generator
     */
    private String valuetype;

    /**
     * 状态: s_dicttype.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 类型描述: s_dicttype.REMARK
     * @author MyBatis Generator
     */
    private String remark;

    /**
     * 创建时间: s_dicttype.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 更新时间: s_dicttype.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: s_dicttype.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: s_dicttype.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取ID号: s_dicttype.ID
     * @return ID号: s_dicttype.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: s_dicttype.ID
     * @param id 映射数据库字段: s_dicttype.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取类型编码: s_dicttype.TYPECODE
     * @return 类型编码: s_dicttype.TYPECODE
     * @author MyBatis Generator
     */
    public String getTypecode() {
        return typecode;
    }

    /**
     * 设置类型编码: s_dicttype.TYPECODE
     * @param typecode 映射数据库字段: s_dicttype.TYPECODE
     * @author MyBatis Generator
     */
    public void setTypecode(String typecode) {
        this.typecode = typecode == null ? null : typecode.trim();
    }

    /**
     * 获取类型名称: s_dicttype.TYPENAME
     * @return 类型名称: s_dicttype.TYPENAME
     * @author MyBatis Generator
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置类型名称: s_dicttype.TYPENAME
     * @param typename 映射数据库字段: s_dicttype.TYPENAME
     * @author MyBatis Generator
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     * 获取字典值类型,N:无数据;B:布尔数据;T:文本数据;I:整型数据;F浮点型数据: s_dicttype.VALUETYPE
     * @return 字典值类型,N:无数据;B:布尔数据;T:文本数据;I:整型数据;F浮点型数据: s_dicttype.VALUETYPE
     * @author MyBatis Generator
     */
    public String getValuetype() {
        return valuetype;
    }

    /**
     * 设置字典值类型,N:无数据;B:布尔数据;T:文本数据;I:整型数据;F浮点型数据: s_dicttype.VALUETYPE
     * @param valuetype 映射数据库字段: s_dicttype.VALUETYPE
     * @author MyBatis Generator
     */
    public void setValuetype(String valuetype) {
        this.valuetype = valuetype == null ? null : valuetype.trim();
    }

    /**
     * 获取状态: s_dicttype.STATUS
     * @return 状态: s_dicttype.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态: s_dicttype.STATUS
     * @param status 映射数据库字段: s_dicttype.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取类型描述: s_dicttype.REMARK
     * @return 类型描述: s_dicttype.REMARK
     * @author MyBatis Generator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置类型描述: s_dicttype.REMARK
     * @param remark 映射数据库字段: s_dicttype.REMARK
     * @author MyBatis Generator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建时间: s_dicttype.CREATETIME
     * @return 创建时间: s_dicttype.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: s_dicttype.CREATETIME
     * @param createtime 映射数据库字段: s_dicttype.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间: s_dicttype.UPDATETIME
     * @return 更新时间: s_dicttype.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: s_dicttype.UPDATETIME
     * @param updatetime 映射数据库字段: s_dicttype.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: s_dicttype.CREATOR
     * @return 创建人: s_dicttype.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: s_dicttype.CREATOR
     * @param creator 映射数据库字段: s_dicttype.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: s_dicttype.UPDATER
     * @return 更新人: s_dicttype.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: s_dicttype.UPDATER
     * @param updater 映射数据库字段: s_dicttype.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}