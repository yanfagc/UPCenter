package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.RoleGroup;
import org.hanzhdy.manager.upc.model.RoleGroupExample;

public interface RoleGroupMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int countByExample(RoleGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int deleteByExample(RoleGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int insert(RoleGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int insertSelective(RoleGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    List<RoleGroup> selectByExample(RoleGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    RoleGroup selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") RoleGroup record, @Param("example") RoleGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") RoleGroup record, @Param("example") RoleGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(RoleGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_group
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(RoleGroup record);
}