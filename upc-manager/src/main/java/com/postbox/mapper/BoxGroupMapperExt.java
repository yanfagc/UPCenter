package com.postbox.mapper;

import com.postbox.model.BoxGroup;
import com.postbox.vo.BoxGroupVo;

import java.util.List;
import java.util.Map;

public interface BoxGroupMapperExt extends BoxGroupMapper {
    /**
     * 查询符合条件的箱子组数据总数
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);
    
    /**
     * 根据条件查询箱子组数据
     * @param params
     * @return
     */
    List<BoxGroupVo> selectAsList(Map<String, Object> params);
    
    /**
     * 根据boxGroupId查找箱子组信息
     * @param boxGroupId
     * @return
     */
    BoxGroupVo selectByGroupId(Long boxGroupId);
    
    /**
     * 根据条件，查询箱子组信息，用于ajax查找
     * @param params
     * @return
     */
    List<BoxGroup> selectForAjaxSearch(Map<String, Object> params);
}