package org.hanzhdy.manager.upc.model;

public class UserRoleKey {
    /**
     * 用户ID: r_user_role.USERID
     * @author MyBatis Generator
     */
    private Long userId;

    /**
     * 角色ID: r_user_role.ROLEID
     * @author MyBatis Generator
     */
    private Long roleId;

    /**
     * 获取用户ID: r_user_role.USERID
     * @return 用户ID: r_user_role.USERID
     * @author MyBatis Generator
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID: r_user_role.USERID
     * @param userId 映射数据库字段: r_user_role.USERID
     * @author MyBatis Generator
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取角色ID: r_user_role.ROLEID
     * @return 角色ID: r_user_role.ROLEID
     * @author MyBatis Generator
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID: r_user_role.ROLEID
     * @param roleId 映射数据库字段: r_user_role.ROLEID
     * @author MyBatis Generator
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}