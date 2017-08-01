package com.postbox.mapper;

import com.postbox.model.BoxInfo;
import com.postbox.model.BoxInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoxInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int countByExample(BoxInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int deleteByExample(BoxInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long boxInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int insert(BoxInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int insertSelective(BoxInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    List<BoxInfo> selectByExample(BoxInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    BoxInfo selectByPrimaryKey(Long boxInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") BoxInfo record, @Param("example") BoxInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") BoxInfo record, @Param("example") BoxInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(BoxInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_box_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(BoxInfo record);
}