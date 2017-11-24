package org.hanzhdy.manager.upc.mapper;

import org.hanzhdy.manager.upc.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserBasicMapperExt extends UserBasicMapper {
    /**
     * 按条件查询用户数量
     * @param params
     * @return
     */
    int countAsList(Map<String, Object> params);
    
    /**
     * 按条件查询用户信息
     * @param params
     * @return
     */
    List<UserVo> selectAsList(Map<String, Object> params);
    
    /**
     * 根据用户ID查询用户信息
     * @param userid
     * @return
     */
    UserVo selectById(Long userid);
    
    /**
     * 根据用户帐号查询用户信息
     * @param account
     * @return
     */
    UserVo selectByAccount(String account);
    
    /**
     * 删除用户的formid属性
     * @param userid
     * @return
     */
    int updateClearUserFormid(Long userid);
}