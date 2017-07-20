package org.hanzhdy.manager.upc.mapper;

import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.vo.MenuVo;
import org.hanzhdy.manager.upc.vo.Resource;
import org.hanzhdy.web.bean.ZTreeNode;

import java.util.List;
import java.util.Map;

public interface MenuMapperExt extends MenuMapper {
    int countAsList(Map<String, Object> params);
    
    List<MenuVo> selectAsList(Map<String, Object> params);
    
    List<ZTreeNode> selectAsZTreeNodeByRoleAndSystemid(@Param("roleid") Long roleid, @Param("systemid") Long systemid);
    
    List<Resource> selectByUserAndSystemid(@Param("userid") Long userid, @Param("systemid") Long systemid);
}