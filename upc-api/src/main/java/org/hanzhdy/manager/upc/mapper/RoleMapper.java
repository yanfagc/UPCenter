package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.Role;
import org.hanzhdy.manager.upc.model.RoleExample;

public interface RoleMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int countByExample(RoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int deleteByExample(RoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int insert(Role record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int insertSelective(Role record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    Role selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(Role record);
}