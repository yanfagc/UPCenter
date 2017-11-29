package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.UserRoleExample;
import org.hanzhdy.manager.upc.model.UserRoleKey;

public interface UserRoleMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_user_role
     * @author MyBatis Generator
     */
    int countByExample(UserRoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_user_role
     * @author MyBatis Generator
     */
    int deleteByExample(UserRoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_user_role
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(UserRoleKey key);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_user_role
     * @author MyBatis Generator
     */
    int insert(UserRoleKey record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_user_role
     * @author MyBatis Generator
     */
    int insertSelective(UserRoleKey record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_user_role
     * @author MyBatis Generator
     */
    List<UserRoleKey> selectByExample(UserRoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_user_role
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") UserRoleKey record, @Param("example") UserRoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_user_role
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") UserRoleKey record, @Param("example") UserRoleExample example);
}