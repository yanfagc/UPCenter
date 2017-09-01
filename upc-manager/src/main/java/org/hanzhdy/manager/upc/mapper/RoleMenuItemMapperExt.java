package org.hanzhdy.manager.upc.mapper;

import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.vo.Resource;

import java.util.List;

public interface RoleMenuItemMapperExt extends RoleMenuItemMapper {
    /**
     * 根据菜单项ID，删除与之关联的权限信息
     * @param itemid
     * @return
     */
    int deleteByItemid(Long itemid);

    /**
     * 根据角色ID和菜单ID，删除该角色关联的菜单项数据，并且这些菜单项数据隶属于输入的菜单ID
     * @param roleid
     * @param menuid
     * @return
     */
    int deleteByRoleAndMenuid(@Param("roleid") Long roleid, @Param("menuid") Long menuid);

    /**
     * 角色权限设置页面，根据角色和菜单ID，查询资源信息
     * @param roleid
     * @param menuid
     * @return
     */
    List<Resource> selectForSettingRoleResource(@Param("roleid") Long roleid, @Param("menuid") Long menuid);
}