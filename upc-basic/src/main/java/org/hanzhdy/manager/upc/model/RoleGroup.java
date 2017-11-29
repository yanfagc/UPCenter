package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;

public class RoleGroup implements Serializable {
    public static final long serialVersionUID = 510088327783535581L;

    /**
     * ID号: r_role_group.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 分组编码: r_role_group.GROUPCODE
     * @author MyBatis Generator
     */
    private String groupcode;

    /**
     * 分组名称: r_role_group.GROUPNAME
     * @author MyBatis Generator
     */
    private String groupname;

    /**
     * 类型描述: r_role_group.REMARK
     * @author MyBatis Generator
     */
    private String remark;

    /**
     * 创建时间: r_role_group.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 更新时间: r_role_group.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: r_role_group.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: r_role_group.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取ID号: r_role_group.ID
     * @return ID号: r_role_group.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: r_role_group.ID
     * @param id 映射数据库字段: r_role_group.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分组编码: r_role_group.GROUPCODE
     * @return 分组编码: r_role_group.GROUPCODE
     * @author MyBatis Generator
     */
    public String getGroupcode() {
        return groupcode;
    }

    /**
     * 设置分组编码: r_role_group.GROUPCODE
     * @param groupcode 映射数据库字段: r_role_group.GROUPCODE
     * @author MyBatis Generator
     */
    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    /**
     * 获取分组名称: r_role_group.GROUPNAME
     * @return 分组名称: r_role_group.GROUPNAME
     * @author MyBatis Generator
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * 设置分组名称: r_role_group.GROUPNAME
     * @param groupname 映射数据库字段: r_role_group.GROUPNAME
     * @author MyBatis Generator
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    /**
     * 获取类型描述: r_role_group.REMARK
     * @return 类型描述: r_role_group.REMARK
     * @author MyBatis Generator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置类型描述: r_role_group.REMARK
     * @param remark 映射数据库字段: r_role_group.REMARK
     * @author MyBatis Generator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建时间: r_role_group.CREATETIME
     * @return 创建时间: r_role_group.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: r_role_group.CREATETIME
     * @param createtime 映射数据库字段: r_role_group.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间: r_role_group.UPDATETIME
     * @return 更新时间: r_role_group.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: r_role_group.UPDATETIME
     * @param updatetime 映射数据库字段: r_role_group.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: r_role_group.CREATOR
     * @return 创建人: r_role_group.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: r_role_group.CREATOR
     * @param creator 映射数据库字段: r_role_group.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: r_role_group.UPDATER
     * @return 更新人: r_role_group.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: r_role_group.UPDATER
     * @param updater 映射数据库字段: r_role_group.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}