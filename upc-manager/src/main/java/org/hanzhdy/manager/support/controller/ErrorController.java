package org.hanzhdy.manager.support.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 错误页面
 * @author H.CAAHN
 * @createtime 2015年12月6日 上午12:03:23
 */
@Controller
@RequestMapping("/error")
public class ErrorController extends ApplicationController {
    /**
     * 404页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/404")
    public String to404(Model model, HttpServletRequest request) {
        return "error/404";
    }
    
    /**
     * 403无权页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/403")
    public String to403(Model model, HttpServletRequest request) {
        return "error/403";
    }
}
