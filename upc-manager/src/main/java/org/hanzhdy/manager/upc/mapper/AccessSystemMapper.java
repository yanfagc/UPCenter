package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.AccessSystem;
import org.hanzhdy.manager.upc.model.AccessSystemExample;

public interface AccessSystemMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int countByExample(AccessSystemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int deleteByExample(AccessSystemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int insert(AccessSystem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int insertSelective(AccessSystem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    List<AccessSystem> selectByExample(AccessSystemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    AccessSystem selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") AccessSystem record, @Param("example") AccessSystemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") AccessSystem record, @Param("example") AccessSystemExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(AccessSystem record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: r_accesssystem
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(AccessSystem record);
}