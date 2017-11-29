package org.hanzhdy.manager.settings.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.settings.model.FormField;
import org.hanzhdy.manager.settings.model.FormFieldExample;
import org.hanzhdy.manager.settings.model.FormFieldKey;

public interface FormFieldMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int countByExample(FormFieldExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int deleteByExample(FormFieldExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(FormFieldKey key);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int insert(FormField record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int insertSelective(FormField record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    List<FormField> selectByExample(FormFieldExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    FormField selectByPrimaryKey(FormFieldKey key);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") FormField record, @Param("example") FormFieldExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") FormField record, @Param("example") FormFieldExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(FormField record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_field
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(FormField record);
}