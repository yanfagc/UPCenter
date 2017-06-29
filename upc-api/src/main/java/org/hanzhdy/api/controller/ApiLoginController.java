package org.hanzhdy.api.controller;

import org.apache.commons.lang.StringUtils;
import org.hanzhdy.api.ApplicationController;
import org.hanzhdy.api.service.UserService;
import org.hanzhdy.api.vo.UserVo;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by H.CAAHN on 2017/6/26.
 */
@Controller
@RequestMapping(value = "/api/")
public class ApiLoginController extends ApplicationController {
    @Resource
    private UserService userService;

    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "login")
    public Object login(@RequestParam("account") String account, @RequestParam("password") String password, String loginip, HttpServletRequest request) {
        try {
            // 参数检查
            if (StringUtils.isBlank(account)) {
                return RespResult.create(respCode.LOGIN_EMPTY_USERNAME);
            }
            if (StringUtils.isBlank(password)) {
                return RespResult.create(respCode.LOGIN_EMPTY_PASSWORD);
            }
            if (StringUtils.isBlank(loginip)) {
                loginip = HttpUtils.getRealIp(request);
            }

            // 验证用户名密码，尝试登录
            UserVo record = userService.updateForLogin(account, password, loginip);
            if (record == null) {
                return RespResult.create(respCode.LOGIN_ILLEGAL_USER_PWD);
            }
            return RespResult.create(respCode.SUCCESS, record);
        }
        catch (Exception ex) {
            logger.error("用户登录失败，登录帐号：" + account, ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
