package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.UserInfo;
import org.hanzhdy.manager.upc.model.UserInfoExample;

public interface UserInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int countByExample(UserInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int deleteByExample(UserInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int insert(UserInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int insertSelective(UserInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    List<UserInfo> selectByExample(UserInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    UserInfo selectByPrimaryKey(Long userId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(UserInfo record);
}