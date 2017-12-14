package org.hanzhdy.manager.proxy.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.proxy.common.ApiResult;
import org.hanzhdy.manager.upc.service.UserService;
import org.hanzhdy.proxy.request.UserLoginRequest;
import org.hanzhdy.web.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by H.CAAHN on 2017/12/8.
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController {
    @Autowired
    private UserService userService;
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    private static final boolean isDebugEnabled = logger.isDebugEnabled();
    
    /**
     * 客户端登录请求
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Object login(@RequestBody UserLoginRequest params, HttpServletRequest request) {
        try {
            // 参数校验
            if (StringUtils.isBlank(params.getAccount()) || StringUtils.isBlank(params.getPassword())) {
                return ApiResult.FAILED_ARGS_EMPTY;
            }
            
            if (isDebugEnabled) {
                logger.debug("客户端登录请求【处理中】请求参数：" + JSON.toJSONString(params));
            }
            
            if (isDebugEnabled) {
                logger.debug("客户端登录请求【登录成功】请求参数：" + JSON.toJSONString(params));
            }
        }
        catch (Exception ex) {
            logger.error("客户端登录请求【异常】，请求参数：" + JSON.toJSONString(params), ex);
            return ApiResult.EXCEPTION;
        }
        return null;
    }
}
