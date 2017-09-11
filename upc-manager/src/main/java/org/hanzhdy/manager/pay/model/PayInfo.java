package org.hanzhdy.manager.pay.model;

import java.io.Serializable;
import java.util.Date;

public class PayInfo implements Serializable {
    public static final long serialVersionUID = -1374984534L;

    /**
     * 本地生成的支付订单信息: pay_info.PAY_INFO_ID
     * @author MyBatis Generator
     */
    private String payInfoId;

    /**
     * 支付金额: pay_info.PAY_AMOUNT
     * @author MyBatis Generator
     */
    private Long payAmount;

    /**
     * 支付渠道     wx:微信   ali:支付宝   jd：京东支付  union:银联: pay_info.CHANNEL
     * @author MyBatis Generator
     */
    private String channel;

    /**
     * 对应支付渠道订单id， 如果是微信，关联pay_order_wx表: pay_info.PAY_CHANNEL_ORDER_ID
     * @author MyBatis Generator
     */
    private String payChannelOrderId;

    /**
     * 当前绑定的支付订单明细id， 对应渠道下的订单明细id: pay_info.PAY_DETAIL_ID
     * @author MyBatis Generator
     */
    private String payDetailId;

    /**
     * 业务类型   自己系统的业务类型     暂定  buy:购买业务    delivery：提货业务: pay_info.BIZ_TYPE
     * @author MyBatis Generator
     */
    private String bizType;

    /**
     * 业务id, 关联的业务id: pay_info.BIZ_ID
     * @author MyBatis Generator
     */
    private String bizId;

    /**
     * 支付成功已通知商户服务器次数: pay_info.PAY_SUCCESS_NOTIFIED_TIMES
     * @author MyBatis Generator
     */
    private String paySuccessNotifiedTimes;

    /**
     * 支付状态   NO_CHANNEL：订单已生成，但未选择支付渠道  UNPAYING：支付渠道已选择，但未付款  CANCELLED：支付已取消  SUCCESS:支付成功: pay_info.STATUS
     * @author MyBatis Generator
     */
    private String status;

    /**
     * 状态历史: pay_info.STATUS_HISTORY
     * @author MyBatis Generator
     */
    private String statusHistory;

    /**
     * 创建时间: pay_info.TIME_START
     * @author MyBatis Generator
     */
    private Date timeStart;

    /**
     * 支付过期时间: pay_info.TIME_EXPIRE
     * @author MyBatis Generator
     */
    private Date timeExpire;

    /**
     * 退款状态, 退款是按原支付渠道退回，退款详细信息请到对应的支付渠道查询: pay_info.REFUND_STATUS
     * @author MyBatis Generator
     */
    private String refundStatus;

    /**
     * 已退款金额，单位为分: pay_info.REFUNDED_PRICE
     * @author MyBatis Generator
     */
    private Long refundedPrice;

    /**
     * 创建时间: pay_info.CREATE_TIME
     * @author MyBatis Generator
     */
    private Date createTime;

    /**
     * 修改时间: pay_info.UPDATE_TIME
     * @author MyBatis Generator
     */
    private Date updateTime;

    /**
     * 支付完成时间: pay_info.PAY_SUCCESS_TIME
     * @author MyBatis Generator
     */
    private Date paySuccessTime;

    /**
     * 退款发起时间: pay_info.REFUND_APPLY_TIME
     * @author MyBatis Generator
     */
    private Date refundApplyTime;

    /**
     * 退款完成时间: pay_info.REFUND_SUCCESS_TIME
     * @author MyBatis Generator
     */
    private Date refundSuccessTime;

    /**
     * 上次查询时间: pay_info.QUERY_TIME
     * @author MyBatis Generator
     */
    private Date queryTime;

    /**
     * 获取本地生成的支付订单信息: pay_info.PAY_INFO_ID
     * @return 本地生成的支付订单信息: pay_info.PAY_INFO_ID
     * @author MyBatis Generator
     */
    public String getPayInfoId() {
        return payInfoId;
    }

    /**
     * 设置本地生成的支付订单信息: pay_info.PAY_INFO_ID
     * @param payInfoId 映射数据库字段: pay_info.PAY_INFO_ID
     * @author MyBatis Generator
     */
    public void setPayInfoId(String payInfoId) {
        this.payInfoId = payInfoId == null ? null : payInfoId.trim();
    }

    /**
     * 获取支付金额: pay_info.PAY_AMOUNT
     * @return 支付金额: pay_info.PAY_AMOUNT
     * @author MyBatis Generator
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额: pay_info.PAY_AMOUNT
     * @param payAmount 映射数据库字段: pay_info.PAY_AMOUNT
     * @author MyBatis Generator
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取支付渠道     wx:微信   ali:支付宝   jd：京东支付  union:银联: pay_info.CHANNEL
     * @return 支付渠道     wx:微信   ali:支付宝   jd：京东支付  union:银联: pay_info.CHANNEL
     * @author MyBatis Generator
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置支付渠道     wx:微信   ali:支付宝   jd：京东支付  union:银联: pay_info.CHANNEL
     * @param channel 映射数据库字段: pay_info.CHANNEL
     * @author MyBatis Generator
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * 获取对应支付渠道订单id， 如果是微信，关联pay_order_wx表: pay_info.PAY_CHANNEL_ORDER_ID
     * @return 对应支付渠道订单id， 如果是微信，关联pay_order_wx表: pay_info.PAY_CHANNEL_ORDER_ID
     * @author MyBatis Generator
     */
    public String getPayChannelOrderId() {
        return payChannelOrderId;
    }

