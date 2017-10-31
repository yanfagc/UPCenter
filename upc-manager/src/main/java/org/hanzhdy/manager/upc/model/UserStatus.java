package org.hanzhdy.manager.upc.model;

import java.io.Serializable;
import java.util.Date;
import org.hanzhdy.manager.support.enums.LoginUserStatus;

public class UserStatus implements Serializable {
    public static final long serialVersionUID = 552924649L;

    /**
     * 用户ID: u_user_status.USERID
     * @author MyBatis Generator
     */
    private Long userId;

    /**
     * 状态.N正常,L锁定,F冻结,D已注销: u_user_status.STATUS
     * @author MyBatis Generator
     */
    private LoginUserStatus status;

    /**
     * 登录错误次数: u_user_status.ERRCOUNT
     * @author MyBatis Generator
     */
    private Integer errcount;

    /**
     * 创建时间: u_user_status.CREATETIME
     * @author MyBatis Generator
     */
    private Date createtime;

    /**
     * 冻结时间: u_user_status.FROZENTIME
     * @author MyBatis Generator
     */
    private Date frozentime;

    /**
     * 锁定时间: u_user_status.LOCKEDTIME
     * @author MyBatis Generator
     */
    private Date lockedtime;

    /**
     * 注销时间: u_user_status.DEMISETIME
     * @author MyBatis Generator
     */
    private Date demisetime;

    /**
     * 更新时间: u_user_status.UPDATETIME
     * @author MyBatis Generator
     */
    private Date updatetime;

    /**
     * 创建人: u_user_status.CREATOR
     * @author MyBatis Generator
     */
    private Long creator;

    /**
     * 更新人: u_user_status.UPDATER
     * @author MyBatis Generator
     */
    private Long updater;

    /**
     * 获取用户ID: u_user_status.USERID
     * @return 用户ID: u_user_status.USERID
     * @author MyBatis Generator
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID: u_user_status.USERID
     * @param userId 映射数据库字段: u_user_status.USERID
     * @author MyBatis Generator
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取状态.N正常,L锁定,F冻结,D已注销: u_user_status.STATUS
     * @return 状态.N正常,L锁定,F冻结,D已注销: u_user_status.STATUS
     * @author MyBatis Generator
     */
    public LoginUserStatus getStatus() {
        return status;
    }

    /**
     * 设置状态.N正常,L锁定,F冻结,D已注销: u_user_status.STATUS
     * @param status 映射数据库字段: u_user_status.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(LoginUserStatus status) {
        this.status = status;
    }

    /**
     * 获取登录错误次数: u_user_status.ERRCOUNT
     * @return 登录错误次数: u_user_status.ERRCOUNT
     * @author MyBatis Generator
     */
    public Integer getErrcount() {
        return errcount;
    }

    /**
     * 设置登录错误次数: u_user_status.ERRCOUNT
     * @param errcount 映射数据库字段: u_user_status.ERRCOUNT
     * @author MyBatis Generator
     */
    public void setErrcount(Integer errcount) {
        this.errcount = errcount;
    }

    /**
     * 获取创建时间: u_user_status.CREATETIME
     * @return 创建时间: u_user_status.CREATETIME
     * @author MyBatis Generator
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间: u_user_status.CREATETIME
     * @param createtime 映射数据库字段: u_user_status.CREATETIME
     * @author MyBatis Generator
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取冻结时间: u_user_status.FROZENTIME
     * @return 冻结时间: u_user_status.FROZENTIME
     * @author MyBatis Generator
     */
    public Date getFrozentime() {
        return frozentime;
    }

    /**
     * 设置冻结时间: u_user_status.FROZENTIME
     * @param frozentime 映射数据库字段: u_user_status.FROZENTIME
     * @author MyBatis Generator
     */
    public void setFrozentime(Date frozentime) {
        this.frozentime = frozentime;
    }

    /**
     * 获取锁定时间: u_user_status.LOCKEDTIME
     * @return 锁定时间: u_user_status.LOCKEDTIME
     * @author MyBatis Generator
     */
    public Date getLockedtime() {
        return lockedtime;
    }

    /**
     * 设置锁定时间: u_user_status.LOCKEDTIME
     * @param lockedtime 映射数据库字段: u_user_status.LOCKEDTIME
     * @author MyBatis Generator
     */
    public void setLockedtime(Date lockedtime) {
        this.lockedtime = lockedtime;
    }

    /**
     * 获取注销时间: u_user_status.DEMISETIME
     * @return 注销时间: u_user_status.DEMISETIME
     * @author MyBatis Generator
     */
    public Date getDemisetime() {
        return demisetime;
    }

    /**
     * 设置注销时间: u_user_status.DEMISETIME
     * @param demisetime 映射数据库字段: u_user_status.DEMISETIME
     * @author MyBatis Generator
     */
    public void setDemisetime(Date demisetime) {
        this.demisetime = demisetime;
    }

    /**
     * 获取更新时间: u_user_status.UPDATETIME
     * @return 更新时间: u_user_status.UPDATETIME
     * @author MyBatis Generator
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间: u_user_status.UPDATETIME
     * @param updatetime 映射数据库字段: u_user_status.UPDATETIME
     * @author MyBatis Generator
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取创建人: u_user_status.CREATOR
     * @return 创建人: u_user_status.CREATOR
     * @author MyBatis Generator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人: u_user_status.CREATOR
     * @param creator 映射数据库字段: u_user_status.CREATOR
     * @author MyBatis Generator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取更新人: u_user_status.UPDATER
     * @return 更新人: u_user_status.UPDATER
     * @author MyBatis Generator
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * 设置更新人: u_user_status.UPDATER
     * @param updater 映射数据库字段: u_user_status.UPDATER
     * @author MyBatis Generator
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}