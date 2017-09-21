package org.hanzhdy.manager.pay.vo;

import org.hanzhdy.manager.pay.model.PayOrderWx;

import java.util.Date;

public class PayOrderWxVo extends PayOrderWx {
    private static final long serialVersionUID = 2993522896865850886L;

    /**
     * 预订单号,由本系统生成后返回给app，作为app支付的预订单号: prepay_info.PREPAY_INFO_ID
     */
    private String prepayInfoId;

    /**
     * app系统内部订单号，要求32个字符内，只能是数字、大小写字母 ，且在同一个商户号下唯一。: prepay_info.APP_TRADE_NO
     */
    private String appTradeNo;

    /**
     * 支付应用 id: prepay_info.APP_ID
     */
    private String preAppId;

    /**
     * 支付金额: prepay_info.AMOUNT
     */
    private Long amount;

    /**
     * 支付app下单时间: prepay_info.CREATE_TIME
     */
    private Date prepayCreateTime;

    /**
     * 支付app下单服务器ip: prepay_info.APP_IP
     */
    private String appIp;

    /**
     * 支付金额: pay_info.PAY_AMOUNT
     */
    private Long payAmount;

    /**
     * 支付渠道     wx:微信   ali:支付宝   jd：京东支付  union:银联: pay_info.CHANNEL
     */
    private String channel;

    /**
     * 对应支付渠道订单id， 如果是微信，关联pay_order_wx表: pay_info.PAY_CHANNEL_ORDER_ID
     */
    private String payChannelOrderId;

    /**
     * 当前绑定的支付订单明细id， 对应渠道下的订单明细id: pay_info.PAY_DETAIL_ID
     */
    private String payDetailId;

    /**
     * 业务类型   自己系统的业务类型     暂定  buy:购买业务    delivery：提货业务: pay_info.BIZ_TYPE
     */
    private String bizType;

    /**
     * 业务id, 关联的业务id: pay_info.BIZ_ID
     */
    private String bizId;

    /**
     * 支付成功已通知商户服务器次数: pay_info.PAY_SUCCESS_NOTIFIED_TIMES
     */
    private String paySuccessNotifiedTimes;

    /**
     * 支付状态   NO_CHANNEL：订单已生成，但未选择支付渠道  UNPAYING：支付渠道已选择，但未付款  CANCELLED：支付已取消  SUCCESS:支付成功: pay_info.STATUS
     */
    private String status;

    /**
     * 状态历史: pay_info.STATUS_HISTORY
     */
    private String statusHistory;

    /**
     * 创建时间: pay_info.TIME_START
     */
    private Date payTimeStart;

    /**
     * 支付过期时间: pay_info.TIME_EXPIRE
     */
    private Date payTimeExpire;

    /**
     * 退款状态, 退款是按原支付渠道退回，退款详细信息请到对应的支付渠道查询: pay_info.REFUND_STATUS
     */
    private String refundStatus;

    /**
     * 已退款金额，单位为分: pay_info.REFUNDED_PRICE
     */
    private Long refundedPrice;

    /**
     * 创建时间: pay_info.CREATE_TIME
     */
    private Date createTime;

    /**
     * 修改时间: pay_info.UPDATE_TIME
     */
    private Date updateTime;

    /**
     * 支付完成时间: pay_info.PAY_SUCCESS_TIME
     */
    private Date paySuccessTime;

    /**
     * 退款发起时间: pay_info.REFUND_APPLY_TIME
     */
    private Date refundApplyTime;

    /**
     * 退款完成时间: pay_info.REFUND_SUCCESS_TIME
     */
    private Date refundSuccessTime;

    /**
     * 上次查询时间: pay_info.QUERY_TIME
     */
    private Date queryTime;

    public String getPreAppId() {
        return preAppId;
    }

    public void setPreAppId(String preAppId) {
        this.preAppId = preAppId;
    }

    public Date getPrepayCreateTime() {
        return prepayCreateTime;
    }

    public void setPrepayCreateTime(Date prepayCreateTime) {
        this.prepayCreateTime = prepayCreateTime;
    }

    public Date getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(Date payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public Date getPayTimeExpire() {
        return payTimeExpire;
    }

    public void setPayTimeExpire(Date payTimeExpire) {
        this.payTimeExpire = payTimeExpire;
    }

    public String getPrepayInfoId() {
        return prepayInfoId;
    }

    public void setPrepayInfoId(String prepayInfoId) {
        this.prepayInfoId = prepayInfoId;
    }

    public String getAppTradeNo() {
        return appTradeNo;
    }

    public void setAppTradeNo(String appTradeNo) {
        this.appTradeNo = appTradeNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAppIp() {
        return appIp;
    }

    public void setAppIp(String appIp) {
        this.appIp = appIp;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPayChannelOrderId() {
        return payChannelOrderId;
    }

    public void setPayChannelOrderId(String payChannelOrderId) {
        this.payChannelOrderId = payChannelOrderId;
    }

    public String getPayDetailId() {
        return payDetailId;
    }

    public void setPayDetailId(String payDetailId) {
        this.payDetailId = payDetailId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getPaySuccessNotifiedTimes() {
        return paySuccessNotifiedTimes;
    }

    public void setPaySuccessNotifiedTimes(String paySuccessNotifiedTimes) {
        this.paySuccessNotifiedTimes = paySuccessNotifiedTimes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(String statusHistory) {
        this.statusHistory = statusHistory;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Long getRefundedPrice() {
        return refundedPrice;
    }

    public void setRefundedPrice(Long refundedPrice) {
        this.refundedPrice = refundedPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public Date getRefundApplyTime() {
        return refundApplyTime;
    }

    public void setRefundApplyTime(Date refundApplyTime) {
        this.refundApplyTime = refundApplyTime;
    }

    public Date getRefundSuccessTime() {
        return refundSuccessTime;
    }

    public void setRefundSuccessTime(Date refundSuccessTime) {
        this.refundSuccessTime = refundSuccessTime;
    }

    public Date getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }
}
