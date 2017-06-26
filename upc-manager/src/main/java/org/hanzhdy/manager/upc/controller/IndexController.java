package org.hanzhdy.manager.upc.controller;

import javax.servlet.http.HttpServletRequest;

import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.upc.service.LoginService;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description 首页、登录、登出
 * @author H.CAAHN
 * @createtime 2015年6月17日 下午11:41:42
 */
@Controller
@RequestMapping("/")
public class IndexController extends ApplicationController {
    @Autowired
    private LoginService        loginService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    /**
     * 执行登录过程
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam("j_username") String username, @RequestParam("j_password") String password,
            @RequestParam("j_captcha") String captcha, HttpServletRequest request) {
        try {
            SessionUser user = this.loginService.insertByCheckLogin(username, password, captcha);
            super.setSessionUser(request, user);
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            int code = ex.getCode();
            if (code == respCode.LOGIN_ILLEGAL_IMGTOKEN.getCode()) {
                logger.error("验证码错误：{}, {}", username, captcha);
            }
            return RespResult.create(ex.getStatus());
        }
        catch (Exception ex) {
            logger.error("登录失败，内部服务错误", ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
    
    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout() {
        return "";
    }
}
