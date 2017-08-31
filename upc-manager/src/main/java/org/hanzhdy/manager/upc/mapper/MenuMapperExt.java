package org.hanzhdy.manager.upc.mapper;

import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.vo.MenuVo;
import org.hanzhdy.manager.upc.vo.Resource;
import org.hanzhdy.web.bean.ZTreeNode;

import java.util.List;
import java.util.Map;

public interface MenuMapperExt extends MenuMapper {
    /**
     * 菜单管理页面，查询统计符合条件的菜单数量
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);

    /**
     * 菜单管理页面，查询符合条件的菜单数据
     * @param params
     * @return
     */
    List<MenuVo> selectAsList(Map<String, Object> params);

    /**
     * 角色管理页面，设置角色菜单功能，查询所有菜单信息
     * @param roleid
     * @param systemid
     * @return
     */
    List<ZTreeNode> selectAsZTreeNodeByRoleAndSystemid(@Param("roleid") Long roleid, @Param("systemid") Long systemid);

    /**
     * 角色管理页面，设置角色资源功能，查询指定角色关联的所有菜单数据
     * @param roleid
     * @param systemid
     * @return
     */
    List<ZTreeNode> selectAsZTreeNodeByRoleAndSystemidForSettingItem(@Param("roleid") Long roleid, @Param("systemid") Long systemid);

    /**
     * 根据用户ID和登录的系统ID，查询该用户在该系统中所拥有的菜单数据
     * @param userid
     * @param systemid
     * @return
     */
    List<Resource> selectByUserAndSystemid(@Param("userid") Long userid, @Param("systemid") Long systemid);
}