package com.postbox.mapper;

import com.postbox.model.CompanyInfo;
import com.postbox.model.CompanyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int countByExample(CompanyInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int deleteByExample(CompanyInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long companyInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int insert(CompanyInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int insertSelective(CompanyInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    List<CompanyInfo> selectByExample(CompanyInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    CompanyInfo selectByPrimaryKey(Long companyInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(CompanyInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_company_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(CompanyInfo record);
}