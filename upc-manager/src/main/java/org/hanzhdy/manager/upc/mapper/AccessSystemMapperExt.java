package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import java.util.Map;

import org.hanzhdy.manager.upc.model.AccessSystem;

public interface AccessSystemMapperExt extends AccessSystemMapper {
    /**
     * 按条件查询接入系统数量
     * @param search
     * @return
     */
    public int countAsList(Map<String, Object> search);
    
    /**
     * 按条件查询接入系统信息
     * @param search
     * @return
     */
    public List<AccessSystem> selectAsList(Map<String, Object> search);
}