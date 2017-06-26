package org.hanzhdy.manager.upc.mapper;

public interface RoleMenuMapperExt extends RoleMenuMapper {
    /**
     * 根据菜单ID，删除与其关联的权限信息
     * @param menuid
     * @return
     */
    public int deleteByMenuid(Long menuid);
}