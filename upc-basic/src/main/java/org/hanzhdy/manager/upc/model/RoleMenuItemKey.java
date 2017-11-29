package org.hanzhdy.manager.upc.model;

public class RoleMenuItemKey {
    /**
     * 角色ID: r_role_menuitem.ROLEID
     * @author MyBatis Generator
     */
    private Long roleId;

    /**
     * 菜单项ID: r_role_menuitem.ITEMID
     * @author MyBatis Generator
     */
    private Long itemId;

    /**
     * 获取角色ID: r_role_menuitem.ROLEID
     * @return 角色ID: r_role_menuitem.ROLEID
     * @author MyBatis Generator
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID: r_role_menuitem.ROLEID
     * @param roleId 映射数据库字段: r_role_menuitem.ROLEID
     * @author MyBatis Generator
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单项ID: r_role_menuitem.ITEMID
     * @return 菜单项ID: r_role_menuitem.ITEMID
     * @author MyBatis Generator
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置菜单项ID: r_role_menuitem.ITEMID
     * @param itemId 映射数据库字段: r_role_menuitem.ITEMID
     * @author MyBatis Generator
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}