    /**
     * 设置对应支付渠道订单id， 如果是微信，关联pay_order_wx表: pay_info.PAY_CHANNEL_ORDER_ID
     * @param payChannelOrderId 映射数据库字段: pay_info.PAY_CHANNEL_ORDER_ID
     * @author MyBatis Generator
     */
    public void setPayChannelOrderId(String payChannelOrderId) {
        this.payChannelOrderId = payChannelOrderId == null ? null : payChannelOrderId.trim();
    }

    /**
     * 获取当前绑定的支付订单明细id， 对应渠道下的订单明细id: pay_info.PAY_DETAIL_ID
     * @return 当前绑定的支付订单明细id， 对应渠道下的订单明细id: pay_info.PAY_DETAIL_ID
     * @author MyBatis Generator
     */
    public String getPayDetailId() {
        return payDetailId;
    }

    /**
     * 设置当前绑定的支付订单明细id， 对应渠道下的订单明细id: pay_info.PAY_DETAIL_ID
     * @param payDetailId 映射数据库字段: pay_info.PAY_DETAIL_ID
     * @author MyBatis Generator
     */
    public void setPayDetailId(String payDetailId) {
        this.payDetailId = payDetailId == null ? null : payDetailId.trim();
    }

    /**
     * 获取业务类型   自己系统的业务类型     暂定  buy:购买业务    delivery：提货业务: pay_info.BIZ_TYPE
     * @return 业务类型   自己系统的业务类型     暂定  buy:购买业务    delivery：提货业务: pay_info.BIZ_TYPE
     * @author MyBatis Generator
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 设置业务类型   自己系统的业务类型     暂定  buy:购买业务    delivery：提货业务: pay_info.BIZ_TYPE
     * @param bizType 映射数据库字段: pay_info.BIZ_TYPE
     * @author MyBatis Generator
     */
    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    /**
     * 获取业务id, 关联的业务id: pay_info.BIZ_ID
     * @return 业务id, 关联的业务id: pay_info.BIZ_ID
     * @author MyBatis Generator
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 设置业务id, 关联的业务id: pay_info.BIZ_ID
     * @param bizId 映射数据库字段: pay_info.BIZ_ID
     * @author MyBatis Generator
     */
    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    /**
     * 获取支付成功已通知商户服务器次数: pay_info.PAY_SUCCESS_NOTIFIED_TIMES
     * @return 支付成功已通知商户服务器次数: pay_info.PAY_SUCCESS_NOTIFIED_TIMES
     * @author MyBatis Generator
     */
    public String getPaySuccessNotifiedTimes() {
        return paySuccessNotifiedTimes;
    }

    /**
     * 设置支付成功已通知商户服务器次数: pay_info.PAY_SUCCESS_NOTIFIED_TIMES
     * @param paySuccessNotifiedTimes 映射数据库字段: pay_info.PAY_SUCCESS_NOTIFIED_TIMES
     * @author MyBatis Generator
     */
    public void setPaySuccessNotifiedTimes(String paySuccessNotifiedTimes) {
        this.paySuccessNotifiedTimes = paySuccessNotifiedTimes == null ? null : paySuccessNotifiedTimes.trim();
    }

    /**
     * 获取支付状态   NO_CHANNEL：订单已生成，但未选择支付渠道  UNPAYING：支付渠道已选择，但未付款  CANCELLED：支付已取消  SUCCESS:支付成功: pay_info.STATUS
     * @return 支付状态   NO_CHANNEL：订单已生成，但未选择支付渠道  UNPAYING：支付渠道已选择，但未付款  CANCELLED：支付已取消  SUCCESS:支付成功: pay_info.STATUS
     * @author MyBatis Generator
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置支付状态   NO_CHANNEL：订单已生成，但未选择支付渠道  UNPAYING：支付渠道已选择，但未付款  CANCELLED：支付已取消  SUCCESS:支付成功: pay_info.STATUS
     * @param status 映射数据库字段: pay_info.STATUS
     * @author MyBatis Generator
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取状态历史: pay_info.STATUS_HISTORY
     * @return 状态历史: pay_info.STATUS_HISTORY
     * @author MyBatis Generator
     */
    public String getStatusHistory() {
        return statusHistory;
    }

    /**
     * 设置状态历史: pay_info.STATUS_HISTORY
     * @param statusHistory 映射数据库字段: pay_info.STATUS_HISTORY
     * @author MyBatis Generator
     */
    public void setStatusHistory(String statusHistory) {
        this.statusHistory = statusHistory == null ? null : statusHistory.trim();
    }

