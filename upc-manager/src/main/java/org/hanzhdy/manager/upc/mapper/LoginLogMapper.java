package org.hanzhdy.manager.upc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.upc.model.LoginLog;
import org.hanzhdy.manager.upc.model.LoginLogExample;

public interface LoginLogMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int countByExample(LoginLogExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int deleteByExample(LoginLogExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int insert(LoginLog record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int insertSelective(LoginLog record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    List<LoginLog> selectByExample(LoginLogExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    LoginLog selectByPrimaryKey(Long id);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") LoginLog record, @Param("example") LoginLogExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") LoginLog record, @Param("example") LoginLogExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(LoginLog record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: g_login_log
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(LoginLog record);
}