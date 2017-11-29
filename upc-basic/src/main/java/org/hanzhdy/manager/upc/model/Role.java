package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;
import org.hanzhdy.manager.support.enums.CommonStatus;

public class Role implements Serializable {
    public static final long serialVersionUID = 510088331079105474L;

    /**
     * ID号: r_role.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 角色编码: r_role.ROLECODE
     * @author MyBatis Generator
     */
    private String rolecode;

    /**
     * 角色名称: r_role.ROLENAME
     * @author MyBatis Generator
     */
    private String rolename;

    /**
     * 角色类型: r_role.GROUPID
     * @author MyBatis Generator
     */
    private Long groupid;

    /**
     * 状态.N正常,F冻结,D注销: r_role.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 描述: r_role.REMARK
     * @author MyBatis Generator
     */
    private String remark;

    /**
     * 接入系统: r_role.SYSTEMID
     * @author MyBatis Generator
     */
    private Long systemId;

    /**
     * 创建时间: r_role.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 更新时间: r_role.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: r_role.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: r_role.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取ID号: r_role.ID
     * @return ID号: r_role.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: r_role.ID
     * @param id 映射数据库字段: r_role.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色编码: r_role.ROLECODE
     * @return 角色编码: r_role.ROLECODE
     * @author MyBatis Generator
     */
    public String getRolecode() {
        return rolecode;
    }

    /**
     * 设置角色编码: r_role.ROLECODE
     * @param rolecode 映射数据库字段: r_role.ROLECODE
     * @author MyBatis Generator
     */
    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    /**
     * 获取角色名称: r_role.ROLENAME
     * @return 角色名称: r_role.ROLENAME
     * @author MyBatis Generator
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 设置角色名称: r_role.ROLENAME
     * @param rolename 映射数据库字段: r_role.ROLENAME
     * @author MyBatis Generator
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * 获取角色类型: r_role.GROUPID
     * @return 角色类型: r_role.GROUPID
     * @author MyBatis Generator
     */
    public Long getGroupid() {
        return groupid;
    }

    /**
     * 设置角色类型: r_role.GROUPID
     * @param groupid 映射数据库字段: r_role.GROUPID
     * @author MyBatis Generator
     */
    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    /**
     * 获取状态.N正常,F冻结,D注销: r_role.STATUS
     * @return 状态.N正常,F冻结,D注销: r_role.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态.N正常,F冻结,D注销: r_role.STATUS
     * @param status 映射数据库字段: r_role.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取描述: r_role.REMARK
     * @return 描述: r_role.REMARK
     * @author MyBatis Generator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述: r_role.REMARK
     * @param remark 映射数据库字段: r_role.REMARK
     * @author MyBatis Generator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取接入系统: r_role.SYSTEMID
     * @return 接入系统: r_role.SYSTEMID
     * @author MyBatis Generator
     */
    public Long getSystemId() {
        return systemId;
    }

    /**
     * 设置接入系统: r_role.SYSTEMID
     * @param systemId 映射数据库字段: r_role.SYSTEMID
     * @author MyBatis Generator
     */
    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    /**
     * 获取创建时间: r_role.CREATETIME
     * @return 创建时间: r_role.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: r_role.CREATETIME
     * @param createtime 映射数据库字段: r_role.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间: r_role.UPDATETIME
     * @return 更新时间: r_role.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: r_role.UPDATETIME
     * @param updatetime 映射数据库字段: r_role.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: r_role.CREATOR
     * @return 创建人: r_role.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: r_role.CREATOR
     * @param creator 映射数据库字段: r_role.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: r_role.UPDATER
     * @return 更新人: r_role.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: r_role.UPDATER
     * @param updater 映射数据库字段: r_role.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}