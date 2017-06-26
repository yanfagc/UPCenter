package org.hanzhdy.manager.upc.mapper;

public interface RoleMenuItemMapperExt extends RoleMenuItemMapper {
    /**
     * 根据菜单项ID，删除与之关联的权限信息
     * @param itemid
     * @return
     */
    public int deleteByItemid(Long itemid);
}