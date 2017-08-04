package com.postbox.mapper;

import com.postbox.model.RepairRecord;
import com.postbox.model.RepairRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairRecordMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int countByExample(RepairRecordExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int deleteByExample(RepairRecordExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long repairRecordId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int insert(RepairRecord record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int insertSelective(RepairRecord record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    List<RepairRecord> selectByExample(RepairRecordExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    RepairRecord selectByPrimaryKey(Long repairRecordId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(RepairRecord record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: t_repair_record
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(RepairRecord record);
}