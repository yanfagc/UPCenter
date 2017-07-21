package com.postbox.controller;

import com.alibaba.fastjson.JSON;
import com.postbox.controller.params.CustomerInfoParams;
import com.postbox.enums.DataStatus;
import com.postbox.model.CustomerInfo;
import com.postbox.service.CustomerInfoService;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 客户信息管理
 * Created by H.CAAHN on 2017/7/21.
 */
@Controller
@RequestMapping("/postbox/customer")
public class CustomerInfoController extends ApplicationController {
    @Autowired
    private CustomerInfoService customerInfoService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(CustomerInfoController.class);
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        model.addAttribute("statusList", DataStatus.values());
        return "/postbox/customer/customer-list";
    }
    
    /**
     * 请求获取客户列表数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(CustomerInfoParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = this.customerInfoService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询客户信息失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询客户信息失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
    
    /**
     * 查询客户详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "viewDetail", method = RequestMethod.GET)
    public String viewDetail(Model model, @RequestParam("id") Long id) {
        if (id != null) {
            CustomerInfo record = this.customerInfoService.queryById(id);
            if (record != null) {
                model.addAttribute("record", record);
                return "/postbox/customer/customer-detail";
            }
        }
        return redirect(REDIRECT_404);
    }
    
    /**
     * 处理更新客户信息状态请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(CustomerInfo record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            this.customerInfoService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新客户信息状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新客户信息状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
