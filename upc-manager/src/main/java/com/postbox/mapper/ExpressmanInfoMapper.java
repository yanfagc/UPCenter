package com.postbox.mapper;

import com.postbox.model.ExpressmanInfo;
import com.postbox.model.ExpressmanInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpressmanInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int countByExample(ExpressmanInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int deleteByExample(ExpressmanInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long expressmanInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int insert(ExpressmanInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int insertSelective(ExpressmanInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    List<ExpressmanInfo> selectByExample(ExpressmanInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    ExpressmanInfo selectByPrimaryKey(Long expressmanInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") ExpressmanInfo record, @Param("example") ExpressmanInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") ExpressmanInfo record, @Param("example") ExpressmanInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(ExpressmanInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_expressman_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(ExpressmanInfo record);
}