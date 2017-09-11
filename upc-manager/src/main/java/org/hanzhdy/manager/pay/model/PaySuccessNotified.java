package org.hanzhdy.manager.pay.model;

import java.io.Serializable;
import java.util.Date;

public class PaySuccessNotified implements Serializable {
    public static final long serialVersionUID = -1861889217L;

    /**
     * : pay_success_notified.PAY_SUCCESS_NOTIFIED_ID
     * @author MyBatis Generator
     */
    private Long paySuccessNotifiedId;

    /**
     * 本地生成的支付订单信息: pay_success_notified.PAY_INFO_ID
     * @author MyBatis Generator
     */
    private String payInfoId;

    /**
     * 通知时间: pay_success_notified.NOTIFY_TIME
     * @author MyBatis Generator
     */
    private Date notifyTime;

    /**
     * 通知url: pay_success_notified.NOTIFY_URL
     * @author MyBatis Generator
     */
    private String notifyUrl;

    /**
     * 结果反馈: pay_success_notified.RETURN_RESULT
     * @author MyBatis Generator
     */
    private String returnResult;

    /**
     * 获取: pay_success_notified.PAY_SUCCESS_NOTIFIED_ID
     * @return : pay_success_notified.PAY_SUCCESS_NOTIFIED_ID
     * @author MyBatis Generator
     */
    public Long getPaySuccessNotifiedId() {
        return paySuccessNotifiedId;
    }

    /**
     * 设置: pay_success_notified.PAY_SUCCESS_NOTIFIED_ID
     * @param paySuccessNotifiedId 映射数据库字段: pay_success_notified.PAY_SUCCESS_NOTIFIED_ID
     * @author MyBatis Generator
     */
    public void setPaySuccessNotifiedId(Long paySuccessNotifiedId) {
        this.paySuccessNotifiedId = paySuccessNotifiedId;
    }

    /**
     * 获取本地生成的支付订单信息: pay_success_notified.PAY_INFO_ID
     * @return 本地生成的支付订单信息: pay_success_notified.PAY_INFO_ID
     * @author MyBatis Generator
     */
    public String getPayInfoId() {
        return payInfoId;
    }

    /**
     * 设置本地生成的支付订单信息: pay_success_notified.PAY_INFO_ID
     * @param payInfoId 映射数据库字段: pay_success_notified.PAY_INFO_ID
     * @author MyBatis Generator
     */
    public void setPayInfoId(String payInfoId) {
        this.payInfoId = payInfoId == null ? null : payInfoId.trim();
    }

    /**
     * 获取通知时间: pay_success_notified.NOTIFY_TIME
     * @return 通知时间: pay_success_notified.NOTIFY_TIME
     * @author MyBatis Generator
     */
    public Date getNotifyTime() {
        return notifyTime;
    }

    /**
     * 设置通知时间: pay_success_notified.NOTIFY_TIME
     * @param notifyTime 映射数据库字段: pay_success_notified.NOTIFY_TIME
     * @author MyBatis Generator
     */
    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    /**
     * 获取通知url: pay_success_notified.NOTIFY_URL
     * @return 通知url: pay_success_notified.NOTIFY_URL
     * @author MyBatis Generator
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置通知url: pay_success_notified.NOTIFY_URL
     * @param notifyUrl 映射数据库字段: pay_success_notified.NOTIFY_URL
     * @author MyBatis Generator
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * 获取结果反馈: pay_success_notified.RETURN_RESULT
     * @return 结果反馈: pay_success_notified.RETURN_RESULT
     * @author MyBatis Generator
     */
    public String getReturnResult() {
        return returnResult;
    }

    /**
     * 设置结果反馈: pay_success_notified.RETURN_RESULT
     * @param returnResult 映射数据库字段: pay_success_notified.RETURN_RESULT
     * @author MyBatis Generator
     */
    public void setReturnResult(String returnResult) {
        this.returnResult = returnResult == null ? null : returnResult.trim();
    }
}