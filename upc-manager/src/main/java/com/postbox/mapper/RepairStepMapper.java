package com.postbox.mapper;

import com.postbox.model.RepairStep;
import com.postbox.model.RepairStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairStepMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int countByExample(RepairStepExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int deleteByExample(RepairStepExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long repairStepId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int insert(RepairStep record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int insertSelective(RepairStep record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    List<RepairStep> selectByExample(RepairStepExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    RepairStep selectByPrimaryKey(Long repairStepId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") RepairStep record, @Param("example") RepairStepExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") RepairStep record, @Param("example") RepairStepExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(RepairStep record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_step
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(RepairStep record);
}