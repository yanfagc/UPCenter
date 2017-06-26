package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.UserStatus;
import org.hanzhdy.manager.upc.model.UserStatusExample;

public interface UserStatusMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int countByExample(UserStatusExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int deleteByExample(UserStatusExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int insert(UserStatus record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int insertSelective(UserStatus record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    List<UserStatus> selectByExample(UserStatusExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    UserStatus selectByPrimaryKey(Long userId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") UserStatus record, @Param("example") UserStatusExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") UserStatus record, @Param("example") UserStatusExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(UserStatus record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_status
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(UserStatus record);
}