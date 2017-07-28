package org.hanzhdy.manager.settings.mapper;

import org.hanzhdy.manager.settings.model.Area;

import java.util.List;

public interface AreaMapperExt extends AreaMapper {
    /**
     * 根据上级区域名称查询子区域列表，不包括再次级区域
     * @param parentName
     * @return
     */
    List<Area> selectByParentName(String parentName);
}