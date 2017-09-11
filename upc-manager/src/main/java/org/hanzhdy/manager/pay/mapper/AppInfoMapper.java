package org.hanzhdy.manager.pay.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.pay.model.AppInfo;
import org.hanzhdy.manager.pay.model.AppInfoExample;

public interface AppInfoMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int countByExample(AppInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int deleteByExample(AppInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(String appId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int insert(AppInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int insertSelective(AppInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    List<AppInfo> selectByExample(AppInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    AppInfo selectByPrimaryKey(String appId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") AppInfo record, @Param("example") AppInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") AppInfo record, @Param("example") AppInfoExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(AppInfo record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: app_info
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(AppInfo record);
}