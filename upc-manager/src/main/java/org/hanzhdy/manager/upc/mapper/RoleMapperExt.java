package org.hanzhdy.manager.upc.mapper;

import org.hanzhdy.manager.upc.vo.RoleVo;

import java.util.List;
import java.util.Map;

public interface RoleMapperExt extends RoleMapper {
    /**
     * 查询角色信息总数
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);
    
    /**
     * 分页查询角色信息
     * @param params
     * @return
     */
    List<RoleVo> selectAsList(Map<String, Object> params);
    
    /**
     * 用户角色设置专用，查询用户角色
     * @param userid
     * @return
     */
    List<RoleVo> selectRolesForUserSetting(Long userid);
    
    /**
     * 将GroupId值设置为NULL
     * @param groupId
     * @return
     */
    int updateGroupId2ZeroByGroupId(Long groupId);
}