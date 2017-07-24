package com.postbox.controller;

import com.alibaba.fastjson.JSON;
import com.postbox.controller.params.CompanyInfoParams;
import com.postbox.enums.DataStatus;
import com.postbox.model.CompanyInfo;
import com.postbox.service.CompanyInfoService;
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
 * 企业管理Controller
 * Created by H.CAAHN on 2017/7/20.
 */
@Controller
@RequestMapping("/postbox/company")
public class CompanyInfoController extends ApplicationController {
    @Autowired
    private CompanyInfoService companyInfoService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(CompanyInfoController.class);
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model, HttpServletRequest request) {
        model.addAttribute("statusList", DataStatus.values());
        return "/postbox/company/company-list";
    }
    
    /**
     * 请求获取企业列表数据
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(CompanyInfoParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = this.companyInfoService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询企业信息失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询企业信息失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
    
    /**
     * 跳转到编辑企业信息的页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "toEdit", method = RequestMethod.GET)
    public String toEdit(Long id, Model model, HttpServletRequest request) {
        model.addAttribute("statusList", DataStatus.values());
        
        if (id != null) {
            CompanyInfo record = this.companyInfoService.queryById(id);
            if (record != null) {
                model.addAttribute("record", record);
                return "/postbox/company/company-edit";
            }
            return redirect(REDIRECT_404);
        }
        else {
            return "/postbox/company/company-edit";
        }
    }
    
    /**
     * 保存企业数据
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Object saveCompanyInfo(CompanyInfo record, HttpServletRequest request) {
        try {
            // 执行新增或更新操作
            boolean result = false;
            if (record.getCompanyInfoId() == null) {
                result = this.companyInfoService.insert(record);
            }
            else {
                result = this.companyInfoService.update(record);
            }
            
            // 处理返回结果
            return RespResult.create(result ? respCode.SUCCESS : respCode.SAVE_NORECORD);
        }
        catch (BizException ex) {
            logger.error("保存企业信息失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("保存企业信息失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新企业信息状态请求
     * @param record
     * @param request
     * @return
     */
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(CompanyInfo record, HttpServletRequest request) {
        try {
            this.companyInfoService.updateStatus(record);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新企业信息状态失败，数据参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(record), ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新企业信息状态失败，数据参数：" + JSON.toJSONString(record), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 处理更新企业鉴权数据请求
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "refreshAuth", method = RequestMethod.POST)
    @ResponseBody
    public Object refreshAuth(@RequestParam("id") Long id, HttpServletRequest request) {
        SessionUser user = super.getSessionUser(request);
        try {
            this.companyInfoService.updateRefreshAuth(id);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            logger.error("更新企业鉴权数据失败，企业ID：{}, 错误信息：[{}, {}]", id, ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("更新企业鉴权数据失败，企业ID：" + id, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
