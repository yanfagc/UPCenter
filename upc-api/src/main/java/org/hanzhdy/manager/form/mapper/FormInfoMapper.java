package org.hanzhdy.manager.form.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.form.model.FormInfo;
import org.hanzhdy.manager.form.model.FormInfoExample;

public interface FormInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int countByExample(FormInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int deleteByExample(FormInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int insert(FormInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int insertSelective(FormInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    List<FormInfo> selectByExample(FormInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    FormInfo selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") FormInfo record, @Param("example") FormInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") FormInfo record, @Param("example") FormInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(FormInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: f_form_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(FormInfo record);
}