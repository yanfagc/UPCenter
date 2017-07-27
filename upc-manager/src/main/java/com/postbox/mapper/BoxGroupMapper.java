package com.postbox.mapper;

import com.postbox.model.BoxGroup;
import com.postbox.model.BoxGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoxGroupMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int countByExample(BoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int deleteByExample(BoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long boxGroupId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int insert(BoxGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int insertSelective(BoxGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    List<BoxGroup> selectByExample(BoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    BoxGroup selectByPrimaryKey(Long boxGroupId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") BoxGroup record, @Param("example") BoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") BoxGroup record, @Param("example") BoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(BoxGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(BoxGroup record);
}