package com.postbox.mapper;

import com.postbox.model.RepairerInfo;

import java.util.List;
import java.util.Map;

public interface RepairerInfoMapperExt extends RepairerInfoMapper {
    /**
     * 根据条件，查询维修员信息，用于ajax查找
     * @param params
     * @return
     */
    List<RepairerInfo> selectForAjaxSearch(Map<String, Object> params);
}