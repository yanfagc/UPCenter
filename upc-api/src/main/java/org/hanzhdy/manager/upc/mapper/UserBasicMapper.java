package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.UserBasic;
import org.hanzhdy.manager.upc.model.UserBasicExample;

public interface UserBasicMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int countByExample(UserBasicExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int deleteByExample(UserBasicExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int insert(UserBasic record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int insertSelective(UserBasic record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    List<UserBasic> selectByExample(UserBasicExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    UserBasic selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") UserBasic record, @Param("example") UserBasicExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") UserBasic record, @Param("example") UserBasicExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(UserBasic record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: u_user_basic
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(UserBasic record);
}