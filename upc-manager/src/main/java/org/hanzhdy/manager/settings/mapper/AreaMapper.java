package org.hanzhdy.manager.settings.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.settings.model.Area;
import org.hanzhdy.manager.settings.model.AreaExample;

public interface AreaMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int countByExample(AreaExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int deleteByExample(AreaExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int insert(Area record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int insertSelective(Area record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    List<Area> selectByExample(AreaExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    Area selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_area
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(Area record);
}