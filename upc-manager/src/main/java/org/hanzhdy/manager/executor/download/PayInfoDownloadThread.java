package org.hanzhdy.manager.executor.download;


import org.apache.poi.hssf.usermodel.*;
import org.hanzhdy.manager.engine.utils.ApplicationContextUtil;
import org.hanzhdy.manager.engine.utils.DateTimeUtils;
import org.hanzhdy.manager.engine.utils.ExcelUtils;
import org.hanzhdy.manager.engine.utils.Lang;
import org.hanzhdy.manager.pay.controller.params.PayInfoParams;
import org.hanzhdy.manager.pay.service.PayInfoService;
import org.hanzhdy.manager.pay.vo.PayOrderWxVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Calendar;
import java.util.List;

/**
 * Created by wangchengzhi on 2017/9/4.
 */
public class PayInfoDownloadThread extends DownloadProcessThread {

    protected PayInfoParams params;

    protected PayInfoService payInfoService;

    private static final Logger logger = LoggerFactory.getLogger(PayInfoDownloadThread.class);

    public PayInfoDownloadThread(PayInfoParams params) {
        this.params = params;
        payInfoService = ApplicationContextUtil.getBean("payInfoService", PayInfoService.class);
    }

    protected void handle(Calendar calendar) throws Exception {
        File file;
        try {
            file = createFile("支付订单_{0}.xls", calendar);
            payInfoService.absolutePath = file.getAbsolutePath();
            payInfoService.filename = file.getName();
            logger.info("导出的支付订单的绝对路径为：", file.getAbsolutePath());
            logger.info("导出的支付订单的文件名为：", file.getName());
        }
        catch (Exception ex) {
            logger.error("支付订单订单下载进程处理失败【文件创建】", ex);
            throw ex;
        }

        HSSFWorkbook workbook = new HSSFWorkbook();
        try {
            List<PayOrderWxVo> payOrderWxList = payInfoService.listOrderWx(params);
            String datetime = DateTimeUtils.format(calendar.getTime(), "yyyyMMddHHmmss");
            HSSFSheet sheet = this.buildExcelSheet(workbook, datetime);

            int totalNumber = this.payInfoService.getWxTotalNumber(params);
            int totalPage = totalNumber/this.params.getiDisplayLength();
            if (totalNumber % params.getiDisplayLength() != 0) {
                totalPage = totalPage + 1;
            }

            if (payOrderWxList != null && !payOrderWxList.isEmpty()) {
                int nowline = this.buildExcelContent(sheet, 1, payOrderWxList);

                for (int i = 2; i <= totalPage; i++) {
                    params.setiDisplayStart((i-1)*params.getiDisplayLength());
                    payOrderWxList = payInfoService.listOrderWx(params);
                    nowline = this.buildExcelContent(sheet, nowline, payOrderWxList);
                }
            }
        }
        catch (Exception ex) {
            logger.error("支付订单下载进程处理失败【数据读取分析】", ex);
            throw ex;
        }

        try {
            this.writeFile(file, workbook );
        }
        catch (Exception ex) {
            logger.error("支付订单下载进程处理失败【文件写入】", ex);
            throw ex;
        }
    }

