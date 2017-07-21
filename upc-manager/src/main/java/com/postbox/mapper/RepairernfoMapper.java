package com.postbox.mapper;

import com.postbox.model.Repairernfo;
import com.postbox.model.RepairernfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairernfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int countByExample(RepairernfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int deleteByExample(RepairernfoExample example);

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
    int insert(Repairernfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int insertSelective(Repairernfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    List<Repairernfo> selectByExample(RepairernfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    Repairernfo selectByPrimaryKey(Long repairerInfoid);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") Repairernfo record, @Param("example") RepairernfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") Repairernfo record, @Param("example") RepairernfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(Repairernfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repairer_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(Repairernfo record);
}