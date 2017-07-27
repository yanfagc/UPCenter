package com.postbox.mapper;

import com.postbox.model.RepairerInfo;
import com.postbox.model.RepairerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairerInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int countByExample(RepairerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int deleteByExample(RepairerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long repairerInfoid);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int insert(RepairerInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int insertSelective(RepairerInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    List<RepairerInfo> selectByExample(RepairerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    RepairerInfo selectByPrimaryKey(Long repairerInfoid);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") RepairerInfo record, @Param("example") RepairerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") RepairerInfo record, @Param("example") RepairerInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(RepairerInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(RepairerInfo record);
}