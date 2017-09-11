package org.hanzhdy.manager.pay.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hanzhdy.manager.pay.model.PaySuccessNotified;
import org.hanzhdy.manager.pay.model.PaySuccessNotifiedExample;

public interface PaySuccessNotifiedMapper {
    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int countByExample(PaySuccessNotifiedExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int deleteByExample(PaySuccessNotifiedExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int deleteByPrimaryKey(Long paySuccessNotifiedId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int insert(PaySuccessNotified record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int insertSelective(PaySuccessNotified record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    List<PaySuccessNotified> selectByExample(PaySuccessNotifiedExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    PaySuccessNotified selectByPrimaryKey(Long paySuccessNotifiedId);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int updateByExampleSelective(@Param("record") PaySuccessNotified record, @Param("example") PaySuccessNotifiedExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int updateByExample(@Param("record") PaySuccessNotified record, @Param("example") PaySuccessNotifiedExample example);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int updateByPrimaryKeySelective(PaySuccessNotified record);

    /**
     * 本段代码由Mybatis Generator自动生成.
     * 映射数据库: pay_success_notified
     * @author MyBatis Generator
     */
    int updateByPrimaryKey(PaySuccessNotified record);
}