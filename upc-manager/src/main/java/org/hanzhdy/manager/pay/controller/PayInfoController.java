package org.hanzhdy.manager.pay.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.executor.DownloadExecutor;
import org.hanzhdy.manager.pay.controller.params.PayInfoParams;
import org.hanzhdy.manager.pay.model.PayOrderWx;
import org.hanzhdy.manager.pay.service.PayInfoService;
import org.hanzhdy.manager.support.constants.DownloadConstants;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.support.enums.PaymentChannel;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangchengzhi
 * @description 支付信息列表查询
 * @createtime 2017年9月11日
 */
@Controller
@RequestMapping("/pay/payInfo")
public class PayInfoController extends ApplicationController {

    @Autowired
    private PayInfoService payInfoService;

    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(PayInfoController.class);

    /**
     * 转到支付信息列表查询页面
     *
     * @return
     */
    @RequiresPermissions("pay:payInfo:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model) {
        try {
            model.addAttribute("channelList", PaymentChannel.values());
        } catch (Exception ex) {
            logger.error("转到支付信息列表查询页面失败", ex);
        }
        return "pay/payInfo/payInfo-list";
    }

    /**
     * 请求获取支付信息列表数据
     *
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("pay:payInfo:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(PayInfoParams params, HttpServletRequest request) {
        DatatableResult dataResult = null;
        try {
            dataResult = payInfoService.queryAsDatatableResult(params);
        } catch (BizException ex) {
            dataResult = super.getEmptyDatatableResult();
            logger.error("查询支付信息列表数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        } catch (Exception ex) {
            dataResult = super.getEmptyDatatableResult();
            logger.error("查询支付信息列表数据失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return JSON.toJSONString(dataResult);
    }

    /**
     * 跳转到渠道订单详情页面
     *
     * @param channel
     * @param payChannelOrderId
     * @param request
     * @return
     */
    @RequiresPermissions("pay:payInfo:viewDetail")
    @RequestMapping(value = "toViewDetail", method = RequestMethod.GET)
    public String toViewDetail(String channel, String payChannelOrderId, Model model, HttpServletRequest request) {
        // 查询支付渠道类型信息
        model.addAttribute("channelList", PaymentChannel.values());

        try {
            // 分渠道查询订单详情信息
            if ("wx".equals(channel) && payChannelOrderId != null && payChannelOrderId != "") {
                PayOrderWx record = payInfoService.queryByWxOrderId(payChannelOrderId);
                if (record != null) {
                    model.addAttribute("record", record);
                    return "pay/payInfo/payInfo-detail";
                }
                return redirect(REDIRECT_404);
            } else if ("ali".equals(channel) && payChannelOrderId != null && payChannelOrderId != "") {

                //查询支付宝订单详情信息

            } else if ("jd".equals(channel) && payChannelOrderId != null && payChannelOrderId != "") {

                //查询京东宝订单详情信息

            } else if ("union".equals(channel) && payChannelOrderId != null && payChannelOrderId != "") {

                //查询银联订单详情信息

            }
        } catch (Exception ex) {
            logger.error("查询渠道订单详情失败, id：" + payChannelOrderId, ex);
            return redirect(REDIRECT_404);
        }
        return redirect(REDIRECT_404);
    }
    @RequestMapping(value = "download")
    public void download(PayInfoParams params, HttpServletRequest request, HttpServletResponse response) {
        try {
        DownloadExecutor downloadExecutor = new DownloadExecutor();
        // 放入到线程池中执行
        ThreadPoolExecutor executor = downloadExecutor.addTask(params, DownloadConstants.TYPE_PAY_ORDER_WX);

            executor.shutdown();//只是不能再提交新任务，等待执行的任务不受影响

            try {
                boolean loop = true;
                do {    //等待所有任务完成
                    loop = !executor.awaitTermination(2, TimeUnit.SECONDS);  //阻塞，直到线程池里所有任务结束
                } while(loop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            payInfoService.download(request,response);
//            return "error/404";
        }
        catch (Exception ex) {
            logger.error("导出提货订单失败，查询条件：" + JSON.toJSONString(params), ex);
//            return redirect(redirect(REDIRECT_404));
        }
    }
}
