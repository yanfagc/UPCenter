package org.hanzhdy.manager.settings.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.settings.model.DictType;
import org.hanzhdy.manager.settings.model.DictTypeExample;

public interface DictTypeMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int countByExample(DictTypeExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int deleteByExample(DictTypeExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int insert(DictType record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int insertSelective(DictType record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    List<DictType> selectByExample(DictTypeExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    DictType selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") DictType record, @Param("example") DictTypeExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") DictType record, @Param("example") DictTypeExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(DictType record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: s_dicttype
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(DictType record);
}