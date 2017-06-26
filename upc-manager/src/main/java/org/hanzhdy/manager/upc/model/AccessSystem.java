package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;

import org.hanzhdy.manager.support.enums.CommonStatus;

public class AccessSystem implements Serializable {
    public static final long serialVersionUID = 251111423L;

    /**
     * ID号: r_accesssystem.ID
     * @author MyBatis Generator
     */
    private Long id;

    /**
     * 系统编码: r_accesssystem.SYSCODE
     * @author MyBatis Generator
     */
    private String syscode;

    /**
     * 系统名称: r_accesssystem.SYSNAME
     * @author MyBatis Generator
     */
    private String sysname;

    /**
     * 系统访问地址: r_accesssystem.SYSADDR
     * @author MyBatis Generator
     */
    private String sysaddr;

    /**
     * 系统简介: r_accesssystem.REMARK
     * @author MyBatis Generator
     */
    private String remark;

    /**
     * 状态.N正常,F冻结,D无效: r_accesssystem.STATUS
     * @author MyBatis Generator
     */
    private CommonStatus status;

    /**
     * 创建时间: r_accesssystem.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 更新时间: r_accesssystem.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: r_accesssystem.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: r_accesssystem.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取ID号: r_accesssystem.ID
     * @return ID号: r_accesssystem.ID
     * @author MyBatis Generator
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID号: r_accesssystem.ID
     * @param id 映射数据库字段: r_accesssystem.ID
     * @author MyBatis Generator
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取系统编码: r_accesssystem.SYSCODE
     * @return 系统编码: r_accesssystem.SYSCODE
     * @author MyBatis Generator
     */
    public String getSyscode() {
        return syscode;
    }

    /**
     * 设置系统编码: r_accesssystem.SYSCODE
     * @param syscode 映射数据库字段: r_accesssystem.SYSCODE
     * @author MyBatis Generator
     */
    public void setSyscode(String syscode) {
        this.syscode = syscode == null ? null : syscode.trim();
    }

    /**
     * 获取系统名称: r_accesssystem.SYSNAME
     * @return 系统名称: r_accesssystem.SYSNAME
     * @author MyBatis Generator
     */
    public String getSysname() {
        return sysname;
    }

    /**
     * 设置系统名称: r_accesssystem.SYSNAME
     * @param sysname 映射数据库字段: r_accesssystem.SYSNAME
     * @author MyBatis Generator
     */
    public void setSysname(String sysname) {
        this.sysname = sysname == null ? null : sysname.trim();
    }

    /**
     * 获取系统访问地址: r_accesssystem.SYSADDR
     * @return 系统访问地址: r_accesssystem.SYSADDR
     * @author MyBatis Generator
     */
    public String getSysaddr() {
        return sysaddr;
    }

    /**
     * 设置系统访问地址: r_accesssystem.SYSADDR
     * @param sysaddr 映射数据库字段: r_accesssystem.SYSADDR
     * @author MyBatis Generator
     */
    public void setSysaddr(String sysaddr) {
        this.sysaddr = sysaddr == null ? null : sysaddr.trim();
    }

    /**
     * 获取系统简介: r_accesssystem.REMARK
     * @return 系统简介: r_accesssystem.REMARK
     * @author MyBatis Generator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置系统简介: r_accesssystem.REMARK
     * @param remark 映射数据库字段: r_accesssystem.REMARK
     * @author MyBatis Generator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取状态.N正常,F冻结,D无效: r_accesssystem.STATUS
     * @return 状态.N正常,F冻结,D无效: r_accesssystem.STATUS
     * @author MyBatis Generator
     */
    public CommonStatus getStatus() {
        return status;
    }

    /**
     * 设置状态.N正常,F冻结,D无效: r_accesssystem.STATUS
     * @param status 映射数据库字段: r_accesssystem.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    /**
     * 获取创建时间: r_accesssystem.CREATETIME
     * @return 创建时间: r_accesssystem.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: r_accesssystem.CREATETIME
     * @param createtime 映射数据库字段: r_accesssystem.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间: r_accesssystem.UPDATETIME
     * @return 更新时间: r_accesssystem.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: r_accesssystem.UPDATETIME
     * @param updatetime 映射数据库字段: r_accesssystem.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: r_accesssystem.CREATOR
     * @return 创建人: r_accesssystem.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: r_accesssystem.CREATOR
     * @param creator 映射数据库字段: r_accesssystem.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: r_accesssystem.UPDATER
     * @return 更新人: r_accesssystem.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: r_accesssystem.UPDATER
     * @param updater 映射数据库字段: r_accesssystem.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}