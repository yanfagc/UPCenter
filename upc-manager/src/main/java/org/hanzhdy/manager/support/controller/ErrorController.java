package org.hanzhdy.manager.support.controller;

import com.alibaba.fastjson.JSON;
import org.hanzhdy.manager.shiro.ShiroFilterUtils;
import org.hanzhdy.manager.support.constants.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 错误页面
 * @author H.CAAHN
 * @createtime 2015年12月6日 上午12:03:23
 */
@Controller
@RequestMapping("/error")
public class ErrorController extends ApplicationController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
    
    /**
     * 404页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/404")
    public String to404(Model model, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(404);
        return "error/404";
    }
    
    /**
     * 403无权页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/403")
    public String to403(Model model, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(403);
        return "error/403";
    }
    
    /**
     * org.apache.shiro.authz.AuthorizationException: Not authorized to invoke method
     * @param request
     * @param response
     */
    @RequestMapping("/authorization")
    public void toTimeout(HttpServletRequest request, HttpServletResponse response) {
        boolean isAjax = ShiroFilterUtils.isAjax(request);
        try {
            if (isAjax) {
                String result = JSON.toJSONString(ApiResult.LOGIN_TIMEOUT);
                response.setContentType("UTF-8");
                response.getWriter().write(result);
            }
            else {
                response.sendRedirect("/login");
            }
        }
        catch (Exception ex) {
            logger.error("跳转到登录失败", ex);
        }
    }
}
