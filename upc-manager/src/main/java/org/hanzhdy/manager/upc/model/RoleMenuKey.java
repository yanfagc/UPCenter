package org.hanzhdy.manager.upc.model;

public class RoleMenuKey {
    /**
     * 角色ID: r_role_menu.ROLEID
     * @author MyBatis Generator
     */
    private Long roleId;

    /**
     * 菜单ID: r_role_menu.MENUID
     * @author MyBatis Generator
     */
    private Long menuId;

    /**
     * 获取角色ID: r_role_menu.ROLEID
     * @return 角色ID: r_role_menu.ROLEID
     * @author MyBatis Generator
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID: r_role_menu.ROLEID
     * @param roleId 映射数据库字段: r_role_menu.ROLEID
     * @author MyBatis Generator
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单ID: r_role_menu.MENUID
     * @return 菜单ID: r_role_menu.MENUID
     * @author MyBatis Generator
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID: r_role_menu.MENUID
     * @param menuId 映射数据库字段: r_role_menu.MENUID
     * @author MyBatis Generator
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}