package com.postbox.mapper;

import com.postbox.model.BoxGrid;
import com.postbox.model.BoxGridExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoxGridMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int countByExample(BoxGridExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int deleteByExample(BoxGridExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long boxGridId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int insert(BoxGrid record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int insertSelective(BoxGrid record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    List<BoxGrid> selectByExample(BoxGridExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    BoxGrid selectByPrimaryKey(Long boxGridId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") BoxGrid record, @Param("example") BoxGridExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") BoxGrid record, @Param("example") BoxGridExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(BoxGrid record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_grid
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(BoxGrid record);
}