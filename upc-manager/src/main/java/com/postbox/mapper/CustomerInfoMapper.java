package com.postbox.mapper;

import com.postbox.model.CustomerInfo;
import com.postbox.model.CustomerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int countByExample(CustomerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int deleteByExample(CustomerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long customerInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int insert(CustomerInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int insertSelective(CustomerInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    List<CustomerInfo> selectByExample(CustomerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    CustomerInfo selectByPrimaryKey(Long customerInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(CustomerInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_customer_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(CustomerInfo record);
}