package com.postbox.mapper;

import com.postbox.model.TBoxGroup;
import com.postbox.model.TBoxGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBoxGroupMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int countByExample(TBoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int deleteByExample(TBoxGroupExample example);

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
    int insert(TBoxGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int insertSelective(TBoxGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    List<TBoxGroup> selectByExample(TBoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    TBoxGroup selectByPrimaryKey(Long boxGroupId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") TBoxGroup record, @Param("example") TBoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") TBoxGroup record, @Param("example") TBoxGroupExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(TBoxGroup record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_group
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(TBoxGroup record);
}