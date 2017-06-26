package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import java.util.Map;

import org.hanzhdy.manager.upc.vo.MenuVo;

public interface MenuItemMapperExt extends MenuItemMapper {
    public int countAsList(Map<String, Object> params);
    
    public List<MenuVo> selectAsList(Map<String, Object> params);
}