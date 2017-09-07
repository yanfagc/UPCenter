package org.hanzhdy.manager.upc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.WebConstants;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.controller.ApplicationController;
import org.hanzhdy.manager.upc.model.AccessSystem;
import org.hanzhdy.manager.upc.service.AccessSystemService;
import org.hanzhdy.manager.upc.service.LoginLogService;
import org.hanzhdy.manager.upc.service.LoginService;
import org.hanzhdy.manager.upc.service.MenuService;
import org.hanzhdy.manager.upc.vo.Resource;
import org.hanzhdy.utils.HttpUtils;
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
import java.util.List;

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
    
    @Autowired
    private MenuService         menuService;
    
    @Autowired
    private AccessSystemService accessSystemService;
    
    @Autowired
    private LoginLogService     loginLogService;
    
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        try {
            SessionUser user = super.getSessionUser(request);
            AccessSystem system = accessSystemService.queryBySyscode(systemCode);
            if (system != null) {
                List<Resource> resourceList = this.menuService.queryMenuResourceByUserAndSysid(user.getId(), system.getId());
                model.addAttribute("resourceList", resourceList);
            }
        }
        catch (Exception ex) {
            logger.error("首页打开失败", ex);
        }
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
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam("j_username") String username, @RequestParam("j_password") String password,
            @RequestParam("j_captcha") String captcha, HttpServletRequest request) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            SessionUser user = this.loginService.getSessionUserByAccount(username);
            // super.setSessionUser(request, user);
            subject.getSession().setAttribute(WebConstants.SESSION_USER, user);

            // 记录日志
            this.loginLogService.insert(user, HttpUtils.getRealIp(request), "用户[" + username + "]登录系统");
            
            // 返回登录成功
            return RespResult.create(respCode.SUCCESS);
        }
        catch (BizException ex) {
            int code = ex.getCode();
            if (code == respCode.LOGIN_ILLEGAL_IMGTOKEN.getCode()) {
                logger.warn("用户: {} 登录失败: 验证码错误：{}", username, captcha);
            }
            return RespResult.create(ex.getStatus());
        }
        catch (ExcessiveAttemptsException ex) {
            logger.warn("用户: {} 登录失败: 登录次数过多", username);
            return RespResult.create(respCode.LOGIN_EXCESSIVE_ATTEMPTS);
        }
        catch (LockedAccountException ex) {
            logger.warn("用户: {} 登录失败：帐号被锁定", username);
            return RespResult.create(respCode.LOGIN_USER_LOCKED);
        }
        catch (DisabledAccountException ex) {
            logger.warn("用户: {} 登录失败，状态冻结或注销", username);
            return RespResult.create(respCode.LOGIN_USER_FROZEN);
        }
        catch (IncorrectCredentialsException | UnknownAccountException ex) {
            logger.warn("用户: {} 登录失败: 错误的用户名或密码", username);
            return RespResult.create(respCode.LOGIN_ILLEGAL_USER_PWD);
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
    public String logout(HttpServletRequest request) {
        super.removeSessionUser(request);
        return redirect("login");
    }
}
