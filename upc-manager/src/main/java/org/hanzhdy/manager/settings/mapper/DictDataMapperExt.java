package org.hanzhdy.manager.settings.mapper;

import org.hanzhdy.manager.settings.model.DictData;

import java.util.List;
import java.util.Map;

public interface DictDataMapperExt extends DictDataMapper {
    /**
     * 查询符合条件的字典表数据总数
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);
    
    /**
     * 查询符合条件的字典表数据（支持分页查询）
     * @param params
     * @return
     */
    List<DictData> selectAsList(Map<String, Object> params);
    
    /**
     * 根据字典类型typecode值查询其包含的数据字典数据
     * @param typecode
     * @return
     */
    List<DictData> selectByTypecode(String typecode);
}