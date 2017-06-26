package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.MenuItem;
import org.hanzhdy.manager.upc.model.MenuItemExample;

public interface MenuItemMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int countByExample(MenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int deleteByExample(MenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int insert(MenuItem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int insertSelective(MenuItem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    List<MenuItem> selectByExample(MenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    MenuItem selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") MenuItem record, @Param("example") MenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") MenuItem record, @Param("example") MenuItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(MenuItem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menuitem
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(MenuItem record);
}