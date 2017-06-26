package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import java.util.Map;

import org.hanzhdy.manager.upc.model.DictType;

public interface DictTypeMapperExt extends DictTypeMapper {
    /**
     * 按条件查询字典类型数量
     * @param params
     * @return
     */
    public int countAsList(Map<String, Object> params);
    
    /**
     * 按条件查询字典类型信息
     * @param params
     * @return
     */
    public List<DictType> selectAsList(Map<String, Object> params);
}