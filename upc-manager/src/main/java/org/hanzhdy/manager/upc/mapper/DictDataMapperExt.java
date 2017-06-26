package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import java.util.Map;

import org.hanzhdy.manager.upc.model.DictData;

public interface DictDataMapperExt extends DictDataMapper {
    /**
     * 按条件查询数据字典数量
     * @param params
     * @return
     */
    public int countAsList(Map<String, Object> params);
    
    /**
     * 按条件查询数据字典信息
     * @param params
     * @return
     */
    public List<DictData> selectAsList(Map<String, Object> params);
    
    /**
     * 根据数据字典类型编码查询数据字典数据
     * @param typecode
     * @return
     */
    public List<DictData> selectByTypecode(String typecode);
}