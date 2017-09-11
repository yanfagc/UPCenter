package org.hanzhdy.manager.pay.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.pay.model.PrepayInfo;
import org.hanzhdy.manager.pay.model.PrepayInfoExample;

public interface PrepayInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int countByExample(PrepayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int deleteByExample(PrepayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(String prepayInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int insert(PrepayInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int insertSelective(PrepayInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    List<PrepayInfo> selectByExample(PrepayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    PrepayInfo selectByPrimaryKey(String prepayInfoId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") PrepayInfo record, @Param("example") PrepayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") PrepayInfo record, @Param("example") PrepayInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(PrepayInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: prepay_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(PrepayInfo record);
}