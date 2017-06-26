package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.RoleMenuItemExample;
import org.hanzhdy.manager.upc.model.RoleMenuItemKey;

public interface RoleMenuItemMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menuitem
     * @author MyBatis Generator
     */
    int countByExample(RoleMenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menuitem
     * @author MyBatis Generator
     */
    int deleteByExample(RoleMenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menuitem
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(RoleMenuItemKey key);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menuitem
     * @author MyBatis Generator
     */
    int insert(RoleMenuItemKey record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menuitem
     * @author MyBatis Generator
     */
    int insertSelective(RoleMenuItemKey record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menuitem
     * @author MyBatis Generator
     */
    List<RoleMenuItemKey> selectByExample(RoleMenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menuitem
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") RoleMenuItemKey record, @Param("example") RoleMenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_role_menuitem
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") RoleMenuItemKey record, @Param("example") RoleMenuItemExample example);
}