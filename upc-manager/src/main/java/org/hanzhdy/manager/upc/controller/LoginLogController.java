package org.hanzhdy.manager.upc.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.upc.controller.params.LoginLogParams;
import org.hanzhdy.manager.upc.service.LoginLogService;
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

/**
 * Created by H.CAAHN on 2017/7/19.
 */
@Controller
@RequestMapping("/basic/loginlog")
public class LoginLogController extends ApplicationController {
    @Autowired
    private LoginLogService loginLogService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(LoginLogController.class);
    
    /**
     * 打开系统登录日志页面
     * @param model
     * @return
     */
    @RequiresPermissions("basic:loginlog:list")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model) {
        return "/basic/loginlog/loginlog-list";
    }
    
    /**
     * 分页获取系统日志列表数据
     * @param params
     * @param request
     * @return
     */
    @RequiresPermissions("basic:loginlog:list")
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(LoginLogParams params, HttpServletRequest request) {
        DatatableResult dataResult;
        try {
            dataResult = loginLogService.queryAsDatatableResult(params);
        }
        catch (BizException ex) {
            logger.error("查询登录日志列表数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getBizMessage());
            dataResult = super.getEmptyDatatableResult();
        }
        catch (Exception ex) {
            logger.error("查询登录日志列表数据失败，查询参数：" + JSON.toJSONString(params), ex);
            dataResult = super.getEmptyDatatableResult();
        }
        return JSON.toJSONString(dataResult);
    }
}