    private HSSFSheet buildExcelSheet(HSSFWorkbook workbook, String datetime) {
        HSSFSheet sheet = workbook.createSheet("微信渠道支付订单 " + datetime);
        sheet.setColumnWidth(0, 2500); // 序号
        sheet.setColumnWidth(1, 3500); // 预订单号
        sheet.setColumnWidth(2, 3500); // app系统内部订单号
        sheet.setColumnWidth(3, 4500); // 支付应用 id
        sheet.setColumnWidth(4, 4500); // 支付金额
        sheet.setColumnWidth(5, 4500); // 支付app下单时间
        sheet.setColumnWidth(6, 4500); // 支付app下单服务器ip
        sheet.setColumnWidth(7, 3500); // 支付金额
        sheet.setColumnWidth(8, 4500); // 支付渠道
        sheet.setColumnWidth(9, 4500); // 对应支付渠道订单id
        sheet.setColumnWidth(10, 4500); // 当前绑定的支付订单明细id
        sheet.setColumnWidth(11, 4800); // 业务类型
        sheet.setColumnWidth(12, 4500); // 业务id
        sheet.setColumnWidth(13, 4500); // 支付成功已通知商户服务器次数
        sheet.setColumnWidth(14, 4500); // 支付状态
        sheet.setColumnWidth(15, 4500); // 状态历史
        sheet.setColumnWidth(16, 4500); // 创建时间
        sheet.setColumnWidth(17, 4500); // 支付过期时间
        sheet.setColumnWidth(18, 4500); // 退款状态
        sheet.setColumnWidth(19, 4500); // 已退款金额
        sheet.setColumnWidth(20, 4500); // 创建时间
        sheet.setColumnWidth(21, 4500); // 修改时间
        sheet.setColumnWidth(22, 4500); // 支付完成时间
        sheet.setColumnWidth(23, 4500); // 退款发起时间
        sheet.setColumnWidth(24, 4500); // 退款完成时间
        sheet.setColumnWidth(25, 4500); // 上次查询时间
        sheet.setColumnWidth(26, 4500); // 微信渠道支付明细id
        sheet.setColumnWidth(27, 4500); // 基本支付信息id
        sheet.setColumnWidth(28, 4500); // 微信支付分配的公众账号ID
        sheet.setColumnWidth(29, 4500); // 微信支付分配的商户号
        sheet.setColumnWidth(30, 4500); // 自定义参数
        sheet.setColumnWidth(31, 4500); // 商品简单描述
        sheet.setColumnWidth(32, 4500); // 商品详细列表
        sheet.setColumnWidth(33, 4500); // 附加数据
        sheet.setColumnWidth(34, 4500); // 资费类别 符合ISO 4217标准的三位字母代码，默认人民币：CNY
        sheet.setColumnWidth(35, 4500); // 订单总金额
        sheet.setColumnWidth(36, 4500); // APP和网页支付提交用户端ip
        sheet.setColumnWidth(37, 4500); // 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
        sheet.setColumnWidth(38, 4500); // 订单失效时间
        sheet.setColumnWidth(39, 4500); // 商品标记
        sheet.setColumnWidth(40, 4500); // 交易方式
        sheet.setColumnWidth(41, 4500); // 商品ID
        sheet.setColumnWidth(42, 4500); // 支付方式限制
        sheet.setColumnWidth(43, 4500); // openid
        sheet.setColumnWidth(44, 4500); // 微信支付系统返回的预付单信息
        sheet.setColumnWidth(45, 4500); // 二维码URL
        sheet.setColumnWidth(46, 4500); // 预付单业务结果
        sheet.setColumnWidth(47, 4500); // 微信支付订单号
        sheet.setColumnWidth(48, 4500); // 支付结果
        sheet.setColumnWidth(49, 4500); // 付款银行
        sheet.setColumnWidth(50, 4500); // 应结订单金额
        sheet.setColumnWidth(51, 4500); // 现金支付金额
        sheet.setColumnWidth(52, 4500); // 货币类型
        sheet.setColumnWidth(53, 4500); // 总代金券金额
        sheet.setColumnWidth(54, 4500); // 代金券使用数量
        sheet.setColumnWidth(55, 4500); // 所有代金券明细
        sheet.setColumnWidth(56, 4500); // 支付完成时间
        sheet.setColumnWidth(57, 4500); // 是否有效, true:有效     false:无效

        HSSFCellStyle style1 = ExcelUtils.generateCellStyle(workbook);
        style1.setFont(ExcelUtils.generateFont(workbook));
        HSSFCellStyle style2 = ExcelUtils.generateCellStyle2(workbook);
        style2.setFont(ExcelUtils.generateFont2(workbook));
        String[] headers = new String[]{"序号", "预订单号",  "app系统内部订单号", "支付应用id", "支付金额", "支付app下单时间", "支付app下单服务器ip", "支付金额", "支付渠道", "对应支付渠道订单id", "当前绑定的支付订单明细id", "业务类型", "业务id", "支付成功已通知商户服务器次数", "支付状态", "状态历史", "创建时间", "支付过期时间", "退款状态", "已退款金额", "创建时间", "修改时间", "支付完成时间", "退款发起时间", "退款完成时间", "上次查询时间", "微信渠道支付明细id", "基本支付信息id", "微信支付分配的公众账号ID", "微信支付分配的商户号", "自定义参数", "商品简单描述", "商品详细列表", "附加数据", "资费类别", "订单总金额", "APP和网页支付提交用户端ip", "订单生成时间", "订单失效时间", "商品标记", "交易方式", "商品ID", "支付方式限制", "openid", "微信支付系统返回的预付单信息", "二维码URL", "预付单业务结果", "微信支付订单号", "支付结果", "付款银行", "应结订单金额", "现金支付金额", "货币类型", "总代金券金额", "代金券使用数量", "所有代金券明细", "支付完成时间", "是否有效"};
        //产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style1);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        return sheet;
    }

