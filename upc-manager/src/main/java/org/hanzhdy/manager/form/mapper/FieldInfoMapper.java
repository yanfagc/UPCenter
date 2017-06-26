package org.hanzhdy.manager.form.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.form.model.FieldInfo;
import org.hanzhdy.manager.form.model.FieldInfoExample;

public interface FieldInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int countByExample(FieldInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int deleteByExample(FieldInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int insert(FieldInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int insertSelective(FieldInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    List<FieldInfo> selectByExample(FieldInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    FieldInfo selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") FieldInfo record, @Param("example") FieldInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") FieldInfo record, @Param("example") FieldInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(FieldInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_field_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(FieldInfo record);
}