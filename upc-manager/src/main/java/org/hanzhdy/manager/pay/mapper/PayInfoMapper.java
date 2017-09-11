package org.hanzhdy.manager.pay.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.pay.model.PayInfo;
import org.hanzhdy.manager.pay.model.PayInfoExample;

public interface PayInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int countByExample(PayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int deleteByExample(PayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(String payInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int insert(PayInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int insertSelective(PayInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    List<PayInfo> selectByExample(PayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    PayInfo selectByPrimaryKey(String payInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") PayInfo record, @Param("example") PayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") PayInfo record, @Param("example") PayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(PayInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(PayInfo record);
}