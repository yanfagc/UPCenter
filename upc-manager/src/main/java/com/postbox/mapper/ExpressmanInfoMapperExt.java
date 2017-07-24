package com.postbox.mapper;

import com.postbox.vo.ExpressmanInfoVo;

import java.util.List;
import java.util.Map;

public interface ExpressmanInfoMapperExt extends ExpressmanInfoMapper {
    /**
     * 按条件查询快递员总数
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);
    
    /**
     * 按条件查询快递员信息，并返回符合条件的列表数据（支持分页参数）
     * @param params
     * @return
     */
    List<ExpressmanInfoVo> selectAsList(Map<String, Object> params);
}