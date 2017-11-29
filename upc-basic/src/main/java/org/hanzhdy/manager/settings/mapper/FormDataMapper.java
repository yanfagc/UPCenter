package org.hanzhdy.manager.settings.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.settings.model.FormData;
import org.hanzhdy.manager.settings.model.FormDataExample;

public interface FormDataMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int countByExample(FormDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int deleteByExample(FormDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int insert(FormData record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int insertSelective(FormData record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    List<FormData> selectByExample(FormDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    FormData selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") FormData record, @Param("example") FormDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") FormData record, @Param("example") FormDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(FormData record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_data
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(FormData record);
}