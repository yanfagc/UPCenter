package org.hanzhdy.manager.settings.mapper;

import org.hanzhdy.manager.settings.model.DictType;

import java.util.List;
import java.util.Map;

public interface DictTypeMapperExt extends DictTypeMapper {
    /**
     * 按条件查询字典类型数量
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);
    
    /**
     * 按条件查询字典类型信息
     * @param params
     * @return
     */
    List<DictType> selectAsList(Map<String, Object> params);
}