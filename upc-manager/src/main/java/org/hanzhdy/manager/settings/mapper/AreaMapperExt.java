package org.hanzhdy.manager.settings.mapper;

import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.vo.AreaVo;

import java.util.List;
import java.util.Map;

public interface AreaMapperExt extends AreaMapper {
    /**
     * 查询符合条件的地区数据总数
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);
    
    /**
     * 查询符合条件的地区数据，返回数据集合
     * @param params
     * @return
     */
    List<AreaVo> selectAsList(Map<String, Object> params);
    
    /**
     * 根据上级区域名称查询子区域列表，不包括再次级区域
     * @param parentName
     * @return
     */
    List<Area> selectByParentName(String parentName);
}