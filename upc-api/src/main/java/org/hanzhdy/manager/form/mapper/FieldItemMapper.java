package org.hanzhdy.manager.form.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.form.model.FieldItem;
import org.hanzhdy.manager.form.model.FieldItemExample;

public interface FieldItemMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int countByExample(FieldItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int deleteByExample(FieldItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int insert(FieldItem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int insertSelective(FieldItem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    List<FieldItem> selectByExample(FieldItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    FieldItem selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") FieldItem record, @Param("example") FieldItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") FieldItem record, @Param("example") FieldItemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(FieldItem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_item
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(FieldItem record);
}