package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.vo.MenuVo;
import org.hanzhdy.web.bean.ZTreeNode;

public interface MenuMapperExt extends MenuMapper {
    int countAsList(Map<String, Object> params);
    
    List<MenuVo> selectAsList(Map<String, Object> params);
    
    List<ZTreeNode> selectAsZTreeNodeByRoleAndSystemid(@Param("roleid") Long roleid, @Param("systemid") Long systemid);
}