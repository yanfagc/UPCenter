package com.postbox.controller;

import com.alibaba.fastjson.JSON;
import com.postbox.controller.params.ExpressmanInfoParams;
import com.postbox.enums.ActiveStatus;
import com.postbox.enums.DataStatus;
import com.postbox.enums.Sex;
import com.postbox.model.CustomerInfo;
import com.postbox.model.ExpressmanInfo;
import com.postbox.service.CustomerInfoService;
import com.postbox.service.ExpressmanInfoService;
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
 * Created by H.CAAHN on 2017/7/22.
 */
@Controller
@RequestMapping("/postbox/expressman")
public class ExpressmanInfoController extends ApplicationController {
    @Autowired
    private ExpressmanInfoService expressmanInfoService;
    
    @Autowired
    private CustomerInfoService   customerInfoService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(CustomerInfoController.class);
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        model.addAttribute("statusList", ActiveStatus.values());
        return "/postbox/expressman/expressman-list";
    }
    
    /**
     * 请求获取快递员列表数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(ExpressmanInfoParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = this.expressmanInfoService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询快递员信息失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询快递员信息失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
    
    /**
     * 查询快递员详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "viewDetail", method = RequestMethod.GET)
    public String viewDetail(Model model, @RequestParam("id") Long id) {
        if (id != null) {
            ExpressmanInfo record = this.expressmanInfoService.queryById(id);
            CustomerInfo customer = this.customerInfoService.queryById(record.getCustomerInfoId());
            if (record != null) {
                model.addAttribute("sexList", Sex.values());
                model.addAttribute("statusList", DataStatus.values());
                model.addAttribute("expressStatusList", ActiveStatus.values());
                model.addAttribute("record", record);
                model.addAttribute("customer", customer);
                return "/postbox/expressman/expressman-detail";
            }
        }
        return redirect(REDIRECT_404);
    }
    
    /**
     * 转至快递员审核
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "toAudit", method = RequestMethod.GET)
    public String toAudit(Model model, @RequestParam("id") Long id) {
        if (id != null) {
            ExpressmanInfo record = this.expressmanInfoService.queryById(id);
            CustomerInfo customer = this.customerInfoService.queryById(record.getCustomerInfoId());
            if (record != null) {
                model.addAttribute("sexList", Sex.values());
                model.addAttribute("statusList", DataStatus.values());
                model.addAttribute("expressStatusList", ActiveStatus.values());
                model.addAttribute("record", record);
                model.addAttribute("customer", customer);
                if (record.getStatus() == ActiveStatus.NOACTIVE) {
                    model.addAttribute("audit", true);
                }
                return "/postbox/expressman/expressman-detail";
            }
        }
        return redirect(REDIRECT_404);
    }
    
    /**
     * 处理更新快递员信息状态请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(ExpressmanInfo record, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            this.expressmanInfoService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新快递员信息状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新快递员信息状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
