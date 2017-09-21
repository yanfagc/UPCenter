package org.hanzhdy.manager.support.enums;

/**
 * @description 支付渠道
 * @author wangchengzhi
 * @createtime 2017年9月11日
 */
public enum PaymentChannel {
    /** 微信 */
    wx("微信"),

    /** 支付宝 */
    ali("支付宝"),

    /** 京东支付 */
    jd("京东支付"),

    /** 银联 */
    union("银联");

    private String remark;

    private PaymentChannel(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }
}