    private int buildExcelContent(HSSFSheet sheet, int nowline, List<PayOrderWxVo> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return nowline;
        }

        for (PayOrderWxVo data : dataList) {
            HSSFRow row = sheet.createRow(nowline);
            HSSFCell cell = row.createCell(0); // 序号
            cell.setCellValue(nowline);

            cell = row.createCell(1); // 预订单号
            cell.setCellValue(data.getPrepayInfoId());

            cell = row.createCell(2); // app系统内部订单号
            cell.setCellValue(data.getAppTradeNo());

            cell = row.createCell(3);// 支付应用id
            cell.setCellValue(data.getPreAppId());

            cell = row.createCell(4); // 支付金额
            if (data.getAmount() != null) {
                cell.setCellValue(Lang.getNearValue(data.getAmount().doubleValue() / 100, 2) + " 元");
            }
            else {
                cell.setCellValue("0.0 元");
            }

            cell = row.createCell(5);// 支付app下单时间
            cell.setCellValue(DateTimeUtils.format(data.getPrepayCreateTime()));

            cell = row.createCell(6); // 支付app下单服务器ip
            cell.setCellValue(data.getAppIp());

            cell = row.createCell(7); // 支付金额
            if (data.getPayAmount() != null) {
                cell.setCellValue(Lang.getNearValue(data.getAmount().doubleValue() / 100, 2) + " 元");
            }
            else {
                cell.setCellValue("0.0 元");
            }

            cell = row.createCell(8); // 支付渠道
            cell.setCellValue(data.getChannel());

            cell = row.createCell(9); // 对应支付渠道订单id
            cell.setCellValue(data.getPayChannelOrderId());

            cell = row.createCell(10);// 当前绑定的支付订单明细id
            cell.setCellValue(data.getPayDetailId());

            cell = row.createCell(11); // 业务类型
            cell.setCellValue(data.getBizType());

            cell = row.createCell(12); // 业务id
            cell.setCellValue(data.getBizId());

            cell = row.createCell(13); // 支付成功已通知商户服务器次数
            cell.setCellValue(data.getPaySuccessNotifiedTimes());

            cell = row.createCell(14); // 支付状态
            cell.setCellValue(data.getStatus());

            cell = row.createCell(15);// 状态历史
            cell.setCellValue(data.getStatusHistory());

            cell = row.createCell(16); // 创建时间
            cell.setCellValue(DateTimeUtils.format(data.getPayTimeStart()));

            cell = row.createCell(17); // 支付过期时间
            cell.setCellValue(DateTimeUtils.format(data.getPayTimeExpire()));

            cell = row.createCell(18); // 退款状态
            cell.setCellValue(data.getRefundStatus());

            cell = row.createCell(19); // 已退款金额
            if (data.getRefundedPrice() != null) {
                cell.setCellValue(Lang.getNearValue(data.getRefundedPrice().doubleValue() / 100, 2) + " 元");
            }
            else {
                cell.setCellValue("0.0 元");
            }

            cell = row.createCell(20);// 创建时间
            cell.setCellValue(DateTimeUtils.format(data.getCreateTime()));

            cell = row.createCell(21); // 修改时间
            cell.setCellValue(DateTimeUtils.format(data.getUpdateTime()));

            cell = row.createCell(22); // 支付完成时间
            cell.setCellValue(DateTimeUtils.format(data.getPaySuccessTime()));

            cell = row.createCell(23); // 退款发起时间
            cell.setCellValue(DateTimeUtils.format(data.getRefundApplyTime()));

            cell = row.createCell(24); // 退款完成时间
            cell.setCellValue(DateTimeUtils.format(data.getRefundSuccessTime()));

            cell = row.createCell(25);// 上次查询时间
            cell.setCellValue(DateTimeUtils.format(data.getQueryTime()));

            cell = row.createCell(26); // 微信渠道支付明细id
            cell.setCellValue(data.getPayOrderWxId());

            cell = row.createCell(27); // 基本支付信息id
            if (data.getPayInfoId() != null) {
                cell.setCellValue(data.getPayInfoId());
            }
            else {
                cell.setCellValue("");
            }

            cell = row.createCell(28); // 微信支付分配的公众账号ID
            cell.setCellValue(data.getAppid());

            cell = row.createCell(29); // 微信支付分配的商户号
            cell.setCellValue(data.getMchId());

            cell = row.createCell(30);// 自定义参数
            cell.setCellValue(data.getDeviceInfo());

            cell = row.createCell(31); // 商品简单描述
            cell.setCellValue(data.getBody());

            cell = row.createCell(32); // 商品详细列表
            cell.setCellValue(data.getDetail());

            cell = row.createCell(33); // 附加数据
            cell.setCellValue(data.getAttach());

            cell = row.createCell(34); // 资费类别 符合ISO 4217标准的三位字母代码，默认人民币：CNY
            cell.setCellValue(data.getFeeType());

            cell = row.createCell(35);// 订单总金额
            if (data.getTotalFee() != null) {
                cell.setCellValue(Lang.getNearValue(data.getTotalFee().doubleValue() / 100, 2) + " 元");
            }
            else {
                cell.setCellValue("0.0 元");
            }

            cell = row.createCell(36); // APP和网页支付提交用户端ip
            cell.setCellValue(data.getSpbillCreateIp());

            cell = row.createCell(37); // 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
            cell.setCellValue(DateTimeUtils.format(data.getTimeStart()));

            cell = row.createCell(38); // 订单失效时间
            cell.setCellValue(DateTimeUtils.format(data.getTimeExpire()));

            cell = row.createCell(39); // 商品标记
            cell.setCellValue(data.getGoodsTag());

            cell = row.createCell(40);// 交易方式
            cell.setCellValue(data.getTradeType());

            cell = row.createCell(41); // 商品ID
            cell.setCellValue(data.getProductId());

            cell = row.createCell(42); // 支付方式限制
            cell.setCellValue(data.getLimitPay());

            cell = row.createCell(43); // openid
            cell.setCellValue(data.getOpenid());

            cell = row.createCell(44); // 微信支付系统返回的预付单信息
            cell.setCellValue(data.getPrepayId());

            cell = row.createCell(45);// 二维码URL
            cell.setCellValue(data.getCodeUrl());

            cell = row.createCell(46); // 预付单业务结果
            cell.setCellValue(data.getPrepayResultCode());

            cell = row.createCell(47); // 微信支付订单号
            cell.setCellValue(data.getPayTransactionId());

            cell = row.createCell(48); // 支付结果
            cell.setCellValue(data.getPayResultCode());

            cell = row.createCell(49); // 付款银行
            cell.setCellValue(data.getBankType());

            cell = row.createCell(50);// 应结订单金额
            if (data.getSettlementTotalFee() != null) {
                cell.setCellValue(Lang.getNearValue(data.getSettlementTotalFee().doubleValue() / 100, 2) + " 元");
            }
            else {
                cell.setCellValue("0.0 元");
            }

            cell = row.createCell(51); // 现金支付金额
            if (data.getCashFee() != null) {
                cell.setCellValue(Lang.getNearValue(data.getCashFee().doubleValue() / 100, 2) + " 元");
            }
            else {
                cell.setCellValue("0.0 元");
            }

            cell = row.createCell(52); // 货币类型
            cell.setCellValue(data.getFeeType());

            cell = row.createCell(53); // 总代金券金额
            if (data.getCouponFee() != null) {
                cell.setCellValue(Lang.getNearValue(data.getCouponFee().doubleValue() / 100, 2) + " 元");
            }
            else {
                cell.setCellValue("0.0 元");
            }

            cell = row.createCell(54); // 代金券使用数量
            if (data.getCouponCount() != null) {
                cell.setCellValue(data.getCouponCount());
            }
            else {
                cell.setCellValue("0 张");
            }

            cell = row.createCell(55);// 所有代金券明细
            cell.setCellValue(data.getCouponDetailList());

            cell = row.createCell(56); // 支付完成时间
            cell.setCellValue(DateTimeUtils.format(data.getTimeEnd()));

            cell = row.createCell(57); // 是否有效, true:有效     false:无效
            cell.setCellValue(data.getIsValid());


            nowline++;
        }
        return nowline;
    }
}
