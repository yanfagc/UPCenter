package org.hanzhdy.manager.pay.controller.params;

import org.hanzhdy.web.bean.DatatableParams;

import java.util.Date;

/**
 * @description 支付信息 查询条件
 * @author wangchengzhi
 * @createtime 2017年9月9日
 */
public class PayInfoParams extends DatatableParams {
    /** 序列化号 */
    private static final long serialVersionUID = 1707011756804077008L;

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
    private String appId;

    /**
     * 本地生成的支付订单信息: prepay_info.PAY_INFO_ID
     */
    private String payInfoId;

    /**
     * 支付金额: prepay_info.AMOUNT
     */
    private String amount;

    /**
     * 支付app下单时间: prepay_info.CREATE_TIME
     */
    private Date createTime;

    /**
     * 支付app下单服务器ip: prepay_info.APP_IP
     */
    private String appIp;

    /**
     * 支付渠道     wx:微信   ali:支付宝   jd：京东支付  union:银联: pay_info.CHANNEL
     */
    private String channel;

    /**
     * 对应支付渠道订单id， 如果是微信，关联pay_order_wx表: pay_info.PAY_CHANNEL_ORDER_ID
     */
    private String payChannelOrderId;

    /**
     * 业务类型   自己系统的业务类型     暂定  buy:购买业务    delivery：提货业务: pay_info.BIZ_TYPE
     */
    private String bizType;

    /**
     * 业务id, 关联的业务id: pay_info.BIZ_ID
     */
    private String bizId;

    /**
     * 支付状态   NO_CHANNEL：订单已生成，但未选择支付渠道  UNPAYING：支付渠道已选择，但未付款  CANCELLED：支付已取消  SUCCESS:支付成功: pay_info.STATUS
     */
    private String status;

    /**
     * 支付完成时间: pay_info.PAY_SUCCESS_TIME
     */
    private Date paySuccessTime;

    /**
     * 微信支付分配的商户号: pay_order_wx.MCH_ID
     */
    private String mchId;

    /**
     * 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB": pay_order_wx.DEVICE_INFO
     */
    private String deviceInfo;

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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPayInfoId() {
        return payInfoId;
    }

    public void setPayInfoId(String payInfoId) {
        this.payInfoId = payInfoId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAppIp() {
        return appIp;
    }

    public void setAppIp(String appIp) {
        this.appIp = appIp;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
