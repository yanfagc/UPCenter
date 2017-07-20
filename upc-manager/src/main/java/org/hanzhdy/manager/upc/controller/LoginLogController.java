package org.hanzhdy.manager.upc.controller;

import com.alibaba.fastjson.JSON;
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
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toList(Model model) {
        return "/basic/loginlog/loginlog-list";
    }
    
    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public Object dataList(LoginLogParams params, HttpServletRequest request) {
        try {
            DatatableResult dataResult = loginLogService.queryAsDatatableResult(params);
            return JSON.toJSONString(dataResult);
        }
        catch (BizException ex) {
            logger.error("查询登录日志列表数据失败，查询参数：{}, 错误信息：[{}, {}]", JSON.toJSONString(params), ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            logger.error("查询登录日志列表数据失败，查询参数：" + JSON.toJSONString(params), ex);
        }
        return null;
    }
}
