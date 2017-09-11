package org.hanzhdy.manager.pay.model;

import java.io.Serializable;
import java.util.Date;

public class PrepayInfo implements Serializable {
    public static final long serialVersionUID = 1972643775L;

    /**
     * 预订单号,由本系统生成后返回给app，作为app支付的预订单号: prepay_info.PREPAY_INFO_ID
     * @author MyBatis Generator
     */
    private String prepayInfoId;

    /**
     * app系统内部订单号，要求32个字符内，只能是数字、大小写字母 ，且在同一个商户号下唯一。: prepay_info.APP_TRADE_NO
     * @author MyBatis Generator
     */
    private String appTradeNo;

    /**
     * 支付应用 id: prepay_info.APP_ID
     * @author MyBatis Generator
     */
    private String appId;

    /**
     * 本地生成的支付订单信息: prepay_info.PAY_INFO_ID
     * @author MyBatis Generator
     */
    private String payInfoId;

    /**
     * 支付金额: prepay_info.AMOUNT
     * @author MyBatis Generator
     */
    private Long amount;

    /**
     * 支付app下单时间: prepay_info.CREATE_TIME
     * @author MyBatis Generator
     */
    private Date createTime;

    /**
     * 支付app下单服务器ip: prepay_info.APP_IP
     * @author MyBatis Generator
     */
    private String appIp;

    /**
     * 获取预订单号,由本系统生成后返回给app，作为app支付的预订单号: prepay_info.PREPAY_INFO_ID
     * @return 预订单号,由本系统生成后返回给app，作为app支付的预订单号: prepay_info.PREPAY_INFO_ID
     * @author MyBatis Generator
     */
    public String getPrepayInfoId() {
        return prepayInfoId;
    }

    /**
     * 设置预订单号,由本系统生成后返回给app，作为app支付的预订单号: prepay_info.PREPAY_INFO_ID
     * @param prepayInfoId 映射数据库字段: prepay_info.PREPAY_INFO_ID
     * @author MyBatis Generator
     */
    public void setPrepayInfoId(String prepayInfoId) {
        this.prepayInfoId = prepayInfoId == null ? null : prepayInfoId.trim();
    }

    /**
     * 获取app系统内部订单号，要求32个字符内，只能是数字、大小写字母 ，且在同一个商户号下唯一。: prepay_info.APP_TRADE_NO
     * @return app系统内部订单号，要求32个字符内，只能是数字、大小写字母 ，且在同一个商户号下唯一。: prepay_info.APP_TRADE_NO
     * @author MyBatis Generator
     */
    public String getAppTradeNo() {
        return appTradeNo;
    }

    /**
     * 设置app系统内部订单号，要求32个字符内，只能是数字、大小写字母 ，且在同一个商户号下唯一。: prepay_info.APP_TRADE_NO
     * @param appTradeNo 映射数据库字段: prepay_info.APP_TRADE_NO
     * @author MyBatis Generator
     */
    public void setAppTradeNo(String appTradeNo) {
        this.appTradeNo = appTradeNo == null ? null : appTradeNo.trim();
    }

    /**
     * 获取支付应用 id: prepay_info.APP_ID
     * @return 支付应用 id: prepay_info.APP_ID
     * @author MyBatis Generator
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置支付应用 id: prepay_info.APP_ID
     * @param appId 映射数据库字段: prepay_info.APP_ID
     * @author MyBatis Generator
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取本地生成的支付订单信息: prepay_info.PAY_INFO_ID
     * @return 本地生成的支付订单信息: prepay_info.PAY_INFO_ID
     * @author MyBatis Generator
     */
    public String getPayInfoId() {
        return payInfoId;
    }

    /**
     * 设置本地生成的支付订单信息: prepay_info.PAY_INFO_ID
     * @param payInfoId 映射数据库字段: prepay_info.PAY_INFO_ID
     * @author MyBatis Generator
     */
    public void setPayInfoId(String payInfoId) {
        this.payInfoId = payInfoId == null ? null : payInfoId.trim();
    }

    /**
     * 获取支付金额: prepay_info.AMOUNT
     * @return 支付金额: prepay_info.AMOUNT
     * @author MyBatis Generator
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置支付金额: prepay_info.AMOUNT
     * @param amount 映射数据库字段: prepay_info.AMOUNT
     * @author MyBatis Generator
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 获取支付app下单时间: prepay_info.CREATE_TIME
     * @return 支付app下单时间: prepay_info.CREATE_TIME
     * @author MyBatis Generator
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置支付app下单时间: prepay_info.CREATE_TIME
     * @param createTime 映射数据库字段: prepay_info.CREATE_TIME
     * @author MyBatis Generator
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取支付app下单服务器ip: prepay_info.APP_IP
     * @return 支付app下单服务器ip: prepay_info.APP_IP
     * @author MyBatis Generator
     */
    public String getAppIp() {
        return appIp;
    }

    /**
     * 设置支付app下单服务器ip: prepay_info.APP_IP
     * @param appIp 映射数据库字段: prepay_info.APP_IP
     * @author MyBatis Generator
     */
    public void setAppIp(String appIp) {
        this.appIp = appIp == null ? null : appIp.trim();
    }
}