package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.RoleMenuExample;
import org.hanzhdy.manager.upc.model.RoleMenuKey;

public interface RoleMenuMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menu
     * @author MyBatis Generator
     */
    int countByExample(RoleMenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menu
     * @author MyBatis Generator
     */
    int deleteByExample(RoleMenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menu
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(RoleMenuKey key);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menu
     * @author MyBatis Generator
     */
    int insert(RoleMenuKey record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menu
     * @author MyBatis Generator
     */
    int insertSelective(RoleMenuKey record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menu
     * @author MyBatis Generator
     */
    List<RoleMenuKey> selectByExample(RoleMenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menu
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") RoleMenuKey record, @Param("example") RoleMenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menu
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") RoleMenuKey record, @Param("example") RoleMenuExample example);
}