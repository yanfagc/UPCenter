package com.postbox.mapper;

import com.postbox.vo.BoxInfoVo;

import java.util.List;
import java.util.Map;

public interface BoxInfoMapperExt extends BoxInfoMapper {
    /**
     * 查询符合条件的箱子总数
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);
    
    /**
     * 查询符合条件的箱子信息（支持分页）
     * @param params
     * @return
     */
    List<BoxInfoVo> selectAsList(Map<String, Object> params);
    
    /**
     * 根据ID查找箱子信息
     * @param id
     * @return
     */
    BoxInfoVo selectMoreById(Long id);
}