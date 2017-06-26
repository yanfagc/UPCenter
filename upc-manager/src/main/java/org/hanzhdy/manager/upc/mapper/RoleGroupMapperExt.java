package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import java.util.Map;

import org.hanzhdy.manager.upc.model.RoleGroup;

public interface RoleGroupMapperExt extends RoleGroupMapper {
    public int countAsList(Map<String, Object> params);
    
    public List<RoleGroup> selectAsList(Map<String, Object> params);
}