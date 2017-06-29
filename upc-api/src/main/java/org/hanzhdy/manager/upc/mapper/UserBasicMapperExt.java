package org.hanzhdy.manager.upc.mapper;

import org.hanzhdy.api.vo.UserVo;

public interface UserBasicMapperExt extends UserBasicMapper {
    /**
     * 根据帐号查找用户信息
     * @param account
     * @return
     */
    UserVo selectByAccount(String account);
}