    /**
     * 获取创建时间: pay_info.TIME_START
     * @return 创建时间: pay_info.TIME_START
     * @author MyBatis Generator
     */
    public Date getTimeStart() {
        return timeStart;
    }

    /**
     * 设置创建时间: pay_info.TIME_START
     * @param timeStart 映射数据库字段: pay_info.TIME_START
     * @author MyBatis Generator
     */
    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    /**
     * 获取支付过期时间: pay_info.TIME_EXPIRE
     * @return 支付过期时间: pay_info.TIME_EXPIRE
     * @author MyBatis Generator
     */
    public Date getTimeExpire() {
        return timeExpire;
    }

    /**
     * 设置支付过期时间: pay_info.TIME_EXPIRE
     * @param timeExpire 映射数据库字段: pay_info.TIME_EXPIRE
     * @author MyBatis Generator
     */
    public void setTimeExpire(Date timeExpire) {
        this.timeExpire = timeExpire;
    }

    /**
     * 获取退款状态, 退款是按原支付渠道退回，退款详细信息请到对应的支付渠道查询: pay_info.REFUND_STATUS
     * @return 退款状态, 退款是按原支付渠道退回，退款详细信息请到对应的支付渠道查询: pay_info.REFUND_STATUS
     * @author MyBatis Generator
     */
    public String getRefundStatus() {
        return refundStatus;
    }

    /**
     * 设置退款状态, 退款是按原支付渠道退回，退款详细信息请到对应的支付渠道查询: pay_info.REFUND_STATUS
     * @param refundStatus 映射数据库字段: pay_info.REFUND_STATUS
     * @author MyBatis Generator
     */
    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    /**
     * 获取已退款金额，单位为分: pay_info.REFUNDED_PRICE
     * @return 已退款金额，单位为分: pay_info.REFUNDED_PRICE
     * @author MyBatis Generator
     */
    public Long getRefundedPrice() {
        return refundedPrice;
    }

    /**
     * 设置已退款金额，单位为分: pay_info.REFUNDED_PRICE
     * @param refundedPrice 映射数据库字段: pay_info.REFUNDED_PRICE
     * @author MyBatis Generator
     */
    public void setRefundedPrice(Long refundedPrice) {
        this.refundedPrice = refundedPrice;
    }

    /**
     * 获取创建时间: pay_info.CREATE_TIME
     * @return 创建时间: pay_info.CREATE_TIME
     * @author MyBatis Generator
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间: pay_info.CREATE_TIME
     * @param createTime 映射数据库字段: pay_info.CREATE_TIME
     * @author MyBatis Generator
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间: pay_info.UPDATE_TIME
     * @return 修改时间: pay_info.UPDATE_TIME
     * @author MyBatis Generator
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间: pay_info.UPDATE_TIME
     * @param updateTime 映射数据库字段: pay_info.UPDATE_TIME
     * @author MyBatis Generator
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取支付完成时间: pay_info.PAY_SUCCESS_TIME
     * @return 支付完成时间: pay_info.PAY_SUCCESS_TIME
     * @author MyBatis Generator
     */
    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    /**
     * 设置支付完成时间: pay_info.PAY_SUCCESS_TIME
     * @param paySuccessTime 映射数据库字段: pay_info.PAY_SUCCESS_TIME
     * @author MyBatis Generator
     */
    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    /**
     * 获取退款发起时间: pay_info.REFUND_APPLY_TIME
     * @return 退款发起时间: pay_info.REFUND_APPLY_TIME
     * @author MyBatis Generator
     */
    public Date getRefundApplyTime() {
        return refundApplyTime;
    }

    /**
     * 设置退款发起时间: pay_info.REFUND_APPLY_TIME
     * @param refundApplyTime 映射数据库字段: pay_info.REFUND_APPLY_TIME
     * @author MyBatis Generator
     */
    public void setRefundApplyTime(Date refundApplyTime) {
        this.refundApplyTime = refundApplyTime;
    }

    /**
     * 获取退款完成时间: pay_info.REFUND_SUCCESS_TIME
     * @return 退款完成时间: pay_info.REFUND_SUCCESS_TIME
     * @author MyBatis Generator
     */
    public Date getRefundSuccessTime() {
        return refundSuccessTime;
    }

    /**
     * 设置退款完成时间: pay_info.REFUND_SUCCESS_TIME
     * @param refundSuccessTime 映射数据库字段: pay_info.REFUND_SUCCESS_TIME
     * @author MyBatis Generator
     */
    public void setRefundSuccessTime(Date refundSuccessTime) {
        this.refundSuccessTime = refundSuccessTime;
    }

    /**
     * 获取上次查询时间: pay_info.QUERY_TIME
     * @return 上次查询时间: pay_info.QUERY_TIME
     * @author MyBatis Generator
     */
    public Date getQueryTime() {
        return queryTime;
    }

    /**
     * 设置上次查询时间: pay_info.QUERY_TIME
     * @param queryTime 映射数据库字段: pay_info.QUERY_TIME
     * @author MyBatis Generator
     */
    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }
}