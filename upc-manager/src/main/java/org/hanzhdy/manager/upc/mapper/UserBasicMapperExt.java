package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import java.util.Map;

import org.hanzhdy.manager.upc.vo.UserVo;

public interface UserBasicMapperExt extends UserBasicMapper {
    /**
     * 按条件查询用户数量
     * @param params
     * @return
     */
    public int countAsList(Map<String, Object> params);
    
    /**
     * 按条件查询用户信息
     * @param params
     * @return
     */
    public List<UserVo> selectAsList(Map<String, Object> params);
    
    /**
     * 根据用户ID查询用户信息
     * @param userid
     * @return
     */
    public UserVo selectById(Long userid);
    
    /**
     * 根据用户帐号查询用户信息
     * @param account
     * @return
     */
    public UserVo selectByAccount(String account);
}