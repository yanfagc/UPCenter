package org.hanzhdy.manager.upc.mapper;

import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.MenuItem;
import org.hanzhdy.manager.upc.vo.MenuVo;

import java.util.List;
import java.util.Map;

public interface MenuItemMapperExt extends MenuItemMapper {
    int countAsList(Map<String, Object> params);
    
    List<MenuVo> selectAsList(Map<String, Object> params);
    
    List<MenuItem> selectByUserAndSysId(@Param("userid") Long userid, @Param("systemid") Long systemid);
}