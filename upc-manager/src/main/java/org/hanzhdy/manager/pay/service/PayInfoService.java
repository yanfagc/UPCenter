package org.hanzhdy.manager.pay.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.engine.utils.Util;
import org.hanzhdy.manager.pay.controller.params.PayInfoParams;
import org.hanzhdy.manager.pay.mapper.PayOrderWxMapperExt;
import org.hanzhdy.manager.pay.mapper.PrepayInfoMapperExt;
import org.hanzhdy.manager.pay.model.PayOrderWx;
import org.hanzhdy.manager.pay.vo.PayInfoVo;
import org.hanzhdy.manager.pay.vo.PayOrderWxVo;
import org.hanzhdy.web.bean.DatatableResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangchengzhi
 * @description 支付信息列表查询Service
 * @createtime 2017年9月11日
 */
@Service
public class PayInfoService {

    @Autowired
    private PrepayInfoMapperExt prepayInfoMapperExt;

    @Autowired
    private PayOrderWxMapperExt payOrderWxMapperExt;

    public static String absolutePath;

    public static String filename;

    private static final Logger LOGGER = LoggerFactory.getLogger(PayInfoService.class);

    /**
     * 分页查询支付信息，并按条件返回符合datatable数据格式的信息
     *
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(PayInfoParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        if (StringUtils.isNotBlank(params.getPrepayInfoId())) {
            search.put("prepayInfoId", params.getPrepayInfoId());
        }
        if (StringUtils.isNotBlank(params.getAppTradeNo())) {
            search.put("appTradeNo", params.getAppTradeNo());
        }
        if (StringUtils.isNotBlank(params.getAppId())) {
            search.put("appId", params.getAppId());
        }
        if (StringUtils.isNotBlank(params.getPayInfoId())) {
            search.put("payInfoId", params.getPayInfoId());
        }
        if (StringUtils.isNotBlank(params.getAmount())) {
            search.put("amount", params.getAmount());
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", params.getStatus());
        }
        if (StringUtils.isNotBlank(params.getBizType())) {
            search.put("bizType", "%" + params.getBizType() + "%");
        }
        if (StringUtils.isNotBlank(params.getBizId())) {
            search.put("bizId", "%" + params.getBizId() + "%");
        }
        if (StringUtils.isNotBlank(params.getChannel())) {
            search.put("channel",params.getChannel());
        }
        if (StringUtils.isNotBlank(params.getPayChannelOrderId())) {
            search.put("payChannelOrderId", params.getPayChannelOrderId());
        }
        if (params.getCreateTime() != null) {
            search.put("createTime", "%" + params.getCreateTime() + "%");
        }
        if (params.getPaySuccessTime() != null) {
            search.put("paySuccessTime", "%" + params.getPaySuccessTime() + "%");
        }

        // 查询数据
        int count = this.prepayInfoMapperExt.countAsList(search);
        List<PayInfoVo> data = this.prepayInfoMapperExt.selectAsList(search);

        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }

    /**
     * 根据微信渠道支付明细id号查询渠道订单信息
     *
     * @param payChannelOrderId
     * @return
     */
    public PayOrderWx queryByWxOrderId(String payChannelOrderId){
        return this.payOrderWxMapperExt.selectByPrimaryKey(payChannelOrderId);
    }

    /**
     * 根据搜索条件查询出所有微信渠道订单明细
     *
     * @param params
     * @return
     */
    public List<PayOrderWxVo> listOrderWx(PayInfoParams params) {
        try {
            // 构造查询条件
            Map<String, Object> search = new HashMap<String, Object>();
            search.put("page", params.createPage());
            if (StringUtils.isNotBlank(params.getPrepayInfoId())) {
                search.put("prepayInfoId", params.getPrepayInfoId());
            }
            if (StringUtils.isNotBlank(params.getAppId())) {
                search.put("appId", params.getAppId());
            }
            if (StringUtils.isNotBlank(params.getPayInfoId())) {
                search.put("payInfoId", params.getPayInfoId());
            }
            if (StringUtils.isNotBlank(params.getChannel())) {
                search.put("channel", params.getChannel());
            }
            if (StringUtils.isNotBlank(params.getPayChannelOrderId())) {
                search.put("payChannelOrderId", params.getPayChannelOrderId());
            }
            List<PayOrderWxVo> payOrderWxList = this.payOrderWxMapperExt.selectByParamsSelective(search);
            return payOrderWxList;
        } catch (Exception e) {
            LOGGER.error("支付订单列表详情获取失败：",e);
            return null;
        }

    }

    /**
     * 根据搜索条件查询出所有微信渠道订单总记录数
     *
     * @param params
     * @return
     */
    public int getWxTotalNumber(PayInfoParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(params.getPrepayInfoId())) {
            search.put("prepayInfoId", params.getPrepayInfoId());
        }
        if (StringUtils.isNotBlank(params.getAppId())) {
            search.put("appId", params.getAppId());
        }
        if (StringUtils.isNotBlank(params.getPayInfoId())) {
            search.put("payInfoId", params.getPayInfoId());
        }
        if (StringUtils.isNotBlank(params.getChannel())) {
            search.put("channel",params.getChannel());
        }
        if (StringUtils.isNotBlank(params.getPayChannelOrderId())) {
            search.put("payChannelOrderId", params.getPayChannelOrderId());
        }
        return this.payOrderWxMapperExt.countAsList(search);
    }

    public void download(HttpServletRequest request, HttpServletResponse response) {
        int index = filename.lastIndexOf("/");
        if (index == -1) {
            index = filename.lastIndexOf("\\");
        }
        if (index != -1) {
            filename = filename.substring(index + 1);
        }

        InputStream in = null;
        try {
            //处理中文文件名
            filename = Util.encodeFilename(filename, request);

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + filename);
            OutputStream ouputStream = response.getOutputStream();

            if (!absolutePath.endsWith("\\") && !absolutePath.endsWith("/")) {
                absolutePath += File.separator;
            }

            File file = new File(absolutePath);
            in = new FileInputStream(file);
            byte[] bs = new byte[1024];
            int len = -1;
            while ((len = in.read(bs)) > -1) {
                response.getOutputStream().write(bs, 0, len);
            }

            ouputStream.flush();
            ouputStream.close();
        }
        catch (Exception ex) {
            LOGGER.error("导出文件下载失败", ex);
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (Exception ex) {

                }
            }
        }
    }

}
