package org.hanzhdy.manager.settings.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.settings.model.DictData;
import org.hanzhdy.manager.settings.model.DictDataExample;

public interface DictDataMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int countByExample(DictDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int deleteByExample(DictDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int insert(DictData record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int insertSelective(DictData record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    List<DictData> selectByExample(DictDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    DictData selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") DictData record, @Param("example") DictDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") DictData record, @Param("example") DictDataExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(DictData record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dictdata
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(DictData record);
}