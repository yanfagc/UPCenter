package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.Menu;
import org.hanzhdy.manager.upc.model.MenuExample;

public interface MenuMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int countByExample(MenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int deleteByExample(MenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int insert(Menu record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int insertSelective(Menu record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    Menu selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_menu
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(Menu record);
}