package com.postbox.mapper;

import com.postbox.vo.RepairRecordVo;

import java.util.List;
import java.util.Map;

public interface RepairRecordMapperExt extends RepairRecordMapper {
    int countAsList(Map<String, Object> params);
    
    List<RepairRecordVo> selectAsList (Map<String, Object> params);
}